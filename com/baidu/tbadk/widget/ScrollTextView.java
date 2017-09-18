package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aNI;
    private float aNJ;
    private boolean aNK;

    public ScrollTextView(Context context) {
        super(context);
        this.aNJ = 15.0f;
        this.aNK = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aNI = new Scroller(context, new LinearInterpolator());
        setScroller(this.aNI);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aNI.isFinished()) {
            HP();
        }
    }

    private void HP() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aNI.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aNJ));
        if (this.aNK) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aNI.isFinished()) {
            HP();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aNJ = f;
    }

    public float getSpeed() {
        return this.aNJ;
    }

    public void setContinuousScrolling(boolean z) {
        this.aNK = z;
    }
}
