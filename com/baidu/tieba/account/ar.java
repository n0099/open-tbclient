package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aq f1030a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar) {
        this.f1030a = aqVar;
    }

    @Override // com.baidu.tieba.account.q
    public void a(AccountData accountData) {
        this.f1030a.f1029a.n = accountData;
        this.f1030a.f1029a.f();
    }
}
