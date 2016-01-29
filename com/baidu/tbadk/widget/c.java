package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aDT = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0057a c0057a;
        a.C0057a c0057a2;
        i = this.aDT.adO;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0057a = this.aDT.aDx;
            c0057a.d(f, f2);
            a aVar = this.aDT;
            c0057a2 = this.aDT.aDx;
            aVar.startAnimation(c0057a2);
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
        i = this.aDT.adO;
        if (i != 1) {
            i2 = this.aDT.adO;
            if (i2 != 2) {
                this.aDT.mMode = 2;
                f = this.aDT.aDq;
                f2 = this.aDT.aDo;
                if (f > f2) {
                    a aVar = this.aDT;
                    f4 = this.aDT.aDo;
                    aVar.aDq = f4;
                    a aVar2 = this.aDT;
                    f5 = this.aDT.aDq;
                    aVar2.aDr = f5;
                    this.aDT.GK();
                    this.aDT.GI();
                    return true;
                }
                a aVar3 = this.aDT;
                f3 = this.aDT.aDo;
                aVar3.aDq = f3 * 2.0f;
                this.aDT.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aDT.GI();
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
        onClickListener = this.aDT.aDw;
        if (onClickListener != null) {
            z = this.aDT.aDz;
            if (!z) {
                onClickListener2 = this.aDT.aDw;
                onClickListener2.onClick(this.aDT);
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
        this.aDT.aDz = true;
        i = this.aDT.aDu;
        if (i == 0) {
            z = this.aDT.aDA;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aDT.getScrollX();
        if (this.aDT.aDl >= this.aDT.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aDT.aDu;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aDT.getWidth() + i2 > this.aDT.aDl) {
                    i2 = (int) (this.aDT.aDl - this.aDT.getWidth());
                }
                scrollY = this.aDT.getScrollY();
                if (this.aDT.aDm + this.aDT.mTop + this.aDT.mBottom >= this.aDT.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aDT.aDu;
                    if (i3 == 0) {
                        if (scrollY < (-this.aDT.aDE)) {
                            scrollY = -this.aDT.aDE;
                        }
                        if (this.aDT.getHeight() + scrollY > this.aDT.aDm + this.aDT.mBottom + this.aDT.aDF) {
                            scrollY = (int) ((this.aDT.aDm - this.aDT.getHeight()) + this.aDT.mBottom + this.aDT.aDF);
                        }
                    }
                }
                if (i2 == this.aDT.getScrollX() || scrollY != this.aDT.getScrollY()) {
                    this.aDT.scrollTo(i2, scrollY);
                    this.aDT.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aDT.getScrollY();
        if (this.aDT.aDm + this.aDT.mTop + this.aDT.mBottom >= this.aDT.getHeight()) {
        }
        if (i2 == this.aDT.getScrollX()) {
        }
        this.aDT.scrollTo(i2, scrollY);
        this.aDT.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aDT.anJ;
        if (onLongClickListener != null) {
            z = this.aDT.aDz;
            if (!z) {
                onLongClickListener2 = this.aDT.anJ;
                onLongClickListener2.onLongClick(this.aDT);
            }
        }
        super.onLongPress(motionEvent);
    }
}
