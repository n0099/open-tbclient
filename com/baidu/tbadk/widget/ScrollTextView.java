package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aNW;
    private float aNX;
    private boolean aNY;

    public ScrollTextView(Context context) {
        super(context);
        this.aNX = 15.0f;
        this.aNY = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aNW = new Scroller(context, new LinearInterpolator());
        setScroller(this.aNW);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aNW.isFinished()) {
            HP();
        }
    }

    private void HP() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aNW.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aNX));
        if (this.aNY) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aNW.isFinished()) {
            HP();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aNX = f;
    }

    public float getSpeed() {
        return this.aNX;
    }

    public void setContinuousScrolling(boolean z) {
        this.aNY = z;
    }
}
