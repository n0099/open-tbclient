package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aKp;
    private float aKq;
    private boolean aKr;

    public ScrollTextView(Context context) {
        super(context);
        this.aKq = 15.0f;
        this.aKr = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aKp = new Scroller(context, new LinearInterpolator());
        setScroller(this.aKp);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aKp.isFinished()) {
            GW();
        }
    }

    private void GW() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aKp.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aKq));
        if (this.aKr) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aKp.isFinished()) {
            GW();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aKq = f;
    }

    public float getSpeed() {
        return this.aKq;
    }

    public void setContinuousScrolling(boolean z) {
        this.aKr = z;
    }
}
