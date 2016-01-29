package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class v implements a.InterfaceC0042a {
    final /* synthetic */ NotLoginGuideActivity aJJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NotLoginGuideActivity notLoginGuideActivity) {
        this.aJJ = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void cj(String str) {
        if (this.aJJ.getLoadingDialog() == null || !this.aJJ.getLoadingDialog().isShowing()) {
            this.aJJ.showLoadingDialog(this.aJJ.getPageContext().getString(t.j.sapi_logining), new w(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aJJ.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aJJ.j(accountData);
        } else {
            this.aJJ.o(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void c(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aJJ.closeLoadingDialog();
        i2 = this.aJJ.aJH;
        if (i2 != 1) {
            i3 = this.aJJ.aJH;
            if (i3 != 2) {
                return;
            }
            this.aJJ.It();
            return;
        }
        this.aJJ.Is();
    }
}
