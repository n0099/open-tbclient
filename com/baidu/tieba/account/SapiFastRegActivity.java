package com.baidu.tieba.account;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SapiFastRegActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class SapiFastRegActivity extends BaseActivity<SapiFastRegActivity> {
    private com.baidu.tbadk.coreExtra.view.t PT = null;
    private String aoe = null;
    private final com.baidu.tbadk.core.account.g Gl = new ac(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(SapiFastRegActivityConfig.class, SapiFastRegActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.layout_sapi_webview_fastreg);
        rm();
    }

    protected void rm() {
        SapiWebView sapiWebView = (SapiWebView) findViewById(com.baidu.tieba.w.sapi_webview);
        com.baidu.tbadk.core.account.j.a(getPageContext().getContext(), sapiWebView);
        sapiWebView.setOnFinishCallback(new ad(this));
        sapiWebView.setAuthorizationListener(new ae(this));
        sapiWebView.loadFastReg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(AccountData accountData) {
        if (this.PT == null) {
            this.PT = new com.baidu.tbadk.coreExtra.view.t(this);
            this.PT.a(new af(this));
        }
        this.PT.tM();
        this.PT.g(accountData);
        this.PT.tJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        com.baidu.tbadk.core.account.a.a(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getBaseContext());
        Intent intent = new Intent();
        intent.putExtra("fast_reg_user_type", this.aoe);
        setResult(-1, intent);
        finish();
    }
}
