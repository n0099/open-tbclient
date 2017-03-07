package com.baidu.tieba.frs.entelechy.view;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ a bTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.bTB = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bTB.bsG != null && this.bTB.bsG.getLayoutParams() != null && this.bTB.bsG.getVisibility() != 8) {
            this.bTB.bsG.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.bTB.bsG.getLayoutParams();
            if (this.bTB.bsG.getWidth() > 0) {
                layoutParams.height = (int) (this.bTB.bsG.getWidth() * 0.5625d);
                this.bTB.bsG.setLayoutParams(layoutParams);
            }
        }
    }
}
