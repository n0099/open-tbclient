package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aGv;
    private float aGw;
    private boolean aGx;

    public ScrollTextView(Context context) {
        super(context);
        this.aGw = 15.0f;
        this.aGx = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aGv = new Scroller(context, new LinearInterpolator());
        setScroller(this.aGv);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aGv.isFinished()) {
            HF();
        }
    }

    private void HF() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aGv.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aGw));
        if (this.aGx) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aGv.isFinished()) {
            HF();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aGw = f;
    }

    public float getSpeed() {
        return this.aGw;
    }

    public void setContinuousScrolling(boolean z) {
        this.aGx = z;
    }
}
