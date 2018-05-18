package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aPc;
    private float aPd;
    private boolean aPe;

    public ScrollTextView(Context context) {
        super(context);
        this.aPd = 15.0f;
        this.aPe = true;
        setup(context);
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aPd = 15.0f;
        this.aPe = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aPc = new Scroller(context, new LinearInterpolator());
        setScroller(this.aPc);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aPc.isFinished()) {
            Iq();
        }
    }

    private void Iq() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aPc.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aPd));
        if (this.aPe) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aPc.isFinished()) {
            Iq();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aPd = f;
    }

    public float getSpeed() {
        return this.aPd;
    }

    public void setContinuousScrolling(boolean z) {
        this.aPe = z;
    }
}
