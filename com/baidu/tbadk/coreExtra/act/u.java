package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.coreExtra.view.y {
    final /* synthetic */ FillUProfileActivity PU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FillUProfileActivity fillUProfileActivity) {
        this.PU = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.y
    public void f(AccountData accountData) {
        com.baidu.tbadk.core.account.a.a(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, this.PU.getBaseContext());
        this.PU.rn();
    }
}
