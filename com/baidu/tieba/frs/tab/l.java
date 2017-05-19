package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ k bZH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bZH = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MorePopupWindow morePopupWindow;
        morePopupWindow = this.bZH.QU;
        com.baidu.adp.lib.g.j.a(morePopupWindow);
    }
}
