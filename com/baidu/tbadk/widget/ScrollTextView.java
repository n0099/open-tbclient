package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aFF;
    private float aFG;
    private boolean aFH;

    public ScrollTextView(Context context) {
        super(context);
        this.aFG = 15.0f;
        this.aFH = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aFF = new Scroller(context, new LinearInterpolator());
        setScroller(this.aFF);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aFF.isFinished()) {
            HC();
        }
    }

    private void HC() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aFF.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aFG));
        if (this.aFH) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aFF.isFinished()) {
            HC();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aFG = f;
    }

    public float getSpeed() {
        return this.aFG;
    }

    public void setContinuousScrolling(boolean z) {
        this.aFH = z;
    }
}
