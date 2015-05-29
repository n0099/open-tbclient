package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ac implements com.baidu.tbadk.core.a.b {
    final /* synthetic */ NotLoginGuideActivity axb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(NotLoginGuideActivity notLoginGuideActivity) {
        this.axb = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.b
    public void cb(String str) {
        if (this.axb.getLoadingDialog() == null || !this.axb.getLoadingDialog().isShowing()) {
            this.axb.showLoadingDialog(this.axb.getPageContext().getString(com.baidu.tieba.t.sapi_logining), new ad(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.b
    public void a(AccountData accountData) {
        this.axb.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.axb.f(accountData);
        } else {
            this.axb.n(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.b
    public void c(String str, int i, String str2) {
        int i2;
        int i3;
        this.axb.closeLoadingDialog();
        i2 = this.axb.axa;
        if (i2 != 1) {
            i3 = this.axb.axa;
            if (i3 != 2) {
                return;
            }
            this.axb.Fh();
            return;
        }
        this.axb.Fg();
    }
}
