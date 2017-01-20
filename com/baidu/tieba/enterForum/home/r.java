package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    final /* synthetic */ l bxV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar) {
        this.bxV = lVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        EnterForumModel enterForumModel;
        long j;
        TiebaStatic.eventStat(this.bxV.aQU.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        this.bxV.bxC.Vp();
        this.bxV.bxJ = System.currentTimeMillis();
        enterForumModel = this.bxV.bxD;
        j = this.bxV.bxJ;
        enterForumModel.aL(j);
        aVar.dismiss();
    }
}
