package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class y implements Runnable {
    private final /* synthetic */ AccountData Mb;
    final /* synthetic */ NotLoginGuideActivity aMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(NotLoginGuideActivity notLoginGuideActivity, AccountData accountData) {
        this.aMm = notLoginGuideActivity;
        this.Mb = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.Mb);
    }
}
