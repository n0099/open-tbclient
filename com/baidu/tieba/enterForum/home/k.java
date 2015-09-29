package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.home.d;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    final /* synthetic */ d aLL;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.v aLM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar, com.baidu.tieba.tbadkCore.v vVar) {
        this.aLL = dVar;
        this.aLM = vVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.k.jd()) {
            new d.a(this.aLM).execute(new com.baidu.tieba.tbadkCore.v[0]);
        } else {
            this.aLL.showToast(i.h.delete_like_fail);
        }
        TiebaStatic.eventStat(this.aLL.aFJ.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
