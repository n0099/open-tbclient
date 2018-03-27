package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller bEB;
    private float bEC;
    private boolean bED;

    public ScrollTextView(Context context) {
        super(context);
        this.bEC = 15.0f;
        this.bED = true;
        setup(context);
    }

    private void setup(Context context) {
        this.bEB = new Scroller(context, new LinearInterpolator());
        setScroller(this.bEB);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bEB.isFinished()) {
            PR();
        }
    }

    private void PR() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.bEB.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.bEC));
        if (this.bED) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bEB.isFinished()) {
            PR();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.bEC = f;
    }

    public float getSpeed() {
        return this.bEC;
    }

    public void setContinuousScrolling(boolean z) {
        this.bED = z;
    }
}
