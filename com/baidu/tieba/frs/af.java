package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.ForumData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.e {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.base.e
    public void a(Object obj) {
        com.baidu.tieba.model.af afVar;
        ct ctVar;
        String str;
        String str2;
        ct ctVar2;
        g gVar;
        g gVar2;
        ct ctVar3;
        String str3;
        ct ctVar4;
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
            ctVar = this.a.w;
            ctVar.a(this.a.getString(com.baidu.tieba.y.had_liked_forum));
            this.a.E();
            return;
        }
        str = this.a.O;
        if (str.equals("normal_page")) {
            ctVar4 = this.a.w;
            gVar3 = this.a.I;
            ForumData g = gVar3.g();
            gVar4 = this.a.I;
            ctVar4.b(1, g, gVar4, true);
        } else {
            str2 = this.a.O;
            if (str2.equals("frs_page")) {
                ctVar2 = this.a.w;
                gVar = this.a.I;
                ForumData g2 = gVar.g();
                gVar2 = this.a.I;
                ctVar2.a(1, g2, gVar2, true);
            }
        }
        ctVar3 = this.a.w;
        ctVar3.a(this.a.getString(com.baidu.tieba.y.like_success));
        com.baidu.tieba.ai c = com.baidu.tieba.ai.c();
        str3 = this.a.n;
        c.e(str3);
    }
}
