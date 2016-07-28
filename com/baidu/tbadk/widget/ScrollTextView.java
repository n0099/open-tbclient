package com.baidu.tbadk.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ScrollTextView extends TextView implements Runnable {
    private Scroller aCZ;
    private float aDa;
    private boolean aDb;

    public ScrollTextView(Context context) {
        super(context);
        this.aDa = 15.0f;
        this.aDb = true;
        setup(context);
    }

    private void setup(Context context) {
        this.aCZ = new Scroller(context, new LinearInterpolator());
        setScroller(this.aCZ);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aCZ.isFinished()) {
            Gj();
        }
    }

    private void Gj() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineHeight = height + (getLineHeight() * (getLineCount() - 1));
        this.aCZ.startScroll(0, height * (-1), 0, lineHeight, (int) (lineHeight * this.aDa));
        if (this.aDb) {
            post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aCZ.isFinished()) {
            Gj();
        } else {
            post(this);
        }
    }

    public void setSpeed(float f) {
        this.aDa = f;
    }

    public float getSpeed() {
        return this.aDa;
    }

    public void setContinuousScrolling(boolean z) {
        this.aDb = z;
    }
}
