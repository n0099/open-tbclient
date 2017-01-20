package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class q implements a.InterfaceC0032a {
    final /* synthetic */ NotLoginGuideActivity aPS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NotLoginGuideActivity notLoginGuideActivity) {
        this.aPS = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
    public void cf(String str) {
        if (this.aPS.getLoadingDialog() == null || !this.aPS.getLoadingDialog().isShowing()) {
            this.aPS.showLoadingDialog(this.aPS.getPageContext().getString(r.l.sapi_logining), new r(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aPS.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aPS.k(accountData);
        } else {
            this.aPS.p(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
    public void b(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aPS.closeLoadingDialog();
        i2 = this.aPS.aPQ;
        if (i2 != 1) {
            i3 = this.aPS.aPQ;
            if (i3 != 2) {
                return;
            }
            this.aPS.KZ();
            return;
        }
        this.aPS.KY();
    }
}
