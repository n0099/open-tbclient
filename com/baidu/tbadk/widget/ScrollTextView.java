package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller cvx;
    private boolean cvy;
    private float speed;

    public ScrollTextView(Context context) {
        super(context);
        this.speed = 15.0f;
        this.cvy = true;
        setup(context);
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.speed = 15.0f;
        this.cvy = true;
        setup(context);
    }

    private void setup(Context context) {
        this.cvx = new Scroller(context, new LinearInterpolator());
        setScroller(this.cvx);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.cvx.isFinished()) {
            aqX();
        }
    }

    private void aqX() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.cvx.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.speed));
        if (this.cvy) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cvx.isFinished()) {
            aqX();
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
        this.cvy = z;
    }
}
