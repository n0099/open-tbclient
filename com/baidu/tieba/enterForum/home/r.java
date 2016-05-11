package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    final /* synthetic */ k aXF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(k kVar) {
        this.aXF = kVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.enterForum.c.c cVar;
        long j;
        TiebaStatic.eventStat(this.aXF.aJw.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        this.aXF.aXk.Ns();
        this.aXF.aXr = System.currentTimeMillis();
        cVar = this.aXF.aXl;
        j = this.aXF.aXr;
        cVar.ax(j);
        aVar.dismiss();
    }
}
