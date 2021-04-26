package com.baidu.tieba.ala.livecard.vc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes4.dex */
public class FrsAlaStageLiveViewPager extends ViewPager {
    public FrsAlaStageLiveViewPager(Context context) {
        super(context);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            childAt.measure(i2, View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i4) {
                i4 = measuredHeight;
            }
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
    }

    public FrsAlaStageLiveViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
