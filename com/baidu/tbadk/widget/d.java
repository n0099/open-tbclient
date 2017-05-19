package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ b aKm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.aKm = bVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        b.a aVar;
        b.a aVar2;
        i = this.aKm.agC;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            aVar = this.aKm.aJP;
            aVar.e(f, f2);
            b bVar = this.aKm;
            aVar2 = this.aKm.aJP;
            bVar.startAnimation(aVar2);
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
        i = this.aKm.agC;
        if (i != 1) {
            i2 = this.aKm.agC;
            if (i2 != 2) {
                this.aKm.mMode = 2;
                f = this.aKm.mCurrentScale;
                f2 = this.aKm.aJH;
                if (f > f2) {
                    b bVar = this.aKm;
                    f4 = this.aKm.aJH;
                    bVar.mCurrentScale = f4;
                    b bVar2 = this.aKm;
                    f5 = this.aKm.mCurrentScale;
                    bVar2.aJJ = f5;
                    this.aKm.GW();
                    return true;
                }
                b bVar3 = this.aKm;
                f3 = this.aKm.aJH;
                bVar3.mCurrentScale = f3 * 2.0f;
                this.aKm.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
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
        onClickListener = this.aKm.aJO;
        if (onClickListener != null) {
            z = this.aKm.aJR;
            if (!z) {
                onClickListener2 = this.aKm.aJO;
                onClickListener2.onClick(this.aKm);
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
        this.aKm.aJR = true;
        i = this.aKm.aJM;
        if (i == 0) {
            z = this.aKm.aJS;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aKm.getScrollX();
        if (this.aKm.aJE >= this.aKm.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aKm.aJM;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aKm.getWidth() + i2 > this.aKm.aJE) {
                    i2 = (int) (this.aKm.aJE - this.aKm.getWidth());
                }
                scrollY = this.aKm.getScrollY();
                if (this.aKm.aJF + this.aKm.mTop + this.aKm.mBottom >= this.aKm.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aKm.aJM;
                    if (i3 == 0) {
                        if (scrollY < (-this.aKm.aJW)) {
                            scrollY = -this.aKm.aJW;
                        }
                        if (this.aKm.getHeight() + scrollY > this.aKm.aJF + this.aKm.mBottom + this.aKm.aJX) {
                            scrollY = (int) ((this.aKm.aJF - this.aKm.getHeight()) + this.aKm.mBottom + this.aKm.aJX);
                        }
                    }
                }
                if (i2 == this.aKm.getScrollX() || scrollY != this.aKm.getScrollY()) {
                    this.aKm.scrollTo(i2, scrollY);
                    this.aKm.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aKm.getScrollY();
        if (this.aKm.aJF + this.aKm.mTop + this.aKm.mBottom >= this.aKm.getHeight()) {
        }
        if (i2 == this.aKm.getScrollX()) {
        }
        this.aKm.scrollTo(i2, scrollY);
        this.aKm.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aKm.atr;
        if (onLongClickListener != null) {
            z = this.aKm.aJR;
            if (!z) {
                onLongClickListener2 = this.aKm.atr;
                onLongClickListener2.onLongClick(this.aKm);
            }
        }
        super.onLongPress(motionEvent);
    }
}
