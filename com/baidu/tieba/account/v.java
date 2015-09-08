package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class v implements a.InterfaceC0040a {
    final /* synthetic */ NotLoginGuideActivity aGc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NotLoginGuideActivity notLoginGuideActivity) {
        this.aGc = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void cc(String str) {
        if (this.aGc.getLoadingDialog() == null || !this.aGc.getLoadingDialog().isShowing()) {
            this.aGc.showLoadingDialog(this.aGc.getPageContext().getString(i.h.sapi_logining), new w(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aGc.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aGc.f(accountData);
        } else {
            this.aGc.p(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void c(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aGc.closeLoadingDialog();
        i2 = this.aGc.aGa;
        if (i2 != 1) {
            i3 = this.aGc.aGa;
            if (i3 != 2) {
                return;
            }
            this.aGc.Gg();
            return;
        }
        this.aGc.Gf();
    }
}
