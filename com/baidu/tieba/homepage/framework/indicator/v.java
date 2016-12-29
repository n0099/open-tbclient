package com.baidu.tieba.homepage.framework.indicator;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ SlidingTabLayout coq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SlidingTabLayout slidingTabLayout) {
        this.coq = slidingTabLayout;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        boolean z;
        z zVar;
        com.baidu.tieba.homepage.framework.w wVar;
        z = this.coq.f2com;
        if (!z) {
            this.coq.f2com = true;
            zVar = this.coq.coo;
            wVar = this.coq.cop;
            zVar.a(wVar);
        }
    }
}
