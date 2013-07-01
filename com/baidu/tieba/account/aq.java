package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ao f654a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar) {
        this.f654a = aoVar;
    }

    @Override // com.baidu.tieba.account.o
    public void a(AccountData accountData) {
        ReLoginShareActivity reLoginShareActivity;
        reLoginShareActivity = this.f654a.f652a;
        reLoginShareActivity.d();
    }
}
