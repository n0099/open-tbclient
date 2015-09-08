package com.baidu.tieba.frs.tab;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements p.a {
    final /* synthetic */ i bbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.bbw = iVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void qA() {
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void qB() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.bbw.mPopWindow;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.bbw.mPopWindow;
            com.baidu.adp.lib.g.j.a(morePopupWindow2);
        }
    }
}
