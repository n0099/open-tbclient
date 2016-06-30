package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aBT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aBT = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0048a c0048a;
        a.C0048a c0048a2;
        i = this.aBT.YT;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0048a = this.aBT.aBx;
            c0048a.a(f, f2);
            a aVar = this.aBT;
            c0048a2 = this.aBT.aBx;
            aVar.startAnimation(c0048a2);
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
        i = this.aBT.YT;
        if (i != 1) {
            i2 = this.aBT.YT;
            if (i2 != 2) {
                this.aBT.mMode = 2;
                f = this.aBT.aBq;
                f2 = this.aBT.aBo;
                if (f > f2) {
                    a aVar = this.aBT;
                    f4 = this.aBT.aBo;
                    aVar.aBq = f4;
                    a aVar2 = this.aBT;
                    f5 = this.aBT.aBq;
                    aVar2.aBr = f5;
                    this.aBT.Ga();
                    this.aBT.FS();
                    return true;
                }
                a aVar3 = this.aBT;
                f3 = this.aBT.aBo;
                aVar3.aBq = f3 * 2.0f;
                this.aBT.d(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.aBT.FS();
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
        onClickListener = this.aBT.aBw;
        if (onClickListener != null) {
            z = this.aBT.aBz;
            if (!z) {
                onClickListener2 = this.aBT.aBw;
                onClickListener2.onClick(this.aBT);
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
        this.aBT.aBz = true;
        i = this.aBT.aBu;
        if (i == 0) {
            z = this.aBT.aBA;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aBT.getScrollX();
        if (this.aBT.aBl >= this.aBT.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aBT.aBu;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aBT.getWidth() + i2 > this.aBT.aBl) {
                    i2 = (int) (this.aBT.aBl - this.aBT.getWidth());
                }
                scrollY = this.aBT.getScrollY();
                if (this.aBT.aBm + this.aBT.mTop + this.aBT.mBottom >= this.aBT.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aBT.aBu;
                    if (i3 == 0) {
                        if (scrollY < (-this.aBT.aBE)) {
                            scrollY = -this.aBT.aBE;
                        }
                        if (this.aBT.getHeight() + scrollY > this.aBT.aBm + this.aBT.mBottom + this.aBT.aBF) {
                            scrollY = (int) ((this.aBT.aBm - this.aBT.getHeight()) + this.aBT.mBottom + this.aBT.aBF);
                        }
                    }
                }
                if (i2 == this.aBT.getScrollX() || scrollY != this.aBT.getScrollY()) {
                    this.aBT.scrollTo(i2, scrollY);
                    this.aBT.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aBT.getScrollY();
        if (this.aBT.aBm + this.aBT.mTop + this.aBT.mBottom >= this.aBT.getHeight()) {
        }
        if (i2 == this.aBT.getScrollX()) {
        }
        this.aBT.scrollTo(i2, scrollY);
        this.aBT.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aBT.aku;
        if (onLongClickListener != null) {
            z = this.aBT.aBz;
            if (!z) {
                onLongClickListener2 = this.aBT.aku;
                onLongClickListener2.onLongClick(this.aBT);
            }
        }
        super.onLongPress(motionEvent);
    }
}
