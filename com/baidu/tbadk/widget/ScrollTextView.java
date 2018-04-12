package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aPb;
    private float aPc;
    private boolean aPd;

    public ScrollTextView(Context context) {
        super(context);
        this.aPc = 15.0f;
        this.aPd = true;
        setup(context);
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aPc = 15.0f;
        this.aPd = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aPb = new Scroller(context, new LinearInterpolator());
        setScroller(this.aPb);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aPb.isFinished()) {
            Is();
        }
    }

    private void Is() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aPb.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aPc));
        if (this.aPd) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aPb.isFinished()) {
            Is();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aPc = f;
    }

    public float getSpeed() {
        return this.aPc;
    }

    public void setContinuousScrolling(boolean z) {
        this.aPd = z;
    }
}
