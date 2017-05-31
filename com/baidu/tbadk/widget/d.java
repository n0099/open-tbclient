package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ b aJZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.aJZ = bVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        b.a aVar;
        b.a aVar2;
        i = this.aJZ.agt;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            aVar = this.aJZ.aJC;
            aVar.e(f, f2);
            b bVar = this.aJZ;
            aVar2 = this.aJZ.aJC;
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
        i = this.aJZ.agt;
        if (i != 1) {
            i2 = this.aJZ.agt;
            if (i2 != 2) {
                this.aJZ.mMode = 2;
                f = this.aJZ.mCurrentScale;
                f2 = this.aJZ.aJu;
                if (f > f2) {
                    b bVar = this.aJZ;
                    f4 = this.aJZ.aJu;
                    bVar.mCurrentScale = f4;
                    b bVar2 = this.aJZ;
                    f5 = this.aJZ.mCurrentScale;
                    bVar2.aJw = f5;
                    this.aJZ.GQ();
                    return true;
                }
                b bVar3 = this.aJZ;
                f3 = this.aJZ.aJu;
                bVar3.mCurrentScale = f3 * 2.0f;
                this.aJZ.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
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
        onClickListener = this.aJZ.aJB;
        if (onClickListener != null) {
            z = this.aJZ.aJE;
            if (!z) {
                onClickListener2 = this.aJZ.aJB;
                onClickListener2.onClick(this.aJZ);
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
        this.aJZ.aJE = true;
        i = this.aJZ.aJz;
        if (i == 0) {
            z = this.aJZ.aJF;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aJZ.getScrollX();
        if (this.aJZ.aJr >= this.aJZ.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aJZ.aJz;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aJZ.getWidth() + i2 > this.aJZ.aJr) {
                    i2 = (int) (this.aJZ.aJr - this.aJZ.getWidth());
                }
                scrollY = this.aJZ.getScrollY();
                if (this.aJZ.aJs + this.aJZ.mTop + this.aJZ.mBottom >= this.aJZ.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aJZ.aJz;
                    if (i3 == 0) {
                        if (scrollY < (-this.aJZ.aJJ)) {
                            scrollY = -this.aJZ.aJJ;
                        }
                        if (this.aJZ.getHeight() + scrollY > this.aJZ.aJs + this.aJZ.mBottom + this.aJZ.aJK) {
                            scrollY = (int) ((this.aJZ.aJs - this.aJZ.getHeight()) + this.aJZ.mBottom + this.aJZ.aJK);
                        }
                    }
                }
                if (i2 == this.aJZ.getScrollX() || scrollY != this.aJZ.getScrollY()) {
                    this.aJZ.scrollTo(i2, scrollY);
                    this.aJZ.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aJZ.getScrollY();
        if (this.aJZ.aJs + this.aJZ.mTop + this.aJZ.mBottom >= this.aJZ.getHeight()) {
        }
        if (i2 == this.aJZ.getScrollX()) {
        }
        this.aJZ.scrollTo(i2, scrollY);
        this.aJZ.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aJZ.atb;
        if (onLongClickListener != null) {
            z = this.aJZ.aJE;
            if (!z) {
                onLongClickListener2 = this.aJZ.atb;
                onLongClickListener2.onLongClick(this.aJZ);
            }
        }
        super.onLongPress(motionEvent);
    }
}
