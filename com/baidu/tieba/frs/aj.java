package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.ForumData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.base.h {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        com.baidu.tieba.model.ag agVar;
        com.baidu.tieba.model.ag agVar2;
        String str;
        String str2;
        bu buVar;
        b bVar;
        b bVar2;
        String str3;
        bu buVar2;
        b bVar3;
        b bVar4;
        String str4;
        b bVar5;
        boolean z = false;
        if (obj != null && (obj instanceof com.baidu.tieba.data.aa)) {
            a EV = a.EV();
            str4 = this.aBk.aAn;
            EV.u(str4, false);
            ((com.baidu.tieba.data.aa) obj).setLike(1);
            bVar5 = this.aBk.azE;
            bVar5.a((com.baidu.tieba.data.aa) obj);
            z = true;
        }
        if (!z) {
            agVar = this.aBk.avr;
            if (agVar.getErrorCode() == 22) {
                this.aBk.showToast(this.aBk.getString(com.baidu.tieba.y.had_liked_forum));
            } else {
                FrsActivity frsActivity = this.aBk;
                agVar2 = this.aBk.avr;
                frsActivity.showToast(agVar2.getErrorString());
            }
            this.aBk.refresh();
            return;
        }
        str = this.aBk.mPageType;
        if (str.equals("normal_page")) {
            buVar2 = this.aBk.aAv;
            bVar3 = this.aBk.azE;
            ForumData zJ = bVar3.zJ();
            bVar4 = this.aBk.azE;
            buVar2.b(1, zJ, bVar4, true);
        } else {
            str2 = this.aBk.mPageType;
            if (str2.equals("frs_page")) {
                buVar = this.aBk.aAv;
                bVar = this.aBk.azE;
                ForumData zJ2 = bVar.zJ();
                bVar2 = this.aBk.azE;
                buVar.a(1, zJ2, bVar2, true);
            }
        }
        this.aBk.showToast(this.aBk.getString(com.baidu.tieba.y.like_success));
        com.baidu.tieba.aj wk = com.baidu.tieba.aj.wk();
        str3 = this.aBk.aAn;
        wk.dW(str3);
    }
}
