package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements c.b {
    final /* synthetic */ d aLW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(d dVar) {
        this.aLW = dVar;
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
        if (this.aLW.isAdded()) {
            if (!com.baidu.adp.lib.util.i.iM()) {
                this.aLW.aLF.IV();
            }
            this.aLW.d(true, "");
            if (aVar.type == 1) {
                this.aLW.aLF.IQ();
            }
            if (aVar.aMu) {
                if (aVar.type == 1) {
                    this.aLW.aLH = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.aLW.a(aVar.aMv);
                } else if (aVar.type == 0) {
                    z = this.aLW.aLH;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.aMv;
                        cVar5 = this.aLW.aLG;
                        cVar5.b(bVar);
                        this.aLW.a(bVar);
                    }
                }
            } else if (aVar.aMt != null && !aVar.aMt.equals("")) {
                this.aLW.aFU.showToast(aVar.aMt);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m411getInst().getIsNewRegUser()) {
                isShow = this.aLW.isShow();
                if (isShow) {
                    TbadkCoreApplication.m411getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.aLW.aLJ;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.aLW.aLJ;
                    cVar = this.aLW.aLG;
                    long Iw = cVar.Iw();
                    j3 = this.aLW.aLJ;
                    long j4 = Iw - j3;
                    cVar2 = this.aLW.aLG;
                    long Iu = cVar2.Iu();
                    cVar3 = this.aLW.aLG;
                    long Iv = cVar3.Iv();
                    cVar4 = this.aLW.aLG;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Iu, Iv, currentTimeMillis - cVar4.It());
                    this.aLW.aLJ = -1L;
                }
            }
            if (aVar.aMv != null && aVar.aMv.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.c hotSearchInfoData = aVar.aMv.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.tr().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.tr().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.tr().putString("hot_search_title", hotSearchInfoData.HW());
                com.baidu.tbadk.core.sharedPref.b.tr().putLong("hot_search_type", hotSearchInfoData.getType());
                this.aLW.setSearchHint(hotSearchInfoData.HW());
                return;
            }
            this.aLW.setSearchHint(this.aLW.getString(i.h.enter_forum_search_tip));
        }
    }
}
