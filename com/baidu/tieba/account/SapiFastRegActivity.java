package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.aw;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class SapiFastRegActivity extends BaseActivity {
    private com.baidu.tbadk.coreExtra.view.q a = null;
    private String b = null;
    private final com.baidu.tbadk.core.account.g c = new aa(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(aw.class, SapiFastRegActivity.class);
    }

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, SapiFastRegActivity.class), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.layout_sapi_webview_fastreg);
        a();
    }

    protected void a() {
        SapiWebView sapiWebView = (SapiWebView) findViewById(com.baidu.tieba.v.sapi_webview);
        com.baidu.tbadk.core.account.j.a(this, sapiWebView);
        sapiWebView.setOnFinishCallback(new ab(this));
        sapiWebView.setAuthorizationListener(new ac(this));
        sapiWebView.loadFastReg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountData accountData) {
        if (this.a == null) {
            this.a = new com.baidu.tbadk.coreExtra.view.q(this);
            this.a.a(new ad(this));
        }
        this.a.e();
        this.a.a(accountData);
        this.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AccountData accountData) {
        com.baidu.tbadk.core.account.a.a(accountData);
        TbadkApplication.setCurrentAccount(accountData, getBaseContext());
        Intent intent = new Intent();
        intent.putExtra("fast_reg_user_type", this.b);
        setResult(-1, intent);
        finish();
    }
}
