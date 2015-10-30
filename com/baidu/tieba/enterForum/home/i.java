package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.b {
    final /* synthetic */ d aLW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar) {
        this.aLW = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.enterForum.c.c cVar;
        long j;
        TiebaStatic.eventStat(this.aLW.aFU.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        this.aLW.aLF.IU();
        this.aLW.aLL = System.currentTimeMillis();
        cVar = this.aLW.aLG;
        j = this.aLW.aLL;
        cVar.ai(j);
        aVar.dismiss();
    }
}
