package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b aCb;
    private final /* synthetic */ AccountData aCc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, AccountData accountData) {
        this.aCb = bVar;
        this.aCc = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.aCc);
    }
}
