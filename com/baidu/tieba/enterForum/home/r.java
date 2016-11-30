package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    final /* synthetic */ l bKe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar) {
        this.bKe = lVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.enterForum.c.c cVar;
        long j;
        TiebaStatic.eventStat(this.bKe.aWd.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        this.bKe.bJM.ZH();
        this.bKe.bJT = System.currentTimeMillis();
        cVar = this.bKe.bJN;
        j = this.bKe.bJT;
        cVar.bc(j);
        aVar.dismiss();
    }
}
