package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements l.a {
    final /* synthetic */ NotLoginGuideActivity aEu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(NotLoginGuideActivity notLoginGuideActivity) {
        this.aEu = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.l.a
    public void g(AccountData accountData) {
        this.aEu.q(accountData);
    }
}
