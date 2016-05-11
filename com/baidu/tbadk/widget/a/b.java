package com.baidu.tbadk.widget.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
public class b extends HorizontalScrollView {
    private GestureDetector mGestureDetector;

    public b(Context context) {
        super(context);
        this.mGestureDetector = new GestureDetector(new a(this, null));
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGestureDetector = new GestureDetector(new a(this, null));
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGestureDetector = new GestureDetector(new a(this, null));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
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

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return Math.abs(f) > Math.abs(f2);
        }
    }
}
