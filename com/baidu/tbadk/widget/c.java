package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aAf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aAf = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0054a c0054a;
        a.C0054a c0054a2;
        i = this.aAf.abG;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0054a = this.aAf.azJ;
            c0054a.d(f, f2);
            a aVar = this.aAf;
            c0054a2 = this.aAf.azJ;
            aVar.startAnimation(c0054a2);
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
        i = this.aAf.abG;
        if (i != 1) {
            i2 = this.aAf.abG;
            if (i2 != 2) {
                this.aAf.mMode = 2;
                f = this.aAf.azC;
                f2 = this.aAf.azA;
                if (f > f2) {
                    a aVar = this.aAf;
                    f4 = this.aAf.azA;
                    aVar.azC = f4;
                    a aVar2 = this.aAf;
                    f5 = this.aAf.azC;
                    aVar2.azD = f5;
                    this.aAf.EN();
                    this.aAf.EL();
                    return true;
                }
                a aVar3 = this.aAf;
                f3 = this.aAf.azA;
                aVar3.azC = f3 * 2.0f;
                this.aAf.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aAf.EL();
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
        onClickListener = this.aAf.azI;
        if (onClickListener != null) {
            z = this.aAf.azL;
            if (!z) {
                onClickListener2 = this.aAf.azI;
                onClickListener2.onClick(this.aAf);
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
        this.aAf.azL = true;
        i = this.aAf.azG;
        if (i == 0) {
            z = this.aAf.azM;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aAf.getScrollX();
        if (this.aAf.azx >= this.aAf.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aAf.azG;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aAf.getWidth() + i2 > this.aAf.azx) {
                    i2 = (int) (this.aAf.azx - this.aAf.getWidth());
                }
                scrollY = this.aAf.getScrollY();
                if (this.aAf.azy + this.aAf.mTop + this.aAf.mBottom >= this.aAf.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aAf.azG;
                    if (i3 == 0) {
                        if (scrollY < (-this.aAf.azQ)) {
                            scrollY = -this.aAf.azQ;
                        }
                        if (this.aAf.getHeight() + scrollY > this.aAf.azy + this.aAf.mBottom + this.aAf.azR) {
                            scrollY = (int) ((this.aAf.azy - this.aAf.getHeight()) + this.aAf.mBottom + this.aAf.azR);
                        }
                    }
                }
                if (i2 == this.aAf.getScrollX() || scrollY != this.aAf.getScrollY()) {
                    this.aAf.scrollTo(i2, scrollY);
                    this.aAf.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aAf.getScrollY();
        if (this.aAf.azy + this.aAf.mTop + this.aAf.mBottom >= this.aAf.getHeight()) {
        }
        if (i2 == this.aAf.getScrollX()) {
        }
        this.aAf.scrollTo(i2, scrollY);
        this.aAf.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aAf.akJ;
        if (onLongClickListener != null) {
            z = this.aAf.azL;
            if (!z) {
                onLongClickListener2 = this.aAf.akJ;
                onLongClickListener2.onLongClick(this.aAf);
            }
        }
        super.onLongPress(motionEvent);
    }
}
