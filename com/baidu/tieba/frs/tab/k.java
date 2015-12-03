package com.baidu.tieba.frs.tab;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements i.a {
    final /* synthetic */ i biC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.biC = iVar;
    }

    @Override // com.baidu.tbadk.core.view.i.a
    public void qG() {
    }

    @Override // com.baidu.tbadk.core.view.i.a
    public void qH() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.biC.mPopWindow;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.biC.mPopWindow;
            com.baidu.adp.lib.h.j.a(morePopupWindow2);
        }
    }
}
