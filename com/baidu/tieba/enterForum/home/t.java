package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.home.l;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ l bHl;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.u bHm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(l lVar, com.baidu.tieba.tbadkCore.u uVar) {
        this.bHl = lVar;
        this.bHm = uVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (!com.baidu.adp.lib.util.k.hB()) {
            this.bHl.aXw.showToast(w.l.delete_like_fail);
        } else {
            new l.a(this.bHm).execute(new com.baidu.tieba.tbadkCore.u[0]);
        }
        TiebaStatic.eventStat(this.bHl.aXw.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
