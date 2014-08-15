package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.ForumData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.base.h {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        com.baidu.tieba.model.af afVar;
        com.baidu.tieba.model.af afVar2;
        String str;
        String str2;
        cu cuVar;
        g gVar;
        g gVar2;
        String str3;
        cu cuVar2;
        g gVar3;
        g gVar4;
        String str4;
        g gVar5;
        boolean z = false;
        if (obj != null && (obj instanceof com.baidu.tieba.data.ab)) {
            f a = f.a();
            str4 = this.a.q;
            a.a(str4, false);
            ((com.baidu.tieba.data.ab) obj).b(1);
            gVar5 = this.a.L;
            gVar5.a((com.baidu.tieba.data.ab) obj);
            z = true;
        }
        if (!z) {
            afVar = this.a.M;
            if (afVar.getErrorCode() == 22) {
                this.a.showToast(this.a.getString(com.baidu.tieba.x.had_liked_forum));
            } else {
                FrsActivity frsActivity = this.a;
                afVar2 = this.a.M;
                frsActivity.showToast(afVar2.getErrorString());
            }
            this.a.D();
            return;
        }
        str = this.a.R;
        if (str.equals("normal_page")) {
            cuVar2 = this.a.z;
            gVar3 = this.a.L;
            ForumData i = gVar3.i();
            gVar4 = this.a.L;
            cuVar2.b(1, i, gVar4, true);
        } else {
            str2 = this.a.R;
            if (str2.equals("frs_page")) {
                cuVar = this.a.z;
                gVar = this.a.L;
                ForumData i2 = gVar.i();
                gVar2 = this.a.L;
                cuVar.a(1, i2, gVar2, true);
            }
        }
        this.a.showToast(this.a.getString(com.baidu.tieba.x.like_success));
        com.baidu.tieba.ai c = com.baidu.tieba.ai.c();
        str3 = this.a.q;
        c.d(str3);
    }
}
