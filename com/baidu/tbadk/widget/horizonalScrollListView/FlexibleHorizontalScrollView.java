package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import d.a.c.e.p.e;
/* loaded from: classes3.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public int f13218e;

    /* renamed from: f  reason: collision with root package name */
    public int f13219f;

    /* renamed from: g  reason: collision with root package name */
    public float f13220g;

    /* renamed from: h  reason: collision with root package name */
    public float f13221h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f13222i;
    public float j;
    public int k;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.f13218e = 150;
        this.f13221h = 0.0f;
    }

    public final void c() {
        if (this.f13222i == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f13222i = valueAnimator;
            valueAnimator.setDuration(200L);
            this.f13222i.setInterpolator(new DecelerateInterpolator());
            this.f13222i.addUpdateListener(new a());
        }
        if (this.k == 0) {
            setOverScrollMode(2);
            int a2 = e.a(getContext());
            this.k = a2;
            this.j = (this.f13218e * 1.0f) / a2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
        if (r3 != 3) goto L17;
     */
    @Override // android.widget.HorizontalScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.f13219f && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.f13218e;
        c();
        if (action != 0) {
            int i3 = 0;
            if (action != 1) {
                if (action == 2) {
                    float rawX = motionEvent.getRawX() - this.f13220g;
                    if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                        this.f13220g = motionEvent.getRawX();
                        return true;
                    }
                    float f2 = this.f13221h;
                    if (f2 * rawX < 0.0f) {
                        this.f13221h = f2 + rawX;
                    } else {
                        this.f13221h = f2 + (rawX * this.j);
                    }
                    this.f13220g = motionEvent.getRawX();
                    if (scrollX == 0) {
                        i3 = 1;
                    } else if (scrollX == this.f13219f) {
                        i3 = -1;
                    }
                    if (i3 != 0) {
                        float f3 = i3;
                        float f4 = this.f13221h;
                        if (f3 * f4 > i2) {
                            this.f13221h = i3 * i2;
                            this.f13220g = motionEvent.getRawX();
                        } else if (f3 * f4 < 0.0f) {
                            this.f13221h = 0.0f;
                            this.f13220g = motionEvent.getRawX();
                            setX(0.0f);
                            return super.onTouchEvent(motionEvent);
                        }
                        setX(this.f13221h);
                        return true;
                    }
                }
            }
            if (x != 0.0f) {
                this.f13221h = 0.0f;
                this.f13220g = 0.0f;
                this.f13222i.setFloatValues(x, 0.0f);
                this.f13222i.start();
                return true;
            }
        } else {
            if (this.f13222i.isRunning()) {
                this.f13222i.cancel();
            }
            this.f13220g = motionEvent.getRawX();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        this.f13219f = i6;
        return super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z);
    }

    public void setMaxOverScrollDistance(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.f13218e = i2;
        this.j = (i2 * 1.0f) / this.k;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13218e = 150;
        this.f13221h = 0.0f;
    }
}
