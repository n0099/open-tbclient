package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements c.b {
    final /* synthetic */ i aWN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(i iVar) {
        this.aWN = iVar;
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
        if (aVar != null && this.aWN.aWr.isAdded()) {
            this.aWN.e(true, "");
            if (aVar.type == 1) {
                this.aWN.aWs.MB();
            }
            if (aVar.aXo) {
                if (aVar.type == 1) {
                    this.aWN.aWu = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.aWN.a(aVar.aXp);
                } else if (aVar.type == 0) {
                    z = this.aWN.aWu;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.aXp;
                        cVar5 = this.aWN.aWt;
                        cVar5.c(bVar);
                        this.aWN.a(bVar);
                    }
                }
            } else {
                if (aVar.aXn != null && !aVar.aXn.equals("")) {
                    this.aWN.aKq.showToast(aVar.aXn);
                }
                this.aWN.aWC = false;
            }
            if (aVar.type == 1 && TbadkCoreApplication.m411getInst().getIsNewRegUser()) {
                isShow = this.aWN.isShow();
                if (isShow) {
                    TbadkCoreApplication.m411getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.aWN.aWx;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.aWN.aWx;
                    cVar = this.aWN.aWt;
                    long Mo = cVar.Mo();
                    j3 = this.aWN.aWx;
                    long j4 = Mo - j3;
                    cVar2 = this.aWN.aWt;
                    long Mm = cVar2.Mm();
                    cVar3 = this.aWN.aWt;
                    long Mn = cVar3.Mn();
                    cVar4 = this.aWN.aWt;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Mm, Mn, currentTimeMillis - cVar4.Ml());
                    this.aWN.aWx = -1L;
                }
            }
            if (aVar.aXp != null && aVar.aXp.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.c hotSearchInfoData = aVar.aXp.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.uO().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.uO().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.uO().putString("hot_search_title", hotSearchInfoData.LL());
                com.baidu.tbadk.core.sharedPref.b.uO().putLong("hot_search_type", hotSearchInfoData.LM());
                this.aWN.setSearchHint(hotSearchInfoData.LL());
                return;
            }
            this.aWN.setSearchHint(this.aWN.aKq.getResources().getString(t.j.enter_forum_search_tip));
        }
    }
}
