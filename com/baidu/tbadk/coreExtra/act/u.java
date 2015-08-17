package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements l.a {
    final /* synthetic */ LoginActivity agE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(LoginActivity loginActivity) {
        this.agE = loginActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.l.a
    public void g(AccountData accountData) {
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, this.agE.getPageContext().getPageActivity());
        this.agE.wh();
        this.agE.wc();
    }
}
