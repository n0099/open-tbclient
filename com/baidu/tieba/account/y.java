package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class y implements Runnable {
    private final /* synthetic */ AccountData TO;
    final /* synthetic */ NotLoginGuideActivity aEu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(NotLoginGuideActivity notLoginGuideActivity, AccountData accountData) {
        this.aEu = notLoginGuideActivity;
        this.TO = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.TO);
    }
}
