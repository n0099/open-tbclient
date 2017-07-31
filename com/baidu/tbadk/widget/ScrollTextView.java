package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aOa;
    private float aOb;
    private boolean aOc;

    public ScrollTextView(Context context) {
        super(context);
        this.aOb = 15.0f;
        this.aOc = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aOa = new Scroller(context, new LinearInterpolator());
        setScroller(this.aOa);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aOa.isFinished()) {
            HQ();
        }
    }

    private void HQ() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aOa.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aOb));
        if (this.aOc) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aOa.isFinished()) {
            HQ();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aOb = f;
    }

    public float getSpeed() {
        return this.aOb;
    }

    public void setContinuousScrolling(boolean z) {
        this.aOc = z;
    }
}
