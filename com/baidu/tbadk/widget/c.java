package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aFj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aFj = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0057a c0057a;
        a.C0057a c0057a2;
        i = this.aFj.ade;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0057a = this.aFj.aEN;
            c0057a.b(f, f2);
            a aVar = this.aFj;
            c0057a2 = this.aFj.aEN;
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
        i = this.aFj.ade;
        if (i != 1) {
            i2 = this.aFj.ade;
            if (i2 != 2) {
                this.aFj.mMode = 2;
                f = this.aFj.aEG;
                f2 = this.aFj.aEE;
                if (f > f2) {
                    a aVar = this.aFj;
                    f4 = this.aFj.aEE;
                    aVar.aEG = f4;
                    a aVar2 = this.aFj;
                    f5 = this.aFj.aEG;
                    aVar2.aEH = f5;
                    this.aFj.HM();
                    this.aFj.HK();
                    return true;
                }
                a aVar3 = this.aFj;
                f3 = this.aFj.aEE;
                aVar3.aEG = f3 * 2.0f;
                this.aFj.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aFj.HK();
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
        onClickListener = this.aFj.aEM;
        if (onClickListener != null) {
            z = this.aFj.aEP;
            if (!z) {
                onClickListener2 = this.aFj.aEM;
                onClickListener2.onClick(this.aFj);
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
        this.aFj.aEP = true;
        i = this.aFj.aEK;
        if (i == 0) {
            z = this.aFj.aEQ;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aFj.getScrollX();
        if (this.aFj.aEB >= this.aFj.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aFj.aEK;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aFj.getWidth() + i2 > this.aFj.aEB) {
                    i2 = (int) (this.aFj.aEB - this.aFj.getWidth());
                }
                scrollY = this.aFj.getScrollY();
                if (this.aFj.aEC + this.aFj.mTop + this.aFj.mBottom >= this.aFj.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aFj.aEK;
                    if (i3 == 0) {
                        if (scrollY < (-this.aFj.aEU)) {
                            scrollY = -this.aFj.aEU;
                        }
                        if (this.aFj.getHeight() + scrollY > this.aFj.aEC + this.aFj.mBottom + this.aFj.aEV) {
                            scrollY = (int) ((this.aFj.aEC - this.aFj.getHeight()) + this.aFj.mBottom + this.aFj.aEV);
                        }
                    }
                }
                if (i2 == this.aFj.getScrollX() || scrollY != this.aFj.getScrollY()) {
                    this.aFj.scrollTo(i2, scrollY);
                    this.aFj.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aFj.getScrollY();
        if (this.aFj.aEC + this.aFj.mTop + this.aFj.mBottom >= this.aFj.getHeight()) {
        }
        if (i2 == this.aFj.getScrollX()) {
        }
        this.aFj.scrollTo(i2, scrollY);
        this.aFj.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aFj.aoa;
        if (onLongClickListener != null) {
            z = this.aFj.aEP;
            if (!z) {
                onLongClickListener2 = this.aFj.aoa;
                onLongClickListener2.onLongClick(this.aFj);
            }
        }
        super.onLongPress(motionEvent);
    }
}
