package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements j.a {
    final /* synthetic */ NotLoginGuideActivity aUB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NotLoginGuideActivity notLoginGuideActivity) {
        this.aUB = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public void j(AccountData accountData) {
        this.aUB.p(accountData);
    }
}
