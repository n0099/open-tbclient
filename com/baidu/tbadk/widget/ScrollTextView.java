package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aNO;
    private float aNP;
    private boolean aNQ;

    public ScrollTextView(Context context) {
        super(context);
        this.aNP = 15.0f;
        this.aNQ = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aNO = new Scroller(context, new LinearInterpolator());
        setScroller(this.aNO);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aNO.isFinished()) {
            HE();
        }
    }

    private void HE() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aNO.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aNP));
        if (this.aNQ) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aNO.isFinished()) {
            HE();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aNP = f;
    }

    public float getSpeed() {
        return this.aNP;
    }

    public void setContinuousScrolling(boolean z) {
        this.aNQ = z;
    }
}
