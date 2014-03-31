package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
final class ae extends com.baidu.adp.a.h {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        com.baidu.tieba.model.af afVar;
        cm cmVar;
        String str;
        String str2;
        cm cmVar2;
        g gVar;
        g gVar2;
        cm cmVar3;
        String str3;
        cm cmVar4;
        g gVar3;
        g gVar4;
        String str4;
        g gVar5;
        boolean z = false;
        if (obj != null && (obj instanceof com.baidu.tieba.data.z)) {
            f a = f.a();
            str4 = this.a.i;
            a.b(str4);
            ((com.baidu.tieba.data.z) obj).b(1);
            gVar5 = this.a.D;
            gVar5.a((com.baidu.tieba.data.z) obj);
            z = true;
        }
        if (!z) {
            afVar = this.a.E;
            afVar.getErrorCode();
            cmVar = this.a.r;
            cmVar.a(this.a.getString(com.baidu.tieba.a.k.had_liked_forum));
            this.a.n();
            return;
        }
        str = this.a.J;
        if (str.equals("normal_page")) {
            cmVar4 = this.a.r;
            gVar3 = this.a.D;
            ForumData f = gVar3.f();
            gVar4 = this.a.D;
            cmVar4.b(1, f, gVar4, true);
        } else {
            str2 = this.a.J;
            if (str2.equals("frs_page")) {
                cmVar2 = this.a.r;
                gVar = this.a.D;
                ForumData f2 = gVar.f();
                gVar2 = this.a.D;
                cmVar2.a(1, f2, gVar2, true);
            }
        }
        cmVar3 = this.a.r;
        cmVar3.a(this.a.getString(com.baidu.tieba.a.k.like_success));
        com.baidu.tieba.r c = com.baidu.tieba.r.c();
        str3 = this.a.i;
        c.e(str3);
    }
}
