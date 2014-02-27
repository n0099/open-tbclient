package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class q extends com.baidu.adp.a.g {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.a.g
    public final void a(Object obj) {
        com.baidu.tieba.model.ar arVar;
        bs bsVar;
        String str;
        String str2;
        bs bsVar2;
        com.baidu.tieba.model.z zVar;
        com.baidu.tieba.model.z zVar2;
        bs bsVar3;
        String str3;
        bs bsVar4;
        com.baidu.tieba.model.z zVar3;
        com.baidu.tieba.model.z zVar4;
        String str4;
        com.baidu.tieba.model.z zVar5;
        boolean z = false;
        if (obj != null && (obj instanceof com.baidu.tieba.data.af)) {
            com.baidu.tieba.model.o a = com.baidu.tieba.model.o.a();
            str4 = this.a.g;
            a.b(str4);
            ((com.baidu.tieba.data.af) obj).b(1);
            zVar5 = this.a.A;
            zVar5.a((com.baidu.tieba.data.af) obj);
            z = true;
        }
        if (!z) {
            arVar = this.a.B;
            arVar.getErrorCode();
            bsVar = this.a.p;
            bsVar.a(this.a.getString(R.string.had_liked_forum));
            this.a.n();
            return;
        }
        str = this.a.G;
        if (str.equals("normal_page")) {
            bsVar4 = this.a.p;
            zVar3 = this.a.A;
            ForumData f = zVar3.f();
            zVar4 = this.a.A;
            bsVar4.b(1, f, zVar4, true);
        } else {
            str2 = this.a.G;
            if (str2.equals("frs_page")) {
                bsVar2 = this.a.p;
                zVar = this.a.A;
                ForumData f2 = zVar.f();
                zVar2 = this.a.A;
                bsVar2.a(1, f2, zVar2, true);
            }
        }
        bsVar3 = this.a.p;
        bsVar3.a(this.a.getString(R.string.like_success));
        TiebaApplication g = TiebaApplication.g();
        str3 = this.a.g;
        g.e(str3);
    }
}
