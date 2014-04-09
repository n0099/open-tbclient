package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
final class al implements Runnable {
    final /* synthetic */ ak a;
    private final /* synthetic */ AccountData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, AccountData accountData) {
        this.a = akVar;
        this.b = accountData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SapiFastRegActivity sapiFastRegActivity;
        sapiFastRegActivity = this.a.a;
        SapiFastRegActivity.a(sapiFastRegActivity, this.b);
    }
}
