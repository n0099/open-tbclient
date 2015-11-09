package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class q implements a.InterfaceC0040a {
    final /* synthetic */ NotLoginGuideActivity aEd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NotLoginGuideActivity notLoginGuideActivity) {
        this.aEd = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void cb(String str) {
        if (this.aEd.getLoadingDialog() == null || !this.aEd.getLoadingDialog().isShowing()) {
            this.aEd.showLoadingDialog(this.aEd.getPageContext().getString(i.h.sapi_logining), new r(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aEd.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aEd.n(accountData);
        } else {
            this.aEd.o(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void c(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aEd.closeLoadingDialog();
        i2 = this.aEd.aEb;
        if (i2 != 1) {
            i3 = this.aEd.aEb;
            if (i3 != 2) {
                return;
            }
            this.aEd.FU();
            return;
        }
        this.aEd.FT();
    }
}
