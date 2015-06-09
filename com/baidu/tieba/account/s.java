package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.a.b {
    final /* synthetic */ p awx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.awx = pVar;
    }

    @Override // com.baidu.tieba.a.b
    public void a(AccountData accountData) {
        u uVar;
        u uVar2;
        new t(this, accountData).execute(new Void[0]);
        uVar = this.awx.awu;
        if (uVar != null) {
            uVar2 = this.awx.awu;
            uVar2.onSuccess();
        }
    }

    @Override // com.baidu.tieba.a.b
    public void fp(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.a.d.cc(str);
        }
    }
}
