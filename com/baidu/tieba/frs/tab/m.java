package com.baidu.tieba.frs.tab;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements p.a {
    final /* synthetic */ i bbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.bbc = iVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void qD() {
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void qE() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.bbc.mPopWindow;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.bbc.mPopWindow;
            com.baidu.adp.lib.g.j.a(morePopupWindow2);
        }
    }
}
