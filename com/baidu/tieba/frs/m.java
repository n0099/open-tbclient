package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class m implements ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1089a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.f1089a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ab
    public void a(com.baidu.tieba.model.ac acVar, com.baidu.tieba.model.ad adVar) {
        az azVar;
        az azVar2;
        az azVar3;
        com.baidu.tieba.model.aa aaVar;
        com.baidu.tieba.model.aa aaVar2;
        az azVar4;
        com.baidu.tieba.model.aa aaVar3;
        com.baidu.tieba.model.aa aaVar4;
        if (acVar.f1322a) {
            azVar3 = this.f1089a.l;
            azVar3.a(this.f1089a.getString(R.string.add_fan_sucess));
            aaVar = this.f1089a.v;
            aaVar.e().b(1);
            aaVar2 = this.f1089a.v;
            aaVar2.e().c(acVar.c);
            azVar4 = this.f1089a.l;
            aaVar3 = this.f1089a.v;
            com.baidu.tieba.data.v a2 = aaVar3.a();
            aaVar4 = this.f1089a.v;
            azVar4.a(1, a2, aaVar4.e());
            TiebaApplication.f().j(true);
            return;
        }
        if (adVar.d == null || adVar.d.length() <= 0) {
            azVar = this.f1089a.l;
            azVar.a(this.f1089a.getString(R.string.add_fan_error));
        } else {
            azVar2 = this.f1089a.l;
            azVar2.a(adVar.d);
        }
        if (adVar.c != 120002) {
            return;
        }
        this.f1089a.w();
    }
}
