package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aaq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aaq = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        d dVar;
        d dVar2;
        if (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f) {
            dVar = this.aaq.ZZ;
            dVar.a(f, f2);
            a aVar = this.aaq;
            dVar2 = this.aaq.ZZ;
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
        i = this.aaq.FW;
        if (i != 1) {
            i2 = this.aaq.FW;
            if (i2 != 2) {
                this.aaq.mMode = 2;
                f = this.aaq.ZR;
                f2 = this.aaq.ZP;
                if (f > f2) {
                    a aVar = this.aaq;
                    f4 = this.aaq.ZP;
                    aVar.ZR = f4;
                    a aVar2 = this.aaq;
                    f5 = this.aaq.ZR;
                    aVar2.ZS = f5;
                    this.aaq.vr();
                    this.aaq.ve();
                    return true;
                }
                a aVar3 = this.aaq;
                f3 = this.aaq.ZP;
                aVar3.ZR = f3 * 2.0f;
                this.aaq.d(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aaq.ve();
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
        onClickListener = this.aaq.ZY;
        if (onClickListener != null) {
            z = this.aaq.aab;
            if (!z) {
                onClickListener2 = this.aaq.ZY;
                onClickListener2.onClick(this.aaq);
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
        this.aaq.aab = true;
        i = this.aaq.ZW;
        if (i == 0) {
            z = this.aaq.aac;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aaq.getScrollX();
        f3 = this.aaq.ZM;
        if (f3 >= this.aaq.getWidth()) {
            scrollX = (int) (scrollX + f);
            i12 = this.aaq.ZW;
            if (i12 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                f8 = this.aaq.ZM;
                if (this.aaq.getWidth() + i2 > f8) {
                    f9 = this.aaq.ZM;
                    i2 = (int) (f9 - this.aaq.getWidth());
                }
                scrollY = this.aaq.getScrollY();
                f4 = this.aaq.ZN;
                i3 = this.aaq.aaj;
                f5 = f4 + i3;
                i4 = this.aaq.aak;
                if (f5 + i4 >= this.aaq.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i5 = this.aaq.ZW;
                    if (i5 == 0) {
                        i6 = this.aaq.aal;
                        if (scrollY < (-i6)) {
                            i11 = this.aaq.aal;
                            scrollY = -i11;
                        }
                        f6 = this.aaq.ZN;
                        i7 = this.aaq.aak;
                        float f10 = f6 + i7;
                        i8 = this.aaq.aam;
                        if (this.aaq.getHeight() + scrollY > f10 + i8) {
                            f7 = this.aaq.ZN;
                            float height = f7 - this.aaq.getHeight();
                            i9 = this.aaq.aak;
                            float f11 = height + i9;
                            i10 = this.aaq.aam;
                            scrollY = (int) (f11 + i10);
                        }
                    }
                }
                if (i2 == this.aaq.getScrollX() || scrollY != this.aaq.getScrollY()) {
                    this.aaq.scrollTo(i2, scrollY);
                    this.aaq.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aaq.getScrollY();
        f4 = this.aaq.ZN;
        i3 = this.aaq.aaj;
        f5 = f4 + i3;
        i4 = this.aaq.aak;
        if (f5 + i4 >= this.aaq.getHeight()) {
        }
        if (i2 == this.aaq.getScrollX()) {
        }
        this.aaq.scrollTo(i2, scrollY);
        this.aaq.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aaq.NU;
        if (onLongClickListener != null) {
            z = this.aaq.aab;
            if (!z) {
                onLongClickListener2 = this.aaq.NU;
                onLongClickListener2.onLongClick(this.aaq);
            }
        }
        super.onLongPress(motionEvent);
    }
}
