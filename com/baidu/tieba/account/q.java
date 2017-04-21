package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class q implements a.InterfaceC0030a {
    final /* synthetic */ NotLoginGuideActivity aVT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NotLoginGuideActivity notLoginGuideActivity) {
        this.aVT = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
    public void cf(String str) {
        if (this.aVT.getLoadingDialog() == null || !this.aVT.getLoadingDialog().isShowing()) {
            this.aVT.showLoadingDialog(this.aVT.getPageContext().getString(w.l.sapi_logining), new r(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aVT.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aVT.k(accountData);
        } else {
            this.aVT.p(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
    public void b(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aVT.closeLoadingDialog();
        i2 = this.aVT.aVR;
        if (i2 != 1) {
            i3 = this.aVT.aVR;
            if (i3 != 2) {
                return;
            }
            this.aVT.Mf();
            return;
        }
        this.aVT.Me();
    }
}
