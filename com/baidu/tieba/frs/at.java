package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class at implements dg {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dg
    public void a(i iVar, j jVar) {
        ct ctVar;
        ct ctVar2;
        ct ctVar3;
        g gVar;
        g gVar2;
        ct ctVar4;
        g gVar3;
        g gVar4;
        if (iVar.a) {
            ctVar3 = this.a.w;
            ctVar3.a(this.a.getString(com.baidu.tieba.y.add_fan_sucess));
            gVar = this.a.I;
            gVar.l().b(1);
            gVar2 = this.a.I;
            gVar2.l().c(iVar.c);
            ctVar4 = this.a.w;
            gVar3 = this.a.I;
            ForumData g = gVar3.g();
            gVar4 = this.a.I;
            ctVar4.a(1, g, gVar4, false);
            com.baidu.tieba.ai.c().e(true);
            return;
        }
        if (jVar.d == null || jVar.d.length() <= 0) {
            ctVar = this.a.w;
            ctVar.a(this.a.getString(com.baidu.tieba.y.add_fan_error));
        } else {
            ctVar2 = this.a.w;
            ctVar2.a(jVar.d);
        }
        if (jVar.c != 120002) {
            return;
        }
        this.a.E();
    }
}
