package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class q implements a.InterfaceC0033a {
    final /* synthetic */ NotLoginGuideActivity aTj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NotLoginGuideActivity notLoginGuideActivity) {
        this.aTj = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void cf(String str) {
        if (this.aTj.getLoadingDialog() == null || !this.aTj.getLoadingDialog().isShowing()) {
            this.aTj.showLoadingDialog(this.aTj.getPageContext().getString(r.j.sapi_logining), new r(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aTj.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aTj.k(accountData);
        } else {
            this.aTj.p(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aTj.closeLoadingDialog();
        i2 = this.aTj.aTh;
        if (i2 != 1) {
            i3 = this.aTj.aTh;
            if (i3 != 2) {
                return;
            }
            this.aTj.Ml();
            return;
        }
        this.aTj.Mk();
    }
}
