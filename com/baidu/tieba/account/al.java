package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class al implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f649a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ReLoginActivity reLoginActivity) {
        this.f649a = reLoginActivity;
    }

    @Override // com.baidu.tieba.account.o
    public void a(AccountData accountData) {
        this.f649a.finish();
    }
}
