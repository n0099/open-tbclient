package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aNk;
    private float aNl;
    private boolean aNm;

    public ScrollTextView(Context context) {
        super(context);
        this.aNl = 15.0f;
        this.aNm = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aNk = new Scroller(context, new LinearInterpolator());
        setScroller(this.aNk);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aNk.isFinished()) {
            Hr();
        }
    }

    private void Hr() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aNk.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aNl));
        if (this.aNm) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aNk.isFinished()) {
            Hr();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aNl = f;
    }

    public float getSpeed() {
        return this.aNl;
    }

    public void setContinuousScrolling(boolean z) {
        this.aNm = z;
    }
}
