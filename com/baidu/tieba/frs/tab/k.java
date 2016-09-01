package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j cdN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.cdN = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MorePopupWindow morePopupWindow;
        morePopupWindow = this.cdN.MV;
        com.baidu.adp.lib.h.j.a(morePopupWindow);
    }
}
