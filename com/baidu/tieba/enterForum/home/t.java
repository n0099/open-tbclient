package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.home.l;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ l bFb;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.u bFc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(l lVar, com.baidu.tieba.tbadkCore.u uVar) {
        this.bFb = lVar;
        this.bFc = uVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (!com.baidu.adp.lib.util.k.hv()) {
            this.bFb.aXf.showToast(w.l.delete_like_fail);
        } else {
            new l.a(this.bFc).execute(new com.baidu.tieba.tbadkCore.u[0]);
        }
        TiebaStatic.eventStat(this.bFb.aXf.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
