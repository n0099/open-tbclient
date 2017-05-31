package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements EnterForumModel.b {
    final /* synthetic */ i bMN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(i iVar) {
        this.bMN = iVar;
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
        if (aVar != null && this.bMN.bMA.isAdded()) {
            if (aVar.type == 1) {
                this.bMN.bMB.XQ();
            }
            if (aVar.bNh) {
                if (aVar.type == 1) {
                    this.bMN.bMD = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.bMN.a(aVar.bNi);
                } else if (aVar.type == 0) {
                    z = this.bMN.bMD;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.bNi;
                        enterForumModel5 = this.bMN.bMC;
                        enterForumModel5.b(bVar);
                        this.bMN.a(bVar);
                    }
                }
            } else if (aVar.bNg != null && !aVar.bNg.equals("")) {
                this.bMN.aVu.showToast(aVar.bNg);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m9getInst().getIsNewRegUser()) {
                isShow = this.bMN.isShow();
                if (isShow) {
                    TbadkCoreApplication.m9getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.bMN.bMF;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.bMN.bMF;
                    enterForumModel = this.bMN.bMC;
                    long XD = enterForumModel.XD();
                    j3 = this.bMN.bMF;
                    long j4 = XD - j3;
                    enterForumModel2 = this.bMN.bMC;
                    long XB = enterForumModel2.XB();
                    enterForumModel3 = this.bMN.bMC;
                    long XC = enterForumModel3.XC();
                    enterForumModel4 = this.bMN.bMC;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, XB, XC, currentTimeMillis - enterForumModel4.XA());
                    this.bMN.bMF = -1L;
                }
            }
            if (aVar.bNi != null && aVar.bNi.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.f hotSearchInfoData = aVar.bNi.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("hot_search_title", hotSearchInfoData.WZ());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("hot_search_type", hotSearchInfoData.Xa());
                this.bMN.setSearchHint(hotSearchInfoData.WZ());
                return;
            }
            this.bMN.setSearchHint(this.bMN.aVu.getResources().getString(w.l.enter_forum_search_tip));
        }
    }
}
