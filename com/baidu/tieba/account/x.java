package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x implements com.baidu.tbadk.coreExtra.view.u {
    final /* synthetic */ ReLoginShareActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(ReLoginShareActivity reLoginShareActivity) {
        this.a = reLoginShareActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.u
    public final void a(AccountData accountData) {
        ReLoginShareActivity.a(this.a, accountData);
    }
}
