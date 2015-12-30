package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aDd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aDd = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0056a c0056a;
        a.C0056a c0056a2;
        i = this.aDd.ads;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0056a = this.aDd.aCH;
            c0056a.d(f, f2);
            a aVar = this.aDd;
            c0056a2 = this.aDd.aCH;
            aVar.startAnimation(c0056a2);
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
        i = this.aDd.ads;
        if (i != 1) {
            i2 = this.aDd.ads;
            if (i2 != 2) {
                this.aDd.mMode = 2;
                f = this.aDd.aCA;
                f2 = this.aDd.aCy;
                if (f > f2) {
                    a aVar = this.aDd;
                    f4 = this.aDd.aCy;
                    aVar.aCA = f4;
                    a aVar2 = this.aDd;
                    f5 = this.aDd.aCA;
                    aVar2.aCB = f5;
                    this.aDd.Fs();
                    this.aDd.Fq();
                    return true;
                }
                a aVar3 = this.aDd;
                f3 = this.aDd.aCy;
                aVar3.aCA = f3 * 2.0f;
                this.aDd.f(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aDd.Fq();
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
        onClickListener = this.aDd.aCG;
        if (onClickListener != null) {
            z = this.aDd.aCJ;
            if (!z) {
                onClickListener2 = this.aDd.aCG;
                onClickListener2.onClick(this.aDd);
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
        this.aDd.aCJ = true;
        i = this.aDd.aCE;
        if (i == 0) {
            z = this.aDd.aCK;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aDd.getScrollX();
        if (this.aDd.aCv >= this.aDd.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aDd.aCE;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aDd.getWidth() + i2 > this.aDd.aCv) {
                    i2 = (int) (this.aDd.aCv - this.aDd.getWidth());
                }
                scrollY = this.aDd.getScrollY();
                if (this.aDd.aCw + this.aDd.mTop + this.aDd.mBottom >= this.aDd.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aDd.aCE;
                    if (i3 == 0) {
                        if (scrollY < (-this.aDd.aCO)) {
                            scrollY = -this.aDd.aCO;
                        }
                        if (this.aDd.getHeight() + scrollY > this.aDd.aCw + this.aDd.mBottom + this.aDd.aCP) {
                            scrollY = (int) ((this.aDd.aCw - this.aDd.getHeight()) + this.aDd.mBottom + this.aDd.aCP);
                        }
                    }
                }
                if (i2 == this.aDd.getScrollX() || scrollY != this.aDd.getScrollY()) {
                    this.aDd.scrollTo(i2, scrollY);
                    this.aDd.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aDd.getScrollY();
        if (this.aDd.aCw + this.aDd.mTop + this.aDd.mBottom >= this.aDd.getHeight()) {
        }
        if (i2 == this.aDd.getScrollX()) {
        }
        this.aDd.scrollTo(i2, scrollY);
        this.aDd.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aDd.amQ;
        if (onLongClickListener != null) {
            z = this.aDd.aCJ;
            if (!z) {
                onLongClickListener2 = this.aDd.amQ;
                onLongClickListener2.onLongClick(this.aDd);
            }
        }
        super.onLongPress(motionEvent);
    }
}
