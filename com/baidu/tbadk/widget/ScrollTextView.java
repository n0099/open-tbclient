package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller dDt;
    private boolean dDu;
    private float speed;

    public ScrollTextView(Context context) {
        super(context);
        this.speed = 15.0f;
        this.dDu = true;
        setup(context);
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.speed = 15.0f;
        this.dDu = true;
        setup(context);
    }

    private void setup(Context context) {
        this.dDt = new Scroller(context, new LinearInterpolator());
        setScroller(this.dDt);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.dDt.isFinished()) {
            aPZ();
        }
    }

    private void aPZ() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.dDt.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.speed));
        if (this.dDu) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.dDt.isFinished()) {
            aPZ();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setContinuousScrolling(boolean z) {
        this.dDu = z;
    }
}
