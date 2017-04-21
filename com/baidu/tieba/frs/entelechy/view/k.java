package com.baidu.tieba.frs.entelechy.view;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ a bVG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.bVG = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bVG.buR != null && this.bVG.buR.getLayoutParams() != null && this.bVG.buR.getVisibility() != 8) {
            this.bVG.buR.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.bVG.buR.getLayoutParams();
            if (this.bVG.buR.getWidth() > 0) {
                layoutParams.height = (int) (this.bVG.buR.getWidth() * 0.5625d);
                this.bVG.buR.setLayoutParams(layoutParams);
            }
        }
    }
}
