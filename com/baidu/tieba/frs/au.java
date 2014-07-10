package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class au implements dh {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dh
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
            ctVar3 = this.a.v;
            ctVar3.a(this.a.getString(com.baidu.tieba.y.add_fan_sucess));
            gVar = this.a.H;
            gVar.l().b(1);
            gVar2 = this.a.H;
            gVar2.l().c(iVar.c);
            ctVar4 = this.a.v;
            gVar3 = this.a.H;
            ForumData g = gVar3.g();
            gVar4 = this.a.H;
            ctVar4.a(1, g, gVar4, false);
            com.baidu.tieba.ai.c().e(true);
            return;
        }
        if (jVar.d == null || jVar.d.length() <= 0) {
            ctVar = this.a.v;
            ctVar.a(this.a.getString(com.baidu.tieba.y.add_fan_error));
        } else {
            ctVar2 = this.a.v;
            ctVar2.a(jVar.d);
        }
        if (jVar.c != 120002) {
            return;
        }
        this.a.E();
    }
}
