package com.baidu.tieba.account;

import android.os.Handler;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
final class bq implements AuthorizationListener {
    final /* synthetic */ SapiFastRegActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(SapiFastRegActivity sapiFastRegActivity) {
        this.a = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public final void onSuccess() {
        Handler handler;
        az azVar;
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (!com.baidu.tieba.util.bs.c(session.username)) {
            this.a.b = "login_user";
            String str = session.username;
            String str2 = session.bduss;
            String str3 = session.ptoken;
            azVar = this.a.d;
            ay.a(str, str2, str3, azVar, true);
            return;
        }
        AccountData accountData = new AccountData();
        accountData.setAccount(session.username);
        accountData.setID(session.uid);
        accountData.setBDUSS(String.valueOf(session.bduss) + "|" + session.ptoken);
        accountData.setPortrait(session.portrait);
        this.a.b = "regist_user";
        handler = this.a.c;
        handler.post(new br(this, accountData));
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public final void onFailed(int i, String str) {
        com.baidu.adp.lib.util.e.e("simon", "onFailed", str);
        this.a.finish();
    }
}
