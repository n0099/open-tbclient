package com.baidu.tieba.frs.entelechy.c;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ a bpG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.bpG = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bpG.aPE != null && this.bpG.aPE.getLayoutParams() != null) {
            this.bpG.aPE.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.bpG.aPE.getLayoutParams();
            layoutParams.height = this.bpG.aPE.getWidth();
            this.bpG.aPE.setLayoutParams(layoutParams);
        }
    }
}
