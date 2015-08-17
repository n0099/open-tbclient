package com.baidu.tieba.account;

import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends AuthorizationListener {
    final /* synthetic */ SapiFastRegActivity aFk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(SapiFastRegActivity sapiFastRegActivity) {
        this.aFk = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_success", 0, "", new Object[0]);
        this.aFk.Gj();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_fail", i, str, new Object[0]);
        if (str != null && !"".equals(str)) {
            this.aFk.showToast(str);
        } else {
            this.aFk.showToast(i.C0057i.data_load_error);
        }
        this.aFk.finish();
    }
}
