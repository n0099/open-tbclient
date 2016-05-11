package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class x implements Runnable {
    private final /* synthetic */ AccountData Mb;
    final /* synthetic */ NotLoginGuideActivity aIP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(NotLoginGuideActivity notLoginGuideActivity, AccountData accountData) {
        this.aIP = notLoginGuideActivity;
        this.Mb = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.Mb);
    }
}
