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
    public void a(com.baidu.tieba.c.u uVar, com.baidu.tieba.c.v vVar) {
        ba baVar;
        ba baVar2;
        ba baVar3;
        com.baidu.tieba.c.s sVar;
        com.baidu.tieba.c.s sVar2;
        ba baVar4;
        com.baidu.tieba.c.s sVar3;
        com.baidu.tieba.c.s sVar4;
        if (uVar.a) {
            baVar3 = this.a.l;
            baVar3.a(this.a.getString(R.string.add_fan_sucess));
            sVar = this.a.v;
            sVar.e().b(1);
            sVar2 = this.a.v;
            sVar2.e().c(uVar.c);
            baVar4 = this.a.l;
            sVar3 = this.a.v;
            com.baidu.tieba.a.s a = sVar3.a();
            sVar4 = this.a.v;
            baVar4.a(1, a, sVar4.e());
            TiebaApplication.e().i(true);
            return;
        }
        if (vVar.d == null || vVar.d.length() <= 0) {
            baVar = this.a.l;
            baVar.a(this.a.getString(R.string.add_fan_error));
        } else {
            baVar2 = this.a.l;
            baVar2.a(vVar.d);
        }
        if (vVar.c != 120002) {
            return;
        }
        this.a.y();
    }
}
