package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private boolean bEA;
    private Scroller bEy;
    private float bEz;

    public ScrollTextView(Context context) {
        super(context);
        this.bEz = 15.0f;
        this.bEA = true;
        setup(context);
    }

    private void setup(Context context) {
        this.bEy = new Scroller(context, new LinearInterpolator());
        setScroller(this.bEy);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bEy.isFinished()) {
            PQ();
        }
    }

    private void PQ() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.bEy.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.bEz));
        if (this.bEA) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bEy.isFinished()) {
            PQ();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.bEz = f;
    }

    public float getSpeed() {
        return this.bEz;
    }

    public void setContinuousScrolling(boolean z) {
        this.bEA = z;
    }
}
