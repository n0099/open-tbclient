package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements s {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ar f1066a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar) {
        this.f1066a = arVar;
    }

    @Override // com.baidu.tieba.account.s
    public void a(AccountData accountData) {
        this.f1066a.f1065a.j = accountData;
        this.f1066a.f1065a.e();
    }
}
