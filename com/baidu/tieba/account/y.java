package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class y implements Runnable {
    private final /* synthetic */ AccountData On;
    final /* synthetic */ NotLoginGuideActivity aSA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(NotLoginGuideActivity notLoginGuideActivity, AccountData accountData) {
        this.aSA = notLoginGuideActivity;
        this.On = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.On);
    }
}
