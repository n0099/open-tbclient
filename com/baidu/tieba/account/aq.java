package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements p {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ap f900a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar) {
        this.f900a = apVar;
    }

    @Override // com.baidu.tieba.account.p
    public void a(AccountData accountData) {
        ReLoginShareActivity reLoginShareActivity;
        ReLoginShareActivity reLoginShareActivity2;
        reLoginShareActivity = this.f900a.f899a;
        reLoginShareActivity.n = accountData;
        reLoginShareActivity2 = this.f900a.f899a;
        reLoginShareActivity2.m();
    }
}
