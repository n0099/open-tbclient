package com.baidu.tieba.barselect.idCard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes6.dex */
public class OCRFrameLayout extends ViewGroup {
    public OCRFrameLayout(Context context) {
        super(context);
    }

    public OCRFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g(attributeSet);
    }

    public OCRFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g(attributeSet);
    }

    private void g(AttributeSet attributeSet) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (int i3 = 0; i3 < childCount; i3++) {
            measureChild(getChildAt(i3), View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        }
        setMeasuredDimension(resolveSize(size, i), resolveSize(size2, i2));
    }
}
