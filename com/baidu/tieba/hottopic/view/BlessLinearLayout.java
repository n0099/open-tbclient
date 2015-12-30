package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class BlessLinearLayout extends LinearLayout {
    public BlessLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
    }

    public BlessLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BlessLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                return false;
            case 1:
                return true;
            default:
                return super.dispatchTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
