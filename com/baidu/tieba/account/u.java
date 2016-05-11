package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class u implements a.InterfaceC0033a {
    final /* synthetic */ NotLoginGuideActivity aIP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NotLoginGuideActivity notLoginGuideActivity) {
        this.aIP = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void ce(String str) {
        if (this.aIP.getLoadingDialog() == null || !this.aIP.getLoadingDialog().isShowing()) {
            this.aIP.showLoadingDialog(this.aIP.getPageContext().getString(t.j.sapi_logining), new v(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aIP.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aIP.j(accountData);
        } else {
            this.aIP.o(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aIP.closeLoadingDialog();
        i2 = this.aIP.aIN;
        if (i2 != 1) {
            i3 = this.aIP.aIN;
            if (i3 != 2) {
                return;
            }
            this.aIP.Ig();
            return;
        }
        this.aIP.If();
    }
}
