package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class x implements Runnable {
    private final /* synthetic */ AccountData Rl;
    final /* synthetic */ NotLoginGuideActivity aMF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(NotLoginGuideActivity notLoginGuideActivity, AccountData accountData) {
        this.aMF = notLoginGuideActivity;
        this.Rl = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.Rl);
    }
}
