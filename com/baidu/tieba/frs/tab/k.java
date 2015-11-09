package com.baidu.tieba.frs.tab;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements h.a {
    final /* synthetic */ i bbX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.bbX = iVar;
    }

    @Override // com.baidu.tbadk.core.view.h.a
    public void qu() {
    }

    @Override // com.baidu.tbadk.core.view.h.a
    public void qv() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.bbX.mPopWindow;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.bbX.mPopWindow;
            com.baidu.adp.lib.g.j.a(morePopupWindow2);
        }
    }
}
