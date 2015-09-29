package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aAr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aAr = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0054a c0054a;
        a.C0054a c0054a2;
        i = this.aAr.abN;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0054a = this.aAr.azV;
            c0054a.d(f, f2);
            a aVar = this.aAr;
            c0054a2 = this.aAr.azV;
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
        i = this.aAr.abN;
        if (i != 1) {
            i2 = this.aAr.abN;
            if (i2 != 2) {
                this.aAr.mMode = 2;
                f = this.aAr.azO;
                f2 = this.aAr.azM;
                if (f > f2) {
                    a aVar = this.aAr;
                    f4 = this.aAr.azM;
                    aVar.azO = f4;
                    a aVar2 = this.aAr;
                    f5 = this.aAr.azO;
                    aVar2.azP = f5;
                    this.aAr.EM();
                    this.aAr.EK();
                    return true;
                }
                a aVar3 = this.aAr;
                f3 = this.aAr.azM;
                aVar3.azO = f3 * 2.0f;
                this.aAr.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aAr.EK();
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
        onClickListener = this.aAr.azU;
        if (onClickListener != null) {
            z = this.aAr.azX;
            if (!z) {
                onClickListener2 = this.aAr.azU;
                onClickListener2.onClick(this.aAr);
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
        this.aAr.azX = true;
        i = this.aAr.azS;
        if (i == 0) {
            z = this.aAr.azY;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aAr.getScrollX();
        if (this.aAr.azJ >= this.aAr.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aAr.azS;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aAr.getWidth() + i2 > this.aAr.azJ) {
                    i2 = (int) (this.aAr.azJ - this.aAr.getWidth());
                }
                scrollY = this.aAr.getScrollY();
                if (this.aAr.azK + this.aAr.mTop + this.aAr.mBottom >= this.aAr.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aAr.azS;
                    if (i3 == 0) {
                        if (scrollY < (-this.aAr.aAc)) {
                            scrollY = -this.aAr.aAc;
                        }
                        if (this.aAr.getHeight() + scrollY > this.aAr.azK + this.aAr.mBottom + this.aAr.aAd) {
                            scrollY = (int) ((this.aAr.azK - this.aAr.getHeight()) + this.aAr.mBottom + this.aAr.aAd);
                        }
                    }
                }
                if (i2 == this.aAr.getScrollX() || scrollY != this.aAr.getScrollY()) {
                    this.aAr.scrollTo(i2, scrollY);
                    this.aAr.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aAr.getScrollY();
        if (this.aAr.azK + this.aAr.mTop + this.aAr.mBottom >= this.aAr.getHeight()) {
        }
        if (i2 == this.aAr.getScrollX()) {
        }
        this.aAr.scrollTo(i2, scrollY);
        this.aAr.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aAr.ajT;
        if (onLongClickListener != null) {
            z = this.aAr.azX;
            if (!z) {
                onLongClickListener2 = this.aAr.ajT;
                onLongClickListener2.onLongClick(this.aAr);
            }
        }
        super.onLongPress(motionEvent);
    }
}
