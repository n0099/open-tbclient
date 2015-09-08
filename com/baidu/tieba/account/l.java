package com.baidu.tieba.account;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.account.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0040a {
    final /* synthetic */ k aFw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.aFw = kVar;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void cc(String str) {
        k.a aVar;
        k.a aVar2;
        aVar = this.aFw.aFt;
        if (aVar != null) {
            aVar2 = this.aFw.aFt;
            aVar2.cc(str);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void a(AccountData accountData) {
        k.a aVar;
        k.a aVar2;
        aVar = this.aFw.aFt;
        if (aVar != null) {
            aVar2 = this.aFw.aFt;
            aVar2.onSuccess();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void c(String str, int i, String str2) {
        if (i == 1) {
            ReloginManager.ts().e(null);
        }
        m mVar = new m(this, str);
        mVar.setPriority(3);
        mVar.execute(new Void[0]);
    }
}
