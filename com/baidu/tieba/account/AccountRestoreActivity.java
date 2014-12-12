package com.baidu.tieba.account;

import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.atomData.AccountRestoreActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.PageType;
/* loaded from: classes.dex */
public class AccountRestoreActivity extends BaseActivity<AccountRestoreActivity> {
    private static final String PAGE_TYPE = "page_type";
    private NavigationBar mNavigationBar;
    private String mPageType;
    private BaseWebView mWebView;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(AccountRestoreActivityConfig.class, AccountRestoreActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.account_restore_activity);
        this.mPageType = getIntent().getStringExtra(PAGE_TYPE);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.anti_account_restore));
        this.mWebView = (BaseWebView) findViewById(com.baidu.tieba.w.webview_acc_restore);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.addJavascriptInterface(this, "AccountJsBridge");
        initCookie();
        this.mWebView.loadUrl("http://tieba.baidu.com/mo/q/account_page?_client_version=" + TbConfig.getVersion());
    }

    public void initCookie() {
        try {
            AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(TbadkCoreApplication.getCurrentBduss());
            CookieSyncManager.createInstance(getPageContext().getPageActivity());
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie("baidu.com", "BDUSS=" + parseBDUSS.mBduss + "; domain=.baidu.com;");
            cookieManager.setCookie("baidu.com", "PTOKEN=" + parseBDUSS.mPtoken + "; domain=.baidu.com;");
            CookieSyncManager.getInstance().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    @JavascriptInterface
    public void exit(int i) {
        if (PageType.PERSON_INFO.toString().equals(this.mPageType)) {
            TbadkCoreApplication.setRefreshFlag(true);
        } else if (PageType.FRS.toString().equals(this.mPageType)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
        }
        finish();
    }
}
