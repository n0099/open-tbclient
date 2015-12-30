package com.baidu.tieba.frs.tab;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements j.a {
    final /* synthetic */ i bmt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.bmt = iVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qp() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qq() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.bmt.mPopWindow;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.bmt.mPopWindow;
            com.baidu.adp.lib.h.j.a(morePopupWindow2);
        }
    }
}
