package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.core.account.g {
    final /* synthetic */ FillUProfileActivity Pr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FillUProfileActivity fillUProfileActivity) {
        this.Pr = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onBeforeLogin(String str) {
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onSuccess(AccountData accountData) {
        if (accountData.getAccount() != null && !"".equals(accountData.getAccount())) {
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkCoreApplication.setCurrentAccount(accountData, this.Pr.getBaseContext());
            this.Pr.rc();
            return;
        }
        this.Pr.e(accountData);
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onFailure(String str, int i, String str2) {
        this.Pr.showToast(str2);
    }
}
