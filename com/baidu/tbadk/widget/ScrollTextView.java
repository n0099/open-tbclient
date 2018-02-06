package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller bEL;
    private float bEM;
    private boolean bEN;

    public ScrollTextView(Context context) {
        super(context);
        this.bEM = 15.0f;
        this.bEN = true;
        setup(context);
    }

    private void setup(Context context) {
        this.bEL = new Scroller(context, new LinearInterpolator());
        setScroller(this.bEL);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bEL.isFinished()) {
            PR();
        }
    }

    private void PR() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.bEL.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.bEM));
        if (this.bEN) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bEL.isFinished()) {
            PR();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.bEM = f;
    }

    public float getSpeed() {
        return this.bEM;
    }

    public void setContinuousScrolling(boolean z) {
        this.bEN = z;
    }
}
