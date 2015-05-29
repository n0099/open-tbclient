package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements x {
    final /* synthetic */ LoginActivity abx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(LoginActivity loginActivity) {
        this.abx = loginActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.x
    public void g(AccountData accountData) {
        com.baidu.tbadk.core.a.d.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, this.abx.getBaseContext());
        this.abx.vb();
        this.abx.uY();
    }
}
