package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller bCH;
    private float bCI;
    private boolean bCJ;

    public ScrollTextView(Context context) {
        super(context);
        this.bCI = 15.0f;
        this.bCJ = true;
        setup(context);
    }

    private void setup(Context context) {
        this.bCH = new Scroller(context, new LinearInterpolator());
        setScroller(this.bCH);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bCH.isFinished()) {
            Pm();
        }
    }

    private void Pm() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.bCH.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.bCI));
        if (this.bCJ) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bCH.isFinished()) {
            Pm();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.bCI = f;
    }

    public float getSpeed() {
        return this.bCI;
    }

    public void setContinuousScrolling(boolean z) {
        this.bCJ = z;
    }
}
