package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class t implements bx {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.bx
    public void a(com.baidu.tieba.model.ab abVar, com.baidu.tieba.model.ac acVar) {
        br brVar;
        br brVar2;
        br brVar3;
        com.baidu.tieba.model.z zVar;
        com.baidu.tieba.model.z zVar2;
        br brVar4;
        com.baidu.tieba.model.z zVar3;
        com.baidu.tieba.model.z zVar4;
        if (abVar.a) {
            brVar3 = this.a.p;
            brVar3.a(this.a.getString(R.string.add_fan_sucess));
            zVar = this.a.A;
            zVar.g().b(1);
            zVar2 = this.a.A;
            zVar2.g().c(abVar.c);
            brVar4 = this.a.p;
            zVar3 = this.a.A;
            ForumData b = zVar3.b();
            zVar4 = this.a.A;
            brVar4.a(1, b, zVar4, false);
            TiebaApplication.g().h(true);
            return;
        }
        if (acVar.d == null || acVar.d.length() <= 0) {
            brVar = this.a.p;
            brVar.a(this.a.getString(R.string.add_fan_error));
        } else {
            brVar2 = this.a.p;
            brVar2.a(acVar.d);
        }
        if (acVar.c != 120002) {
            return;
        }
        this.a.C();
    }
}
