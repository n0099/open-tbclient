package com.baidu.tieba.frs;
/* loaded from: classes.dex */
final class af implements com.baidu.tieba.model.bd {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.model.bd
    public final void a(String str, long j) {
        String str2;
        g gVar;
        String str3;
        String str4;
        cm cmVar;
        cm cmVar2;
        f a = f.a();
        str2 = this.a.i;
        a.b(str2);
        gVar = this.a.D;
        gVar.f().setLike(0);
        str3 = this.a.J;
        if (str3.equals("normal_page")) {
            cmVar2 = this.a.r;
            cmVar2.g(0);
        } else {
            str4 = this.a.J;
            if (str4.equals("frs_page")) {
                cmVar = this.a.r;
                cmVar.h(0);
            }
        }
        com.baidu.tieba.r.c().f(str);
    }

    @Override // com.baidu.tieba.model.bd
    public final void a() {
    }
}
