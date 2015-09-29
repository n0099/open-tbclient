package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class q implements a.InterfaceC0040a {
    final /* synthetic */ NotLoginGuideActivity aEY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NotLoginGuideActivity notLoginGuideActivity) {
        this.aEY = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void cc(String str) {
        if (this.aEY.getLoadingDialog() == null || !this.aEY.getLoadingDialog().isShowing()) {
            this.aEY.showLoadingDialog(this.aEY.getPageContext().getString(i.h.sapi_logining), new r(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aEY.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aEY.n(accountData);
        } else {
            this.aEY.o(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void c(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aEY.closeLoadingDialog();
        i2 = this.aEY.aEW;
        if (i2 != 1) {
            i3 = this.aEY.aEW;
            if (i3 != 2) {
                return;
            }
            this.aEY.Gb();
            return;
        }
        this.aEY.Ga();
    }
}
