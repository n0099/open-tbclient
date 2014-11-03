package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aau;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aau = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        d dVar;
        d dVar2;
        if (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f) {
            dVar = this.aau.aad;
            dVar.a(f, f2);
            a aVar = this.aau;
            dVar2 = this.aau.aad;
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
        i = this.aau.FX;
        if (i != 1) {
            i2 = this.aau.FX;
            if (i2 != 2) {
                this.aau.mMode = 2;
                f = this.aau.ZV;
                f2 = this.aau.ZT;
                if (f > f2) {
                    a aVar = this.aau;
                    f4 = this.aau.ZT;
                    aVar.ZV = f4;
                    a aVar2 = this.aau;
                    f5 = this.aau.ZV;
                    aVar2.ZW = f5;
                    this.aau.vt();
                    this.aau.vg();
                    return true;
                }
                a aVar3 = this.aau;
                f3 = this.aau.ZT;
                aVar3.ZV = f3 * 2.0f;
                this.aau.d(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aau.vg();
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
        onClickListener = this.aau.aac;
        if (onClickListener != null) {
            z = this.aau.aaf;
            if (!z) {
                onClickListener2 = this.aau.aac;
                onClickListener2.onClick(this.aau);
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
        this.aau.aaf = true;
        i = this.aau.aaa;
        if (i == 0) {
            z = this.aau.aag;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aau.getScrollX();
        f3 = this.aau.ZQ;
        if (f3 >= this.aau.getWidth()) {
            scrollX = (int) (scrollX + f);
            i12 = this.aau.aaa;
            if (i12 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                f8 = this.aau.ZQ;
                if (this.aau.getWidth() + i2 > f8) {
                    f9 = this.aau.ZQ;
                    i2 = (int) (f9 - this.aau.getWidth());
                }
                scrollY = this.aau.getScrollY();
                f4 = this.aau.ZR;
                i3 = this.aau.aan;
                f5 = f4 + i3;
                i4 = this.aau.aao;
                if (f5 + i4 >= this.aau.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i5 = this.aau.aaa;
                    if (i5 == 0) {
                        i6 = this.aau.aap;
                        if (scrollY < (-i6)) {
                            i11 = this.aau.aap;
                            scrollY = -i11;
                        }
                        f6 = this.aau.ZR;
                        i7 = this.aau.aao;
                        float f10 = f6 + i7;
                        i8 = this.aau.aaq;
                        if (this.aau.getHeight() + scrollY > f10 + i8) {
                            f7 = this.aau.ZR;
                            float height = f7 - this.aau.getHeight();
                            i9 = this.aau.aao;
                            float f11 = height + i9;
                            i10 = this.aau.aaq;
                            scrollY = (int) (f11 + i10);
                        }
                    }
                }
                if (i2 == this.aau.getScrollX() || scrollY != this.aau.getScrollY()) {
                    this.aau.scrollTo(i2, scrollY);
                    this.aau.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aau.getScrollY();
        f4 = this.aau.ZR;
        i3 = this.aau.aan;
        f5 = f4 + i3;
        i4 = this.aau.aao;
        if (f5 + i4 >= this.aau.getHeight()) {
        }
        if (i2 == this.aau.getScrollX()) {
        }
        this.aau.scrollTo(i2, scrollY);
        this.aau.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aau.NY;
        if (onLongClickListener != null) {
            z = this.aau.aaf;
            if (!z) {
                onLongClickListener2 = this.aau.NY;
                onLongClickListener2.onLongClick(this.aau);
            }
        }
        super.onLongPress(motionEvent);
    }
}
