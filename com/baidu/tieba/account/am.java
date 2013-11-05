package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1025a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ReLoginActivity reLoginActivity) {
        this.f1025a = reLoginActivity;
    }

    @Override // com.baidu.tieba.account.q
    public void a(AccountData accountData) {
        this.f1025a.a(accountData);
    }
}
