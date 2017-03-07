package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    final /* synthetic */ l bFb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar) {
        this.bFb = lVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        EnterForumModel enterForumModel;
        long j;
        TiebaStatic.eventStat(this.bFb.aXf.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        this.bFb.bEI.Wn();
        this.bFb.bEP = System.currentTimeMillis();
        enterForumModel = this.bFb.bEJ;
        j = this.bFb.bEP;
        enterForumModel.aL(j);
        aVar.dismiss();
    }
}
