package com.baidu.tieba.frs.tab;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements j.a {
    final /* synthetic */ i bph;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.bph = iVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qK() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void qL() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.bph.Su;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.bph.Su;
            com.baidu.adp.lib.h.j.a(morePopupWindow2);
        }
    }
}
