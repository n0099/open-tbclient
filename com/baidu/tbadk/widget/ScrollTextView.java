package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aWY;
    private boolean aWZ;
    private float pL;

    public ScrollTextView(Context context) {
        super(context);
        this.pL = 15.0f;
        this.aWZ = true;
        setup(context);
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pL = 15.0f;
        this.aWZ = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aWY = new Scroller(context, new LinearInterpolator());
        setScroller(this.aWY);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aWY.isFinished()) {
            LM();
        }
    }

    private void LM() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aWY.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.pL));
        if (this.aWZ) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aWY.isFinished()) {
            LM();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.pL = f;
    }

    public float getSpeed() {
        return this.pL;
    }

    public void setContinuousScrolling(boolean z) {
        this.aWZ = z;
    }
}
