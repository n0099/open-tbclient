package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aKt;
    private float aKu;
    private boolean aKv;

    public ScrollTextView(Context context) {
        super(context);
        this.aKu = 15.0f;
        this.aKv = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aKt = new Scroller(context, new LinearInterpolator());
        setScroller(this.aKt);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aKt.isFinished()) {
            HR();
        }
    }

    private void HR() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aKt.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aKu));
        if (this.aKv) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aKt.isFinished()) {
            HR();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aKu = f;
    }

    public float getSpeed() {
        return this.aKu;
    }

    public void setContinuousScrolling(boolean z) {
        this.aKv = z;
    }
}
