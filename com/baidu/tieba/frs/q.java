package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.a.g {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        com.baidu.tieba.model.ar arVar;
        br brVar;
        String str;
        String str2;
        br brVar2;
        com.baidu.tieba.model.z zVar;
        com.baidu.tieba.model.z zVar2;
        br brVar3;
        String str3;
        br brVar4;
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
            brVar = this.a.p;
            brVar.a(this.a.getString(R.string.had_liked_forum));
            this.a.C();
            return;
        }
        str = this.a.G;
        if (str.equals("normal_page")) {
            brVar4 = this.a.p;
            zVar3 = this.a.A;
            ForumData b = zVar3.b();
            zVar4 = this.a.A;
            brVar4.b(1, b, zVar4, true);
        } else {
            str2 = this.a.G;
            if (str2.equals("frs_page")) {
                brVar2 = this.a.p;
                zVar = this.a.A;
                ForumData b2 = zVar.b();
                zVar2 = this.a.A;
                brVar2.a(1, b2, zVar2, true);
            }
        }
        brVar3 = this.a.p;
        brVar3.a(this.a.getString(R.string.like_success));
        TiebaApplication g = TiebaApplication.g();
        str3 = this.a.g;
        g.e(str3);
    }
}
