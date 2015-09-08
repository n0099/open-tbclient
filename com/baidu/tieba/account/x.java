package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements k.a {
    final /* synthetic */ NotLoginGuideActivity aGc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(NotLoginGuideActivity notLoginGuideActivity) {
        this.aGc = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.k.a
    public void g(AccountData accountData) {
        this.aGc.p(accountData);
    }
}
