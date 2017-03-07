package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class t implements Runnable {
    private final /* synthetic */ AccountData SC;
    final /* synthetic */ NotLoginGuideActivity aVE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(NotLoginGuideActivity notLoginGuideActivity, AccountData accountData) {
        this.aVE = notLoginGuideActivity;
        this.SC = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.SC);
    }
}
