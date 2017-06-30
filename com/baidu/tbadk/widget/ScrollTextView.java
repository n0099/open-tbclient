package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aLE;
    private float aLF;
    private boolean aLG;

    public ScrollTextView(Context context) {
        super(context);
        this.aLF = 15.0f;
        this.aLG = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aLE = new Scroller(context, new LinearInterpolator());
        setScroller(this.aLE);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aLE.isFinished()) {
            Ht();
        }
    }

    private void Ht() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aLE.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aLF));
        if (this.aLG) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aLE.isFinished()) {
            Ht();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aLF = f;
    }

    public float getSpeed() {
        return this.aLF;
    }

    public void setContinuousScrolling(boolean z) {
        this.aLG = z;
    }
}
