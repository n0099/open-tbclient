package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class q implements a.InterfaceC0031a {
    final /* synthetic */ NotLoginGuideActivity aVE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NotLoginGuideActivity notLoginGuideActivity) {
        this.aVE = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0031a
    public void bY(String str) {
        if (this.aVE.getLoadingDialog() == null || !this.aVE.getLoadingDialog().isShowing()) {
            this.aVE.showLoadingDialog(this.aVE.getPageContext().getString(w.l.sapi_logining), new r(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0031a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aVE.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aVE.k(accountData);
        } else {
            this.aVE.p(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0031a
    public void b(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aVE.closeLoadingDialog();
        i2 = this.aVE.aVC;
        if (i2 != 1) {
            i3 = this.aVE.aVC;
            if (i3 != 2) {
                return;
            }
            this.aVE.LE();
            return;
        }
        this.aVE.LD();
    }
}
