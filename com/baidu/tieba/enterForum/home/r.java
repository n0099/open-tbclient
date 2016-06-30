package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    final /* synthetic */ k btA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(k kVar) {
        this.btA = kVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.enterForum.c.c cVar;
        long j;
        TiebaStatic.eventStat(this.btA.aMU.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        this.btA.btg.SV();
        this.btA.bto = System.currentTimeMillis();
        cVar = this.btA.bth;
        j = this.btA.bto;
        cVar.aN(j);
        aVar.dismiss();
    }
}
