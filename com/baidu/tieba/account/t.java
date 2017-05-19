package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class t implements Runnable {
    private final /* synthetic */ AccountData Sp;
    final /* synthetic */ NotLoginGuideActivity aWp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(NotLoginGuideActivity notLoginGuideActivity, AccountData accountData) {
        this.aWp = notLoginGuideActivity;
        this.Sp = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.Sp);
    }
}
