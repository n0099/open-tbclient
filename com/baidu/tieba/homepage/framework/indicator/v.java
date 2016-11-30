package com.baidu.tieba.homepage.framework.indicator;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ SlidingTabLayout cIV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SlidingTabLayout slidingTabLayout) {
        this.cIV = slidingTabLayout;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        boolean z;
        z zVar;
        com.baidu.tieba.homepage.framework.w wVar;
        z = this.cIV.cIR;
        if (!z) {
            this.cIV.cIR = true;
            zVar = this.cIV.cIT;
            wVar = this.cIV.cIU;
            zVar.a(wVar);
        }
    }
}
