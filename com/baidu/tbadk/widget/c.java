package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aKd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aKd = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0046a c0046a;
        a.C0046a c0046a2;
        i = this.aKd.ahk;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0046a = this.aKd.aJG;
            c0046a.e(f, f2);
            a aVar = this.aKd;
            c0046a2 = this.aKd.aJG;
            aVar.startAnimation(c0046a2);
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
        i = this.aKd.ahk;
        if (i != 1) {
            i2 = this.aKd.ahk;
            if (i2 != 2) {
                this.aKd.mMode = 2;
                f = this.aKd.mCurrentScale;
                f2 = this.aKd.aJy;
                if (f > f2) {
                    a aVar = this.aKd;
                    f4 = this.aKd.aJy;
                    aVar.mCurrentScale = f4;
                    a aVar2 = this.aKd;
                    f5 = this.aKd.mCurrentScale;
                    aVar2.aJA = f5;
                    this.aKd.HL();
                    return true;
                }
                a aVar3 = this.aKd;
                f3 = this.aKd.aJy;
                aVar3.mCurrentScale = f3 * 2.0f;
                this.aKd.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
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
        onClickListener = this.aKd.aJF;
        if (onClickListener != null) {
            z = this.aKd.aJI;
            if (!z) {
                onClickListener2 = this.aKd.aJF;
                onClickListener2.onClick(this.aKd);
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
        this.aKd.aJI = true;
        i = this.aKd.aJD;
        if (i == 0) {
            z = this.aKd.aJJ;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aKd.getScrollX();
        if (this.aKd.aJv >= this.aKd.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aKd.aJD;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aKd.getWidth() + i2 > this.aKd.aJv) {
                    i2 = (int) (this.aKd.aJv - this.aKd.getWidth());
                }
                scrollY = this.aKd.getScrollY();
                if (this.aKd.aJw + this.aKd.mTop + this.aKd.mBottom >= this.aKd.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aKd.aJD;
                    if (i3 == 0) {
                        if (scrollY < (-this.aKd.aJN)) {
                            scrollY = -this.aKd.aJN;
                        }
                        if (this.aKd.getHeight() + scrollY > this.aKd.aJw + this.aKd.mBottom + this.aKd.aJO) {
                            scrollY = (int) ((this.aKd.aJw - this.aKd.getHeight()) + this.aKd.mBottom + this.aKd.aJO);
                        }
                    }
                }
                if (i2 == this.aKd.getScrollX() || scrollY != this.aKd.getScrollY()) {
                    this.aKd.scrollTo(i2, scrollY);
                    this.aKd.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aKd.getScrollY();
        if (this.aKd.aJw + this.aKd.mTop + this.aKd.mBottom >= this.aKd.getHeight()) {
        }
        if (i2 == this.aKd.getScrollX()) {
        }
        this.aKd.scrollTo(i2, scrollY);
        this.aKd.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aKd.atn;
        if (onLongClickListener != null) {
            z = this.aKd.aJI;
            if (!z) {
                onLongClickListener2 = this.aKd.atn;
                onLongClickListener2.onLongClick(this.aKd);
            }
        }
        super.onLongPress(motionEvent);
    }
}
