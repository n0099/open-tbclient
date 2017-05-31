package com.baidu.tieba.frs.entelechy.view;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ a bZs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.bZs = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bZs.bvY != null && this.bZs.bvY.getLayoutParams() != null && this.bZs.bvY.getVisibility() != 8) {
            this.bZs.bvY.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.bZs.bvY.getLayoutParams();
            if (this.bZs.bvY.getWidth() > 0) {
                layoutParams.height = (int) (this.bZs.bvY.getWidth() * 0.5625d);
                this.bZs.bvY.setLayoutParams(layoutParams);
            }
        }
    }
}
