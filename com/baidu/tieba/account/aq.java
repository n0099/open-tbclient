package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ap f1052a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar) {
        this.f1052a = apVar;
    }

    @Override // com.baidu.tieba.account.q
    public void a(AccountData accountData) {
        this.f1052a.f1040a.j = accountData;
        this.f1052a.f1040a.e();
    }
}
