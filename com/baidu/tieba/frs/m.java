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
    public void a(com.baidu.tieba.model.x xVar, com.baidu.tieba.model.y yVar) {
        az azVar;
        az azVar2;
        az azVar3;
        com.baidu.tieba.model.v vVar;
        com.baidu.tieba.model.v vVar2;
        az azVar4;
        com.baidu.tieba.model.v vVar3;
        com.baidu.tieba.model.v vVar4;
        if (xVar.a) {
            azVar3 = this.a.l;
            azVar3.a(this.a.getString(R.string.add_fan_sucess));
            vVar = this.a.v;
            vVar.e().b(1);
            vVar2 = this.a.v;
            vVar2.e().c(xVar.c);
            azVar4 = this.a.l;
            vVar3 = this.a.v;
            com.baidu.tieba.data.r a = vVar3.a();
            vVar4 = this.a.v;
            azVar4.a(1, a, vVar4.e());
            TiebaApplication.f().i(true);
            return;
        }
        if (yVar.d == null || yVar.d.length() <= 0) {
            azVar = this.a.l;
            azVar.a(this.a.getString(R.string.add_fan_error));
        } else {
            azVar2 = this.a.l;
            azVar2.a(yVar.d);
        }
        if (yVar.c != 120002) {
            return;
        }
        this.a.y();
    }
}
