package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
final class aj implements Runnable {
    final /* synthetic */ ai a;
    private final /* synthetic */ AccountData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, AccountData accountData) {
        this.a = aiVar;
        this.b = accountData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SapiFastRegActivity sapiFastRegActivity;
        sapiFastRegActivity = this.a.a;
        SapiFastRegActivity.a(sapiFastRegActivity, this.b);
    }
}
