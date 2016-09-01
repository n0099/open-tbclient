package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements a.b {
    final /* synthetic */ l bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(l lVar) {
        this.bHc = lVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.enterForum.c.c cVar;
        long j;
        TiebaStatic.eventStat(this.bHc.aTi.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        this.bHc.bGJ.Yn();
        this.bHc.bGQ = System.currentTimeMillis();
        cVar = this.bHc.bGK;
        j = this.bHc.bGQ;
        cVar.be(j);
        aVar.dismiss();
    }
}
