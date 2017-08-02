package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aMM;
    private float aMN;
    private boolean aMO;

    public ScrollTextView(Context context) {
        super(context);
        this.aMN = 15.0f;
        this.aMO = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aMM = new Scroller(context, new LinearInterpolator());
        setScroller(this.aMM);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aMM.isFinished()) {
            HI();
        }
    }

    private void HI() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aMM.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aMN));
        if (this.aMO) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aMM.isFinished()) {
            HI();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aMN = f;
    }

    public float getSpeed() {
        return this.aMN;
    }

    public void setContinuousScrolling(boolean z) {
        this.aMO = z;
    }
}
