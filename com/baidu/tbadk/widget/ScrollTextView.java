package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class ScrollTextView extends TextView implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Scroller f13767e;

    /* renamed from: f  reason: collision with root package name */
    public float f13768f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13769g;

    public ScrollTextView(Context context) {
        super(context);
        this.f13768f = 15.0f;
        this.f13769g = true;
        setup(context);
    }

    private void setup(Context context) {
        Scroller scroller = new Scroller(context, new LinearInterpolator());
        this.f13767e = scroller;
        setScroller(scroller);
    }

    public final void a() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineCount = height + ((getLineCount() - 1) * getLineHeight());
        this.f13767e.startScroll(0, height * (-1), 0, lineCount, (int) (lineCount * this.f13768f));
        if (this.f13769g) {
            post(this);
        }
    }

    public float getSpeed() {
        return this.f13768f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f13767e.isFinished()) {
            a();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f13767e.isFinished()) {
            a();
        } else {
            post(this);
        }
    }

    public void setContinuousScrolling(boolean z) {
        this.f13769g = z;
    }

    public void setSpeed(float f2) {
        this.f13768f = f2;
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13768f = 15.0f;
        this.f13769g = true;
        setup(context);
    }
}
