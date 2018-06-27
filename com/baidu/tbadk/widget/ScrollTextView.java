package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aXT;
    private boolean aXU;
    private float speed;

    public ScrollTextView(Context context) {
        super(context);
        this.speed = 15.0f;
        this.aXU = true;
        setup(context);
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.speed = 15.0f;
        this.aXU = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aXT = new Scroller(context, new LinearInterpolator());
        setScroller(this.aXT);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aXT.isFinished()) {
            Me();
        }
    }

    private void Me() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aXT.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.speed));
        if (this.aXU) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aXT.isFinished()) {
            Me();
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
        this.aXU = z;
    }
}
