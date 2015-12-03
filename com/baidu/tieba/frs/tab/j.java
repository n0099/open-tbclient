package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i biC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.biC = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MorePopupWindow morePopupWindow;
        morePopupWindow = this.biC.mPopWindow;
        com.baidu.adp.lib.h.j.a(morePopupWindow);
    }
}
