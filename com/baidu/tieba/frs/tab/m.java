package com.baidu.tieba.frs.tab;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements j.a {
    final /* synthetic */ k cfT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.cfT = kVar;
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void ok() {
    }

    @Override // com.baidu.tbadk.core.view.j.a
    public void ol() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.cfT.QG;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.cfT.QG;
            com.baidu.adp.lib.g.j.a(morePopupWindow2);
        }
    }
}
