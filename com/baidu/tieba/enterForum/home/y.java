package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    final /* synthetic */ h aQN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(h hVar) {
        this.aQN = hVar;
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
        if (aVar != null && this.aQN.aQt.isAdded()) {
            this.aQN.d(true, "");
            if (aVar.type == 1) {
                this.aQN.aQu.Kr();
            }
            if (aVar.aRl) {
                if (aVar.type == 1) {
                    this.aQN.aQw = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.aQN.a(aVar.aRm);
                } else if (aVar.type == 0) {
                    z = this.aQN.aQw;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.aRm;
                        cVar5 = this.aQN.aQv;
                        cVar5.b(bVar);
                        this.aQN.a(bVar);
                    }
                }
            } else if (aVar.aRk != null && !aVar.aRk.equals("")) {
                this.aQN.aHN.showToast(aVar.aRk);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m411getInst().getIsNewRegUser()) {
                isShow = this.aQN.isShow();
                if (isShow) {
                    TbadkCoreApplication.m411getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.aQN.aQy;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.aQN.aQy;
                    cVar = this.aQN.aQv;
                    long Ke = cVar.Ke();
                    j3 = this.aQN.aQy;
                    long j4 = Ke - j3;
                    cVar2 = this.aQN.aQv;
                    long Kc = cVar2.Kc();
                    cVar3 = this.aQN.aQv;
                    long Kd = cVar3.Kd();
                    cVar4 = this.aQN.aQv;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Kc, Kd, currentTimeMillis - cVar4.Kb());
                    this.aQN.aQy = -1L;
                }
            }
            if (aVar.aRm != null && aVar.aRm.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.c hotSearchInfoData = aVar.aRm.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.tZ().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.tZ().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.tZ().putString("hot_search_title", hotSearchInfoData.JE());
                com.baidu.tbadk.core.sharedPref.b.tZ().putLong("hot_search_type", hotSearchInfoData.getType());
                this.aQN.setSearchHint(hotSearchInfoData.JE());
                return;
            }
            this.aQN.setSearchHint(this.aQN.aHN.getResources().getString(n.i.enter_forum_search_tip));
        }
    }
}
