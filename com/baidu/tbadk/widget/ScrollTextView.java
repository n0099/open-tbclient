package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aOx;
    private float aOy;
    private boolean aOz;

    public ScrollTextView(Context context) {
        super(context);
        this.aOy = 15.0f;
        this.aOz = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aOx = new Scroller(context, new LinearInterpolator());
        setScroller(this.aOx);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aOx.isFinished()) {
            HW();
        }
    }

    private void HW() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aOx.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aOy));
        if (this.aOz) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aOx.isFinished()) {
            HW();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aOy = f;
    }

    public float getSpeed() {
        return this.aOy;
    }

    public void setContinuousScrolling(boolean z) {
        this.aOz = z;
    }
}
