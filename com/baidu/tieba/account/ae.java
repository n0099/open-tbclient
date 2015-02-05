package com.baidu.tieba.account;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends AuthorizationListener {
    final /* synthetic */ SapiFastRegActivity aoc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(SapiFastRegActivity sapiFastRegActivity) {
        this.aoc = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        com.baidu.tbadk.core.account.g gVar;
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            String str = session.username;
            String str2 = session.bduss;
            String str3 = session.ptoken;
            gVar = this.aoc.Gi;
            com.baidu.tbadk.core.account.f.a(str, str2, str3, gVar);
        }
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        if (str != null && !"".equals(str)) {
            this.aoc.showToast(str);
        } else {
            this.aoc.showToast(com.baidu.tieba.z.data_load_error);
        }
        this.aoc.finish();
    }
}
