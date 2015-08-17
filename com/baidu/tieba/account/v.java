package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class v implements a.InterfaceC0040a {
    final /* synthetic */ NotLoginGuideActivity aEu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NotLoginGuideActivity notLoginGuideActivity) {
        this.aEu = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void cb(String str) {
        if (this.aEu.getLoadingDialog() == null || !this.aEu.getLoadingDialog().isShowing()) {
            this.aEu.showLoadingDialog(this.aEu.getPageContext().getString(i.C0057i.sapi_logining), new w(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aEu.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aEu.f(accountData);
        } else {
            this.aEu.q(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void c(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aEu.closeLoadingDialog();
        i2 = this.aEu.aEs;
        if (i2 != 1) {
            i3 = this.aEu.aEs;
            if (i3 != 2) {
                return;
            }
            this.aEu.FW();
            return;
        }
        this.aEu.FV();
    }
}
