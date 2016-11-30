package com.baidu.tieba.frs.entelechy.view;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ a cax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.cax = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.cax.bcI != null && this.cax.bcI.getLayoutParams() != null) {
            this.cax.bcI.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.cax.bcI.getLayoutParams();
            layoutParams.height = (int) (this.cax.bcI.getWidth() * 0.5625d);
            this.cax.bcI.setLayoutParams(layoutParams);
        }
    }
}
