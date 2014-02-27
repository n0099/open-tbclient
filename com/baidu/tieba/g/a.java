package com.baidu.tieba.g;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public final class a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnTouchListener {
    private GestureDetector a = new GestureDetector(this);
    private b b;
    private View c;

    public a(b bVar) {
        this.b = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.c = view;
        if (this.a != null) {
            return this.a.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        Log.d("testGestureDetector", "onDoubleTap---->处理双击事件");
        if (this.b != null) {
            return this.b.a(this.c);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        if (this.b != null) {
            b bVar = this.b;
            View view = this.c;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.b != null) {
            b bVar = this.b;
            View view = this.c;
            return bVar.a();
        }
        return false;
    }
}
