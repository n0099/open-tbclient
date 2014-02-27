package com.baidu.tieba.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.person.cm;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.view.BaseWebView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class AccountRestoreActivity extends com.baidu.tieba.f {
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
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_restore_activity);
        this.mPageType = getIntent().getStringExtra(PAGE_TYPE);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.a(getString(R.string.anti_account_restore));
        this.mWebView = (BaseWebView) findViewById(R.id.webview_acc_restore);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.addJavascriptInterface(this, "AccountJsBridge");
        initCookie();
        this.mWebView.loadUrl("http://tieba.baidu.com/mo/q/account_page?_client_version=" + com.baidu.tieba.data.i.u());
    }

    public void initCookie() {
        try {
            o a = a.a(TiebaApplication.x());
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
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.b(i);
    }

    public void exit(int i) {
        if (AntiHelper.PageType.PERSON_INFO.toString().equals(this.mPageType)) {
            cm.b(true);
        } else if (AntiHelper.PageType.FRS.toString().equals(this.mPageType)) {
            FrsActivity.a(true);
        }
        finish();
    }
}
