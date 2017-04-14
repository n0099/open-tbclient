package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aKr;
    private float aKs;
    private boolean aKt;

    public ScrollTextView(Context context) {
        super(context);
        this.aKs = 15.0f;
        this.aKt = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aKr = new Scroller(context, new LinearInterpolator());
        setScroller(this.aKr);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aKr.isFinished()) {
            HR();
        }
    }

    private void HR() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aKr.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aKs));
        if (this.aKt) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aKr.isFinished()) {
            HR();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aKs = f;
    }

    public float getSpeed() {
        return this.aKs;
    }

    public void setContinuousScrolling(boolean z) {
        this.aKt = z;
    }
}
