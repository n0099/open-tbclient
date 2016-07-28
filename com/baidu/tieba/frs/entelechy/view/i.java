package com.baidu.tieba.frs.entelechy.view;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ a bLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.bLV = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bLV.aTW != null && this.bLV.aTW.getLayoutParams() != null) {
            this.bLV.aTW.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.bLV.aTW.getLayoutParams();
            layoutParams.height = this.bLV.aTW.getWidth();
            this.bLV.aTW.setLayoutParams(layoutParams);
        }
    }
}
