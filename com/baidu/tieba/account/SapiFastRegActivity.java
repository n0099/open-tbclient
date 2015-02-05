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
    private com.baidu.tbadk.coreExtra.view.t PP = null;
    private String aob = null;
    private final com.baidu.tbadk.core.account.g Gi = new ac(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(SapiFastRegActivityConfig.class, SapiFastRegActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.layout_sapi_webview_fastreg);
        rg();
    }

    protected void rg() {
        SapiWebView sapiWebView = (SapiWebView) findViewById(com.baidu.tieba.w.sapi_webview);
        com.baidu.tbadk.core.account.j.a(getPageContext().getContext(), sapiWebView);
        sapiWebView.setOnFinishCallback(new ad(this));
        sapiWebView.setAuthorizationListener(new ae(this));
        sapiWebView.loadFastReg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(AccountData accountData) {
        if (this.PP == null) {
            this.PP = new com.baidu.tbadk.coreExtra.view.t(this);
            this.PP.a(new af(this));
        }
        this.PP.tG();
        this.PP.g(accountData);
        this.PP.tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        com.baidu.tbadk.core.account.a.a(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getBaseContext());
        Intent intent = new Intent();
        intent.putExtra("fast_reg_user_type", this.aob);
        setResult(-1, intent);
        finish();
    }
}
