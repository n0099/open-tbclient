package com.baidu.tieba.account;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements t {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // com.baidu.tieba.account.t
    public void a(com.baidu.tieba.a.a aVar) {
        com.baidu.tieba.a.a aVar2;
        com.baidu.tieba.c.k.a(aVar);
        aVar2 = this.a.P;
        TiebaApplication.b(aVar2);
        this.a.g();
    }
}
