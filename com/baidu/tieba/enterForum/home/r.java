package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    final /* synthetic */ l bHl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar) {
        this.bHl = lVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        EnterForumModel enterForumModel;
        long j;
        TiebaStatic.eventStat(this.bHl.aXw.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        this.bHl.bGS.XM();
        this.bHl.bGZ = System.currentTimeMillis();
        enterForumModel = this.bHl.bGT;
        j = this.bHl.bGZ;
        enterForumModel.aL(j);
        aVar.dismiss();
    }
}
