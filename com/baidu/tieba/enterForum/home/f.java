package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ a aCT;
    private final /* synthetic */ ae aCU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, ae aeVar) {
        this.aCT = aVar;
        this.aCU = aeVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        BaseFragmentActivity baseFragmentActivity;
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            new s(this.aCT, this.aCU).execute(new ae[0]);
        } else {
            this.aCT.showToast(y.delete_like_fail);
        }
        baseFragmentActivity = this.aCT.aCF;
        TiebaStatic.eventStat(baseFragmentActivity.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
