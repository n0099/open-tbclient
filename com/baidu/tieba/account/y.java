package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class y implements Runnable {
    private final /* synthetic */ AccountData TP;
    final /* synthetic */ NotLoginGuideActivity aJJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(NotLoginGuideActivity notLoginGuideActivity, AccountData accountData) {
        this.aJJ = notLoginGuideActivity;
        this.TP = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.TP);
    }
}
