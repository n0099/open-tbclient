package com.baidu.tbadk.widget.horizonalScrollListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
/* loaded from: classes3.dex */
public class MyHorizontalScrollView extends HorizontalScrollView {
    public GestureDetector mGestureDetector;

    /* loaded from: classes3.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Math.abs(f2) > Math.abs(f3);
        }
    }

    public MyHorizontalScrollView(Context context) {
        super(context);
        this.mGestureDetector = new GestureDetector(new b());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return onInterceptTouchEvent;
        }
        return false;
    }

    public MyHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGestureDetector = new GestureDetector(new b());
    }

    public MyHorizontalScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mGestureDetector = new GestureDetector(new b());
    }
}
