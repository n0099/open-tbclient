package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.home.k;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ k aXF;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.w aXG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(k kVar, com.baidu.tieba.tbadkCore.w wVar) {
        this.aXF = kVar;
        this.aXG = wVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (!com.baidu.adp.lib.util.k.fH()) {
            this.aXF.aJw.showToast(t.j.delete_like_fail);
        } else {
            new k.a(this.aXG).execute(new com.baidu.tieba.tbadkCore.w[0]);
        }
        TiebaStatic.eventStat(this.aXF.aJw.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
