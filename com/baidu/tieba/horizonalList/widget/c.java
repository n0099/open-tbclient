package com.baidu.tieba.horizonalList.widget;

import android.view.VelocityTracker;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ AbsHListView.e cvz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsHListView.e eVar) {
        this.cvz = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AbsHListView absHListView;
        int i;
        AbsHListView absHListView2;
        VelocityTracker velocityTracker;
        AbsHListView absHListView3;
        int i2;
        AbsHListView absHListView4;
        int i3;
        AbsHListView absHListView5;
        AbsHListView absHListView6;
        AbsHListView absHListView7;
        absHListView = AbsHListView.this;
        i = absHListView.mActivePointerId;
        absHListView2 = AbsHListView.this;
        velocityTracker = absHListView2.mVelocityTracker;
        o oVar = this.cvz.cvw;
        if (velocityTracker != null && i != -1) {
            absHListView3 = AbsHListView.this;
            i2 = absHListView3.mMaximumVelocity;
            velocityTracker.computeCurrentVelocity(1000, i2);
            float f = -velocityTracker.getXVelocity(i);
            float abs = Math.abs(f);
            absHListView4 = AbsHListView.this;
            i3 = absHListView4.mMinimumVelocity;
            if (abs >= i3 && oVar.e(f, 0.0f)) {
                absHListView7 = AbsHListView.this;
                absHListView7.postDelayed(this, 40L);
                return;
            }
            this.cvz.aif();
            absHListView5 = AbsHListView.this;
            absHListView5.mTouchMode = 3;
            absHListView6 = AbsHListView.this;
            absHListView6.jC(1);
        }
    }
}
