package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
final class ai implements cw {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.cw
    public final void a(i iVar, j jVar) {
        cm cmVar;
        cm cmVar2;
        cm cmVar3;
        g gVar;
        g gVar2;
        cm cmVar4;
        g gVar3;
        g gVar4;
        if (iVar.a) {
            cmVar3 = this.a.r;
            cmVar3.a(this.a.getString(com.baidu.tieba.a.k.add_fan_sucess));
            gVar = this.a.D;
            gVar.k().b(1);
            gVar2 = this.a.D;
            gVar2.k().c(iVar.c);
            cmVar4 = this.a.r;
            gVar3 = this.a.D;
            ForumData f = gVar3.f();
            gVar4 = this.a.D;
            cmVar4.a(1, f, gVar4, false);
            com.baidu.tieba.r.c().e(true);
            return;
        }
        if (jVar.d == null || jVar.d.length() <= 0) {
            cmVar = this.a.r;
            cmVar.a(this.a.getString(com.baidu.tieba.a.k.add_fan_error));
        } else {
            cmVar2 = this.a.r;
            cmVar2.a(jVar.d);
        }
        if (jVar.c != 120002) {
            return;
        }
        this.a.n();
    }
}
