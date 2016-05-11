package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aBt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aBt = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0048a c0048a;
        a.C0048a c0048a2;
        i = this.aBt.YC;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0048a = this.aBt.aAX;
            c0048a.a(f, f2);
            a aVar = this.aBt;
            c0048a2 = this.aBt.aAX;
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
        i = this.aBt.YC;
        if (i != 1) {
            i2 = this.aBt.YC;
            if (i2 != 2) {
                this.aBt.mMode = 2;
                f = this.aBt.aAQ;
                f2 = this.aBt.aAO;
                if (f > f2) {
                    a aVar = this.aBt;
                    f4 = this.aBt.aAO;
                    aVar.aAQ = f4;
                    a aVar2 = this.aBt;
                    f5 = this.aBt.aAQ;
                    aVar2.aAR = f5;
                    this.aBt.FX();
                    this.aBt.FP();
                    return true;
                }
                a aVar3 = this.aBt;
                f3 = this.aBt.aAO;
                aVar3.aAQ = f3 * 2.0f;
                this.aBt.d(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aBt.FP();
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
        onClickListener = this.aBt.aAW;
        if (onClickListener != null) {
            z = this.aBt.aAZ;
            if (!z) {
                onClickListener2 = this.aBt.aAW;
                onClickListener2.onClick(this.aBt);
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
        this.aBt.aAZ = true;
        i = this.aBt.aAU;
        if (i == 0) {
            z = this.aBt.aBa;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aBt.getScrollX();
        if (this.aBt.aAL >= this.aBt.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aBt.aAU;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aBt.getWidth() + i2 > this.aBt.aAL) {
                    i2 = (int) (this.aBt.aAL - this.aBt.getWidth());
                }
                scrollY = this.aBt.getScrollY();
                if (this.aBt.aAM + this.aBt.mTop + this.aBt.mBottom >= this.aBt.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aBt.aAU;
                    if (i3 == 0) {
                        if (scrollY < (-this.aBt.aBe)) {
                            scrollY = -this.aBt.aBe;
                        }
                        if (this.aBt.getHeight() + scrollY > this.aBt.aAM + this.aBt.mBottom + this.aBt.aBf) {
                            scrollY = (int) ((this.aBt.aAM - this.aBt.getHeight()) + this.aBt.mBottom + this.aBt.aBf);
                        }
                    }
                }
                if (i2 == this.aBt.getScrollX() || scrollY != this.aBt.getScrollY()) {
                    this.aBt.scrollTo(i2, scrollY);
                    this.aBt.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aBt.getScrollY();
        if (this.aBt.aAM + this.aBt.mTop + this.aBt.mBottom >= this.aBt.getHeight()) {
        }
        if (i2 == this.aBt.getScrollX()) {
        }
        this.aBt.scrollTo(i2, scrollY);
        this.aBt.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aBt.ajO;
        if (onLongClickListener != null) {
            z = this.aBt.aAZ;
            if (!z) {
                onLongClickListener2 = this.aBt.ajO;
                onLongClickListener2.onLongClick(this.aBt);
            }
        }
        super.onLongPress(motionEvent);
    }
}
