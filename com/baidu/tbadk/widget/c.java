package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aKb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aKb = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0046a c0046a;
        a.C0046a c0046a2;
        i = this.aKb.ahj;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0046a = this.aKb.aJE;
            c0046a.e(f, f2);
            a aVar = this.aKb;
            c0046a2 = this.aKb.aJE;
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
        i = this.aKb.ahj;
        if (i != 1) {
            i2 = this.aKb.ahj;
            if (i2 != 2) {
                this.aKb.mMode = 2;
                f = this.aKb.mCurrentScale;
                f2 = this.aKb.aJw;
                if (f > f2) {
                    a aVar = this.aKb;
                    f4 = this.aKb.aJw;
                    aVar.mCurrentScale = f4;
                    a aVar2 = this.aKb;
                    f5 = this.aKb.mCurrentScale;
                    aVar2.aJy = f5;
                    this.aKb.HL();
                    return true;
                }
                a aVar3 = this.aKb;
                f3 = this.aKb.aJw;
                aVar3.mCurrentScale = f3 * 2.0f;
                this.aKb.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
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
        onClickListener = this.aKb.aJD;
        if (onClickListener != null) {
            z = this.aKb.aJG;
            if (!z) {
                onClickListener2 = this.aKb.aJD;
                onClickListener2.onClick(this.aKb);
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
        this.aKb.aJG = true;
        i = this.aKb.aJB;
        if (i == 0) {
            z = this.aKb.aJH;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aKb.getScrollX();
        if (this.aKb.aJt >= this.aKb.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aKb.aJB;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aKb.getWidth() + i2 > this.aKb.aJt) {
                    i2 = (int) (this.aKb.aJt - this.aKb.getWidth());
                }
                scrollY = this.aKb.getScrollY();
                if (this.aKb.aJu + this.aKb.mTop + this.aKb.mBottom >= this.aKb.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aKb.aJB;
                    if (i3 == 0) {
                        if (scrollY < (-this.aKb.aJL)) {
                            scrollY = -this.aKb.aJL;
                        }
                        if (this.aKb.getHeight() + scrollY > this.aKb.aJu + this.aKb.mBottom + this.aKb.aJM) {
                            scrollY = (int) ((this.aKb.aJu - this.aKb.getHeight()) + this.aKb.mBottom + this.aKb.aJM);
                        }
                    }
                }
                if (i2 == this.aKb.getScrollX() || scrollY != this.aKb.getScrollY()) {
                    this.aKb.scrollTo(i2, scrollY);
                    this.aKb.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aKb.getScrollY();
        if (this.aKb.aJu + this.aKb.mTop + this.aKb.mBottom >= this.aKb.getHeight()) {
        }
        if (i2 == this.aKb.getScrollX()) {
        }
        this.aKb.scrollTo(i2, scrollY);
        this.aKb.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aKb.atl;
        if (onLongClickListener != null) {
            z = this.aKb.aJG;
            if (!z) {
                onLongClickListener2 = this.aKb.atl;
                onLongClickListener2.onLongClick(this.aKb);
            }
        }
        super.onLongPress(motionEvent);
    }
}
