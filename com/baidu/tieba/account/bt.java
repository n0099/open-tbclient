package com.baidu.tieba.account;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements AuthorizationListener {
    final /* synthetic */ SapiFastRegActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(SapiFastRegActivity sapiFastRegActivity) {
        this.a = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        be beVar;
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (!com.baidu.tieba.util.bu.c(session.username)) {
            AccountData accountData = new AccountData();
            accountData.setAccount(session.username);
            accountData.setID(session.uid);
            accountData.setBDUSS(session.bduss);
            accountData.setPortrait(session.portrait);
            String str = session.username;
            String str2 = session.bduss;
            String str3 = session.ptoken;
            beVar = this.a.a;
            bd.a(str, str2, str3, beVar, true);
            return;
        }
        LoginActivity.a(this.a, 1);
        this.a.finish();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        com.baidu.adp.lib.g.e.e("simon", "onFailed", str);
        this.a.finish();
    }
}
