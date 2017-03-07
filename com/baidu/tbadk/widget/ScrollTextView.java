package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aKb;
    private float aKc;
    private boolean aKd;

    public ScrollTextView(Context context) {
        super(context);
        this.aKc = 15.0f;
        this.aKd = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aKb = new Scroller(context, new LinearInterpolator());
        setScroller(this.aKb);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aKb.isFinished()) {
            Hs();
        }
    }

    private void Hs() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aKb.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aKc));
        if (this.aKd) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aKb.isFinished()) {
            Hs();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aKc = f;
    }

    public float getSpeed() {
        return this.aKc;
    }

    public void setContinuousScrolling(boolean z) {
        this.aKd = z;
    }
}
