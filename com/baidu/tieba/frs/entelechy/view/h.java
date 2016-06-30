package com.baidu.tieba.frs.entelechy.view;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ a bKn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.bKn = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bKn.aTa != null && this.bKn.aTa.getLayoutParams() != null) {
            this.bKn.aTa.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.bKn.aTa.getLayoutParams();
            layoutParams.height = this.bKn.aTa.getWidth();
            this.bKn.aTa.setLayoutParams(layoutParams);
        }
    }
}
