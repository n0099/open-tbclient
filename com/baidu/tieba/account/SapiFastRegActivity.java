package com.baidu.tieba.account;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class SapiFastRegActivity extends BaseActivity<SapiFastRegActivity> {
    private com.baidu.tbadk.coreExtra.view.t aap = null;
    private String awl = null;
    private final com.baidu.tbadk.core.a.b Sl = new ai(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(com.baidu.tieba.w.layout_sapi_webview_fastreg);
        uo();
    }

    protected void uo() {
        SapiWebView sapiWebView = (SapiWebView) findViewById(com.baidu.tieba.v.sapi_webview);
        com.baidu.tbadk.core.a.f.a(getPageContext().getContext(), sapiWebView);
        sapiWebView.setOnFinishCallback(new aj(this));
        sapiWebView.setAuthorizationListener(new ak(this));
        sapiWebView.loadFastReg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AccountData accountData) {
        if (this.aap == null) {
            this.aap = new com.baidu.tbadk.coreExtra.view.t(getPageContext());
            this.aap.a(new al(this));
        }
        this.aap.xg();
        this.aap.k(accountData);
        this.aap.xc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(AccountData accountData) {
        com.baidu.tbadk.core.a.d.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getBaseContext());
        Intent intent = new Intent();
        intent.putExtra(RegisterActivityConfig.FAST_REG_USER_TYPE, this.awl);
        setResult(-1, intent);
        finish();
    }
}
