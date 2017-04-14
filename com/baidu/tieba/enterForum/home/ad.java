package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements EnterForumModel.b {
    final /* synthetic */ l bEU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(l lVar) {
        this.bEU = lVar;
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
        if (aVar != null && this.bEU.bEA.isAdded()) {
            this.bEU.d(true, "");
            if (aVar.type == 1) {
                this.bEU.bEB.WG();
            }
            if (aVar.bFr) {
                if (aVar.type == 1) {
                    this.bEU.bED = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.bEU.a(aVar.bFs);
                } else if (aVar.type == 0) {
                    z = this.bEU.bED;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.bFs;
                        enterForumModel5 = this.bEU.bEC;
                        enterForumModel5.d(bVar);
                        this.bEU.a(bVar);
                    }
                }
            } else if (aVar.bFq != null && !aVar.bFq.equals("")) {
                this.bEU.aXt.showToast(aVar.bFq);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m9getInst().getIsNewRegUser()) {
                isShow = this.bEU.isShow();
                if (isShow) {
                    TbadkCoreApplication.m9getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.bEU.bEG;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.bEU.bEG;
                    enterForumModel = this.bEU.bEC;
                    long Wj = enterForumModel.Wj();
                    j3 = this.bEU.bEG;
                    long j4 = Wj - j3;
                    enterForumModel2 = this.bEU.bEC;
                    long Wh = enterForumModel2.Wh();
                    enterForumModel3 = this.bEU.bEC;
                    long Wi = enterForumModel3.Wi();
                    enterForumModel4 = this.bEU.bEC;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, Wh, Wi, currentTimeMillis - enterForumModel4.Wg());
                    this.bEU.bEG = -1L;
                }
            }
            if (aVar.bFs != null && aVar.bFs.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.d hotSearchInfoData = aVar.bFs.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.uL().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.uL().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.uL().putString("hot_search_title", hotSearchInfoData.VE());
                com.baidu.tbadk.core.sharedPref.b.uL().putLong("hot_search_type", hotSearchInfoData.VF());
                this.bEU.setSearchHint(hotSearchInfoData.VE());
                return;
            }
            this.bEU.setSearchHint(this.bEU.aXt.getResources().getString(w.l.enter_forum_search_tip));
        }
    }
}
