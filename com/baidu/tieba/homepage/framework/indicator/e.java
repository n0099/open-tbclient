package com.baidu.tieba.homepage.framework.indicator;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ PagerSlidingTabStrip cAf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PagerSlidingTabStrip pagerSlidingTabStrip) {
        this.cAf = pagerSlidingTabStrip;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        this.cAf.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.cAf.currentPosition = this.cAf.aku.getCurrentItem();
        PagerSlidingTabStrip pagerSlidingTabStrip = this.cAf;
        i = this.cAf.currentPosition;
        pagerSlidingTabStrip.D(i, 0);
    }
}
