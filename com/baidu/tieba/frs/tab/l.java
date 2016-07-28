package com.baidu.tieba.frs.tab;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements j.a {
    final /* synthetic */ j bSH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.bSH = jVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void nh() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void ni() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.bSH.KI;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.bSH.KI;
            com.baidu.adp.lib.h.j.a(morePopupWindow2);
        }
    }
}
