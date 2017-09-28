package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aNx;
    private float aNy;
    private boolean aNz;

    public ScrollTextView(Context context) {
        super(context);
        this.aNy = 15.0f;
        this.aNz = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aNx = new Scroller(context, new LinearInterpolator());
        setScroller(this.aNx);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aNx.isFinished()) {
            Hx();
        }
    }

    private void Hx() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aNx.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aNy));
        if (this.aNz) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aNx.isFinished()) {
            Hx();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aNy = f;
    }

    public float getSpeed() {
        return this.aNy;
    }

    public void setContinuousScrolling(boolean z) {
        this.aNz = z;
    }
}
