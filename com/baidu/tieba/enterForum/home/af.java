package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements c.b {
    final /* synthetic */ l bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(l lVar) {
        this.bHc = lVar;
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
        if (aVar != null && this.bHc.bGI.isAdded()) {
            this.bHc.e(true, "");
            if (aVar.type == 1) {
                this.bHc.bGJ.Yi();
            }
            if (aVar.bHA) {
                if (aVar.type == 1) {
                    this.bHc.bGL = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.bHc.a(aVar.bHB);
                } else if (aVar.type == 0) {
                    z = this.bHc.bGL;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.bHB;
                        cVar5 = this.bHc.bGK;
                        cVar5.e(bVar);
                        this.bHc.a(bVar);
                    }
                }
            } else if (aVar.bHz != null && !aVar.bHz.equals("")) {
                this.bHc.aTi.showToast(aVar.bHz);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m9getInst().getIsNewRegUser()) {
                isShow = this.bHc.isShow();
                if (isShow) {
                    TbadkCoreApplication.m9getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.bHc.bGO;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.bHc.bGO;
                    cVar = this.bHc.bGK;
                    long XM = cVar.XM();
                    j3 = this.bHc.bGO;
                    long j4 = XM - j3;
                    cVar2 = this.bHc.bGK;
                    long XK = cVar2.XK();
                    cVar3 = this.bHc.bGK;
                    long XL = cVar3.XL();
                    cVar4 = this.bHc.bGK;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, XK, XL, currentTimeMillis - cVar4.XJ());
                    this.bHc.bGO = -1L;
                }
            }
            if (aVar.bHB != null && aVar.bHB.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.d hotSearchInfoData = aVar.bHB.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.tS().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.tS().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.tS().putString("hot_search_title", hotSearchInfoData.Xh());
                com.baidu.tbadk.core.sharedPref.b.tS().putLong("hot_search_type", hotSearchInfoData.Xi());
                this.bHc.setSearchHint(hotSearchInfoData.Xh());
                return;
            }
            this.bHc.setSearchHint(this.bHc.aTi.getResources().getString(t.j.enter_forum_search_tip));
        }
    }
}
