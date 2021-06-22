package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class ScrollTextView extends TextView implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Scroller f13170e;

    /* renamed from: f  reason: collision with root package name */
    public float f13171f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13172g;

    public ScrollTextView(Context context) {
        super(context);
        this.f13171f = 15.0f;
        this.f13172g = true;
        setup(context);
    }

    private void setup(Context context) {
        Scroller scroller = new Scroller(context, new LinearInterpolator());
        this.f13170e = scroller;
        setScroller(scroller);
    }

    public final void a() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        int lineCount = height + ((getLineCount() - 1) * getLineHeight());
        this.f13170e.startScroll(0, height * (-1), 0, lineCount, (int) (lineCount * this.f13171f));
        if (this.f13172g) {
            post(this);
        }
    }

    public float getSpeed() {
        return this.f13171f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f13170e.isFinished()) {
            a();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f13170e.isFinished()) {
            a();
        } else {
            post(this);
        }
    }

    public void setContinuousScrolling(boolean z) {
        this.f13172g = z;
    }

    public void setSpeed(float f2) {
        this.f13171f = f2;
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13171f = 15.0f;
        this.f13172g = true;
        setup(context);
    }
}
