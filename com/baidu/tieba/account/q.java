package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class q implements a.InterfaceC0030a {
    final /* synthetic */ NotLoginGuideActivity aVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NotLoginGuideActivity notLoginGuideActivity) {
        this.aVR = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
    public void cf(String str) {
        if (this.aVR.getLoadingDialog() == null || !this.aVR.getLoadingDialog().isShowing()) {
            this.aVR.showLoadingDialog(this.aVR.getPageContext().getString(w.l.sapi_logining), new r(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aVR.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aVR.k(accountData);
        } else {
            this.aVR.p(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0030a
    public void b(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aVR.closeLoadingDialog();
        i2 = this.aVR.aVP;
        if (i2 != 1) {
            i3 = this.aVR.aVP;
            if (i3 != 2) {
                return;
            }
            this.aVR.Mf();
            return;
        }
        this.aVR.Me();
    }
}
