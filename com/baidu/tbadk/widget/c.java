package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a azq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.azq = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0054a c0054a;
        a.C0054a c0054a2;
        i = this.azq.abV;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0054a = this.azq.ayU;
            c0054a.d(f, f2);
            a aVar = this.azq;
            c0054a2 = this.azq.ayU;
            aVar.startAnimation(c0054a2);
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        int i;
        int i2;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        i = this.azq.abV;
        if (i != 1) {
            i2 = this.azq.abV;
            if (i2 != 2) {
                this.azq.mMode = 2;
                f = this.azq.ayN;
                f2 = this.azq.ayL;
                if (f > f2) {
                    a aVar = this.azq;
                    f4 = this.azq.ayL;
                    aVar.ayN = f4;
                    a aVar2 = this.azq;
                    f5 = this.azq.ayN;
                    aVar2.ayO = f5;
                    this.azq.EB();
                    this.azq.Ez();
                    return true;
                }
                a aVar3 = this.azq;
                f3 = this.azq.ayL;
                aVar3.ayN = f3 * 2.0f;
                this.azq.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.azq.Ez();
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        boolean z;
        View.OnClickListener onClickListener2;
        onClickListener = this.azq.ayT;
        if (onClickListener != null) {
            z = this.azq.ayW;
            if (!z) {
                onClickListener2 = this.azq.ayT;
                onClickListener2.onClick(this.azq);
            }
        }
        return super.onSingleTapConfirmed(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        int i2;
        int scrollY;
        int i3;
        int i4;
        boolean z;
        this.azq.ayW = true;
        i = this.azq.ayR;
        if (i == 0) {
            z = this.azq.ayX;
            if (z) {
                return false;
            }
        }
        int scrollX = this.azq.getScrollX();
        if (this.azq.ayI >= this.azq.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.azq.ayR;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.azq.getWidth() + i2 > this.azq.ayI) {
                    i2 = (int) (this.azq.ayI - this.azq.getWidth());
                }
                scrollY = this.azq.getScrollY();
                if (this.azq.ayJ + this.azq.mTop + this.azq.mBottom >= this.azq.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.azq.ayR;
                    if (i3 == 0) {
                        if (scrollY < (-this.azq.azb)) {
                            scrollY = -this.azq.azb;
                        }
                        if (this.azq.getHeight() + scrollY > this.azq.ayJ + this.azq.mBottom + this.azq.azc) {
                            scrollY = (int) ((this.azq.ayJ - this.azq.getHeight()) + this.azq.mBottom + this.azq.azc);
                        }
                    }
                }
                if (i2 == this.azq.getScrollX() || scrollY != this.azq.getScrollY()) {
                    this.azq.scrollTo(i2, scrollY);
                    this.azq.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.azq.getScrollY();
        if (this.azq.ayJ + this.azq.mTop + this.azq.mBottom >= this.azq.getHeight()) {
        }
        if (i2 == this.azq.getScrollX()) {
        }
        this.azq.scrollTo(i2, scrollY);
        this.azq.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.azq.ajZ;
        if (onLongClickListener != null) {
            z = this.azq.ayW;
            if (!z) {
                onLongClickListener2 = this.azq.ajZ;
                onLongClickListener2.onLongClick(this.azq);
            }
        }
        super.onLongPress(motionEvent);
    }
}
