package com.baidu.tieba.frs.tab;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements j.a {
    final /* synthetic */ j bZx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.bZx = jVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oL() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oM() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.bZx.RA;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.bZx.RA;
            com.baidu.adp.lib.g.j.a(morePopupWindow2);
        }
    }
}
