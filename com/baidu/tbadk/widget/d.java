package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ b aLo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.aLo = bVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        b.a aVar;
        b.a aVar2;
        i = this.aLo.ahb;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            aVar = this.aLo.aKR;
            aVar.e(f, f2);
            b bVar = this.aLo;
            aVar2 = this.aLo.aKR;
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
        i = this.aLo.ahb;
        if (i != 1) {
            i2 = this.aLo.ahb;
            if (i2 != 2) {
                this.aLo.mMode = 2;
                f = this.aLo.mCurrentScale;
                f2 = this.aLo.aKJ;
                if (f > f2) {
                    b bVar = this.aLo;
                    f4 = this.aLo.aKJ;
                    bVar.mCurrentScale = f4;
                    b bVar2 = this.aLo;
                    f5 = this.aLo.mCurrentScale;
                    bVar2.aKL = f5;
                    this.aLo.Hn();
                    return true;
                }
                b bVar3 = this.aLo;
                f3 = this.aLo.aKJ;
                bVar3.mCurrentScale = f3 * 2.0f;
                this.aLo.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
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
        onClickListener = this.aLo.aKQ;
        if (onClickListener != null) {
            z = this.aLo.aKT;
            if (!z) {
                onClickListener2 = this.aLo.aKQ;
                onClickListener2.onClick(this.aLo);
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
        this.aLo.aKT = true;
        i = this.aLo.aKO;
        if (i == 0) {
            z = this.aLo.aKU;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aLo.getScrollX();
        if (this.aLo.aKG >= this.aLo.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aLo.aKO;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aLo.getWidth() + i2 > this.aLo.aKG) {
                    i2 = (int) (this.aLo.aKG - this.aLo.getWidth());
                }
                scrollY = this.aLo.getScrollY();
                if (this.aLo.aKH + this.aLo.mTop + this.aLo.mBottom >= this.aLo.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aLo.aKO;
                    if (i3 == 0) {
                        if (scrollY < (-this.aLo.aKY)) {
                            scrollY = -this.aLo.aKY;
                        }
                        if (this.aLo.getHeight() + scrollY > this.aLo.aKH + this.aLo.mBottom + this.aLo.aKZ) {
                            scrollY = (int) ((this.aLo.aKH - this.aLo.getHeight()) + this.aLo.mBottom + this.aLo.aKZ);
                        }
                    }
                }
                if (i2 == this.aLo.getScrollX() || scrollY != this.aLo.getScrollY()) {
                    this.aLo.scrollTo(i2, scrollY);
                    this.aLo.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aLo.getScrollY();
        if (this.aLo.aKH + this.aLo.mTop + this.aLo.mBottom >= this.aLo.getHeight()) {
        }
        if (i2 == this.aLo.getScrollX()) {
        }
        this.aLo.scrollTo(i2, scrollY);
        this.aLo.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aLo.aue;
        if (onLongClickListener != null) {
            z = this.aLo.aKT;
            if (!z) {
                onLongClickListener2 = this.aLo.aue;
                onLongClickListener2.onLongClick(this.aLo);
            }
        }
        super.onLongPress(motionEvent);
    }
}
