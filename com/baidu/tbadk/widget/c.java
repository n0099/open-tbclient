package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aiN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aiN = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        d dVar;
        d dVar2;
        i = this.aiN.KA;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            dVar = this.aiN.ais;
            dVar.b(f, f2);
            a aVar = this.aiN;
            dVar2 = this.aiN.ais;
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
        i = this.aiN.KA;
        if (i != 1) {
            i2 = this.aiN.KA;
            if (i2 != 2) {
                this.aiN.mMode = 2;
                f = this.aiN.mCurrentScale;
                f2 = this.aiN.ail;
                if (f > f2) {
                    a aVar = this.aiN;
                    f4 = this.aiN.ail;
                    aVar.mCurrentScale = f4;
                    a aVar2 = this.aiN;
                    f5 = this.aiN.mCurrentScale;
                    aVar2.aim = f5;
                    this.aiN.zY();
                    this.aiN.zW();
                    return true;
                }
                a aVar3 = this.aiN;
                f3 = this.aiN.ail;
                aVar3.mCurrentScale = f3 * 2.0f;
                this.aiN.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aiN.zW();
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
        onClickListener = this.aiN.air;
        if (onClickListener != null) {
            z = this.aiN.aiu;
            if (!z) {
                onClickListener2 = this.aiN.air;
                onClickListener2.onClick(this.aiN);
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
        this.aiN.aiu = true;
        i = this.aiN.aip;
        if (i == 0) {
            z = this.aiN.aiv;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aiN.getScrollX();
        f3 = this.aiN.aii;
        if (f3 >= this.aiN.getWidth()) {
            scrollX = (int) (scrollX + f);
            i12 = this.aiN.aip;
            if (i12 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                f8 = this.aiN.aii;
                if (this.aiN.getWidth() + i2 > f8) {
                    f9 = this.aiN.aii;
                    i2 = (int) (f9 - this.aiN.getWidth());
                }
                scrollY = this.aiN.getScrollY();
                f4 = this.aiN.aij;
                i3 = this.aiN.mTop;
                f5 = f4 + i3;
                i4 = this.aiN.mBottom;
                if (f5 + i4 >= this.aiN.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i5 = this.aiN.aip;
                    if (i5 == 0) {
                        i6 = this.aiN.aiz;
                        if (scrollY < (-i6)) {
                            i11 = this.aiN.aiz;
                            scrollY = -i11;
                        }
                        f6 = this.aiN.aij;
                        i7 = this.aiN.mBottom;
                        float f10 = f6 + i7;
                        i8 = this.aiN.aiA;
                        if (this.aiN.getHeight() + scrollY > f10 + i8) {
                            f7 = this.aiN.aij;
                            float height = f7 - this.aiN.getHeight();
                            i9 = this.aiN.mBottom;
                            float f11 = height + i9;
                            i10 = this.aiN.aiA;
                            scrollY = (int) (f11 + i10);
                        }
                    }
                }
                if (i2 == this.aiN.getScrollX() || scrollY != this.aiN.getScrollY()) {
                    this.aiN.scrollTo(i2, scrollY);
                    this.aiN.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aiN.getScrollY();
        f4 = this.aiN.aij;
        i3 = this.aiN.mTop;
        f5 = f4 + i3;
        i4 = this.aiN.mBottom;
        if (f5 + i4 >= this.aiN.getHeight()) {
        }
        if (i2 == this.aiN.getScrollX()) {
        }
        this.aiN.scrollTo(i2, scrollY);
        this.aiN.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aiN.Uq;
        if (onLongClickListener != null) {
            z = this.aiN.aiu;
            if (!z) {
                onLongClickListener2 = this.aiN.Uq;
                onLongClickListener2.onLongClick(this.aiN);
            }
        }
        super.onLongPress(motionEvent);
    }
}
