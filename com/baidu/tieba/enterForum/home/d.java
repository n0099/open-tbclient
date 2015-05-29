package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ a aFd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.aFd = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        BaseFragmentActivity baseFragmentActivity;
        com.baidu.tieba.enterForum.d.e eVar;
        com.baidu.tieba.enterForum.c.c cVar;
        long j;
        baseFragmentActivity = this.aFd.azk;
        TiebaStatic.eventStat(baseFragmentActivity.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        eVar = this.aFd.aEL;
        eVar.IB();
        this.aFd.aES = System.currentTimeMillis();
        cVar = this.aFd.aEM;
        j = this.aFd.aES;
        cVar.O(j);
        aVar.dismiss();
    }
}
