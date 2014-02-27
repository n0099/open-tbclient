package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
final class br implements Runnable {
    final /* synthetic */ bq a;
    private final /* synthetic */ AccountData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bq bqVar, AccountData accountData) {
        this.a = bqVar;
        this.b = accountData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SapiFastRegActivity sapiFastRegActivity;
        sapiFastRegActivity = this.a.a;
        SapiFastRegActivity.a(sapiFastRegActivity, this.b);
    }
}
