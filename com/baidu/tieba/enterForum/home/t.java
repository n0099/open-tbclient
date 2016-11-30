package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.home.l;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ l bKe;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.w bKf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(l lVar, com.baidu.tieba.tbadkCore.w wVar) {
        this.bKe = lVar;
        this.bKf = wVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (!com.baidu.adp.lib.util.k.gD()) {
            this.bKe.aWd.showToast(r.j.delete_like_fail);
        } else {
            new l.a(this.bKf).execute(new com.baidu.tieba.tbadkCore.w[0]);
        }
        TiebaStatic.eventStat(this.bKe.aWd.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
