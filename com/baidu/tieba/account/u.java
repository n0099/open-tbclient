package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements k.a {
    final /* synthetic */ NotLoginGuideActivity aHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NotLoginGuideActivity notLoginGuideActivity) {
        this.aHc = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.k.a
    public void i(AccountData accountData) {
        this.aHc.o(accountData);
    }
}
