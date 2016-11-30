package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class q implements a.InterfaceC0033a {
    final /* synthetic */ NotLoginGuideActivity aVk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NotLoginGuideActivity notLoginGuideActivity) {
        this.aVk = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void cg(String str) {
        if (this.aVk.getLoadingDialog() == null || !this.aVk.getLoadingDialog().isShowing()) {
            this.aVk.showLoadingDialog(this.aVk.getPageContext().getString(r.j.sapi_logining), new r(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aVk.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aVk.k(accountData);
        } else {
            this.aVk.p(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aVk.closeLoadingDialog();
        i2 = this.aVk.aVi;
        if (i2 != 1) {
            i3 = this.aVk.aVi;
            if (i3 != 2) {
                return;
            }
            this.aVk.MR();
            return;
        }
        this.aVk.MQ();
    }
}
