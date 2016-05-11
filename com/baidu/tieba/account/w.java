package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements j.a {
    final /* synthetic */ NotLoginGuideActivity aIP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(NotLoginGuideActivity notLoginGuideActivity) {
        this.aIP = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public void i(AccountData accountData) {
        this.aIP.o(accountData);
    }
}
