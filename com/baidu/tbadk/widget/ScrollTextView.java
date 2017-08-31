package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aNL;
    private float aNM;
    private boolean aNN;

    public ScrollTextView(Context context) {
        super(context);
        this.aNM = 15.0f;
        this.aNN = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aNL = new Scroller(context, new LinearInterpolator());
        setScroller(this.aNL);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aNL.isFinished()) {
            HP();
        }
    }

    private void HP() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aNL.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aNM));
        if (this.aNN) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aNL.isFinished()) {
            HP();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aNM = f;
    }

    public float getSpeed() {
        return this.aNM;
    }

    public void setContinuousScrolling(boolean z) {
        this.aNN = z;
    }
}
