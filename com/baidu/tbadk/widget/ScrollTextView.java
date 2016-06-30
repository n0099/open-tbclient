package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aCj;
    private float aCk;
    private boolean aCl;

    public ScrollTextView(Context context) {
        super(context);
        this.aCk = 15.0f;
        this.aCl = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aCj = new Scroller(context, new LinearInterpolator());
        setScroller(this.aCj);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aCj.isFinished()) {
            Gg();
        }
    }

    private void Gg() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aCj.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aCk));
        if (this.aCl) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aCj.isFinished()) {
            Gg();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aCk = f;
    }

    public float getSpeed() {
        return this.aCk;
    }

    public void setContinuousScrolling(boolean z) {
        this.aCl = z;
    }
}
