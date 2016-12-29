package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aFP;
    private float aFQ;
    private boolean aFR;

    public ScrollTextView(Context context) {
        super(context);
        this.aFQ = 15.0f;
        this.aFR = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aFP = new Scroller(context, new LinearInterpolator());
        setScroller(this.aFP);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aFP.isFinished()) {
            Hb();
        }
    }

    private void Hb() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aFP.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aFQ));
        if (this.aFR) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aFP.isFinished()) {
            Hb();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aFQ = f;
    }

    public float getSpeed() {
        return this.aFQ;
    }

    public void setContinuousScrolling(boolean z) {
        this.aFR = z;
    }
}
