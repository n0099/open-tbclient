package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements k.a {
    final /* synthetic */ FillUProfileActivity agE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FillUProfileActivity fillUProfileActivity) {
        this.agE = fillUProfileActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.k.a
    public void g(AccountData accountData) {
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, this.agE.getPageContext().getPageActivity());
        this.agE.wh();
    }
}
