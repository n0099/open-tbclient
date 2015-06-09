package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.a.b {
    final /* synthetic */ p awx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.awx = pVar;
    }

    @Override // com.baidu.tbadk.core.a.b
    public void cb(String str) {
        u uVar;
        u uVar2;
        uVar = this.awx.awu;
        if (uVar != null) {
            uVar2 = this.awx.awu;
            uVar2.cb(str);
        }
    }

    @Override // com.baidu.tbadk.core.a.b
    public void a(AccountData accountData) {
        u uVar;
        u uVar2;
        uVar = this.awx.awu;
        if (uVar != null) {
            uVar2 = this.awx.awu;
            uVar2.onSuccess();
        }
    }

    @Override // com.baidu.tbadk.core.a.b
    public void c(String str, int i, String str2) {
        if (i == 1) {
            ReloginManager.sg().e(null);
        }
        r rVar = new r(this, str);
        rVar.setPriority(3);
        rVar.execute(new Void[0]);
    }
}
