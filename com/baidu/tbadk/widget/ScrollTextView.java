package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller bCq;
    private float bCr;
    private boolean bCs;

    public ScrollTextView(Context context) {
        super(context);
        this.bCr = 15.0f;
        this.bCs = true;
        setup(context);
    }

    private void setup(Context context) {
        this.bCq = new Scroller(context, new LinearInterpolator());
        setScroller(this.bCq);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bCq.isFinished()) {
            Pw();
        }
    }

    private void Pw() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.bCq.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.bCr));
        if (this.bCs) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bCq.isFinished()) {
            Pw();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.bCr = f;
    }

    public float getSpeed() {
        return this.bCr;
    }

    public void setContinuousScrolling(boolean z) {
        this.bCs = z;
    }
}
