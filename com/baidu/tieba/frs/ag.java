package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tieba.model.be {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.model.be
    public void a(String str, long j) {
        String str2;
        g gVar;
        String str3;
        String str4;
        ct ctVar;
        ct ctVar2;
        f a = f.a();
        str2 = this.a.n;
        a.b(str2);
        gVar = this.a.I;
        gVar.g().setLike(0);
        str3 = this.a.O;
        if (str3.equals("normal_page")) {
            ctVar2 = this.a.w;
            ctVar2.g(0);
        } else {
            str4 = this.a.O;
            if (str4.equals("frs_page")) {
                ctVar = this.a.w;
                ctVar.h(0);
            }
        }
        com.baidu.tieba.ai.c().f(str);
    }

    @Override // com.baidu.tieba.model.be
    public void b(String str, long j) {
    }
}
