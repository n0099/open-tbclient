package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements a.b {
    final /* synthetic */ h aQN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(h hVar) {
        this.aQN = hVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.enterForum.c.c cVar;
        long j;
        TiebaStatic.eventStat(this.aQN.aHN.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        this.aQN.aQu.KF();
        this.aQN.aQA = System.currentTimeMillis();
        cVar = this.aQN.aQv;
        j = this.aQN.aQA;
        cVar.aq(j);
        aVar.dismiss();
    }
}
