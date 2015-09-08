package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ n agP;
    private final /* synthetic */ AccountData agQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar, AccountData accountData) {
        this.agP = nVar;
        this.agQ = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.agQ);
    }
}
