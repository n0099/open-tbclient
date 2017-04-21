package com.baidu.tieba.homepage.framework.indicator;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ SlidingTabLayout cxI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SlidingTabLayout slidingTabLayout) {
        this.cxI = slidingTabLayout;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        boolean z;
        z zVar;
        com.baidu.tieba.homepage.framework.w wVar;
        z = this.cxI.cxE;
        if (!z) {
            this.cxI.cxE = true;
            zVar = this.cxI.cxG;
            wVar = this.cxI.cxH;
            zVar.a(wVar);
        }
    }
}
