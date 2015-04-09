package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aru;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aru = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        d dVar;
        d dVar2;
        i = this.aru.VZ;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            dVar = this.aru.aqY;
            dVar.b(f, f2);
            a aVar = this.aru;
            dVar2 = this.aru.aqY;
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
        i = this.aru.VZ;
        if (i != 1) {
            i2 = this.aru.VZ;
            if (i2 != 2) {
                this.aru.mMode = 2;
                f = this.aru.mCurrentScale;
                f2 = this.aru.aqR;
                if (f > f2) {
                    a aVar = this.aru;
                    f4 = this.aru.aqR;
                    aVar.mCurrentScale = f4;
                    a aVar2 = this.aru;
                    f5 = this.aru.mCurrentScale;
                    aVar2.aqS = f5;
                    this.aru.Dt();
                    this.aru.Dr();
                    return true;
                }
                a aVar3 = this.aru;
                f3 = this.aru.aqR;
                aVar3.mCurrentScale = f3 * 2.0f;
                this.aru.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aru.Dr();
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
        onClickListener = this.aru.aqX;
        if (onClickListener != null) {
            z = this.aru.ara;
            if (!z) {
                onClickListener2 = this.aru.aqX;
                onClickListener2.onClick(this.aru);
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
        this.aru.ara = true;
        i = this.aru.aqV;
        if (i == 0) {
            z = this.aru.arb;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aru.getScrollX();
        f3 = this.aru.aqO;
        if (f3 >= this.aru.getWidth()) {
            scrollX = (int) (scrollX + f);
            i12 = this.aru.aqV;
            if (i12 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                f8 = this.aru.aqO;
                if (this.aru.getWidth() + i2 > f8) {
                    f9 = this.aru.aqO;
                    i2 = (int) (f9 - this.aru.getWidth());
                }
                scrollY = this.aru.getScrollY();
                f4 = this.aru.aqP;
                i3 = this.aru.mTop;
                f5 = f4 + i3;
                i4 = this.aru.mBottom;
                if (f5 + i4 >= this.aru.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i5 = this.aru.aqV;
                    if (i5 == 0) {
                        i6 = this.aru.arf;
                        if (scrollY < (-i6)) {
                            i11 = this.aru.arf;
                            scrollY = -i11;
                        }
                        f6 = this.aru.aqP;
                        i7 = this.aru.mBottom;
                        float f10 = f6 + i7;
                        i8 = this.aru.arg;
                        if (this.aru.getHeight() + scrollY > f10 + i8) {
                            f7 = this.aru.aqP;
                            float height = f7 - this.aru.getHeight();
                            i9 = this.aru.mBottom;
                            float f11 = height + i9;
                            i10 = this.aru.arg;
                            scrollY = (int) (f11 + i10);
                        }
                    }
                }
                if (i2 == this.aru.getScrollX() || scrollY != this.aru.getScrollY()) {
                    this.aru.scrollTo(i2, scrollY);
                    this.aru.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aru.getScrollY();
        f4 = this.aru.aqP;
        i3 = this.aru.mTop;
        f5 = f4 + i3;
        i4 = this.aru.mBottom;
        if (f5 + i4 >= this.aru.getHeight()) {
        }
        if (i2 == this.aru.getScrollX()) {
        }
        this.aru.scrollTo(i2, scrollY);
        this.aru.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aru.aey;
        if (onLongClickListener != null) {
            z = this.aru.ara;
            if (!z) {
                onLongClickListener2 = this.aru.aey;
                onLongClickListener2.onLongClick(this.aru);
            }
        }
        super.onLongPress(motionEvent);
    }
}
