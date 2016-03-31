package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class u implements a.InterfaceC0042a {
    final /* synthetic */ NotLoginGuideActivity aMF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NotLoginGuideActivity notLoginGuideActivity) {
        this.aMF = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void cg(String str) {
        if (this.aMF.getLoadingDialog() == null || !this.aMF.getLoadingDialog().isShowing()) {
            this.aMF.showLoadingDialog(this.aMF.getPageContext().getString(t.j.sapi_logining), new v(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aMF.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aMF.j(accountData);
        } else {
            this.aMF.o(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void b(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aMF.closeLoadingDialog();
        i2 = this.aMF.aMD;
        if (i2 != 1) {
            i3 = this.aMF.aMD;
            if (i3 != 2) {
                return;
            }
            this.aMF.JP();
            return;
        }
        this.aMF.JO();
    }
}
