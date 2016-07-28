package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.c.c;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements c.b {
    final /* synthetic */ k bvO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(k kVar) {
        this.bvO = kVar;
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
        if (aVar != null && this.bvO.bvu.isAdded()) {
            this.bvO.f(true, "");
            if (aVar.type == 1) {
                this.bvO.bvv.Ty();
            }
            if (aVar.bwm) {
                if (aVar.type == 1) {
                    this.bvO.bvx = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.bvO.a(aVar.bwn);
                } else if (aVar.type == 0) {
                    z = this.bvO.bvx;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.bwn;
                        cVar5 = this.bvO.bvw;
                        cVar5.e(bVar);
                        this.bvO.a(bVar);
                    }
                }
            } else if (aVar.bwl != null && !aVar.bwl.equals("")) {
                this.bvO.aNO.showToast(aVar.bwl);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m10getInst().getIsNewRegUser()) {
                isShow = this.bvO.isShow();
                if (isShow) {
                    TbadkCoreApplication.m10getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.bvO.bvA;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.bvO.bvA;
                    cVar = this.bvO.bvw;
                    long Tb = cVar.Tb();
                    j3 = this.bvO.bvA;
                    long j4 = Tb - j3;
                    cVar2 = this.bvO.bvw;
                    long SZ = cVar2.SZ();
                    cVar3 = this.bvO.bvw;
                    long Ta = cVar3.Ta();
                    cVar4 = this.bvO.bvw;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, SZ, Ta, currentTimeMillis - cVar4.SY());
                    this.bvO.bvA = -1L;
                }
            }
            if (aVar.bwn != null && aVar.bwn.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.d hotSearchInfoData = aVar.bwn.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.sN().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.sN().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.sN().putString("hot_search_title", hotSearchInfoData.Sv());
                com.baidu.tbadk.core.sharedPref.b.sN().putLong("hot_search_type", hotSearchInfoData.Sw());
                this.bvO.setSearchHint(hotSearchInfoData.Sv());
                return;
            }
            this.bvO.setSearchHint(this.bvO.aNO.getResources().getString(u.j.enter_forum_search_tip));
        }
    }
}
