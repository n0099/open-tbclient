package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aOc;
    private float aOd;
    private boolean aOe;

    public ScrollTextView(Context context) {
        super(context);
        this.aOd = 15.0f;
        this.aOe = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aOc = new Scroller(context, new LinearInterpolator());
        setScroller(this.aOc);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aOc.isFinished()) {
            HQ();
        }
    }

    private void HQ() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aOc.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aOd));
        if (this.aOe) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aOc.isFinished()) {
            HQ();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aOd = f;
    }

    public float getSpeed() {
        return this.aOd;
    }

    public void setContinuousScrolling(boolean z) {
        this.aOe = z;
    }
}
