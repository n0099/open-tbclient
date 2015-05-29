package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ a aFd;
    private final /* synthetic */ ae aFe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, ae aeVar) {
        this.aFd = aVar;
        this.aFe = aeVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        BaseFragmentActivity baseFragmentActivity;
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            new r(this.aFd, this.aFe).execute(new ae[0]);
        } else {
            this.aFd.showToast(t.delete_like_fail);
        }
        baseFragmentActivity = this.aFd.azk;
        TiebaStatic.eventStat(baseFragmentActivity.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
