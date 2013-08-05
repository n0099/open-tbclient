package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements p {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ap f865a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar) {
        this.f865a = apVar;
    }

    @Override // com.baidu.tieba.account.p
    public void a(AccountData accountData) {
        ReLoginShareActivity reLoginShareActivity;
        ReLoginShareActivity reLoginShareActivity2;
        reLoginShareActivity = this.f865a.f864a;
        reLoginShareActivity.n = accountData;
        reLoginShareActivity2 = this.f865a.f864a;
        reLoginShareActivity2.l();
    }
}
