package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class n implements af {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1414a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.f1414a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.af
    public void a(com.baidu.tieba.model.am amVar, com.baidu.tieba.model.an anVar) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        bn bnVar4;
        com.baidu.tieba.model.ak akVar3;
        com.baidu.tieba.model.ak akVar4;
        if (amVar.f1988a) {
            bnVar3 = this.f1414a.n;
            bnVar3.a(this.f1414a.getString(R.string.add_fan_sucess));
            akVar = this.f1414a.w;
            akVar.f().b(1);
            akVar2 = this.f1414a.w;
            akVar2.f().c(amVar.c);
            bnVar4 = this.f1414a.n;
            akVar3 = this.f1414a.w;
            ForumData a2 = akVar3.a();
            akVar4 = this.f1414a.w;
            bnVar4.a(1, a2, akVar4, false);
            TiebaApplication.h().h(true);
            return;
        }
        if (anVar.d == null || anVar.d.length() <= 0) {
            bnVar = this.f1414a.n;
            bnVar.a(this.f1414a.getString(R.string.add_fan_error));
        } else {
            bnVar2 = this.f1414a.n;
            bnVar2.a(anVar.d);
        }
        if (anVar.c == 120002) {
            this.f1414a.A();
        }
    }
}
