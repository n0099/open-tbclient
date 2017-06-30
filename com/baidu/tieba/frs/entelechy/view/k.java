package com.baidu.tieba.frs.entelechy.view;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ a chB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.chB = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.chB.byJ != null && this.chB.byJ.getLayoutParams() != null && this.chB.byJ.getVisibility() != 8) {
            this.chB.byJ.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.chB.byJ.getLayoutParams();
            if (this.chB.byJ.getWidth() > 0) {
                layoutParams.height = (int) (this.chB.byJ.getWidth() * 0.5625d);
                this.chB.byJ.setLayoutParams(layoutParams);
            }
        }
    }
}
