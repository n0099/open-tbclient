package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aiK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aiK = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        d dVar;
        d dVar2;
        i = this.aiK.Kx;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            dVar = this.aiK.aip;
            dVar.b(f, f2);
            a aVar = this.aiK;
            dVar2 = this.aiK.aip;
            aVar.startAnimation(dVar2);
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
        i = this.aiK.Kx;
        if (i != 1) {
            i2 = this.aiK.Kx;
            if (i2 != 2) {
                this.aiK.mMode = 2;
                f = this.aiK.mCurrentScale;
                f2 = this.aiK.aii;
                if (f > f2) {
                    a aVar = this.aiK;
                    f4 = this.aiK.aii;
                    aVar.mCurrentScale = f4;
                    a aVar2 = this.aiK;
                    f5 = this.aiK.mCurrentScale;
                    aVar2.aij = f5;
                    this.aiK.zS();
                    this.aiK.zQ();
                    return true;
                }
                a aVar3 = this.aiK;
                f3 = this.aiK.aii;
                aVar3.mCurrentScale = f3 * 2.0f;
                this.aiK.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aiK.zQ();
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
        onClickListener = this.aiK.aio;
        if (onClickListener != null) {
            z = this.aiK.air;
            if (!z) {
                onClickListener2 = this.aiK.aio;
                onClickListener2.onClick(this.aiK);
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
        float f3;
        int i2;
        int scrollY;
        float f4;
        int i3;
        float f5;
        int i4;
        int i5;
        int i6;
        float f6;
        int i7;
        int i8;
        float f7;
        int i9;
        int i10;
        int i11;
        int i12;
        float f8;
        float f9;
        boolean z;
        this.aiK.air = true;
        i = this.aiK.aim;
        if (i == 0) {
            z = this.aiK.ais;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aiK.getScrollX();
        f3 = this.aiK.aif;
        if (f3 >= this.aiK.getWidth()) {
            scrollX = (int) (scrollX + f);
            i12 = this.aiK.aim;
            if (i12 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                f8 = this.aiK.aif;
                if (this.aiK.getWidth() + i2 > f8) {
                    f9 = this.aiK.aif;
                    i2 = (int) (f9 - this.aiK.getWidth());
                }
                scrollY = this.aiK.getScrollY();
                f4 = this.aiK.aig;
                i3 = this.aiK.mTop;
                f5 = f4 + i3;
                i4 = this.aiK.mBottom;
                if (f5 + i4 >= this.aiK.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i5 = this.aiK.aim;
                    if (i5 == 0) {
                        i6 = this.aiK.aiw;
                        if (scrollY < (-i6)) {
                            i11 = this.aiK.aiw;
                            scrollY = -i11;
                        }
                        f6 = this.aiK.aig;
                        i7 = this.aiK.mBottom;
                        float f10 = f6 + i7;
                        i8 = this.aiK.aix;
                        if (this.aiK.getHeight() + scrollY > f10 + i8) {
                            f7 = this.aiK.aig;
                            float height = f7 - this.aiK.getHeight();
                            i9 = this.aiK.mBottom;
                            float f11 = height + i9;
                            i10 = this.aiK.aix;
                            scrollY = (int) (f11 + i10);
                        }
                    }
                }
                if (i2 == this.aiK.getScrollX() || scrollY != this.aiK.getScrollY()) {
                    this.aiK.scrollTo(i2, scrollY);
                    this.aiK.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aiK.getScrollY();
        f4 = this.aiK.aig;
        i3 = this.aiK.mTop;
        f5 = f4 + i3;
        i4 = this.aiK.mBottom;
        if (f5 + i4 >= this.aiK.getHeight()) {
        }
        if (i2 == this.aiK.getScrollX()) {
        }
        this.aiK.scrollTo(i2, scrollY);
        this.aiK.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aiK.Un;
        if (onLongClickListener != null) {
            z = this.aiK.air;
            if (!z) {
                onLongClickListener2 = this.aiK.Un;
                onLongClickListener2.onLongClick(this.aiK);
            }
        }
        super.onLongPress(motionEvent);
    }
}
