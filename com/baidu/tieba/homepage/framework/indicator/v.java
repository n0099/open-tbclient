package com.baidu.tieba.homepage.framework.indicator;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ SlidingTabLayout cwR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SlidingTabLayout slidingTabLayout) {
        this.cwR = slidingTabLayout;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        boolean z;
        z zVar;
        com.baidu.tieba.homepage.framework.w wVar;
        z = this.cwR.cwN;
        if (!z) {
            this.cwR.cwN = true;
            zVar = this.cwR.cwP;
            wVar = this.cwR.cwQ;
            zVar.a(wVar);
        }
    }
}
