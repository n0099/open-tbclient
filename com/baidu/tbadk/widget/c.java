package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        d dVar;
        d dVar2;
        if (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f) {
            dVar = this.a.u;
            dVar.a(f, f2);
            a aVar = this.a;
            dVar2 = this.a.u;
            aVar.startAnimation(dVar2);
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        boolean z;
        View.OnClickListener onClickListener2;
        onClickListener = this.a.r;
        if (onClickListener != null) {
            z = this.a.z;
            if (!z) {
                onClickListener2 = this.a.r;
                onClickListener2.onClick(this.a);
            }
        }
        return super.onSingleTapUp(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
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
        this.a.z = true;
        i = this.a.p;
        if (i == 0) {
            z = this.a.A;
            if (z) {
                return false;
            }
        }
        int scrollX = this.a.getScrollX();
        f3 = this.a.e;
        if (f3 >= this.a.getWidth()) {
            scrollX = (int) (scrollX + f);
            i12 = this.a.p;
            if (i12 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                f8 = this.a.e;
                if (this.a.getWidth() + i2 > f8) {
                    f9 = this.a.e;
                    i2 = (int) (f9 - this.a.getWidth());
                }
                scrollY = this.a.getScrollY();
                f4 = this.a.f;
                i3 = this.a.I;
                f5 = f4 + i3;
                i4 = this.a.J;
                if (f5 + i4 >= this.a.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i5 = this.a.p;
                    if (i5 == 0) {
                        i6 = this.a.K;
                        if (scrollY < (-i6)) {
                            i11 = this.a.K;
                            scrollY = -i11;
                        }
                        f6 = this.a.f;
                        i7 = this.a.J;
                        float f10 = f6 + i7;
                        i8 = this.a.L;
                        if (this.a.getHeight() + scrollY > f10 + i8) {
                            f7 = this.a.f;
                            float height = f7 - this.a.getHeight();
                            i9 = this.a.J;
                            float f11 = height + i9;
                            i10 = this.a.L;
                            scrollY = (int) (f11 + i10);
                        }
                    }
                }
                if (i2 == this.a.getScrollX() || scrollY != this.a.getScrollY()) {
                    this.a.scrollTo(i2, scrollY);
                    this.a.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.a.getScrollY();
        f4 = this.a.f;
        i3 = this.a.I;
        f5 = f4 + i3;
        i4 = this.a.J;
        if (f5 + i4 >= this.a.getHeight()) {
        }
        if (i2 == this.a.getScrollX()) {
        }
        this.a.scrollTo(i2, scrollY);
        this.a.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.a.s;
        if (onLongClickListener != null) {
            z = this.a.z;
            if (!z) {
                onLongClickListener2 = this.a.s;
                onLongClickListener2.onLongClick(this.a);
            }
        }
        super.onLongPress(motionEvent);
    }
}
