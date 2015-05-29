package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a asX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.asX = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        d dVar;
        d dVar2;
        i = this.asX.WG;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            dVar = this.asX.asB;
            dVar.b(f, f2);
            a aVar = this.asX;
            dVar2 = this.asX.asB;
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
        i = this.asX.WG;
        if (i != 1) {
            i2 = this.asX.WG;
            if (i2 != 2) {
                this.asX.mMode = 2;
                f = this.asX.mCurrentScale;
                f2 = this.asX.asu;
                if (f > f2) {
                    a aVar = this.asX;
                    f4 = this.asX.asu;
                    aVar.mCurrentScale = f4;
                    a aVar2 = this.asX;
                    f5 = this.asX.mCurrentScale;
                    aVar2.asv = f5;
                    this.asX.Ed();
                    this.asX.Eb();
                    return true;
                }
                a aVar3 = this.asX;
                f3 = this.asX.asu;
                aVar3.mCurrentScale = f3 * 2.0f;
                this.asX.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.asX.Eb();
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
        onClickListener = this.asX.asA;
        if (onClickListener != null) {
            z = this.asX.asD;
            if (!z) {
                onClickListener2 = this.asX.asA;
                onClickListener2.onClick(this.asX);
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
        this.asX.asD = true;
        i = this.asX.asy;
        if (i == 0) {
            z = this.asX.asE;
            if (z) {
                return false;
            }
        }
        int scrollX = this.asX.getScrollX();
        f3 = this.asX.asr;
        if (f3 >= this.asX.getWidth()) {
            scrollX = (int) (scrollX + f);
            i12 = this.asX.asy;
            if (i12 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                f8 = this.asX.asr;
                if (this.asX.getWidth() + i2 > f8) {
                    f9 = this.asX.asr;
                    i2 = (int) (f9 - this.asX.getWidth());
                }
                scrollY = this.asX.getScrollY();
                f4 = this.asX.ass;
                i3 = this.asX.mTop;
                f5 = f4 + i3;
                i4 = this.asX.mBottom;
                if (f5 + i4 >= this.asX.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i5 = this.asX.asy;
                    if (i5 == 0) {
                        i6 = this.asX.asI;
                        if (scrollY < (-i6)) {
                            i11 = this.asX.asI;
                            scrollY = -i11;
                        }
                        f6 = this.asX.ass;
                        i7 = this.asX.mBottom;
                        float f10 = f6 + i7;
                        i8 = this.asX.asJ;
                        if (this.asX.getHeight() + scrollY > f10 + i8) {
                            f7 = this.asX.ass;
                            float height = f7 - this.asX.getHeight();
                            i9 = this.asX.mBottom;
                            float f11 = height + i9;
                            i10 = this.asX.asJ;
                            scrollY = (int) (f11 + i10);
                        }
                    }
                }
                if (i2 == this.asX.getScrollX() || scrollY != this.asX.getScrollY()) {
                    this.asX.scrollTo(i2, scrollY);
                    this.asX.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.asX.getScrollY();
        f4 = this.asX.ass;
        i3 = this.asX.mTop;
        f5 = f4 + i3;
        i4 = this.asX.mBottom;
        if (f5 + i4 >= this.asX.getHeight()) {
        }
        if (i2 == this.asX.getScrollX()) {
        }
        this.asX.scrollTo(i2, scrollY);
        this.asX.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.asX.afC;
        if (onLongClickListener != null) {
            z = this.asX.asD;
            if (!z) {
                onLongClickListener2 = this.asX.afC;
                onLongClickListener2.onLongClick(this.asX);
            }
        }
        super.onLongPress(motionEvent);
    }
}
