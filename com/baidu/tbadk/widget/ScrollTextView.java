package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aGg;
    private float aGh;
    private boolean aGi;

    public ScrollTextView(Context context) {
        super(context);
        this.aGh = 15.0f;
        this.aGi = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aGg = new Scroller(context, new LinearInterpolator());
        setScroller(this.aGg);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aGg.isFinished()) {
            HD();
        }
    }

    private void HD() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aGg.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aGh));
        if (this.aGi) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aGg.isFinished()) {
            HD();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aGh = f;
    }

    public float getSpeed() {
        return this.aGh;
    }

    public void setContinuousScrolling(boolean z) {
        this.aGi = z;
    }
}
