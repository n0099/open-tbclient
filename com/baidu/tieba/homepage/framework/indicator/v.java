package com.baidu.tieba.homepage.framework.indicator;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ SlidingTabLayout cDI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SlidingTabLayout slidingTabLayout) {
        this.cDI = slidingTabLayout;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        boolean z;
        z zVar;
        com.baidu.tieba.homepage.framework.w wVar;
        z = this.cDI.cDE;
        if (!z) {
            this.cDI.cDE = true;
            zVar = this.cDI.cDG;
            wVar = this.cDI.cDH;
            zVar.a(wVar);
        }
    }
}
