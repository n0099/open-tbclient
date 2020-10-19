package com.baidu.tbadk.widget.timepicker.wheel.c;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes21.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {
    private final WheelView fxR;

    public a(WheelView wheelView) {
        this.fxR = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.fxR.scrollBy(f2);
        return true;
    }
}
