package com.baidu.tieba.frs.entelechy.view;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ a bTA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.bTA = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bTA.buO != null && this.bTA.buO.getLayoutParams() != null && this.bTA.buO.getVisibility() != 8) {
            this.bTA.buO.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.bTA.buO.getLayoutParams();
            if (this.bTA.buO.getWidth() > 0) {
                layoutParams.height = (int) (this.bTA.buO.getWidth() * 0.5625d);
                this.bTA.buO.setLayoutParams(layoutParams);
            }
        }
    }
}
