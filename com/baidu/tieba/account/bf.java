package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bf implements ad {
    final /* synthetic */ ReLoginShareActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(ReLoginShareActivity reLoginShareActivity) {
        this.a = reLoginShareActivity;
    }

    @Override // com.baidu.tieba.account.ad
    public final void a(AccountData accountData) {
        ReLoginShareActivity.c(this.a);
    }
}
