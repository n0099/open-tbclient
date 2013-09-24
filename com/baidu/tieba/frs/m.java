package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class m implements ac {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1154a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.f1154a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ac
    public void a(com.baidu.tieba.model.ae aeVar, com.baidu.tieba.model.af afVar) {
        ba baVar;
        ba baVar2;
        ba baVar3;
        com.baidu.tieba.model.ac acVar;
        com.baidu.tieba.model.ac acVar2;
        ba baVar4;
        com.baidu.tieba.model.ac acVar3;
        com.baidu.tieba.model.ac acVar4;
        if (aeVar.f1392a) {
            baVar3 = this.f1154a.o;
            baVar3.a(this.f1154a.getString(R.string.add_fan_sucess));
            acVar = this.f1154a.x;
            acVar.e().b(1);
            acVar2 = this.f1154a.x;
            acVar2.e().c(aeVar.c);
            baVar4 = this.f1154a.o;
            acVar3 = this.f1154a.x;
            com.baidu.tieba.data.v a2 = acVar3.a();
            acVar4 = this.f1154a.x;
            baVar4.a(1, a2, acVar4.e());
            TiebaApplication.g().h(true);
            return;
        }
        if (afVar.d == null || afVar.d.length() <= 0) {
            baVar = this.f1154a.o;
            baVar.a(this.f1154a.getString(R.string.add_fan_error));
        } else {
            baVar2 = this.f1154a.o;
            baVar2.a(afVar.d);
        }
        if (afVar.c != 120002) {
            return;
        }
        this.f1154a.D();
    }
}
