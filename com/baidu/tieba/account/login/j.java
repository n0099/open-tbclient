package com.baidu.tieba.account.login;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements l.a {
    final /* synthetic */ Login2Activity aGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Login2Activity login2Activity) {
        this.aGf = login2Activity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.l.a
    public void g(AccountData accountData) {
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, this.aGf.getActivity());
        this.aGf.wh();
        this.aGf.wc();
    }
}
