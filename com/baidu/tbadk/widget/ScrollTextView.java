package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private float aFA;
    private boolean aFB;
    private Scroller aFz;

    public ScrollTextView(Context context) {
        super(context);
        this.aFA = 15.0f;
        this.aFB = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aFz = new Scroller(context, new LinearInterpolator());
        setScroller(this.aFz);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aFz.isFinished()) {
            HS();
        }
    }

    private void HS() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aFz.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aFA));
        if (this.aFB) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aFz.isFinished()) {
            HS();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aFA = f;
    }

    public float getSpeed() {
        return this.aFA;
    }

    public void setContinuousScrolling(boolean z) {
        this.aFB = z;
    }
}
