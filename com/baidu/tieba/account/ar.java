package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements p {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ap f885a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap apVar) {
        this.f885a = apVar;
    }

    @Override // com.baidu.tieba.account.p
    public void a(AccountData accountData) {
        ReLoginShareActivity reLoginShareActivity;
        reLoginShareActivity = this.f885a.f883a;
        reLoginShareActivity.d();
    }
}
