package ru.nordigy.lab.amsup.frolov.tests;

import net.bytebuddy.description.modifier.SynchronizationState;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.nordigy.lab.amsup.frolov.ConfigProperties;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.util.concurrent.TimeUnit;

public class SingleSignOnPage {

    WebDriver driver;

    @BeforeSuite(description = "Check the elemetns of the SSO login page are visible")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getTestProperty("driverPathProperty"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(description = "Open the env login page")
    @TestCaseId("PAGE-1")
    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Navigete to Login page")
    public void getMainPage() {
        driver.get(ConfigProperties.getTestProperty("serviceWebUrlProperty"));
        Assert.assertTrue(driver.getCurrentUrl().contains(ConfigProperties.getTestProperty("serviceWebUrlProperty")));
    }

    @Test(description = "Check if elements are vissible")
    @TestCaseId("PAGE-2")
    @Step("Navigete to SSO login page")
    @Severity(value = SeverityLevel.BLOCKER)
    public void getSsoPage() {
        driver.findElement(By.xpath("//button[@data-test-automation-id='ssoBtn']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(ConfigProperties.getTestProperty("ssoURLProperty")));
    }

    @Step("Check if BrandName is vissible")
    public void ssoPageIsBrandNameVisible() {
        try {
            driver.findElement(By.xpath("//*[@id=\"rc-gen11\"]/div/div[1]/div/div/div/div/div/div/div/img")).isDisplayed();
            System.out.println("ssoPageIsBrandNameVisible is Visible - passed");

        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("ssoPageIsBrandNameVisible is not Visible - failed");
        }
    }

    @Step("Check if SsoTitle is vissible")
    public void ssoPageIsSsoTitleVisible() {
        try {
            driver.findElement(By.xpath("//div[@data-test-automation-id='loginSsoTitle']")).isDisplayed();
            System.out.println("ssoPageIsSsoTitleVisible is Visible - passed");

        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("ssoPageIsSsoTitleVisible is not Visible - failed");
        }
    }

    @Step("Check if EmailField is vissible")
    public void ssoPageIsEmailFieldVisible() {
        try {
            driver.findElement(By.xpath("//input[@data-test-automation-id='input']")).isDisplayed();
            System.out.println("ssoPageIsEmailFieldVisible is Visible - passed");

        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("ssoPageIsEmailFieldVisible is not Visible - failed");
        }
    }

    @Step("Check if RememberMe is vissible")
    public void ssoPageIsRememberMeVisible() {
        try {
            driver.findElement(By.xpath("//span[@data-test-automation-id='label']")).isDisplayed();
            System.out.println("ssoPageIsRememberMeVisible is Visible - passed");

        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("ssoPageIsRememberMeVisible is not Visible - failed");
        }
    }

    @Step("Check if BackButton is vissible")
    public void ssoPageIsBackButtonVisible() {
        try {
            driver.findElement(By.xpath("//button[@data-test-automation-id='back']")).isDisplayed();
            System.out.println("ssoPageIsBackButtonVisible is Visible - passed");

        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("ssoPageIsBackButtonVisible is not Visible - failed");
        }
    }

    @Step("Check if SubmitButton is vissible")
    public void ssoPageIsSubmitButtonVisible() {
        try {
            driver.findElement(By.xpath("//button[@data-test-automation-id='submit']")).isDisplayed();
            System.out.println("ssoPageIsSubmitButtonVisible is Visible - passed");

        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("ssoPageIsSubmitButtonVisible is not Visible - failed");
        }
    }

    @AfterSuite
    public void closeDriver() {
        driver.quit();
    }
}
