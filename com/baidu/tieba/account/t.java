package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class t implements Runnable {
    private final /* synthetic */ AccountData SU;
    final /* synthetic */ NotLoginGuideActivity aVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(NotLoginGuideActivity notLoginGuideActivity, AccountData accountData) {
        this.aVR = notLoginGuideActivity;
        this.SU = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.SU);
    }
}
