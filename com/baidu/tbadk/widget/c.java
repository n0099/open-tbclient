package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aCJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aCJ = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0049a c0049a;
        a.C0049a c0049a2;
        i = this.aCJ.ZC;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0049a = this.aCJ.aCn;
            c0049a.c(f, f2);
            a aVar = this.aCJ;
            c0049a2 = this.aCJ.aCn;
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
        i = this.aCJ.ZC;
        if (i != 1) {
            i2 = this.aCJ.ZC;
            if (i2 != 2) {
                this.aCJ.mMode = 2;
                f = this.aCJ.aCg;
                f2 = this.aCJ.aCe;
                if (f > f2) {
                    a aVar = this.aCJ;
                    f4 = this.aCJ.aCe;
                    aVar.aCg = f4;
                    a aVar2 = this.aCJ;
                    f5 = this.aCJ.aCg;
                    aVar2.aCh = f5;
                    this.aCJ.Gd();
                    this.aCJ.FV();
                    return true;
                }
                a aVar3 = this.aCJ;
                f3 = this.aCJ.aCe;
                aVar3.aCg = f3 * 2.0f;
                this.aCJ.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aCJ.FV();
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
        onClickListener = this.aCJ.aCm;
        if (onClickListener != null) {
            z = this.aCJ.aCp;
            if (!z) {
                onClickListener2 = this.aCJ.aCm;
                onClickListener2.onClick(this.aCJ);
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
        this.aCJ.aCp = true;
        i = this.aCJ.aCk;
        if (i == 0) {
            z = this.aCJ.aCq;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aCJ.getScrollX();
        if (this.aCJ.aCb >= this.aCJ.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aCJ.aCk;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aCJ.getWidth() + i2 > this.aCJ.aCb) {
                    i2 = (int) (this.aCJ.aCb - this.aCJ.getWidth());
                }
                scrollY = this.aCJ.getScrollY();
                if (this.aCJ.aCc + this.aCJ.mTop + this.aCJ.mBottom >= this.aCJ.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aCJ.aCk;
                    if (i3 == 0) {
                        if (scrollY < (-this.aCJ.aCu)) {
                            scrollY = -this.aCJ.aCu;
                        }
                        if (this.aCJ.getHeight() + scrollY > this.aCJ.aCc + this.aCJ.mBottom + this.aCJ.aCv) {
                            scrollY = (int) ((this.aCJ.aCc - this.aCJ.getHeight()) + this.aCJ.mBottom + this.aCJ.aCv);
                        }
                    }
                }
                if (i2 == this.aCJ.getScrollX() || scrollY != this.aCJ.getScrollY()) {
                    this.aCJ.scrollTo(i2, scrollY);
                    this.aCJ.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aCJ.getScrollY();
        if (this.aCJ.aCc + this.aCJ.mTop + this.aCJ.mBottom >= this.aCJ.getHeight()) {
        }
        if (i2 == this.aCJ.getScrollX()) {
        }
        this.aCJ.scrollTo(i2, scrollY);
        this.aCJ.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aCJ.alj;
        if (onLongClickListener != null) {
            z = this.aCJ.aCp;
            if (!z) {
                onLongClickListener2 = this.aCJ.alj;
                onLongClickListener2.onLongClick(this.aCJ);
            }
        }
        super.onLongPress(motionEvent);
    }
}
