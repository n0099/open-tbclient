package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ a aCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.aCT = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        BaseFragmentActivity baseFragmentActivity;
        com.baidu.tieba.enterForum.d.e eVar;
        com.baidu.tieba.enterForum.c.c cVar;
        long j;
        baseFragmentActivity = this.aCT.aCF;
        TiebaStatic.eventStat(baseFragmentActivity.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        eVar = this.aCT.aCB;
        eVar.Hv();
        this.aCT.aCJ = System.currentTimeMillis();
        cVar = this.aCT.aCC;
        j = this.aCT.aCJ;
        cVar.N(j);
        aVar.dismiss();
    }
}
