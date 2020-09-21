package com.baidu.tieba.account;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.e.c;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes21.dex */
public class AccountRestoreActivity extends BaseActivity<AccountRestoreActivity> {
    private static final String JS_PROMPT_ACCOUNT_METHOD_EXIT = "exit";
    private static final String JS_PROMPT_INTERFACE_NAME = "AccountJsBridge";
    private static final String PAGE_TYPE = "page_type";
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private NavigationBar mNavigationBar;
    private String mPageType;
    private BaseWebView mWebView;
    private com.baidu.tieba.tbadkCore.e.b jsPromptInterface = new com.baidu.tieba.tbadkCore.e.b() { // from class: com.baidu.tieba.account.AccountRestoreActivity.1
        @Override // com.baidu.tieba.tbadkCore.e.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (TextUtils.equals(AccountRestoreActivity.JS_PROMPT_INTERFACE_NAME, str) && TextUtils.equals("exit", str2)) {
                jsPromptResult.confirm();
                AccountRestoreActivity.this.exitPage();
                return true;
            }
            return false;
        }
    };
    private c jsCallback = new c() { // from class: com.baidu.tieba.account.AccountRestoreActivity.2
        @Override // com.baidu.tieba.tbadkCore.e.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            if (AccountRestoreActivity.this.jsBridge != null) {
                return AccountRestoreActivity.this.jsBridge.a(str, jsPromptResult);
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_restore_activity);
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(this.jsPromptInterface);
        this.mPageType = getIntent().getStringExtra("page_type");
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.anti_account_restore));
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mWebView = (BaseWebView) findViewById(R.id.webview_acc_restore);
        this.mWebView.setOnJsPromptCallback(this.jsCallback);
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
