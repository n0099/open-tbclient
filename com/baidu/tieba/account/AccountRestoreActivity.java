package com.baidu.tieba.account;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.R;
import d.a.j0.d3.l0.b;
import d.a.j0.d3.l0.c;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes4.dex */
public class AccountRestoreActivity extends BaseActivity<AccountRestoreActivity> {
    public static final String JS_PROMPT_ACCOUNT_METHOD_EXIT = "exit";
    public static final String JS_PROMPT_INTERFACE_NAME = "AccountJsBridge";
    public static final String PAGE_TYPE = "page_type";
    public d.a.j0.d3.l0.a jsBridge;
    public NavigationBar mNavigationBar;
    public String mPageType;
    public BaseWebView mWebView;
    public b jsPromptInterface = new b() { // from class: com.baidu.tieba.account.AccountRestoreActivity.1
        @Override // d.a.j0.d3.l0.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (TextUtils.equals(AccountRestoreActivity.JS_PROMPT_INTERFACE_NAME, str) && TextUtils.equals("exit", str2)) {
                jsPromptResult.confirm();
                AccountRestoreActivity.this.exitPage();
                return true;
            }
            return false;
        }
    };
    public c jsCallback = new a();

    /* loaded from: classes4.dex */
    public class a implements c {
        public a() {
        }

        @Override // d.a.j0.d3.l0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            if (AccountRestoreActivity.this.jsBridge != null) {
                return AccountRestoreActivity.this.jsBridge.b(AccountRestoreActivity.this.mWebView, str, jsPromptResult);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitPage() {
        if (PageType.PERSON_INFO.toString().equals(this.mPageType)) {
            TbadkCoreApplication.setRefreshFlag(true);
        } else if (PageType.FRS.toString().equals(this.mPageType)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_restore_activity);
        d.a.j0.d3.l0.a aVar = new d.a.j0.d3.l0.a();
        this.jsBridge = aVar;
        aVar.a(this.jsPromptInterface);
        this.mPageType = getIntent().getStringExtra("page_type");
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.anti_account_restore));
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        BaseWebView baseWebView = (BaseWebView) findViewById(R.id.webview_acc_restore);
        this.mWebView = baseWebView;
        baseWebView.setOnJsPromptCallback(this.jsCallback);
        BaseWebView baseWebView2 = this.mWebView;
        baseWebView2.loadUrl("http://tieba.baidu.com/mo/q/account_page?_client_version=" + TbConfig.getVersion());
    }
}
