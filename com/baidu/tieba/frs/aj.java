package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.ForumData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.base.h {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsActivity frsActivity) {
        this.aBu = frsActivity;
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
            a EX = a.EX();
            str4 = this.aBu.aAx;
            EX.u(str4, false);
            ((com.baidu.tieba.data.aa) obj).setLike(1);
            bVar5 = this.aBu.azN;
            bVar5.a((com.baidu.tieba.data.aa) obj);
            z = true;
        }
        if (!z) {
            agVar = this.aBu.avA;
            if (agVar.getErrorCode() == 22) {
                this.aBu.showToast(this.aBu.getString(com.baidu.tieba.y.had_liked_forum));
            } else {
                FrsActivity frsActivity = this.aBu;
                agVar2 = this.aBu.avA;
                frsActivity.showToast(agVar2.getErrorString());
            }
            this.aBu.refresh();
            return;
        }
        str = this.aBu.mPageType;
        if (str.equals("normal_page")) {
            buVar2 = this.aBu.aAF;
            bVar3 = this.aBu.azN;
            ForumData zL = bVar3.zL();
            bVar4 = this.aBu.azN;
            buVar2.b(1, zL, bVar4, true);
        } else {
            str2 = this.aBu.mPageType;
            if (str2.equals("frs_page")) {
                buVar = this.aBu.aAF;
                bVar = this.aBu.azN;
                ForumData zL2 = bVar.zL();
                bVar2 = this.aBu.azN;
                buVar.a(1, zL2, bVar2, true);
            }
        }
        this.aBu.showToast(this.aBu.getString(com.baidu.tieba.y.like_success));
        com.baidu.tieba.aj wm = com.baidu.tieba.aj.wm();
        str3 = this.aBu.aAx;
        wm.dW(str3);
    }
}
