package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tieba.model.bd {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.model.bd
    public void a(String str, long j) {
        String str2;
        g gVar;
        String str3;
        String str4;
        cs csVar;
        cs csVar2;
        f a = f.a();
        str2 = this.a.n;
        a.b(str2);
        gVar = this.a.I;
        gVar.g().setLike(0);
        str3 = this.a.O;
        if (str3.equals("normal_page")) {
            csVar2 = this.a.w;
            csVar2.g(0);
        } else {
            str4 = this.a.O;
            if (str4.equals("frs_page")) {
                csVar = this.a.w;
                csVar.h(0);
            }
        }
        com.baidu.tieba.ad.c().f(str);
    }

    @Override // com.baidu.tieba.model.bd
    public void b(String str, long j) {
    }
}
