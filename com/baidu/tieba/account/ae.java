package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.coreExtra.view.x {
    final /* synthetic */ NotLoginGuideActivity axc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(NotLoginGuideActivity notLoginGuideActivity) {
        this.axc = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.x
    public void g(AccountData accountData) {
        this.axc.n(accountData);
    }
}
