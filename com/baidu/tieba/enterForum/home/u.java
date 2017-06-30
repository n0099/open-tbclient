package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements EnterForumModel.b {
    final /* synthetic */ i bTq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(i iVar) {
        this.bTq = iVar;
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
        if (aVar != null && this.bTq.bTb.isAdded()) {
            if (aVar.type == 1) {
                this.bTq.bTc.abq();
            }
            if (aVar.bTK) {
                if (aVar.type == 1) {
                    this.bTq.bTe = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.bTq.a(aVar.bTL);
                } else if (aVar.type == 0) {
                    z = this.bTq.bTe;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.bTL;
                        enterForumModel5 = this.bTq.bTd;
                        enterForumModel5.c(bVar);
                        this.bTq.a(bVar);
                    }
                }
            } else if (aVar.bTJ != null && !aVar.bTJ.equals("")) {
                this.bTq.aWN.showToast(aVar.bTJ);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m9getInst().getIsNewRegUser()) {
                isShow = this.bTq.isShow();
                if (isShow) {
                    TbadkCoreApplication.m9getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.bTq.bTh;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.bTq.bTh;
                    enterForumModel = this.bTq.bTd;
                    long abb = enterForumModel.abb();
                    j3 = this.bTq.bTh;
                    long j4 = abb - j3;
                    enterForumModel2 = this.bTq.bTd;
                    long aaZ = enterForumModel2.aaZ();
                    enterForumModel3 = this.bTq.bTd;
                    long aba = enterForumModel3.aba();
                    enterForumModel4 = this.bTq.bTd;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, aaZ, aba, currentTimeMillis - enterForumModel4.aaY());
                    this.bTq.bTh = -1L;
                }
            }
            if (aVar.bTL != null && aVar.bTL.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.f hotSearchInfoData = aVar.bTL.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_title", hotSearchInfoData.aaw());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_type", hotSearchInfoData.aax());
                this.bTq.setSearchHint(hotSearchInfoData.aaw());
                return;
            }
            this.bTq.setSearchHint(this.bTq.aWN.getResources().getString(w.l.enter_forum_search_tip));
        }
    }
}
