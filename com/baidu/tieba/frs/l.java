package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class l implements aa {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.aa
    public void a(com.baidu.tieba.model.am amVar, com.baidu.tieba.model.an anVar) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        bk bkVar4;
        com.baidu.tieba.model.ak akVar3;
        com.baidu.tieba.model.ak akVar4;
        if (amVar.a) {
            bkVar3 = this.a.n;
            bkVar3.a(this.a.getString(R.string.add_fan_sucess));
            akVar = this.a.w;
            akVar.g().b(1);
            akVar2 = this.a.w;
            akVar2.g().c(amVar.c);
            bkVar4 = this.a.n;
            akVar3 = this.a.w;
            ForumData b = akVar3.b();
            akVar4 = this.a.w;
            bkVar4.a(1, b, akVar4, false);
            TiebaApplication.h().h(true);
            return;
        }
        if (anVar.d == null || anVar.d.length() <= 0) {
            bkVar = this.a.n;
            bkVar.a(this.a.getString(R.string.add_fan_error));
        } else {
            bkVar2 = this.a.n;
            bkVar2.a(anVar.d);
        }
        if (anVar.c == 120002) {
            this.a.z();
        }
    }
}
