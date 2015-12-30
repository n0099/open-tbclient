package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements c.b {
    final /* synthetic */ i aUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(i iVar) {
        this.aUE = iVar;
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
        if (aVar != null && this.aUE.aUk.isAdded()) {
            this.aUE.d(true, "");
            if (aVar.type == 1) {
                this.aUE.aUl.KK();
            }
            if (aVar.aVc) {
                if (aVar.type == 1) {
                    this.aUE.aUn = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.aUE.a(aVar.aVd);
                } else if (aVar.type == 0) {
                    z = this.aUE.aUn;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.aVd;
                        cVar5 = this.aUE.aUm;
                        cVar5.b(bVar);
                        this.aUE.a(bVar);
                    }
                }
            } else if (aVar.aVb != null && !aVar.aVb.equals("")) {
                this.aUE.aJl.showToast(aVar.aVb);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m411getInst().getIsNewRegUser()) {
                isShow = this.aUE.isShow();
                if (isShow) {
                    TbadkCoreApplication.m411getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.aUE.aUp;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.aUE.aUp;
                    cVar = this.aUE.aUm;
                    long Kx = cVar.Kx();
                    j3 = this.aUE.aUp;
                    long j4 = Kx - j3;
                    cVar2 = this.aUE.aUm;
                    long Kv = cVar2.Kv();
                    cVar3 = this.aUE.aUm;
                    long Kw = cVar3.Kw();
                    cVar4 = this.aUE.aUm;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Kv, Kw, currentTimeMillis - cVar4.Ku());
                    this.aUE.aUp = -1L;
                }
            }
            if (aVar.aVd != null && aVar.aVd.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.c hotSearchInfoData = aVar.aVd.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.tJ().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.tJ().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.tJ().putString("hot_search_title", hotSearchInfoData.JV());
                com.baidu.tbadk.core.sharedPref.b.tJ().putLong("hot_search_type", hotSearchInfoData.getType());
                this.aUE.setSearchHint(hotSearchInfoData.JV());
                return;
            }
            this.aUE.setSearchHint(this.aUE.aJl.getResources().getString(n.j.enter_forum_search_tip));
        }
    }
}
