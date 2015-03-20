package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a arm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.arm = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        d dVar;
        d dVar2;
        i = this.arm.VX;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            dVar = this.arm.aqQ;
            dVar.b(f, f2);
            a aVar = this.arm;
            dVar2 = this.arm.aqQ;
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
        i = this.arm.VX;
        if (i != 1) {
            i2 = this.arm.VX;
            if (i2 != 2) {
                this.arm.mMode = 2;
                f = this.arm.mCurrentScale;
                f2 = this.arm.aqJ;
                if (f > f2) {
                    a aVar = this.arm;
                    f4 = this.arm.aqJ;
                    aVar.mCurrentScale = f4;
                    a aVar2 = this.arm;
                    f5 = this.arm.mCurrentScale;
                    aVar2.aqK = f5;
                    this.arm.Dn();
                    this.arm.Dl();
                    return true;
                }
                a aVar3 = this.arm;
                f3 = this.arm.aqJ;
                aVar3.mCurrentScale = f3 * 2.0f;
                this.arm.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.arm.Dl();
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
        onClickListener = this.arm.aqP;
        if (onClickListener != null) {
            z = this.arm.aqS;
            if (!z) {
                onClickListener2 = this.arm.aqP;
                onClickListener2.onClick(this.arm);
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
        this.arm.aqS = true;
        i = this.arm.aqN;
        if (i == 0) {
            z = this.arm.aqT;
            if (z) {
                return false;
            }
        }
        int scrollX = this.arm.getScrollX();
        f3 = this.arm.aqG;
        if (f3 >= this.arm.getWidth()) {
            scrollX = (int) (scrollX + f);
            i12 = this.arm.aqN;
            if (i12 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                f8 = this.arm.aqG;
                if (this.arm.getWidth() + i2 > f8) {
                    f9 = this.arm.aqG;
                    i2 = (int) (f9 - this.arm.getWidth());
                }
                scrollY = this.arm.getScrollY();
                f4 = this.arm.aqH;
                i3 = this.arm.mTop;
                f5 = f4 + i3;
                i4 = this.arm.mBottom;
                if (f5 + i4 >= this.arm.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i5 = this.arm.aqN;
                    if (i5 == 0) {
                        i6 = this.arm.aqX;
                        if (scrollY < (-i6)) {
                            i11 = this.arm.aqX;
                            scrollY = -i11;
                        }
                        f6 = this.arm.aqH;
                        i7 = this.arm.mBottom;
                        float f10 = f6 + i7;
                        i8 = this.arm.aqY;
                        if (this.arm.getHeight() + scrollY > f10 + i8) {
                            f7 = this.arm.aqH;
                            float height = f7 - this.arm.getHeight();
                            i9 = this.arm.mBottom;
                            float f11 = height + i9;
                            i10 = this.arm.aqY;
                            scrollY = (int) (f11 + i10);
                        }
                    }
                }
                if (i2 == this.arm.getScrollX() || scrollY != this.arm.getScrollY()) {
                    this.arm.scrollTo(i2, scrollY);
                    this.arm.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.arm.getScrollY();
        f4 = this.arm.aqH;
        i3 = this.arm.mTop;
        f5 = f4 + i3;
        i4 = this.arm.mBottom;
        if (f5 + i4 >= this.arm.getHeight()) {
        }
        if (i2 == this.arm.getScrollX()) {
        }
        this.arm.scrollTo(i2, scrollY);
        this.arm.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.arm.aeq;
        if (onLongClickListener != null) {
            z = this.arm.aqS;
            if (!z) {
                onLongClickListener2 = this.arm.aeq;
                onLongClickListener2.onLongClick(this.arm);
            }
        }
        super.onLongPress(motionEvent);
    }
}
