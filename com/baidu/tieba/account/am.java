package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class am implements p {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f859a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ReLoginActivity reLoginActivity) {
        this.f859a = reLoginActivity;
    }

    @Override // com.baidu.tieba.account.p
    public void a(AccountData accountData) {
        this.f859a.finish();
    }
}
