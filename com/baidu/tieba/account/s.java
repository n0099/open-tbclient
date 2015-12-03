package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class s implements a.InterfaceC0041a {
    final /* synthetic */ NotLoginGuideActivity aHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NotLoginGuideActivity notLoginGuideActivity) {
        this.aHc = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void ci(String str) {
        if (this.aHc.getLoadingDialog() == null || !this.aHc.getLoadingDialog().isShowing()) {
            this.aHc.showLoadingDialog(this.aHc.getPageContext().getString(n.i.sapi_logining), new t(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
        this.aHc.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.aHc.n(accountData);
        } else {
            this.aHc.o(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void c(String str, int i, String str2) {
        int i2;
        int i3;
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
        this.aHc.closeLoadingDialog();
        i2 = this.aHc.aHb;
        if (i2 != 1) {
            i3 = this.aHc.aHb;
            if (i3 != 2) {
                return;
            }
            this.aHc.Hd();
            return;
        }
        this.aHc.Hc();
    }
}
