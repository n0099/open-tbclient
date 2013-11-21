package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class an implements r {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1040a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ReLoginActivity reLoginActivity) {
        this.f1040a = reLoginActivity;
    }

    @Override // com.baidu.tieba.account.r
    public void a(AccountData accountData) {
        this.f1040a.finish();
    }
}
