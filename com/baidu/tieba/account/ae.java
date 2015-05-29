package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.coreExtra.view.x {
    final /* synthetic */ NotLoginGuideActivity axb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(NotLoginGuideActivity notLoginGuideActivity) {
        this.axb = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.x
    public void g(AccountData accountData) {
        this.axb.n(accountData);
    }
}
