package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.core.account.g {
    final /* synthetic */ FillUProfileActivity Ki;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FillUProfileActivity fillUProfileActivity) {
        this.Ki = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onBeforeLogin(String str) {
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onSuccess(AccountData accountData) {
        if (accountData.getAccount() != null && !"".equals(accountData.getAccount())) {
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkApplication.setCurrentAccount(accountData, this.Ki.getBaseContext());
            this.Ki.ob();
            return;
        }
        this.Ki.e(accountData);
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onFailure(String str, int i, String str2) {
        this.Ki.showToast(str2);
    }
}
