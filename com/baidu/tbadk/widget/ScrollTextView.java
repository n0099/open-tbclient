package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aOD;
    private float aOE;
    private boolean aOF;

    public ScrollTextView(Context context) {
        super(context);
        this.aOE = 15.0f;
        this.aOF = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aOD = new Scroller(context, new LinearInterpolator());
        setScroller(this.aOD);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aOD.isFinished()) {
            HX();
        }
    }

    private void HX() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aOD.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aOE));
        if (this.aOF) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aOD.isFinished()) {
            HX();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aOE = f;
    }

    public float getSpeed() {
        return this.aOE;
    }

    public void setContinuousScrolling(boolean z) {
        this.aOF = z;
    }
}
