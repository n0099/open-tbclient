package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aBw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aBw = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0056a c0056a;
        a.C0056a c0056a2;
        i = this.aBw.acN;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0056a = this.aBw.aBa;
            c0056a.d(f, f2);
            a aVar = this.aBw;
            c0056a2 = this.aBw.aBa;
            aVar.startAnimation(c0056a2);
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
        i = this.aBw.acN;
        if (i != 1) {
            i2 = this.aBw.acN;
            if (i2 != 2) {
                this.aBw.mMode = 2;
                f = this.aBw.aAT;
                f2 = this.aBw.aAR;
                if (f > f2) {
                    a aVar = this.aBw;
                    f4 = this.aBw.aAR;
                    aVar.aAT = f4;
                    a aVar2 = this.aBw;
                    f5 = this.aBw.aAT;
                    aVar2.aAU = f5;
                    this.aBw.FE();
                    this.aBw.FC();
                    return true;
                }
                a aVar3 = this.aBw;
                f3 = this.aBw.aAR;
                aVar3.aAT = f3 * 2.0f;
                this.aBw.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aBw.FC();
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
        onClickListener = this.aBw.aAZ;
        if (onClickListener != null) {
            z = this.aBw.aBc;
            if (!z) {
                onClickListener2 = this.aBw.aAZ;
                onClickListener2.onClick(this.aBw);
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
        this.aBw.aBc = true;
        i = this.aBw.aAX;
        if (i == 0) {
            z = this.aBw.aBd;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aBw.getScrollX();
        if (this.aBw.aAO >= this.aBw.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aBw.aAX;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aBw.getWidth() + i2 > this.aBw.aAO) {
                    i2 = (int) (this.aBw.aAO - this.aBw.getWidth());
                }
                scrollY = this.aBw.getScrollY();
                if (this.aBw.aAP + this.aBw.mTop + this.aBw.mBottom >= this.aBw.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aBw.aAX;
                    if (i3 == 0) {
                        if (scrollY < (-this.aBw.aBh)) {
                            scrollY = -this.aBw.aBh;
                        }
                        if (this.aBw.getHeight() + scrollY > this.aBw.aAP + this.aBw.mBottom + this.aBw.aBi) {
                            scrollY = (int) ((this.aBw.aAP - this.aBw.getHeight()) + this.aBw.mBottom + this.aBw.aBi);
                        }
                    }
                }
                if (i2 == this.aBw.getScrollX() || scrollY != this.aBw.getScrollY()) {
                    this.aBw.scrollTo(i2, scrollY);
                    this.aBw.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aBw.getScrollY();
        if (this.aBw.aAP + this.aBw.mTop + this.aBw.mBottom >= this.aBw.getHeight()) {
        }
        if (i2 == this.aBw.getScrollX()) {
        }
        this.aBw.scrollTo(i2, scrollY);
        this.aBw.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aBw.alK;
        if (onLongClickListener != null) {
            z = this.aBw.aBc;
            if (!z) {
                onLongClickListener2 = this.aBw.alK;
                onLongClickListener2.onLongClick(this.aBw);
            }
        }
        super.onLongPress(motionEvent);
    }
}
