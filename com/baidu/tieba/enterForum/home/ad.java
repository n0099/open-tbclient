package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements c.b {
    final /* synthetic */ i bbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(i iVar) {
        this.bbw = iVar;
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
        if (aVar != null && this.bbw.bba.isAdded()) {
            this.bbw.e(true, "");
            if (aVar.type == 1) {
                this.bbw.bbb.Op();
            }
            if (aVar.bbX) {
                if (aVar.type == 1) {
                    this.bbw.bbd = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.bbw.a(aVar.bbY);
                } else if (aVar.type == 0) {
                    z = this.bbw.bbd;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.bbY;
                        cVar5 = this.bbw.bbc;
                        cVar5.c(bVar);
                        this.bbw.a(bVar);
                    }
                }
            } else {
                if (aVar.bbW != null && !aVar.bbW.equals("")) {
                    this.bbw.aNm.showToast(aVar.bbW);
                }
                this.bbw.bbl = false;
            }
            if (aVar.type == 1 && TbadkCoreApplication.m411getInst().getIsNewRegUser()) {
                isShow = this.bbw.isShow();
                if (isShow) {
                    TbadkCoreApplication.m411getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.bbw.bbg;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.bbw.bbg;
                    cVar = this.bbw.bbc;
                    long Oc = cVar.Oc();
                    j3 = this.bbw.bbg;
                    long j4 = Oc - j3;
                    cVar2 = this.bbw.bbc;
                    long Oa = cVar2.Oa();
                    cVar3 = this.bbw.bbc;
                    long Ob = cVar3.Ob();
                    cVar4 = this.bbw.bbc;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Oa, Ob, currentTimeMillis - cVar4.NZ());
                    this.bbw.bbg = -1L;
                }
            }
            if (aVar.bbY != null && aVar.bbY.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.c hotSearchInfoData = aVar.bbY.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.vk().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.vk().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.vk().putString("hot_search_title", hotSearchInfoData.Nz());
                com.baidu.tbadk.core.sharedPref.b.vk().putLong("hot_search_type", hotSearchInfoData.NA());
                this.bbw.setSearchHint(hotSearchInfoData.Nz());
                return;
            }
            this.bbw.setSearchHint(this.bbw.aNm.getResources().getString(t.j.enter_forum_search_tip));
        }
    }
}
