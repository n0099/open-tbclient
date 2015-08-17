package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ n agF;
    private final /* synthetic */ AccountData agG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar, AccountData accountData) {
        this.agF = nVar;
        this.agG = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.agG);
    }
}
