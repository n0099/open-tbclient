package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b Zl;
    private final /* synthetic */ AccountData Zm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, AccountData accountData) {
        this.Zl = bVar;
        this.Zm = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.account.a.a(this.Zm);
    }
}
