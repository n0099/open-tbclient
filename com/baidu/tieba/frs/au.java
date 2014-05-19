package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class au implements df {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.df
    public void a(i iVar, j jVar) {
        cs csVar;
        cs csVar2;
        cs csVar3;
        g gVar;
        g gVar2;
        cs csVar4;
        g gVar3;
        g gVar4;
        if (iVar.a) {
            csVar3 = this.a.w;
            csVar3.a(this.a.getString(com.baidu.tieba.u.add_fan_sucess));
            gVar = this.a.I;
            gVar.l().b(1);
            gVar2 = this.a.I;
            gVar2.l().c(iVar.c);
            csVar4 = this.a.w;
            gVar3 = this.a.I;
            ForumData g = gVar3.g();
            gVar4 = this.a.I;
            csVar4.a(1, g, gVar4, false);
            com.baidu.tieba.ad.c().e(true);
            return;
        }
        if (jVar.d == null || jVar.d.length() <= 0) {
            csVar = this.a.w;
            csVar.a(this.a.getString(com.baidu.tieba.u.add_fan_error));
        } else {
            csVar2 = this.a.w;
            csVar2.a(jVar.d);
        }
        if (jVar.c != 120002) {
            return;
        }
        this.a.D();
    }
}
