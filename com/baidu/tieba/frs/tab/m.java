package com.baidu.tieba.frs.tab;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements h.a {
    final /* synthetic */ i bbq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.bbq = iVar;
    }

    @Override // com.baidu.tbadk.core.view.h.a
    public void qw() {
    }

    @Override // com.baidu.tbadk.core.view.h.a
    public void qx() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.bbq.mPopWindow;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.bbq.mPopWindow;
            com.baidu.adp.lib.g.j.a(morePopupWindow2);
        }
    }
}
