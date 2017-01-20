package com.baidu.tieba.frs.tab;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements j.a {
    final /* synthetic */ j bTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.bTK = jVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void oa() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void ob() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.bTK.Mf;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.bTK.Mf;
            com.baidu.adp.lib.g.j.a(morePopupWindow2);
        }
    }
}
