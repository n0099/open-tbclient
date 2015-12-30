package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class u implements a.InterfaceC0041a {
    final /* synthetic */ NotLoginGuideActivity aIE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NotLoginGuideActivity notLoginGuideActivity) {
        this.aIE = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void ck(String str) {
        if (this.aIE.getLoadingDialog() == null || !this.aIE.getLoadingDialog().isShowing()) {
            this.aIE.showLoadingDialog(this.aIE.getPageContext().getString(n.j.sapi_logining), new v(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aIE.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aIE.n(accountData);
        } else {
            this.aIE.o(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void c(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aIE.closeLoadingDialog();
        i2 = this.aIE.aIC;
        if (i2 != 1) {
            i3 = this.aIE.aIC;
            if (i3 != 2) {
                return;
            }
            this.aIE.GS();
            return;
        }
        this.aIE.GR();
    }
}
