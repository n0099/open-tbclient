package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.coreExtra.view.x {
    final /* synthetic */ FillUProfileActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FillUProfileActivity fillUProfileActivity) {
        this.a = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.x
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.account.a.a(accountData);
        TbadkApplication.setCurrentAccount(accountData, this.a.getBaseContext());
        this.a.b();
    }
}
