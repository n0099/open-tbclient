package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements c.b {
    final /* synthetic */ k btA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(k kVar) {
        this.btA = kVar;
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
        if (aVar != null && this.btA.btf.isAdded()) {
            this.btA.f(true, "");
            if (aVar.type == 1) {
                this.btA.btg.SQ();
            }
            if (aVar.btY) {
                if (aVar.type == 1) {
                    this.btA.bti = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.btA.a(aVar.btZ);
                } else if (aVar.type == 0) {
                    z = this.btA.bti;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.btZ;
                        cVar5 = this.btA.bth;
                        cVar5.e(bVar);
                        this.btA.a(bVar);
                    }
                }
            } else if (aVar.btX != null && !aVar.btX.equals("")) {
                this.btA.aMU.showToast(aVar.btX);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m9getInst().getIsNewRegUser()) {
                isShow = this.btA.isShow();
                if (isShow) {
                    TbadkCoreApplication.m9getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.btA.btl;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.btA.btl;
                    cVar = this.btA.bth;
                    long St = cVar.St();
                    j3 = this.btA.btl;
                    long j4 = St - j3;
                    cVar2 = this.btA.bth;
                    long Sr = cVar2.Sr();
                    cVar3 = this.btA.bth;
                    long Ss = cVar3.Ss();
                    cVar4 = this.btA.bth;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Sr, Ss, currentTimeMillis - cVar4.Sq());
                    this.btA.btl = -1L;
                }
            }
            if (aVar.btZ != null && aVar.btZ.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.d hotSearchInfoData = aVar.btZ.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.sO().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.sO().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.sO().putString("hot_search_title", hotSearchInfoData.RO());
                com.baidu.tbadk.core.sharedPref.b.sO().putLong("hot_search_type", hotSearchInfoData.RP());
                this.btA.setSearchHint(hotSearchInfoData.RO());
                return;
            }
            this.btA.setSearchHint(this.btA.aMU.getResources().getString(u.j.enter_forum_search_tip));
        }
    }
}
