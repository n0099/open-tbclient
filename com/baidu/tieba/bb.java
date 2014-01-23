package com.baidu.tieba;

import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bb implements Runnable {
    final /* synthetic */ AccountData a;
    final /* synthetic */ TiebaApplication b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(AccountData accountData, TiebaApplication tiebaApplication) {
        this.a = accountData;
        this.b = tiebaApplication;
    }

    @Override // java.lang.Runnable
    public void run() {
        TiebaApplication.b(this.a, this.b);
    }
}
