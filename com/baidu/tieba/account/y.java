package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class y implements Runnable {
    private final /* synthetic */ AccountData LZ;
    final /* synthetic */ NotLoginGuideActivity aNg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(NotLoginGuideActivity notLoginGuideActivity, AccountData accountData) {
        this.aNg = notLoginGuideActivity;
        this.LZ = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.LZ);
    }
}
