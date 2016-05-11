package com.baidu.tieba.account;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class AccountRestoreActivity extends BaseActivity<AccountRestoreActivity> {
    private static final String JS_PROMPT_ACCOUNT_METHOD_EXIT = "exit";
    private static final String JS_PROMPT_INTERFACE_NAME = "AccountJsBridge";
    private static final String PAGE_TYPE = "page_type";
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private NavigationBar mNavigationBar;
    private String mPageType;
    private BaseWebView mWebView;
    private com.baidu.tieba.tbadkCore.e.b jsPromptInterface = new m(this);
    private com.baidu.tieba.tbadkCore.e.c jsCallback = new n(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.account_restore_activity);
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(this.jsPromptInterface);
        this.mPageType = getIntent().getStringExtra("page_type");
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.anti_account_restore));
        ((LinearLayout.LayoutParams) ((TextView) findViewById(t.g.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mWebView = (BaseWebView) findViewById(t.g.webview_acc_restore);
        this.mWebView.setOnJsPromptCallback(this.jsCallback);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        com.baidu.tbadk.browser.f.I(getPageContext().getPageActivity());
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
