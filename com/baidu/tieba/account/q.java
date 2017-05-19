package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class q implements a.InterfaceC0035a {
    final /* synthetic */ NotLoginGuideActivity aWp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NotLoginGuideActivity notLoginGuideActivity) {
        this.aWp = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void cf(String str) {
        if (this.aWp.getLoadingDialog() == null || !this.aWp.getLoadingDialog().isShowing()) {
            this.aWp.showLoadingDialog(this.aWp.getPageContext().getString(w.l.sapi_logining), new r(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aWp.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aWp.k(accountData);
        } else {
            this.aWp.p(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void b(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aWp.closeLoadingDialog();
        i2 = this.aWp.aWn;
        if (i2 != 1) {
            i3 = this.aWp.aWn;
            if (i3 != 2) {
                return;
            }
            this.aWp.Lt();
            return;
        }
        this.aWp.Ls();
    }
}
