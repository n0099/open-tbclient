package com.baidu.tieba.frs.entelechy.view;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ a bGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.bGf = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bGf.bcb != null && this.bGf.bcb.getLayoutParams() != null && this.bGf.bcb.getVisibility() != 8) {
            this.bGf.bcb.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.bGf.bcb.getLayoutParams();
            if (this.bGf.bcb.getWidth() > 0) {
                layoutParams.height = (int) (this.bGf.bcb.getWidth() * 0.5625d);
                this.bGf.bcb.setLayoutParams(layoutParams);
            }
        }
    }
}
