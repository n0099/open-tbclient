package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class v implements Runnable {
    private final /* synthetic */ AccountData TQ;
    final /* synthetic */ NotLoginGuideActivity aHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NotLoginGuideActivity notLoginGuideActivity, AccountData accountData) {
        this.aHc = notLoginGuideActivity;
        this.TQ = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.TQ);
    }
}
