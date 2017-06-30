package com.baidu.tieba.homepage.framework.indicator;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ PagerSlidingTabStrip cHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PagerSlidingTabStrip pagerSlidingTabStrip) {
        this.cHR = pagerSlidingTabStrip;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        this.cHR.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.cHR.currentPosition = this.cHR.alh.getCurrentItem();
        PagerSlidingTabStrip pagerSlidingTabStrip = this.cHR;
        i = this.cHR.currentPosition;
        pagerSlidingTabStrip.D(i, 0);
    }
}
