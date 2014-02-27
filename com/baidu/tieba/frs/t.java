package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class t implements by {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.by
    public final void a(com.baidu.tieba.model.ab abVar, com.baidu.tieba.model.ac acVar) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        com.baidu.tieba.model.z zVar;
        com.baidu.tieba.model.z zVar2;
        bs bsVar4;
        com.baidu.tieba.model.z zVar3;
        com.baidu.tieba.model.z zVar4;
        if (abVar.a) {
            bsVar3 = this.a.p;
            bsVar3.a(this.a.getString(R.string.add_fan_sucess));
            zVar = this.a.A;
            zVar.k().b(1);
            zVar2 = this.a.A;
            zVar2.k().c(abVar.c);
            bsVar4 = this.a.p;
            zVar3 = this.a.A;
            ForumData f = zVar3.f();
            zVar4 = this.a.A;
            bsVar4.a(1, f, zVar4, false);
            TiebaApplication.g().g(true);
            return;
        }
        if (acVar.d == null || acVar.d.length() <= 0) {
            bsVar = this.a.p;
            bsVar.a(this.a.getString(R.string.add_fan_error));
        } else {
            bsVar2 = this.a.p;
            bsVar2.a(acVar.d);
        }
        if (acVar.c != 120002) {
            return;
        }
        this.a.n();
    }
}
