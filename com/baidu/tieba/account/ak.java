package com.baidu.tieba.account;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends AuthorizationListener {
    final /* synthetic */ SapiFastRegActivity awm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(SapiFastRegActivity sapiFastRegActivity) {
        this.awm = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        com.baidu.tbadk.core.a.b bVar;
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.a.a pD = com.baidu.tbadk.core.a.a.pD();
            String str = session.username;
            String str2 = session.bduss;
            String str3 = session.ptoken;
            bVar = this.awm.Sl;
            pD.a(str, str2, str3, bVar);
        }
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        if (str != null && !"".equals(str)) {
            this.awm.showToast(str);
        } else {
            this.awm.showToast(com.baidu.tieba.y.data_load_error);
        }
        this.awm.finish();
    }
}
