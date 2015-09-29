package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements c.b {
    final /* synthetic */ d aLL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(d dVar) {
        this.aLL = dVar;
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
        if (this.aLL.isAdded()) {
            if (!com.baidu.adp.lib.util.i.iM()) {
                this.aLL.aLu.IZ();
            }
            this.aLL.d(true, "");
            if (aVar.type == 1) {
                this.aLL.aLu.IU();
            }
            if (aVar.aMj) {
                if (aVar.type == 1) {
                    this.aLL.aLw = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.aLL.a(aVar.aMk);
                } else if (aVar.type == 0) {
                    z = this.aLL.aLw;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.aMk;
                        cVar5 = this.aLL.aLv;
                        cVar5.b(bVar);
                        this.aLL.a(bVar);
                    }
                }
            } else if (aVar.aMi != null && !aVar.aMi.equals("")) {
                this.aLL.aFJ.showToast(aVar.aMi);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m411getInst().getIsNewRegUser()) {
                isShow = this.aLL.isShow();
                if (isShow) {
                    TbadkCoreApplication.m411getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.aLL.aLy;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.aLL.aLy;
                    cVar = this.aLL.aLv;
                    long IA = cVar.IA();
                    j3 = this.aLL.aLy;
                    long j4 = IA - j3;
                    cVar2 = this.aLL.aLv;
                    long Iy = cVar2.Iy();
                    cVar3 = this.aLL.aLv;
                    long Iz = cVar3.Iz();
                    cVar4 = this.aLL.aLv;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Iy, Iz, currentTimeMillis - cVar4.Ix());
                    this.aLL.aLy = -1L;
                }
            }
            if (aVar.aMk != null && aVar.aMk.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.c hotSearchInfoData = aVar.aMk.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.tu().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.tu().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.tu().putString("hot_search_title", hotSearchInfoData.Ia());
                com.baidu.tbadk.core.sharedPref.b.tu().putLong("hot_search_type", hotSearchInfoData.getType());
                this.aLL.setSearchHint(hotSearchInfoData.Ia());
                return;
            }
            this.aLL.setSearchHint(this.aLL.getString(i.h.enter_forum_search_tip));
        }
    }
}
