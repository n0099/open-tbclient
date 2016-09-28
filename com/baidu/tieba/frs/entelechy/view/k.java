package com.baidu.tieba.frs.entelechy.view;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ a bXh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.bXh = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bXh.aZy != null && this.bXh.aZy.getLayoutParams() != null) {
            this.bXh.aZy.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.bXh.aZy.getLayoutParams();
            layoutParams.height = this.bXh.aZy.getWidth();
            this.bXh.aZy.setLayoutParams(layoutParams);
        }
    }
}
