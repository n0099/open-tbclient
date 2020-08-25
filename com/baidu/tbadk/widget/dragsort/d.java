package com.baidu.tbadk.widget.dragsort;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.ListAdapter;
/* loaded from: classes2.dex */
public interface d {
    void dispatchDraw(Canvas canvas);

    void layoutChildren();

    void onDraw(Canvas canvas);

    boolean onInterceptTouchEvent(MotionEvent motionEvent);

    void onMeasure(int i, int i2);

    void onSizeChanged(int i, int i2, int i3, int i4);

    boolean onTouchEvent(MotionEvent motionEvent);

    void requestLayout();

    void setAdapter(ListAdapter listAdapter);
}
