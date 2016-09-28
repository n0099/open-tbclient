package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements c.b {
    final /* synthetic */ l bHk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(l lVar) {
        this.bHk = lVar;
    }

    @Override // com.baidu.tieba.enterForum.c.c.b
    public void a(c.a aVar) {
        long j;
        long j2;
        com.baidu.tieba.enterForum.c.c cVar;
        long j3;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.c.c cVar3;
        com.baidu.tieba.enterForum.c.c cVar4;
        boolean isShow;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar5;
        if (aVar != null && this.bHk.bGR.isAdded()) {
            this.bHk.e(true, "");
            if (aVar.type == 1) {
                this.bHk.bGS.YA();
            }
            if (aVar.bHH) {
                if (aVar.type == 1) {
                    this.bHk.bGU = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.bHk.a(aVar.bHI);
                } else if (aVar.type == 0) {
                    z = this.bHk.bGU;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.bHI;
                        cVar5 = this.bHk.bGT;
                        cVar5.d(bVar);
                        this.bHk.a(bVar);
                    }
                }
            } else if (aVar.bHG != null && !aVar.bHG.equals("")) {
                this.bHk.aTS.showToast(aVar.bHG);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m9getInst().getIsNewRegUser()) {
                isShow = this.bHk.isShow();
                if (isShow) {
                    TbadkCoreApplication.m9getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.bHk.bGX;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.bHk.bGX;
                    cVar = this.bHk.bGT;
                    long Yf = cVar.Yf();
                    j3 = this.bHk.bGX;
                    long j4 = Yf - j3;
                    cVar2 = this.bHk.bGT;
                    long Yd = cVar2.Yd();
                    cVar3 = this.bHk.bGT;
                    long Ye = cVar3.Ye();
                    cVar4 = this.bHk.bGT;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Yd, Ye, currentTimeMillis - cVar4.Yc());
                    this.bHk.bGX = -1L;
                }
            }
            if (aVar.bHI != null && aVar.bHI.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.d hotSearchInfoData = aVar.bHI.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.uh().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.uh().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.uh().putString("hot_search_title", hotSearchInfoData.XA());
                com.baidu.tbadk.core.sharedPref.b.uh().putLong("hot_search_type", hotSearchInfoData.XB());
                this.bHk.setSearchHint(hotSearchInfoData.XA());
                return;
            }
            this.bHk.setSearchHint(this.bHk.aTS.getResources().getString(r.j.enter_forum_search_tip));
        }
    }
}
