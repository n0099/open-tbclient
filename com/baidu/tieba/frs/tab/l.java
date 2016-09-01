package com.baidu.tieba.frs.tab;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements j.a {
    final /* synthetic */ j cdN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.cdN = jVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oc() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void od() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.cdN.MV;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.cdN.MV;
            com.baidu.adp.lib.h.j.a(morePopupWindow2);
        }
    }
}
