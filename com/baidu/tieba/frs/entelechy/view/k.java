package com.baidu.tieba.frs.entelechy.view;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ a bXm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.bXm = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bXm.aZe != null && this.bXm.aZe.getLayoutParams() != null) {
            this.bXm.aZe.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.bXm.aZe.getLayoutParams();
            layoutParams.height = this.bXm.aZe.getWidth();
            this.bXm.aZe.setLayoutParams(layoutParams);
        }
    }
}
