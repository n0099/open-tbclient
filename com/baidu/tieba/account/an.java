package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1026a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ReLoginActivity reLoginActivity) {
        this.f1026a = reLoginActivity;
    }

    @Override // com.baidu.tieba.account.q
    public void a(AccountData accountData) {
        this.f1026a.finish();
    }
}
