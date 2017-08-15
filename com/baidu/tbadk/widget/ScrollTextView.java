package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aOb;
    private float aOc;
    private boolean aOd;

    public ScrollTextView(Context context) {
        super(context);
        this.aOc = 15.0f;
        this.aOd = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aOb = new Scroller(context, new LinearInterpolator());
        setScroller(this.aOb);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aOb.isFinished()) {
            HQ();
        }
    }

    private void HQ() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aOb.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aOc));
        if (this.aOd) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aOb.isFinished()) {
            HQ();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aOc = f;
    }

    public float getSpeed() {
        return this.aOc;
    }

    public void setContinuousScrolling(boolean z) {
        this.aOd = z;
    }
}
