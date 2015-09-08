package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.home.d;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    final /* synthetic */ d aMQ;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.v aMR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar, com.baidu.tieba.tbadkCore.v vVar) {
        this.aMQ = dVar;
        this.aMR = vVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.k.jc()) {
            new d.a(this.aMR).execute(new com.baidu.tieba.tbadkCore.v[0]);
        } else {
            this.aMQ.showToast(i.h.delete_like_fail);
        }
        TiebaStatic.eventStat(this.aMQ.aGQ.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
