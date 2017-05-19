package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnAttachStateChangeListener {
    final /* synthetic */ a bTA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.bTA = aVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        if (this.bTA.buO != null) {
            ViewTreeObserver viewTreeObserver = this.bTA.buO.getViewTreeObserver();
            onGlobalLayoutListener = this.bTA.bTz;
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        if (this.bTA.buO != null) {
            ViewTreeObserver viewTreeObserver = this.bTA.buO.getViewTreeObserver();
            onGlobalLayoutListener = this.bTA.bTz;
            viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }
}
