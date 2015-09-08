package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.a.a;
import com.baidu.tieba.account.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements a.InterfaceC0055a {
    final /* synthetic */ k aFw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.aFw = kVar;
    }

    @Override // com.baidu.tieba.a.a.InterfaceC0055a
    public void a(AccountData accountData) {
        k.a aVar;
        k.a aVar2;
        new o(this, accountData).execute(new Void[0]);
        aVar = this.aFw.aFt;
        if (aVar != null) {
            aVar2 = this.aFw.aFt;
            aVar2.onSuccess();
        }
    }

    @Override // com.baidu.tieba.a.a.InterfaceC0055a
    public void fR(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.a.b.cd(str);
        }
    }
}
