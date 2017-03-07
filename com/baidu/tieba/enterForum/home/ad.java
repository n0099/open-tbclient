package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements EnterForumModel.b {
    final /* synthetic */ l bFb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(l lVar) {
        this.bFb = lVar;
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
        if (aVar != null && this.bFb.bEH.isAdded()) {
            this.bFb.e(true, "");
            if (aVar.type == 1) {
                this.bFb.bEI.Wi();
            }
            if (aVar.bFy) {
                if (aVar.type == 1) {
                    this.bFb.bEK = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.bFb.a(aVar.bFz);
                } else if (aVar.type == 0) {
                    z = this.bFb.bEK;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.bFz;
                        enterForumModel5 = this.bFb.bEJ;
                        enterForumModel5.d(bVar);
                        this.bFb.a(bVar);
                    }
                }
            } else if (aVar.bFx != null && !aVar.bFx.equals("")) {
                this.bFb.aXf.showToast(aVar.bFx);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m9getInst().getIsNewRegUser()) {
                isShow = this.bFb.isShow();
                if (isShow) {
                    TbadkCoreApplication.m9getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.bFb.bEN;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.bFb.bEN;
                    enterForumModel = this.bFb.bEJ;
                    long VL = enterForumModel.VL();
                    j3 = this.bFb.bEN;
                    long j4 = VL - j3;
                    enterForumModel2 = this.bFb.bEJ;
                    long VJ = enterForumModel2.VJ();
                    enterForumModel3 = this.bFb.bEJ;
                    long VK = enterForumModel3.VK();
                    enterForumModel4 = this.bFb.bEJ;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, VJ, VK, currentTimeMillis - enterForumModel4.VI());
                    this.bFb.bEN = -1L;
                }
            }
            if (aVar.bFz != null && aVar.bFz.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.d hotSearchInfoData = aVar.bFz.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.uo().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.uo().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.uo().putString("hot_search_title", hotSearchInfoData.Vg());
                com.baidu.tbadk.core.sharedPref.b.uo().putLong("hot_search_type", hotSearchInfoData.Vh());
                this.bFb.setSearchHint(hotSearchInfoData.Vg());
                return;
            }
            this.bFb.setSearchHint(this.bFb.aXf.getResources().getString(w.l.enter_forum_search_tip));
        }
    }
}
