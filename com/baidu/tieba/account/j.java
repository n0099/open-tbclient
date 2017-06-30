package com.baidu.tieba.account;

import com.baidu.tieba.account.AccountActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ AccountActivity.a aUU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AccountActivity.a aVar) {
        this.aUU = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AccountActivity accountActivity;
        accountActivity = AccountActivity.this;
        accountActivity.finish();
    }
}
