package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.coreExtra.view.w {
    final /* synthetic */ FillUProfileActivity Kj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FillUProfileActivity fillUProfileActivity) {
        this.Kj = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.w
    public void f(AccountData accountData) {
        com.baidu.tbadk.core.account.a.a(accountData);
        TbadkApplication.setCurrentAccount(accountData, this.Kj.getBaseContext());
        this.Kj.ob();
    }
}
