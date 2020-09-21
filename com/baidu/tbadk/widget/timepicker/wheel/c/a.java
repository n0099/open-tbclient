package com.baidu.tbadk.widget.timepicker.wheel.c;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes20.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {
    private final WheelView flD;

    public a(WheelView wheelView) {
        this.flD = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.flD.scrollBy(f2);
        return true;
    }
}
