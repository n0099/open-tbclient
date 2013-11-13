package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class am implements q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1037a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ReLoginActivity reLoginActivity) {
        this.f1037a = reLoginActivity;
    }

    @Override // com.baidu.tieba.account.q
    public void a(AccountData accountData) {
        this.f1037a.finish();
    }
}
