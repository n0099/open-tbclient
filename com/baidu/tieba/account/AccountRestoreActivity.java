package com.baidu.tieba.account;

import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.PageType;
/* loaded from: classes.dex */
public class AccountRestoreActivity extends BaseActivity<AccountRestoreActivity> {
    private static final String PAGE_TYPE = "page_type";
    private NavigationBar mNavigationBar;
    private String mPageType;
    private BaseWebView mWebView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.r.account_restore_activity);
        this.mPageType = getIntent().getStringExtra(PAGE_TYPE);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.t.anti_account_restore));
        this.mWebView = (BaseWebView) findViewById(com.baidu.tieba.q.webview_acc_restore);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.addJavascriptInterface(this, "AccountJsBridge");
        com.baidu.tbadk.browser.f.U(getPageContext().getPageActivity());
        this.mWebView.loadUrl("http://tieba.baidu.com/mo/q/account_page?_client_version=" + TbConfig.getVersion());
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
