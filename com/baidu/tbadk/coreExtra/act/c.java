package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.core.a.b {
    final /* synthetic */ FillUProfileActivity aao;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FillUProfileActivity fillUProfileActivity) {
        this.aao = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.core.a.b
    public void bO(String str) {
    }

    @Override // com.baidu.tbadk.core.a.b
    public void a(AccountData accountData) {
        if (accountData.getAccount() != null && !"".equals(accountData.getAccount())) {
            com.baidu.tbadk.core.a.d.b(accountData);
            TbadkCoreApplication.setCurrentAccount(accountData, this.aao.getBaseContext());
            this.aao.up();
            return;
        }
        this.aao.f(accountData);
    }

    @Override // com.baidu.tbadk.core.a.b
    public void c(String str, int i, String str2) {
        this.aao.showToast(str2);
    }
}
