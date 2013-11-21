package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements r {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aq f1055a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar) {
        this.f1055a = aqVar;
    }

    @Override // com.baidu.tieba.account.r
    public void a(AccountData accountData) {
        this.f1055a.f1054a.j = accountData;
        this.f1055a.f1054a.e();
    }
}
