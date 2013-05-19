package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class m implements ab {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ab
    public void a(com.baidu.tieba.c.r rVar, com.baidu.tieba.c.s sVar) {
        ba baVar;
        ba baVar2;
        ba baVar3;
        com.baidu.tieba.c.p pVar;
        com.baidu.tieba.c.p pVar2;
        ba baVar4;
        com.baidu.tieba.c.p pVar3;
        com.baidu.tieba.c.p pVar4;
        if (rVar.a) {
            baVar3 = this.a.l;
            baVar3.a(this.a.getString(R.string.add_fan_sucess));
            pVar = this.a.v;
            pVar.e().b(1);
            pVar2 = this.a.v;
            pVar2.e().c(rVar.c);
            baVar4 = this.a.l;
            pVar3 = this.a.v;
            com.baidu.tieba.a.s a = pVar3.a();
            pVar4 = this.a.v;
            baVar4.a(1, a, pVar4.e());
            TiebaApplication.d().h(true);
            return;
        }
        if (sVar.d == null || sVar.d.length() <= 0) {
            baVar = this.a.l;
            baVar.a(this.a.getString(R.string.add_fan_error));
        } else {
            baVar2 = this.a.l;
            baVar2.a(sVar.d);
        }
        if (sVar.c != 120002) {
            return;
        }
        this.a.y();
    }
}
