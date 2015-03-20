package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.core.a.d;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b akh;
    private final /* synthetic */ AccountData aki;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, AccountData accountData) {
        this.akh = bVar;
        this.aki = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        d.b(this.aki);
    }
}
