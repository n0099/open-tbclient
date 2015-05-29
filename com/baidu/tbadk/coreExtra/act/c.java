package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.core.a.b {
    final /* synthetic */ FillUProfileActivity abr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FillUProfileActivity fillUProfileActivity) {
        this.abr = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.core.a.b
    public void cb(String str) {
    }

    @Override // com.baidu.tbadk.core.a.b
    public void a(AccountData accountData) {
        if (accountData.getAccount() != null && !"".equals(accountData.getAccount())) {
            com.baidu.tbadk.core.a.d.b(accountData);
            TbadkCoreApplication.setCurrentAccount(accountData, this.abr.getBaseContext());
            this.abr.uY();
            return;
        }
        this.abr.f(accountData);
    }

    @Override // com.baidu.tbadk.core.a.b
    public void c(String str, int i, String str2) {
        this.abr.showToast(str2);
    }
}
