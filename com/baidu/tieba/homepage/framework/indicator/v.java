package com.baidu.tieba.homepage.framework.indicator;

import android.view.ViewTreeObserver;
import com.baidu.tieba.homepage.framework.indicator.SlidingTabLayout;
/* loaded from: classes.dex */
class v implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ SlidingTabLayout.a cDe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SlidingTabLayout.a aVar) {
        this.cDe = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        SlidingTabLayout slidingTabLayout;
        boolean z;
        SlidingTabLayout slidingTabLayout2;
        SlidingTabLayout slidingTabLayout3;
        z zVar;
        SlidingTabLayout slidingTabLayout4;
        com.baidu.tieba.homepage.framework.w wVar;
        slidingTabLayout = SlidingTabLayout.this;
        z = slidingTabLayout.cCZ;
        if (!z) {
            slidingTabLayout2 = SlidingTabLayout.this;
            slidingTabLayout2.cCZ = true;
            slidingTabLayout3 = SlidingTabLayout.this;
            zVar = slidingTabLayout3.cDb;
            slidingTabLayout4 = SlidingTabLayout.this;
            wVar = slidingTabLayout4.cDc;
            zVar.a(wVar);
        }
    }
}
