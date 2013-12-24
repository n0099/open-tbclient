package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class n implements af {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.a = frsActivity;
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
        if (amVar.a) {
            bnVar3 = this.a.n;
            bnVar3.a(this.a.getString(R.string.add_fan_sucess));
            akVar = this.a.w;
            akVar.f().b(1);
            akVar2 = this.a.w;
            akVar2.f().c(amVar.c);
            bnVar4 = this.a.n;
            akVar3 = this.a.w;
            ForumData a = akVar3.a();
            akVar4 = this.a.w;
            bnVar4.a(1, a, akVar4, false);
            TiebaApplication.h().h(true);
            return;
        }
        if (anVar.d == null || anVar.d.length() <= 0) {
            bnVar = this.a.n;
            bnVar.a(this.a.getString(R.string.add_fan_error));
        } else {
            bnVar2 = this.a.n;
            bnVar2.a(anVar.d);
        }
        if (anVar.c == 120002) {
            this.a.A();
        }
    }
}
