package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.home.h;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.b {
    final /* synthetic */ h aQN;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.w aQO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(h hVar, com.baidu.tieba.tbadkCore.w wVar) {
        this.aQN = hVar;
        this.aQO = wVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (!com.baidu.adp.lib.util.k.jg()) {
            this.aQN.aHN.showToast(n.i.delete_like_fail);
        } else {
            new h.a(this.aQO).execute(new com.baidu.tieba.tbadkCore.w[0]);
        }
        TiebaStatic.eventStat(this.aQN.aHN.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
