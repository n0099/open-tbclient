package com.baidu.tieba.account;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements o {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // com.baidu.tieba.account.o
    public void a(com.baidu.tieba.a.a aVar) {
        com.baidu.tieba.a.a aVar2;
        com.baidu.tieba.d.k.a(aVar);
        aVar2 = this.a.T;
        TiebaApplication.b(aVar2);
        this.a.b();
    }
}
