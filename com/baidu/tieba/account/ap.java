package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ao f653a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.f653a = aoVar;
    }

    @Override // com.baidu.tieba.account.o
    public void a(AccountData accountData) {
        ReLoginShareActivity reLoginShareActivity;
        ReLoginShareActivity reLoginShareActivity2;
        reLoginShareActivity = this.f653a.f652a;
        reLoginShareActivity.n = accountData;
        reLoginShareActivity2 = this.f653a.f652a;
        reLoginShareActivity2.n();
    }
}
