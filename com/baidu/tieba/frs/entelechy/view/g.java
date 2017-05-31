package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnAttachStateChangeListener {
    final /* synthetic */ a bZs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.bZs = aVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        if (this.bZs.bvY != null) {
            ViewTreeObserver viewTreeObserver = this.bZs.bvY.getViewTreeObserver();
            onGlobalLayoutListener = this.bZs.bZr;
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        if (this.bZs.bvY != null) {
            ViewTreeObserver viewTreeObserver = this.bZs.bvY.getViewTreeObserver();
            onGlobalLayoutListener = this.bZs.bZr;
            viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }
}
