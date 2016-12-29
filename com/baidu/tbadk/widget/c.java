package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aFz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aFz = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0049a c0049a;
        a.C0049a c0049a2;
        i = this.aFz.act;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0049a = this.aFz.aFc;
            c0049a.e(f, f2);
            a aVar = this.aFz;
            c0049a2 = this.aFz.aFc;
            aVar.startAnimation(c0049a2);
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
        i = this.aFz.act;
        if (i != 1) {
            i2 = this.aFz.act;
            if (i2 != 2) {
                this.aFz.mMode = 2;
                f = this.aFz.aEV;
                f2 = this.aFz.aET;
                if (f > f2) {
                    a aVar = this.aFz;
                    f4 = this.aFz.aET;
                    aVar.aEV = f4;
                    a aVar2 = this.aFz;
                    f5 = this.aFz.aEV;
                    aVar2.aEW = f5;
                    this.aFz.GV();
                    return true;
                }
                a aVar3 = this.aFz;
                f3 = this.aFz.aET;
                aVar3.aEV = f3 * 2.0f;
                this.aFz.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
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
        onClickListener = this.aFz.aFb;
        if (onClickListener != null) {
            z = this.aFz.aFe;
            if (!z) {
                onClickListener2 = this.aFz.aFb;
                onClickListener2.onClick(this.aFz);
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
        this.aFz.aFe = true;
        i = this.aFz.aEZ;
        if (i == 0) {
            z = this.aFz.aFf;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aFz.getScrollX();
        if (this.aFz.aEQ >= this.aFz.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aFz.aEZ;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aFz.getWidth() + i2 > this.aFz.aEQ) {
                    i2 = (int) (this.aFz.aEQ - this.aFz.getWidth());
                }
                scrollY = this.aFz.getScrollY();
                if (this.aFz.aER + this.aFz.mTop + this.aFz.mBottom >= this.aFz.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aFz.aEZ;
                    if (i3 == 0) {
                        if (scrollY < (-this.aFz.aFj)) {
                            scrollY = -this.aFz.aFj;
                        }
                        if (this.aFz.getHeight() + scrollY > this.aFz.aER + this.aFz.mBottom + this.aFz.aFk) {
                            scrollY = (int) ((this.aFz.aER - this.aFz.getHeight()) + this.aFz.mBottom + this.aFz.aFk);
                        }
                    }
                }
                if (i2 == this.aFz.getScrollX() || scrollY != this.aFz.getScrollY()) {
                    this.aFz.scrollTo(i2, scrollY);
                    this.aFz.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aFz.getScrollY();
        if (this.aFz.aER + this.aFz.mTop + this.aFz.mBottom >= this.aFz.getHeight()) {
        }
        if (i2 == this.aFz.getScrollX()) {
        }
        this.aFz.scrollTo(i2, scrollY);
        this.aFz.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aFz.aou;
        if (onLongClickListener != null) {
            z = this.aFz.aFe;
            if (!z) {
                onLongClickListener2 = this.aFz.aou;
                onLongClickListener2.onLongClick(this.aFz);
            }
        }
        super.onLongPress(motionEvent);
    }
}
