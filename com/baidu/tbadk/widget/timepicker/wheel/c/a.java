package com.baidu.tbadk.widget.timepicker.wheel.c;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes15.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {
    private final WheelView fiI;

    public a(WheelView wheelView) {
        this.fiI = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.fiI.scrollBy(f2);
        return true;
    }
}
