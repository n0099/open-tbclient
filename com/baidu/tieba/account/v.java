package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class v implements a.InterfaceC0033a {
    final /* synthetic */ NotLoginGuideActivity aMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NotLoginGuideActivity notLoginGuideActivity) {
        this.aMm = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void cd(String str) {
        if (this.aMm.getLoadingDialog() == null || !this.aMm.getLoadingDialog().isShowing()) {
            this.aMm.showLoadingDialog(this.aMm.getPageContext().getString(u.j.sapi_logining), new w(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aMm.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aMm.j(accountData);
        } else {
            this.aMm.o(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aMm.closeLoadingDialog();
        i2 = this.aMm.aMk;
        if (i2 != 1) {
            i3 = this.aMm.aMk;
            if (i3 != 2) {
                return;
            }
            this.aMm.Jg();
            return;
        }
        this.aMm.Jf();
    }
}
