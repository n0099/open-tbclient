package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aJL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aJL = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0047a c0047a;
        a.C0047a c0047a2;
        i = this.aJL.agV;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0047a = this.aJL.aJo;
            c0047a.e(f, f2);
            a aVar = this.aJL;
            c0047a2 = this.aJL.aJo;
            aVar.startAnimation(c0047a2);
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
        i = this.aJL.agV;
        if (i != 1) {
            i2 = this.aJL.agV;
            if (i2 != 2) {
                this.aJL.mMode = 2;
                f = this.aJL.mCurrentScale;
                f2 = this.aJL.aJg;
                if (f > f2) {
                    a aVar = this.aJL;
                    f4 = this.aJL.aJg;
                    aVar.mCurrentScale = f4;
                    a aVar2 = this.aJL;
                    f5 = this.aJL.mCurrentScale;
                    aVar2.aJi = f5;
                    this.aJL.Hm();
                    return true;
                }
                a aVar3 = this.aJL;
                f3 = this.aJL.aJg;
                aVar3.mCurrentScale = f3 * 2.0f;
                this.aJL.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
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
        onClickListener = this.aJL.aJn;
        if (onClickListener != null) {
            z = this.aJL.aJq;
            if (!z) {
                onClickListener2 = this.aJL.aJn;
                onClickListener2.onClick(this.aJL);
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
        this.aJL.aJq = true;
        i = this.aJL.aJl;
        if (i == 0) {
            z = this.aJL.aJr;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aJL.getScrollX();
        if (this.aJL.aJd >= this.aJL.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aJL.aJl;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aJL.getWidth() + i2 > this.aJL.aJd) {
                    i2 = (int) (this.aJL.aJd - this.aJL.getWidth());
                }
                scrollY = this.aJL.getScrollY();
                if (this.aJL.aJe + this.aJL.mTop + this.aJL.mBottom >= this.aJL.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aJL.aJl;
                    if (i3 == 0) {
                        if (scrollY < (-this.aJL.aJv)) {
                            scrollY = -this.aJL.aJv;
                        }
                        if (this.aJL.getHeight() + scrollY > this.aJL.aJe + this.aJL.mBottom + this.aJL.aJw) {
                            scrollY = (int) ((this.aJL.aJe - this.aJL.getHeight()) + this.aJL.mBottom + this.aJL.aJw);
                        }
                    }
                }
                if (i2 == this.aJL.getScrollX() || scrollY != this.aJL.getScrollY()) {
                    this.aJL.scrollTo(i2, scrollY);
                    this.aJL.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aJL.getScrollY();
        if (this.aJL.aJe + this.aJL.mTop + this.aJL.mBottom >= this.aJL.getHeight()) {
        }
        if (i2 == this.aJL.getScrollX()) {
        }
        this.aJL.scrollTo(i2, scrollY);
        this.aJL.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aJL.asV;
        if (onLongClickListener != null) {
            z = this.aJL.aJq;
            if (!z) {
                onLongClickListener2 = this.aJL.asV;
                onLongClickListener2.onLongClick(this.aJL);
            }
        }
        super.onLongPress(motionEvent);
    }
}
