package com.baidu.tieba.account;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.person.bn;
import com.baidu.tieba.util.AntiHelper;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes.dex */
public class AccountRestoreActivity extends com.baidu.tbadk.a {
    private static final String PAGE_TYPE = "page_type";
    private NavigationBar mNavigationBar;
    private String mPageType;
    private BaseWebView mWebView;

    public static void startActivity(Context context, AntiHelper.PageType pageType) {
        Intent intent = new Intent(context, AccountRestoreActivity.class);
        intent.putExtra(PAGE_TYPE, pageType.toString());
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.account_restore_activity);
        this.mPageType = getIntent().getStringExtra(PAGE_TYPE);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.mNavigationBar.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.a(getString(com.baidu.tieba.a.k.anti_account_restore));
        this.mWebView = (BaseWebView) findViewById(com.baidu.tieba.a.h.webview_acc_restore);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.addJavascriptInterface(this, "AccountJsBridge");
        initCookie();
        this.mWebView.loadUrl("http://tieba.baidu.com/mo/q/account_page?_client_version=" + com.baidu.tbadk.core.data.n.c());
    }

    public void initCookie() {
        try {
            com.baidu.tbadk.core.a.n a = com.baidu.tbadk.core.a.a.a(TbadkApplication.D());
            CookieSyncManager.createInstance(this);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie("baidu.com", "BDUSS=" + a.a + "; domain=.baidu.com;");
            cookieManager.setCookie("baidu.com", "PTOKEN=" + a.b + "; domain=.baidu.com;");
            CookieSyncManager.getInstance().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.b(i);
    }

    public void exit(int i) {
        if (AntiHelper.PageType.PERSON_INFO.toString().equals(this.mPageType)) {
            bn.c(true);
        } else if (AntiHelper.PageType.FRS.toString().equals(this.mPageType)) {
            com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2003003, null));
        }
        finish();
    }
}
