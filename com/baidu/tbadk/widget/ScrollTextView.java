package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aBJ;
    private float aBK;
    private boolean aBL;

    public ScrollTextView(Context context) {
        super(context);
        this.aBK = 15.0f;
        this.aBL = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aBJ = new Scroller(context, new LinearInterpolator());
        setScroller(this.aBJ);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aBJ.isFinished()) {
            Gd();
        }
    }

    private void Gd() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aBJ.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aBK));
        if (this.aBL) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aBJ.isFinished()) {
            Gd();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aBK = f;
    }

    public float getSpeed() {
        return this.aBK;
    }

    public void setContinuousScrolling(boolean z) {
        this.aBL = z;
    }
}
