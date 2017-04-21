package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements EnterForumModel.b {
    final /* synthetic */ l bHl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(l lVar) {
        this.bHl = lVar;
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
        if (aVar != null && this.bHl.bGR.isAdded()) {
            this.bHl.d(true, "");
            if (aVar.type == 1) {
                this.bHl.bGS.XH();
            }
            if (aVar.bHI) {
                if (aVar.type == 1) {
                    this.bHl.bGU = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.bHl.a(aVar.bHJ);
                } else if (aVar.type == 0) {
                    z = this.bHl.bGU;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.bHJ;
                        enterForumModel5 = this.bHl.bGT;
                        enterForumModel5.d(bVar);
                        this.bHl.a(bVar);
                    }
                }
            } else if (aVar.bHH != null && !aVar.bHH.equals("")) {
                this.bHl.aXw.showToast(aVar.bHH);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m9getInst().getIsNewRegUser()) {
                isShow = this.bHl.isShow();
                if (isShow) {
                    TbadkCoreApplication.m9getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.bHl.bGX;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.bHl.bGX;
                    enterForumModel = this.bHl.bGT;
                    long Xk = enterForumModel.Xk();
                    j3 = this.bHl.bGX;
                    long j4 = Xk - j3;
                    enterForumModel2 = this.bHl.bGT;
                    long Xi = enterForumModel2.Xi();
                    enterForumModel3 = this.bHl.bGT;
                    long Xj = enterForumModel3.Xj();
                    enterForumModel4 = this.bHl.bGT;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Xi, Xj, currentTimeMillis - enterForumModel4.Xh());
                    this.bHl.bGX = -1L;
                }
            }
            if (aVar.bHJ != null && aVar.bHJ.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.d hotSearchInfoData = aVar.bHJ.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.uL().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.uL().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.uL().putString("hot_search_title", hotSearchInfoData.WF());
                com.baidu.tbadk.core.sharedPref.b.uL().putLong("hot_search_type", hotSearchInfoData.WG());
                this.bHl.setSearchHint(hotSearchInfoData.WF());
                return;
            }
            this.bHl.setSearchHint(this.bHl.aXw.getResources().getString(w.l.enter_forum_search_tip));
        }
    }
}
