package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aFp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aFp = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0049a c0049a;
        a.C0049a c0049a2;
        i = this.aFp.acC;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0049a = this.aFp.aES;
            c0049a.e(f, f2);
            a aVar = this.aFp;
            c0049a2 = this.aFp.aES;
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
        i = this.aFp.acC;
        if (i != 1) {
            i2 = this.aFp.acC;
            if (i2 != 2) {
                this.aFp.mMode = 2;
                f = this.aFp.aEL;
                f2 = this.aFp.aEJ;
                if (f > f2) {
                    a aVar = this.aFp;
                    f4 = this.aFp.aEJ;
                    aVar.aEL = f4;
                    a aVar2 = this.aFp;
                    f5 = this.aFp.aEL;
                    aVar2.aEM = f5;
                    this.aFp.Hw();
                    return true;
                }
                a aVar3 = this.aFp;
                f3 = this.aFp.aEJ;
                aVar3.aEL = f3 * 2.0f;
                this.aFp.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
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
        onClickListener = this.aFp.aER;
        if (onClickListener != null) {
            z = this.aFp.aEU;
            if (!z) {
                onClickListener2 = this.aFp.aER;
                onClickListener2.onClick(this.aFp);
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
        this.aFp.aEU = true;
        i = this.aFp.aEP;
        if (i == 0) {
            z = this.aFp.aEV;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aFp.getScrollX();
        if (this.aFp.aEG >= this.aFp.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aFp.aEP;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aFp.getWidth() + i2 > this.aFp.aEG) {
                    i2 = (int) (this.aFp.aEG - this.aFp.getWidth());
                }
                scrollY = this.aFp.getScrollY();
                if (this.aFp.aEH + this.aFp.mTop + this.aFp.mBottom >= this.aFp.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aFp.aEP;
                    if (i3 == 0) {
                        if (scrollY < (-this.aFp.aEZ)) {
                            scrollY = -this.aFp.aEZ;
                        }
                        if (this.aFp.getHeight() + scrollY > this.aFp.aEH + this.aFp.mBottom + this.aFp.aFa) {
                            scrollY = (int) ((this.aFp.aEH - this.aFp.getHeight()) + this.aFp.mBottom + this.aFp.aFa);
                        }
                    }
                }
                if (i2 == this.aFp.getScrollX() || scrollY != this.aFp.getScrollY()) {
                    this.aFp.scrollTo(i2, scrollY);
                    this.aFp.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aFp.getScrollY();
        if (this.aFp.aEH + this.aFp.mTop + this.aFp.mBottom >= this.aFp.getHeight()) {
        }
        if (i2 == this.aFp.getScrollX()) {
        }
        this.aFp.scrollTo(i2, scrollY);
        this.aFp.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aFp.anY;
        if (onLongClickListener != null) {
            z = this.aFp.aEU;
            if (!z) {
                onLongClickListener2 = this.aFp.anY;
                onLongClickListener2.onLongClick(this.aFp);
            }
        }
        super.onLongPress(motionEvent);
    }
}
