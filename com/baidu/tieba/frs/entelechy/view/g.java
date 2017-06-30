package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnAttachStateChangeListener {
    final /* synthetic */ a chB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.chB = aVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        if (this.chB.byJ != null) {
            ViewTreeObserver viewTreeObserver = this.chB.byJ.getViewTreeObserver();
            onGlobalLayoutListener = this.chB.chA;
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        if (this.chB.byJ != null) {
            ViewTreeObserver viewTreeObserver = this.chB.byJ.getViewTreeObserver();
            onGlobalLayoutListener = this.chB.chA;
            viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }
}
