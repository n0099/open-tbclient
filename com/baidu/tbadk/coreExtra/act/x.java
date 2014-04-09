package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x implements com.baidu.tbadk.coreExtra.view.u {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.u
    public final void a(AccountData accountData) {
        com.baidu.tbadk.core.a.o.a(accountData);
        TbadkApplication.a(accountData, this.a.getBaseContext());
        this.a.a();
    }
}
