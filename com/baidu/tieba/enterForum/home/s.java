package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements c.b {
    final /* synthetic */ d aMe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(d dVar) {
        this.aMe = dVar;
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
        if (this.aMe.isAdded()) {
            if (!com.baidu.adp.lib.util.i.iN()) {
                this.aMe.aLN.Jl();
            }
            this.aMe.d(true, "");
            if (aVar.type == 1) {
                this.aMe.aLN.Jg();
            }
            if (aVar.aMC) {
                if (aVar.type == 1) {
                    this.aMe.aLP = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.aMe.a(aVar.aMD);
                } else if (aVar.type == 0) {
                    z = this.aMe.aLP;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.aMD;
                        cVar5 = this.aMe.aLO;
                        cVar5.b(bVar);
                        this.aMe.a(bVar);
                    }
                }
            } else if (aVar.aMB != null && !aVar.aMB.equals("")) {
                this.aMe.aEO.showToast(aVar.aMB);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m411getInst().getIsNewRegUser()) {
                isShow = this.aMe.isShow();
                if (isShow) {
                    TbadkCoreApplication.m411getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.aMe.aLR;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.aMe.aLR;
                    cVar = this.aMe.aLO;
                    long IM = cVar.IM();
                    j3 = this.aMe.aLR;
                    long j4 = IM - j3;
                    cVar2 = this.aMe.aLO;
                    long IK = cVar2.IK();
                    cVar3 = this.aMe.aLO;
                    long IL = cVar3.IL();
                    cVar4 = this.aMe.aLO;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, IK, IL, currentTimeMillis - cVar4.IJ());
                    this.aMe.aLR = -1L;
                }
            }
            if (aVar.aMD != null && aVar.aMD.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.c hotSearchInfoData = aVar.aMD.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.tu().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.tu().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.tu().putString("hot_search_title", hotSearchInfoData.Im());
                com.baidu.tbadk.core.sharedPref.b.tu().putLong("hot_search_type", hotSearchInfoData.getType());
                this.aMe.setSearchHint(hotSearchInfoData.Im());
                return;
            }
            this.aMe.setSearchHint(this.aMe.getString(i.h.enter_forum_search_tip));
        }
    }
}
