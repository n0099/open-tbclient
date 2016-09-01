package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aFQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aFQ = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0049a c0049a;
        a.C0049a c0049a2;
        i = this.aFQ.acr;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0049a = this.aFQ.aFu;
            c0049a.e(f, f2);
            a aVar = this.aFQ;
            c0049a2 = this.aFQ.aFu;
            aVar.startAnimation(c0049a2);
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
        i = this.aFQ.acr;
        if (i != 1) {
            i2 = this.aFQ.acr;
            if (i2 != 2) {
                this.aFQ.mMode = 2;
                f = this.aFQ.aFn;
                f2 = this.aFQ.aFl;
                if (f > f2) {
                    a aVar = this.aFQ;
                    f4 = this.aFQ.aFl;
                    aVar.aFn = f4;
                    a aVar2 = this.aFQ;
                    f5 = this.aFQ.aFn;
                    aVar2.aFo = f5;
                    this.aFQ.Hx();
                    this.aFQ.Hp();
                    return true;
                }
                a aVar3 = this.aFQ;
                f3 = this.aFQ.aFl;
                aVar3.aFn = f3 * 2.0f;
                this.aFQ.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aFQ.Hp();
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
        onClickListener = this.aFQ.aFt;
        if (onClickListener != null) {
            z = this.aFQ.aFw;
            if (!z) {
                onClickListener2 = this.aFQ.aFt;
                onClickListener2.onClick(this.aFQ);
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
        this.aFQ.aFw = true;
        i = this.aFQ.aFr;
        if (i == 0) {
            z = this.aFQ.aFx;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aFQ.getScrollX();
        if (this.aFQ.aFi >= this.aFQ.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aFQ.aFr;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aFQ.getWidth() + i2 > this.aFQ.aFi) {
                    i2 = (int) (this.aFQ.aFi - this.aFQ.getWidth());
                }
                scrollY = this.aFQ.getScrollY();
                if (this.aFQ.aFj + this.aFQ.mTop + this.aFQ.mBottom >= this.aFQ.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aFQ.aFr;
                    if (i3 == 0) {
                        if (scrollY < (-this.aFQ.aFB)) {
                            scrollY = -this.aFQ.aFB;
                        }
                        if (this.aFQ.getHeight() + scrollY > this.aFQ.aFj + this.aFQ.mBottom + this.aFQ.aFC) {
                            scrollY = (int) ((this.aFQ.aFj - this.aFQ.getHeight()) + this.aFQ.mBottom + this.aFQ.aFC);
                        }
                    }
                }
                if (i2 == this.aFQ.getScrollX() || scrollY != this.aFQ.getScrollY()) {
                    this.aFQ.scrollTo(i2, scrollY);
                    this.aFQ.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aFQ.getScrollY();
        if (this.aFQ.aFj + this.aFQ.mTop + this.aFQ.mBottom >= this.aFQ.getHeight()) {
        }
        if (i2 == this.aFQ.getScrollX()) {
        }
        this.aFQ.scrollTo(i2, scrollY);
        this.aFQ.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aFQ.aoq;
        if (onLongClickListener != null) {
            z = this.aFQ.aFw;
            if (!z) {
                onLongClickListener2 = this.aFQ.aoq;
                onLongClickListener2.onLongClick(this.aFQ);
            }
        }
        super.onLongPress(motionEvent);
    }
}
