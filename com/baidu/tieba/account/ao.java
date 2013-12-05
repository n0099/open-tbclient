package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class ao implements s {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1051a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ReLoginActivity reLoginActivity) {
        this.f1051a = reLoginActivity;
    }

    @Override // com.baidu.tieba.account.s
    public void a(AccountData accountData) {
        this.f1051a.finish();
    }
}
