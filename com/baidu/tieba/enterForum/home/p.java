package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.b {
    final /* synthetic */ i aWN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(i iVar) {
        this.aWN = iVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.enterForum.c.c cVar;
        long j;
        TiebaStatic.eventStat(this.aWN.aKq.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        this.aWN.aWs.MQ();
        this.aWN.aWz = System.currentTimeMillis();
        cVar = this.aWN.aWt;
        j = this.aWN.aWz;
        cVar.at(j);
        aVar.dismiss();
    }
}
