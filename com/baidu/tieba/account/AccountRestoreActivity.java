package com.baidu.tieba.account;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class AccountRestoreActivity extends BaseActivity<AccountRestoreActivity> {
    private static final String JS_PROMPT_ACCOUNT_METHOD_EXIT = "exit";
    private static final String JS_PROMPT_INTERFACE_NAME = "AccountJsBridge";
    private static final String PAGE_TYPE = "page_type";
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private NavigationBar mNavigationBar;
    private String mPageType;
    private BaseWebView mWebView;
    private com.baidu.tieba.tbadkCore.e.b jsPromptInterface = new l(this);
    private com.baidu.tieba.tbadkCore.e.c jsCallback = new m(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.account_restore_activity);
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(this.jsPromptInterface);
        this.mPageType = getIntent().getStringExtra(PAGE_TYPE);
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(n.i.anti_account_restore));
        this.mWebView = (BaseWebView) findViewById(n.f.webview_acc_restore);
        this.mWebView.setOnJsPromptCallback(this.jsCallback);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        com.baidu.tbadk.browser.f.W(getPageContext().getPageActivity());
        this.mWebView.loadUrl("http://tieba.baidu.com/mo/q/account_page?_client_version=" + TbConfig.getVersion());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitPage() {
        if (PageType.PERSON_INFO.toString().equals(this.mPageType)) {
            TbadkCoreApplication.setRefreshFlag(true);
        } else if (PageType.FRS.toString().equals(this.mPageType)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
        }
        finish();
    }
}
