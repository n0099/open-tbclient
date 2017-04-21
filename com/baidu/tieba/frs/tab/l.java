package com.baidu.tieba.frs.tab;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements j.a {
    final /* synthetic */ j cbO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.cbO = jVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oL() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oM() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.cbO.RC;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.cbO.RC;
            com.baidu.adp.lib.g.j.a(morePopupWindow2);
        }
    }
}
