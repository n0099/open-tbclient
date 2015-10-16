package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b atd;
    private final /* synthetic */ AccountData ate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, AccountData accountData) {
        this.atd = bVar;
        this.ate = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.ate);
    }
}
