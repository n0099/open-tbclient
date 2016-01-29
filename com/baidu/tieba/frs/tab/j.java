package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i bph;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bph = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MorePopupWindow morePopupWindow;
        morePopupWindow = this.bph.Su;
        com.baidu.adp.lib.h.j.a(morePopupWindow);
    }
}
