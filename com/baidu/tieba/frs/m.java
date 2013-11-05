package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class m implements ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1289a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.f1289a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ab
    public void a(com.baidu.tieba.model.am amVar, com.baidu.tieba.model.an anVar) {
        ba baVar;
        ba baVar2;
        ba baVar3;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        ba baVar4;
        com.baidu.tieba.model.ak akVar3;
        com.baidu.tieba.model.ak akVar4;
        if (amVar.f1897a) {
            baVar3 = this.f1289a.o;
            baVar3.a(this.f1289a.getString(R.string.add_fan_sucess));
            akVar = this.f1289a.x;
            akVar.e().b(1);
            akVar2 = this.f1289a.x;
            akVar2.e().c(amVar.c);
            baVar4 = this.f1289a.o;
            akVar3 = this.f1289a.x;
            ForumData a2 = akVar3.a();
            akVar4 = this.f1289a.x;
            baVar4.a(1, a2, akVar4.e());
            TiebaApplication.g().h(true);
            return;
        }
        if (anVar.d == null || anVar.d.length() <= 0) {
            baVar = this.f1289a.o;
            baVar.a(this.f1289a.getString(R.string.add_fan_error));
        } else {
            baVar2 = this.f1289a.o;
            baVar2.a(anVar.d);
        }
        if (anVar.c == 120002) {
            this.f1289a.C();
        }
    }
}
