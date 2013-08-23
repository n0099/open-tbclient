package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class m implements ad {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1106a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.f1106a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ad
    public void a(com.baidu.tieba.model.ac acVar, com.baidu.tieba.model.ad adVar) {
        bb bbVar;
        bb bbVar2;
        bb bbVar3;
        com.baidu.tieba.model.aa aaVar;
        com.baidu.tieba.model.aa aaVar2;
        bb bbVar4;
        com.baidu.tieba.model.aa aaVar3;
        com.baidu.tieba.model.aa aaVar4;
        if (acVar.f1355a) {
            bbVar3 = this.f1106a.l;
            bbVar3.a(this.f1106a.getString(R.string.add_fan_sucess));
            aaVar = this.f1106a.v;
            aaVar.e().b(1);
            aaVar2 = this.f1106a.v;
            aaVar2.e().c(acVar.c);
            bbVar4 = this.f1106a.l;
            aaVar3 = this.f1106a.v;
            com.baidu.tieba.data.v a2 = aaVar3.a();
            aaVar4 = this.f1106a.v;
            bbVar4.a(1, a2, aaVar4.e());
            TiebaApplication.g().i(true);
            return;
        }
        if (adVar.d == null || adVar.d.length() <= 0) {
            bbVar = this.f1106a.l;
            bbVar.a(this.f1106a.getString(R.string.add_fan_error));
        } else {
            bbVar2 = this.f1106a.l;
            bbVar2.a(adVar.d);
        }
        if (adVar.c != 120002) {
            return;
        }
        this.f1106a.A();
    }
}
