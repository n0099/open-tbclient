package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements k.a {
    final /* synthetic */ NotLoginGuideActivity aEd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NotLoginGuideActivity notLoginGuideActivity) {
        this.aEd = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.k.a
    public void i(AccountData accountData) {
        this.aEd.o(accountData);
    }
}
