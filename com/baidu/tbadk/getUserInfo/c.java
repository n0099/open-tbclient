package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.core.a.d;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b akp;
    private final /* synthetic */ AccountData akq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, AccountData accountData) {
        this.akp = bVar;
        this.akq = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        d.b(this.akq);
    }
}
