package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements l.a {
    final /* synthetic */ FillUProfileActivity agu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FillUProfileActivity fillUProfileActivity) {
        this.agu = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.l.a
    public void g(AccountData accountData) {
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, this.agu.getPageContext().getPageActivity());
        this.agu.wc();
    }
}
