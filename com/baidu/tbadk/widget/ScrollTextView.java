package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aEE;
    private float aEF;
    private boolean aEG;

    public ScrollTextView(Context context) {
        super(context);
        this.aEF = 15.0f;
        this.aEG = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aEE = new Scroller(context, new LinearInterpolator());
        setScroller(this.aEE);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aEE.isFinished()) {
            GT();
        }
    }

    private void GT() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aEE.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aEF));
        if (this.aEG) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aEE.isFinished()) {
            GT();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aEF = f;
    }

    public float getSpeed() {
        return this.aEF;
    }

    public void setContinuousScrolling(boolean z) {
        this.aEG = z;
    }
}
