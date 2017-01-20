package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements EnterForumModel.b {
    final /* synthetic */ l bxV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(l lVar) {
        this.bxV = lVar;
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
        if (aVar != null && this.bxV.bxB.isAdded()) {
            this.bxV.e(true, "");
            if (aVar.type == 1) {
                this.bxV.bxC.Vk();
            }
            if (aVar.bys) {
                if (aVar.type == 1) {
                    this.bxV.bxE = true;
                    new com.baidu.tieba.enterForum.b.b();
                    this.bxV.a(aVar.byt);
                } else if (aVar.type == 0) {
                    z = this.bxV.bxE;
                    if (!z) {
                        new com.baidu.tieba.enterForum.b.b();
                        com.baidu.tieba.enterForum.b.b bVar = aVar.byt;
                        enterForumModel5 = this.bxV.bxD;
                        enterForumModel5.d(bVar);
                        this.bxV.a(bVar);
                    }
                }
            } else if (aVar.byr != null && !aVar.byr.equals("")) {
                this.bxV.aQU.showToast(aVar.byr);
            }
            if (aVar.type == 1 && TbadkCoreApplication.m9getInst().getIsNewRegUser()) {
                isShow = this.bxV.isShow();
                if (isShow) {
                    TbadkCoreApplication.m9getInst().setIsNewRegUser(false);
                }
            }
            if (aVar.type == 1) {
                j = this.bxV.bxH;
                if (j > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.bxV.bxH;
                    enterForumModel = this.bxV.bxD;
                    long UN = enterForumModel.UN();
                    j3 = this.bxV.bxH;
                    long j4 = UN - j3;
                    enterForumModel2 = this.bxV.bxD;
                    long UL = enterForumModel2.UL();
                    enterForumModel3 = this.bxV.bxD;
                    long UM = enterForumModel3.UM();
                    enterForumModel4 = this.bxV.bxD;
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, UL, UM, currentTimeMillis - enterForumModel4.UK());
                    this.bxV.bxH = -1L;
                }
            }
            if (aVar.byt != null && aVar.byt.getHotSearchInfoData() != null) {
                com.baidu.tieba.enterForum.b.d hotSearchInfoData = aVar.byt.getHotSearchInfoData();
                com.baidu.tbadk.core.sharedPref.b.tQ().putLong("hot_search_id", hotSearchInfoData.getId());
                com.baidu.tbadk.core.sharedPref.b.tQ().putString("hot_search_name", hotSearchInfoData.getName());
                com.baidu.tbadk.core.sharedPref.b.tQ().putString("hot_search_title", hotSearchInfoData.Ui());
                com.baidu.tbadk.core.sharedPref.b.tQ().putLong("hot_search_type", hotSearchInfoData.Uj());
                this.bxV.setSearchHint(hotSearchInfoData.Ui());
                return;
            }
            this.bxV.setSearchHint(this.bxV.aQU.getResources().getString(r.l.enter_forum_search_tip));
        }
    }
}
