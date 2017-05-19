package com.baidu.tieba.homepage.framework.indicator;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ PagerSlidingTabStrip ctN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PagerSlidingTabStrip pagerSlidingTabStrip) {
        this.ctN = pagerSlidingTabStrip;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        this.ctN.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.ctN.currentPosition = this.ctN.akE.getCurrentItem();
        PagerSlidingTabStrip pagerSlidingTabStrip = this.ctN;
        i = this.ctN.currentPosition;
        pagerSlidingTabStrip.E(i, 0);
    }
}
