package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class q implements a.InterfaceC0033a {
    final /* synthetic */ NotLoginGuideActivity aUB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NotLoginGuideActivity notLoginGuideActivity) {
        this.aUB = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void ch(String str) {
        if (this.aUB.getLoadingDialog() == null || !this.aUB.getLoadingDialog().isShowing()) {
            this.aUB.showLoadingDialog(this.aUB.getPageContext().getString(r.j.sapi_logining), new r(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aUB.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aUB.k(accountData);
        } else {
            this.aUB.p(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aUB.closeLoadingDialog();
        i2 = this.aUB.aUz;
        if (i2 != 1) {
            i3 = this.aUB.aUz;
            if (i3 != 2) {
                return;
            }
            this.aUB.Mk();
            return;
        }
        this.aUB.Mj();
    }
}
