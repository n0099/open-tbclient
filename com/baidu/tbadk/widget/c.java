package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a aGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aGf = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        a.C0049a c0049a;
        a.C0049a c0049a2;
        i = this.aGf.ada;
        if (i != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
            c0049a = this.aGf.aFI;
            c0049a.e(f, f2);
            a aVar = this.aGf;
            c0049a2 = this.aGf.aFI;
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
        i = this.aGf.ada;
        if (i != 1) {
            i2 = this.aGf.ada;
            if (i2 != 2) {
                this.aGf.mMode = 2;
                f = this.aGf.aFB;
                f2 = this.aGf.aFz;
                if (f > f2) {
                    a aVar = this.aGf;
                    f4 = this.aGf.aFz;
                    aVar.aFB = f4;
                    a aVar2 = this.aGf;
                    f5 = this.aGf.aFB;
                    aVar2.aFC = f5;
                    this.aGf.Hz();
                    return true;
                }
                a aVar3 = this.aGf;
                f3 = this.aGf.aFz;
                aVar3.aFB = f3 * 2.0f;
                this.aGf.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
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
        onClickListener = this.aGf.aFH;
        if (onClickListener != null) {
            z = this.aGf.aFK;
            if (!z) {
                onClickListener2 = this.aGf.aFH;
                onClickListener2.onClick(this.aGf);
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
        this.aGf.aFK = true;
        i = this.aGf.aFF;
        if (i == 0) {
            z = this.aGf.aFL;
            if (z) {
                return false;
            }
        }
        int scrollX = this.aGf.getScrollX();
        if (this.aGf.aFw >= this.aGf.getWidth()) {
            scrollX = (int) (scrollX + f);
            i4 = this.aGf.aFF;
            if (i4 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                if (this.aGf.getWidth() + i2 > this.aGf.aFw) {
                    i2 = (int) (this.aGf.aFw - this.aGf.getWidth());
                }
                scrollY = this.aGf.getScrollY();
                if (this.aGf.aFx + this.aGf.mTop + this.aGf.mBottom >= this.aGf.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i3 = this.aGf.aFF;
                    if (i3 == 0) {
                        if (scrollY < (-this.aGf.aFP)) {
                            scrollY = -this.aGf.aFP;
                        }
                        if (this.aGf.getHeight() + scrollY > this.aGf.aFx + this.aGf.mBottom + this.aGf.aFQ) {
                            scrollY = (int) ((this.aGf.aFx - this.aGf.getHeight()) + this.aGf.mBottom + this.aGf.aFQ);
                        }
                    }
                }
                if (i2 == this.aGf.getScrollX() || scrollY != this.aGf.getScrollY()) {
                    this.aGf.scrollTo(i2, scrollY);
                    this.aGf.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.aGf.getScrollY();
        if (this.aGf.aFx + this.aGf.mTop + this.aGf.mBottom >= this.aGf.getHeight()) {
        }
        if (i2 == this.aGf.getScrollX()) {
        }
        this.aGf.scrollTo(i2, scrollY);
        this.aGf.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.aGf.aoS;
        if (onLongClickListener != null) {
            z = this.aGf.aFK;
            if (!z) {
                onLongClickListener2 = this.aGf.aoS;
                onLongClickListener2.onLongClick(this.aGf);
            }
        }
        super.onLongPress(motionEvent);
    }
}
