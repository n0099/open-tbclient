package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.ForumData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.h {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        com.baidu.tieba.model.ae aeVar;
        com.baidu.tieba.model.ae aeVar2;
        ct ctVar;
        com.baidu.tieba.model.ae aeVar3;
        ct ctVar2;
        com.baidu.tieba.model.ae aeVar4;
        ct ctVar3;
        String str;
        String str2;
        ct ctVar4;
        g gVar;
        g gVar2;
        ct ctVar5;
        String str3;
        ct ctVar6;
        g gVar3;
        g gVar4;
        String str4;
        g gVar5;
        boolean z = false;
        if (obj != null && (obj instanceof com.baidu.tieba.data.ab)) {
            f a = f.a();
            str4 = this.a.m;
            a.b(str4);
            ((com.baidu.tieba.data.ab) obj).b(1);
            gVar5 = this.a.H;
            gVar5.a((com.baidu.tieba.data.ab) obj);
            z = true;
        }
        if (!z) {
            aeVar = this.a.I;
            if (aeVar.getErrorCode() == 22) {
                ctVar3 = this.a.v;
                ctVar3.a(this.a.getString(com.baidu.tieba.y.had_liked_forum));
            } else {
                aeVar2 = this.a.I;
                if (aeVar2.getErrorCode() == 1) {
                    ctVar2 = this.a.v;
                    aeVar4 = this.a.I;
                    ctVar2.a(aeVar4.getErrorString());
                } else {
                    ctVar = this.a.v;
                    aeVar3 = this.a.I;
                    ctVar.a(aeVar3.getErrorString());
                }
            }
            this.a.E();
            return;
        }
        str = this.a.N;
        if (str.equals("normal_page")) {
            ctVar6 = this.a.v;
            gVar3 = this.a.H;
            ForumData g = gVar3.g();
            gVar4 = this.a.H;
            ctVar6.b(1, g, gVar4, true);
        } else {
            str2 = this.a.N;
            if (str2.equals("frs_page")) {
                ctVar4 = this.a.v;
                gVar = this.a.H;
                ForumData g2 = gVar.g();
                gVar2 = this.a.H;
                ctVar4.a(1, g2, gVar2, true);
            }
        }
        ctVar5 = this.a.v;
        ctVar5.a(this.a.getString(com.baidu.tieba.y.like_success));
        com.baidu.tieba.ai c = com.baidu.tieba.ai.c();
        str3 = this.a.m;
        c.e(str3);
    }
}
