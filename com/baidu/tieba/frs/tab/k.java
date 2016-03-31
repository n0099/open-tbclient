package com.baidu.tieba.frs.tab;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements j.a {
    final /* synthetic */ i buj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.buj = iVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qb() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qc() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.buj.PS;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.buj.PS;
            com.baidu.adp.lib.h.j.a(morePopupWindow2);
        }
    }
}
