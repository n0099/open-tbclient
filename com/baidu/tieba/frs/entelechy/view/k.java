package com.baidu.tieba.frs.entelechy.view;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ a bMu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.bMu = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bMu.blN != null && this.bMu.blN.getLayoutParams() != null && this.bMu.blN.getVisibility() != 8) {
            this.bMu.blN.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.bMu.blN.getLayoutParams();
            if (this.bMu.blN.getWidth() > 0) {
                layoutParams.height = (int) (this.bMu.blN.getWidth() * 0.5625d);
                this.bMu.blN.setLayoutParams(layoutParams);
            }
        }
    }
}
