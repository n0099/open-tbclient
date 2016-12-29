package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements c.b {
    final /* synthetic */ l bqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(l lVar) {
        this.bqi = lVar;
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
        if (aVar != null && this.bqi.bpP.isAdded()) {
            this.bqi.e(true, "");
            if (aVar.type == 1) {
                this.bqi.bpQ.TP();
            }
            if (aVar.bqF) {
                if (aVar.type == 1) {
                    this.bqi.bpS = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.bqi.a(aVar.bqG);
                } else if (aVar.type == 0) {
                    z = this.bqi.bpS;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.bqG;
                        cVar5 = this.bqi.bpR;
                        cVar5.d(bVar);
                        this.bqi.a(bVar);
                    }
                }
            } else if (aVar.bqE != null && !aVar.bqE.equals("")) {
                this.bqi.aVu.showToast(aVar.bqE);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m9getInst().getIsNewRegUser()) {
                isShow = this.bqi.isShow();
                if (isShow) {
                    TbadkCoreApplication.m9getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.bqi.bpV;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.bqi.bpV;
                    cVar = this.bqi.bpR;
                    long Tu = cVar.Tu();
                    j3 = this.bqi.bpV;
                    long j4 = Tu - j3;
                    cVar2 = this.bqi.bpR;
                    long Ts = cVar2.Ts();
                    cVar3 = this.bqi.bpR;
                    long Tt = cVar3.Tt();
                    cVar4 = this.bqi.bpR;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Ts, Tt, currentTimeMillis - cVar4.Tr());
                    this.bqi.bpV = -1L;
                }
            }
            if (aVar.bqG != null && aVar.bqG.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.d hotSearchInfoData = aVar.bqG.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.tW().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.tW().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.tW().putString("hot_search_title", hotSearchInfoData.SN());
                com.baidu.tbadk.core.sharedPref.b.tW().putLong("hot_search_type", hotSearchInfoData.SO());
                this.bqi.setSearchHint(hotSearchInfoData.SN());
                return;
            }
            this.bqi.setSearchHint(this.bqi.aVu.getResources().getString(r.j.enter_forum_search_tip));
        }
    }
}
