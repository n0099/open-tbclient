package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements o {
    final /* synthetic */ ao a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.a = aoVar;
    }

    @Override // com.baidu.tieba.account.o
    public void a(AccountData accountData) {
        ReLoginShareActivity reLoginShareActivity;
        ReLoginShareActivity reLoginShareActivity2;
        reLoginShareActivity = this.a.a;
        reLoginShareActivity.n = accountData;
        reLoginShareActivity2 = this.a.a;
        reLoginShareActivity2.n();
    }
}
