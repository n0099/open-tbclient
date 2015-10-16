package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aAC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aAC = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0054a c0054a;
        a.C0054a c0054a2;
        i = this.aAC.abQ;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0054a = this.aAC.aAg;
            c0054a.d(f, f2);
            a aVar = this.aAC;
            c0054a2 = this.aAC.aAg;
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
        i = this.aAC.abQ;
        if (i != 1) {
            i2 = this.aAC.abQ;
            if (i2 != 2) {
                this.aAC.mMode = 2;
                f = this.aAC.azZ;
                f2 = this.aAC.azX;
                if (f > f2) {
                    a aVar = this.aAC;
                    f4 = this.aAC.azX;
                    aVar.azZ = f4;
                    a aVar2 = this.aAC;
                    f5 = this.aAC.azZ;
                    aVar2.aAa = f5;
                    this.aAC.EM();
                    this.aAC.EK();
                    return true;
                }
                a aVar3 = this.aAC;
                f3 = this.aAC.azX;
                aVar3.azZ = f3 * 2.0f;
                this.aAC.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aAC.EK();
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
        onClickListener = this.aAC.aAf;
        if (onClickListener != null) {
            z = this.aAC.aAi;
            if (!z) {
                onClickListener2 = this.aAC.aAf;
                onClickListener2.onClick(this.aAC);
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
        this.aAC.aAi = true;
        i = this.aAC.aAd;
        if (i == 0) {
            z = this.aAC.aAj;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aAC.getScrollX();
        if (this.aAC.azU >= this.aAC.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aAC.aAd;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aAC.getWidth() + i2 > this.aAC.azU) {
                    i2 = (int) (this.aAC.azU - this.aAC.getWidth());
                }
                scrollY = this.aAC.getScrollY();
                if (this.aAC.azV + this.aAC.mTop + this.aAC.mBottom >= this.aAC.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aAC.aAd;
                    if (i3 == 0) {
                        if (scrollY < (-this.aAC.aAn)) {
                            scrollY = -this.aAC.aAn;
                        }
                        if (this.aAC.getHeight() + scrollY > this.aAC.azV + this.aAC.mBottom + this.aAC.aAo) {
                            scrollY = (int) ((this.aAC.azV - this.aAC.getHeight()) + this.aAC.mBottom + this.aAC.aAo);
                        }
                    }
                }
                if (i2 == this.aAC.getScrollX() || scrollY != this.aAC.getScrollY()) {
                    this.aAC.scrollTo(i2, scrollY);
                    this.aAC.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aAC.getScrollY();
        if (this.aAC.azV + this.aAC.mTop + this.aAC.mBottom >= this.aAC.getHeight()) {
        }
        if (i2 == this.aAC.getScrollX()) {
        }
        this.aAC.scrollTo(i2, scrollY);
        this.aAC.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aAC.ajU;
        if (onLongClickListener != null) {
            z = this.aAC.aAi;
            if (!z) {
                onLongClickListener2 = this.aAC.ajU;
                onLongClickListener2.onLongClick(this.aAC);
            }
        }
        super.onLongPress(motionEvent);
    }
}
