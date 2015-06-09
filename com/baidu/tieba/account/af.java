package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class af implements Runnable {
    private final /* synthetic */ AccountData Pa;
    final /* synthetic */ NotLoginGuideActivity axc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(NotLoginGuideActivity notLoginGuideActivity, AccountData accountData) {
        this.axc = notLoginGuideActivity;
        this.Pa = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.d.b(this.Pa);
    }
}
