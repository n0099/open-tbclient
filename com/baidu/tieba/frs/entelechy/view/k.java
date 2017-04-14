package com.baidu.tieba.frs.entelechy.view;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ a bTp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.bTp = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bTp.bsy != null && this.bTp.bsy.getLayoutParams() != null && this.bTp.bsy.getVisibility() != 8) {
            this.bTp.bsy.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.bTp.bsy.getLayoutParams();
            if (this.bTp.bsy.getWidth() > 0) {
                layoutParams.height = (int) (this.bTp.bsy.getWidth() * 0.5625d);
                this.bTp.bsy.setLayoutParams(layoutParams);
            }
        }
    }
}
