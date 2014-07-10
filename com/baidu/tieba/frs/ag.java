package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tieba.model.bf {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.model.bf
    public void a(String str, long j) {
        String str2;
        g gVar;
        String str3;
        String str4;
        ct ctVar;
        ct ctVar2;
        f a = f.a();
        str2 = this.a.m;
        a.b(str2);
        gVar = this.a.H;
        gVar.g().setLike(0);
        str3 = this.a.N;
        if (str3.equals("normal_page")) {
            ctVar2 = this.a.v;
            ctVar2.g(0);
        } else {
            str4 = this.a.N;
            if (str4.equals("frs_page")) {
                ctVar = this.a.v;
                ctVar.h(0);
            }
        }
        com.baidu.tieba.ai.c().f(str);
    }

    @Override // com.baidu.tieba.model.bf
    public void b(String str, long j) {
    }
}
