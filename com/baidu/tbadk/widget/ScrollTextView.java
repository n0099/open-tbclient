package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class ScrollTextView extends TextView implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Scroller f14083e;

    /* renamed from: f  reason: collision with root package name */
    public float f14084f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14085g;

    public ScrollTextView(Context context) {
        super(context);
        this.f14084f = 15.0f;
        this.f14085g = true;
        setup(context);
    }

    private void setup(Context context) {
        Scroller scroller = new Scroller(context, new LinearInterpolator());
        this.f14083e = scroller;
        setScroller(scroller);
    }

    public final void a() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineCount = height + ((getLineCount() - 1) * getLineHeight());
        this.f14083e.startScroll(0, height * (-1), 0, lineCount, (int) (lineCount * this.f14084f));
        if (this.f14085g) {
            post(this);
        }
    }

    public float getSpeed() {
        return this.f14084f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f14083e.isFinished()) {
            a();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f14083e.isFinished()) {
            a();
        } else {
            post(this);
        }
    }

    public void setContinuousScrolling(boolean z) {
        this.f14085g = z;
    }

    public void setSpeed(float f2) {
        this.f14084f = f2;
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14084f = 15.0f;
        this.f14085g = true;
        setup(context);
    }
}
