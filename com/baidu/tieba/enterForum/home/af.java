package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements c.b {
    final /* synthetic */ k aXF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(k kVar) {
        this.aXF = kVar;
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
        if (aVar != null && this.aXF.aXj.isAdded()) {
            this.aXF.f(true, "");
            if (aVar.type == 1) {
                this.aXF.aXk.Nn();
            }
            if (aVar.aYg) {
                if (aVar.type == 1) {
                    this.aXF.aXm = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.aXF.a(aVar.aYh);
                } else if (aVar.type == 0) {
                    z = this.aXF.aXm;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.aYh;
                        cVar5 = this.aXF.aXl;
                        cVar5.d(bVar);
                        this.aXF.a(bVar);
                    }
                }
            } else {
                if (aVar.aYf != null && !aVar.aYf.equals("")) {
                    this.aXF.aJw.showToast(aVar.aYf);
                }
                this.aXF.aXu = false;
            }
            if (aVar.type == 1 && TbadkCoreApplication.m11getInst().getIsNewRegUser()) {
                isShow = this.aXF.isShow();
                if (isShow) {
                    TbadkCoreApplication.m11getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.aXF.aXp;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.aXF.aXp;
                    cVar = this.aXF.aXl;
                    long MP = cVar.MP();
                    j3 = this.aXF.aXp;
                    long j4 = MP - j3;
                    cVar2 = this.aXF.aXl;
                    long MN = cVar2.MN();
                    cVar3 = this.aXF.aXl;
                    long MO = cVar3.MO();
                    cVar4 = this.aXF.aXl;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, MN, MO, currentTimeMillis - cVar4.MM());
                    this.aXF.aXp = -1L;
                }
            }
            if (aVar.aYh != null && aVar.aYh.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.c hotSearchInfoData = aVar.aYh.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.sQ().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.sQ().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.sQ().putString("hot_search_title", hotSearchInfoData.Mi());
                com.baidu.tbadk.core.sharedPref.b.sQ().putLong("hot_search_type", hotSearchInfoData.Mj());
                this.aXF.setSearchHint(hotSearchInfoData.Mi());
                return;
            }
            this.aXF.setSearchHint(this.aXF.aJw.getResources().getString(t.j.enter_forum_search_tip));
        }
    }
}
