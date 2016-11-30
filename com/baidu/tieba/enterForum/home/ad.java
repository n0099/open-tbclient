package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements c.b {
    final /* synthetic */ l bKe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(l lVar) {
        this.bKe = lVar;
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
        if (aVar != null && this.bKe.bJL.isAdded()) {
            this.bKe.e(true, "");
            if (aVar.type == 1) {
                this.bKe.bJM.ZC();
            }
            if (aVar.bKB) {
                if (aVar.type == 1) {
                    this.bKe.bJO = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.bKe.a(aVar.bKC);
                } else if (aVar.type == 0) {
                    z = this.bKe.bJO;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.bKC;
                        cVar5 = this.bKe.bJN;
                        cVar5.d(bVar);
                        this.bKe.a(bVar);
                    }
                }
            } else if (aVar.bKA != null && !aVar.bKA.equals("")) {
                this.bKe.aWd.showToast(aVar.bKA);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m9getInst().getIsNewRegUser()) {
                isShow = this.bKe.isShow();
                if (isShow) {
                    TbadkCoreApplication.m9getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.bKe.bJR;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.bKe.bJR;
                    cVar = this.bKe.bJN;
                    long Zh = cVar.Zh();
                    j3 = this.bKe.bJR;
                    long j4 = Zh - j3;
                    cVar2 = this.bKe.bJN;
                    long Zf = cVar2.Zf();
                    cVar3 = this.bKe.bJN;
                    long Zg = cVar3.Zg();
                    cVar4 = this.bKe.bJN;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Zf, Zg, currentTimeMillis - cVar4.Ze());
                    this.bKe.bJR = -1L;
                }
            }
            if (aVar.bKC != null && aVar.bKC.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.d hotSearchInfoData = aVar.bKC.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.um().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.um().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.um().putString("hot_search_title", hotSearchInfoData.YC());
                com.baidu.tbadk.core.sharedPref.b.um().putLong("hot_search_type", hotSearchInfoData.YD());
                this.bKe.setSearchHint(hotSearchInfoData.YC());
                return;
            }
            this.bKe.setSearchHint(this.bKe.aWd.getResources().getString(r.j.enter_forum_search_tip));
        }
    }
}
