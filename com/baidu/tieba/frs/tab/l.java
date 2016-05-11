package com.baidu.tieba.frs.tab;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements j.a {
    final /* synthetic */ j btf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.btf = jVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void nx() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void ny() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.btf.KJ;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.btf.KJ;
            com.baidu.adp.lib.h.j.a(morePopupWindow2);
        }
    }
}
