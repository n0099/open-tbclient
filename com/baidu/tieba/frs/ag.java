package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.ForumData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void a(Object obj) {
        com.baidu.tieba.model.af afVar;
        cs csVar;
        String str;
        String str2;
        cs csVar2;
        g gVar;
        g gVar2;
        cs csVar3;
        String str3;
        cs csVar4;
        g gVar3;
        g gVar4;
        String str4;
        g gVar5;
        boolean z = false;
        if (obj != null && (obj instanceof com.baidu.tieba.data.z)) {
            f a = f.a();
            str4 = this.a.n;
            a.b(str4);
            ((com.baidu.tieba.data.z) obj).b(1);
            gVar5 = this.a.I;
            gVar5.a((com.baidu.tieba.data.z) obj);
            z = true;
        }
        if (!z) {
            afVar = this.a.J;
            afVar.getErrorCode();
            csVar = this.a.w;
            csVar.a(this.a.getString(com.baidu.tieba.u.had_liked_forum));
            this.a.D();
            return;
        }
        str = this.a.O;
        if (str.equals("normal_page")) {
            csVar4 = this.a.w;
            gVar3 = this.a.I;
            ForumData g = gVar3.g();
            gVar4 = this.a.I;
            csVar4.b(1, g, gVar4, true);
        } else {
            str2 = this.a.O;
            if (str2.equals("frs_page")) {
                csVar2 = this.a.w;
                gVar = this.a.I;
                ForumData g2 = gVar.g();
                gVar2 = this.a.I;
                csVar2.a(1, g2, gVar2, true);
            }
        }
        csVar3 = this.a.w;
        csVar3.a(this.a.getString(com.baidu.tieba.u.like_success));
        com.baidu.tieba.ad c = com.baidu.tieba.ad.c();
        str3 = this.a.n;
        c.e(str3);
    }
}
