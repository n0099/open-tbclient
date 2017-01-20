package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aEo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aEo = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0048a c0048a;
        a.C0048a c0048a2;
        i = this.aEo.abF;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0048a = this.aEo.aDR;
            c0048a.e(f, f2);
            a aVar = this.aEo;
            c0048a2 = this.aEo.aDR;
            aVar.startAnimation(c0048a2);
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
        i = this.aEo.abF;
        if (i != 1) {
            i2 = this.aEo.abF;
            if (i2 != 2) {
                this.aEo.mMode = 2;
                f = this.aEo.mCurrentScale;
                f2 = this.aEo.aDJ;
                if (f > f2) {
                    a aVar = this.aEo;
                    f4 = this.aEo.aDJ;
                    aVar.mCurrentScale = f4;
                    a aVar2 = this.aEo;
                    f5 = this.aEo.mCurrentScale;
                    aVar2.aDL = f5;
                    this.aEo.GN();
                    return true;
                }
                a aVar3 = this.aEo;
                f3 = this.aEo.aDJ;
                aVar3.mCurrentScale = f3 * 2.0f;
                this.aEo.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
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
        onClickListener = this.aEo.aDQ;
        if (onClickListener != null) {
            z = this.aEo.aDT;
            if (!z) {
                onClickListener2 = this.aEo.aDQ;
                onClickListener2.onClick(this.aEo);
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
        this.aEo.aDT = true;
        i = this.aEo.aDO;
        if (i == 0) {
            z = this.aEo.aDU;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aEo.getScrollX();
        if (this.aEo.aDG >= this.aEo.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aEo.aDO;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aEo.getWidth() + i2 > this.aEo.aDG) {
                    i2 = (int) (this.aEo.aDG - this.aEo.getWidth());
                }
                scrollY = this.aEo.getScrollY();
                if (this.aEo.aDH + this.aEo.mTop + this.aEo.mBottom >= this.aEo.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aEo.aDO;
                    if (i3 == 0) {
                        if (scrollY < (-this.aEo.aDY)) {
                            scrollY = -this.aEo.aDY;
                        }
                        if (this.aEo.getHeight() + scrollY > this.aEo.aDH + this.aEo.mBottom + this.aEo.aDZ) {
                            scrollY = (int) ((this.aEo.aDH - this.aEo.getHeight()) + this.aEo.mBottom + this.aEo.aDZ);
                        }
                    }
                }
                if (i2 == this.aEo.getScrollX() || scrollY != this.aEo.getScrollY()) {
                    this.aEo.scrollTo(i2, scrollY);
                    this.aEo.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aEo.getScrollY();
        if (this.aEo.aDH + this.aEo.mTop + this.aEo.mBottom >= this.aEo.getHeight()) {
        }
        if (i2 == this.aEo.getScrollX()) {
        }
        this.aEo.scrollTo(i2, scrollY);
        this.aEo.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aEo.anA;
        if (onLongClickListener != null) {
            z = this.aEo.aDT;
            if (!z) {
                onLongClickListener2 = this.aEo.anA;
                onLongClickListener2.onLongClick(this.aEo);
            }
        }
        super.onLongPress(motionEvent);
    }
}
