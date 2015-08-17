package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ i bbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.bbc = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MorePopupWindow morePopupWindow;
        morePopupWindow = this.bbc.mPopWindow;
        com.baidu.adp.lib.g.j.a(morePopupWindow);
    }
}
