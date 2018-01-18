package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private float bCA;
    private boolean bCB;
    private Scroller bCz;

    public ScrollTextView(Context context) {
        super(context);
        this.bCA = 15.0f;
        this.bCB = true;
        setup(context);
    }

    private void setup(Context context) {
        this.bCz = new Scroller(context, new LinearInterpolator());
        setScroller(this.bCz);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bCz.isFinished()) {
            Pk();
        }
    }

    private void Pk() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.bCz.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.bCA));
        if (this.bCB) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bCz.isFinished()) {
            Pk();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.bCA = f;
    }

    public float getSpeed() {
        return this.bCA;
    }

    public void setContinuousScrolling(boolean z) {
        this.bCB = z;
    }
}
