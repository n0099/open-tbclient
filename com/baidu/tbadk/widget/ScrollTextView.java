package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aOA;
    private float aOB;
    private boolean aOC;

    public ScrollTextView(Context context) {
        super(context);
        this.aOB = 15.0f;
        this.aOC = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aOA = new Scroller(context, new LinearInterpolator());
        setScroller(this.aOA);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aOA.isFinished()) {
            HX();
        }
    }

    private void HX() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aOA.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aOB));
        if (this.aOC) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aOA.isFinished()) {
            HX();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aOB = f;
    }

    public float getSpeed() {
        return this.aOB;
    }

    public void setContinuousScrolling(boolean z) {
        this.aOC = z;
    }
}
