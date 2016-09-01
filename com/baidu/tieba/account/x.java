package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements j.a {
    final /* synthetic */ NotLoginGuideActivity aSA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(NotLoginGuideActivity notLoginGuideActivity) {
        this.aSA = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public void j(AccountData accountData) {
        this.aSA.p(accountData);
    }
}
