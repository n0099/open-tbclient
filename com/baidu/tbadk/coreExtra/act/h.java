package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements x {
    final /* synthetic */ FillUProfileActivity aaq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FillUProfileActivity fillUProfileActivity) {
        this.aaq = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.x
    public void g(AccountData accountData) {
        com.baidu.tbadk.core.a.d.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, this.aaq.getBaseContext());
        this.aaq.up();
    }
}
