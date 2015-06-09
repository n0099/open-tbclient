package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ac implements com.baidu.tbadk.core.a.b {
    final /* synthetic */ NotLoginGuideActivity axc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(NotLoginGuideActivity notLoginGuideActivity) {
        this.axc = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.a.b
    public void cb(String str) {
        if (this.axc.getLoadingDialog() == null || !this.axc.getLoadingDialog().isShowing()) {
            this.axc.showLoadingDialog(this.axc.getPageContext().getString(com.baidu.tieba.t.sapi_logining), new ad(this));
        }
    }

    @Override // com.baidu.tbadk.core.a.b
    public void a(AccountData accountData) {
        this.axc.closeLoadingDialog();
        if (TextUtils.isEmpty(accountData.getAccount())) {
            this.axc.f(accountData);
        } else {
            this.axc.n(accountData);
        }
    }

    @Override // com.baidu.tbadk.core.a.b
    public void c(String str, int i, String str2) {
        int i2;
        int i3;
        this.axc.closeLoadingDialog();
        i2 = this.axc.axb;
        if (i2 != 1) {
            i3 = this.axc.axb;
            if (i3 != 2) {
                return;
            }
            this.axc.Fi();
            return;
        }
        this.axc.Fh();
    }
}
