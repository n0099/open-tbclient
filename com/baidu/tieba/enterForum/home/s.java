package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements EnterForumModel.b {
    final /* synthetic */ i bGZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(i iVar) {
        this.bGZ = iVar;
    }

    @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
    public void a(EnterForumModel.a aVar) {
        long j;
        long j2;
        EnterForumModel enterForumModel;
        long j3;
        EnterForumModel enterForumModel2;
        EnterForumModel enterForumModel3;
        EnterForumModel enterForumModel4;
        boolean isShow;
        boolean z;
        EnterForumModel enterForumModel5;
        if (aVar != null && this.bGZ.bGM.isAdded()) {
            if (aVar.type == 1) {
                this.bGZ.bGN.WN();
            }
            if (aVar.bHt) {
                if (aVar.type == 1) {
                    this.bGZ.bGP = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.bGZ.a(aVar.bHu);
                } else if (aVar.type == 0) {
                    z = this.bGZ.bGP;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.bHu;
                        enterForumModel5 = this.bGZ.bGO;
                        enterForumModel5.b(bVar);
                        this.bGZ.a(bVar);
                    }
                }
            } else if (aVar.bHs != null && !aVar.bHs.equals("")) {
                this.bGZ.aXS.showToast(aVar.bHs);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m9getInst().getIsNewRegUser()) {
                isShow = this.bGZ.isShow();
                if (isShow) {
                    TbadkCoreApplication.m9getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.bGZ.bGR;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.bGZ.bGR;
                    enterForumModel = this.bGZ.bGO;
                    long WA = enterForumModel.WA();
                    j3 = this.bGZ.bGR;
                    long j4 = WA - j3;
                    enterForumModel2 = this.bGZ.bGO;
                    long Wy = enterForumModel2.Wy();
                    enterForumModel3 = this.bGZ.bGO;
                    long Wz = enterForumModel3.Wz();
                    enterForumModel4 = this.bGZ.bGO;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Wy, Wz, currentTimeMillis - enterForumModel4.Wx());
                    this.bGZ.bGR = -1L;
                }
            }
            if (aVar.bHu != null && aVar.bHu.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.f hotSearchInfoData = aVar.bHu.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.tX().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.tX().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.tX().putString("hot_search_title", hotSearchInfoData.VW());
                com.baidu.tbadk.core.sharedPref.b.tX().putLong("hot_search_type", hotSearchInfoData.VX());
                this.bGZ.setSearchHint(hotSearchInfoData.VW());
                return;
            }
            this.bGZ.setSearchHint(this.bGZ.aXS.getResources().getString(w.l.enter_forum_search_tip));
        }
    }
}
