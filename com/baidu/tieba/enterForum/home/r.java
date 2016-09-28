package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    final /* synthetic */ l bHk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar) {
        this.bHk = lVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.enterForum.c.c cVar;
        long j;
        TiebaStatic.eventStat(this.bHk.aTS.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        this.bHk.bGS.YF();
        this.bHk.bGZ = System.currentTimeMillis();
        cVar = this.bHk.bGT;
        j = this.bHk.bGZ;
        cVar.be(j);
        aVar.dismiss();
    }
}
