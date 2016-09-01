package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class v implements a.InterfaceC0033a {
    final /* synthetic */ NotLoginGuideActivity aSA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NotLoginGuideActivity notLoginGuideActivity) {
        this.aSA = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void cf(String str) {
        if (this.aSA.getLoadingDialog() == null || !this.aSA.getLoadingDialog().isShowing()) {
            this.aSA.showLoadingDialog(this.aSA.getPageContext().getString(t.j.sapi_logining), new w(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aSA.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aSA.k(accountData);
        } else {
            this.aSA.p(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aSA.closeLoadingDialog();
        i2 = this.aSA.aSy;
        if (i2 != 1) {
            i3 = this.aSA.aSy;
            if (i3 != 2) {
                return;
            }
            this.aSA.LH();
            return;
        }
        this.aSA.LG();
    }
}
