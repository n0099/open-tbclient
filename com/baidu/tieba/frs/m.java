package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class m implements ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f865a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.f865a = frsActivity;
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
        if (xVar.f1068a) {
            azVar3 = this.f865a.l;
            azVar3.a(this.f865a.getString(R.string.add_fan_sucess));
            vVar = this.f865a.v;
            vVar.e().b(1);
            vVar2 = this.f865a.v;
            vVar2.e().c(xVar.c);
            azVar4 = this.f865a.l;
            vVar3 = this.f865a.v;
            com.baidu.tieba.data.r a2 = vVar3.a();
            vVar4 = this.f865a.v;
            azVar4.a(1, a2, vVar4.e());
            TiebaApplication.f().i(true);
            return;
        }
        if (yVar.d == null || yVar.d.length() <= 0) {
            azVar = this.f865a.l;
            azVar.a(this.f865a.getString(R.string.add_fan_error));
        } else {
            azVar2 = this.f865a.l;
            azVar2.a(yVar.d);
        }
        if (yVar.c != 120002) {
            return;
        }
        this.f865a.y();
    }
}
