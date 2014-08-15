package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.core.account.g {
    final /* synthetic */ FillUProfileActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FillUProfileActivity fillUProfileActivity) {
        this.a = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onBeforeLogin(String str) {
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onSuccess(AccountData accountData) {
        if (accountData.getAccount() != null && !"".equals(accountData.getAccount())) {
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkApplication.setCurrentAccount(accountData, this.a.getBaseContext());
            this.a.b();
            return;
        }
        this.a.a(accountData);
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onFailure(String str, int i, String str2) {
        this.a.showToast(str2);
    }
}
