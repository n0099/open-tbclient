package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aBN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aBN = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0054a c0054a;
        a.C0054a c0054a2;
        i = this.aBN.abO;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0054a = this.aBN.aBr;
            c0054a.d(f, f2);
            a aVar = this.aBN;
            c0054a2 = this.aBN.aBr;
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
        i = this.aBN.abO;
        if (i != 1) {
            i2 = this.aBN.abO;
            if (i2 != 2) {
                this.aBN.mMode = 2;
                f = this.aBN.aBk;
                f2 = this.aBN.aBi;
                if (f > f2) {
                    a aVar = this.aBN;
                    f4 = this.aBN.aBi;
                    aVar.aBk = f4;
                    a aVar2 = this.aBN;
                    f5 = this.aBN.aBk;
                    aVar2.aBl = f5;
                    this.aBN.EX();
                    this.aBN.EV();
                    return true;
                }
                a aVar3 = this.aBN;
                f3 = this.aBN.aBi;
                aVar3.aBk = f3 * 2.0f;
                this.aBN.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aBN.EV();
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
        onClickListener = this.aBN.aBq;
        if (onClickListener != null) {
            z = this.aBN.aBt;
            if (!z) {
                onClickListener2 = this.aBN.aBq;
                onClickListener2.onClick(this.aBN);
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
        this.aBN.aBt = true;
        i = this.aBN.aBo;
        if (i == 0) {
            z = this.aBN.aBu;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aBN.getScrollX();
        if (this.aBN.aBf >= this.aBN.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aBN.aBo;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aBN.getWidth() + i2 > this.aBN.aBf) {
                    i2 = (int) (this.aBN.aBf - this.aBN.getWidth());
                }
                scrollY = this.aBN.getScrollY();
                if (this.aBN.aBg + this.aBN.mTop + this.aBN.mBottom >= this.aBN.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aBN.aBo;
                    if (i3 == 0) {
                        if (scrollY < (-this.aBN.aBy)) {
                            scrollY = -this.aBN.aBy;
                        }
                        if (this.aBN.getHeight() + scrollY > this.aBN.aBg + this.aBN.mBottom + this.aBN.aBz) {
                            scrollY = (int) ((this.aBN.aBg - this.aBN.getHeight()) + this.aBN.mBottom + this.aBN.aBz);
                        }
                    }
                }
                if (i2 == this.aBN.getScrollX() || scrollY != this.aBN.getScrollY()) {
                    this.aBN.scrollTo(i2, scrollY);
                    this.aBN.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aBN.getScrollY();
        if (this.aBN.aBg + this.aBN.mTop + this.aBN.mBottom >= this.aBN.getHeight()) {
        }
        if (i2 == this.aBN.getScrollX()) {
        }
        this.aBN.scrollTo(i2, scrollY);
        this.aBN.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aBN.alb;
        if (onLongClickListener != null) {
            z = this.aBN.aBt;
            if (!z) {
                onLongClickListener2 = this.aBN.alb;
                onLongClickListener2.onLongClick(this.aBN);
            }
        }
        super.onLongPress(motionEvent);
    }
}
