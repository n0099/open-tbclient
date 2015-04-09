package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ m aau;
    private final /* synthetic */ AccountData aav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, AccountData accountData) {
        this.aau = mVar;
        this.aav = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.d.b(this.aav);
    }
}
