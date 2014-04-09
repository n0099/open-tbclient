package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class am implements com.baidu.tbadk.coreExtra.view.u {
    final /* synthetic */ SapiFastRegActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(SapiFastRegActivity sapiFastRegActivity) {
        this.a = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.u
    public final void a(AccountData accountData) {
        com.baidu.tbadk.core.a.u uVar;
        com.baidu.tbadk.core.a.n a = com.baidu.tbadk.core.a.a.a(accountData.getBDUSS());
        String account = accountData.getAccount();
        String str = a.a;
        String str2 = a.b;
        uVar = this.a.e;
        com.baidu.tbadk.core.a.t.a(account, str, str2, uVar, true);
    }
}
