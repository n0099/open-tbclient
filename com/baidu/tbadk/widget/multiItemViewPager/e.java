package com.baidu.tbadk.widget.multiItemViewPager;

import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnTouchListener {
    final /* synthetic */ MultiItemViewPager aCI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MultiItemViewPager multiItemViewPager) {
        this.aCI = multiItemViewPager;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ViewPager viewPager;
        viewPager = this.aCI.mViewPager;
        return viewPager.dispatchTouchEvent(motionEvent);
    }
}
