package com.baidu.tieba.graffiti;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class HorizontalScrollLayout extends LinearLayout {
    private GestureDetector mGestureDetector;

    public HorizontalScrollLayout(Context context) {
        super(context);
        this.mGestureDetector = new GestureDetector((Context) null, new a());
    }

    public HorizontalScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGestureDetector = new GestureDetector((Context) null, new a());
    }

    public HorizontalScrollLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGestureDetector = new GestureDetector((Context) null, new a());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
                return onInterceptTouchEvent;
            }
            return onInterceptTouchEvent;
        }
        return false;
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return Math.abs(f) > Math.abs(f2);
        }
    }
}
