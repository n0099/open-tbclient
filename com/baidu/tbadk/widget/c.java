package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aik;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aik = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        d dVar;
        d dVar2;
        i = this.aik.Kh;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            dVar = this.aik.ahQ;
            dVar.b(f, f2);
            a aVar = this.aik;
            dVar2 = this.aik.ahQ;
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
        i = this.aik.Kh;
        if (i != 1) {
            i2 = this.aik.Kh;
            if (i2 != 2) {
                this.aik.mMode = 2;
                f = this.aik.mCurrentScale;
                f2 = this.aik.ahJ;
                if (f > f2) {
                    a aVar = this.aik;
                    f4 = this.aik.ahJ;
                    aVar.mCurrentScale = f4;
                    a aVar2 = this.aik;
                    f5 = this.aik.mCurrentScale;
                    aVar2.ahK = f5;
                    this.aik.zE();
                    this.aik.zC();
                    return true;
                }
                a aVar3 = this.aik;
                f3 = this.aik.ahJ;
                aVar3.mCurrentScale = f3 * 2.0f;
                this.aik.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aik.zC();
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
        onClickListener = this.aik.ahP;
        if (onClickListener != null) {
            z = this.aik.ahS;
            if (!z) {
                onClickListener2 = this.aik.ahP;
                onClickListener2.onClick(this.aik);
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
        this.aik.ahS = true;
        i = this.aik.ahN;
        if (i == 0) {
            z = this.aik.ahT;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aik.getScrollX();
        f3 = this.aik.ahG;
        if (f3 >= this.aik.getWidth()) {
            scrollX = (int) (scrollX + f);
            i12 = this.aik.ahN;
            if (i12 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                f8 = this.aik.ahG;
                if (this.aik.getWidth() + i2 > f8) {
                    f9 = this.aik.ahG;
                    i2 = (int) (f9 - this.aik.getWidth());
                }
                scrollY = this.aik.getScrollY();
                f4 = this.aik.ahH;
                i3 = this.aik.mTop;
                f5 = f4 + i3;
                i4 = this.aik.mBottom;
                if (f5 + i4 >= this.aik.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i5 = this.aik.ahN;
                    if (i5 == 0) {
                        i6 = this.aik.ahX;
                        if (scrollY < (-i6)) {
                            i11 = this.aik.ahX;
                            scrollY = -i11;
                        }
                        f6 = this.aik.ahH;
                        i7 = this.aik.mBottom;
                        float f10 = f6 + i7;
                        i8 = this.aik.ahY;
                        if (this.aik.getHeight() + scrollY > f10 + i8) {
                            f7 = this.aik.ahH;
                            float height = f7 - this.aik.getHeight();
                            i9 = this.aik.mBottom;
                            float f11 = height + i9;
                            i10 = this.aik.ahY;
                            scrollY = (int) (f11 + i10);
                        }
                    }
                }
                if (i2 == this.aik.getScrollX() || scrollY != this.aik.getScrollY()) {
                    this.aik.scrollTo(i2, scrollY);
                    this.aik.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aik.getScrollY();
        f4 = this.aik.ahH;
        i3 = this.aik.mTop;
        f5 = f4 + i3;
        i4 = this.aik.mBottom;
        if (f5 + i4 >= this.aik.getHeight()) {
        }
        if (i2 == this.aik.getScrollX()) {
        }
        this.aik.scrollTo(i2, scrollY);
        this.aik.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aik.TL;
        if (onLongClickListener != null) {
            z = this.aik.ahS;
            if (!z) {
                onLongClickListener2 = this.aik.TL;
                onLongClickListener2.onLongClick(this.aik);
            }
        }
        super.onLongPress(motionEvent);
    }
}
