package com.baidu.tieba.frs.tab;

import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements h.a {
    final /* synthetic */ i bbB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.bbB = iVar;
    }

    @Override // com.baidu.tbadk.core.view.h.a
    public void qt() {
    }

    @Override // com.baidu.tbadk.core.view.h.a
    public void qu() {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.bbB.mPopWindow;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.bbB.mPopWindow;
            com.baidu.adp.lib.g.j.a(morePopupWindow2);
        }
    }
}
