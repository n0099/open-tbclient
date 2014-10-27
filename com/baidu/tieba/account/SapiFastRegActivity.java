package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.SapiFastRegActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class SapiFastRegActivity extends BaseActivity {
    private com.baidu.tbadk.coreExtra.view.r Kh = null;
    private String afK = null;
    private final com.baidu.tbadk.core.account.g BW = new aa(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(SapiFastRegActivityConfig.class, SapiFastRegActivity.class);
    }

    public static void b(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, SapiFastRegActivity.class), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.layout_sapi_webview_fastreg);
        oa();
    }

    protected void oa() {
        SapiWebView sapiWebView = (SapiWebView) findViewById(com.baidu.tieba.v.sapi_webview);
        com.baidu.tbadk.core.account.j.a(this, sapiWebView);
        sapiWebView.setOnFinishCallback(new ab(this));
        sapiWebView.setAuthorizationListener(new ac(this));
        sapiWebView.loadFastReg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(AccountData accountData) {
        if (this.Kh == null) {
            this.Kh = new com.baidu.tbadk.coreExtra.view.r(this);
            this.Kh.a(new ad(this));
        }
        this.Kh.qa();
        this.Kh.g(accountData);
        this.Kh.pX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(AccountData accountData) {
        com.baidu.tbadk.core.account.a.a(accountData);
        TbadkApplication.setCurrentAccount(accountData, getBaseContext());
        Intent intent = new Intent();
        intent.putExtra("fast_reg_user_type", this.afK);
        setResult(-1, intent);
        finish();
    }
}
