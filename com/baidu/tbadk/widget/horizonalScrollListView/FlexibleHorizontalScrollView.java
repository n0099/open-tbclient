package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import d.b.b.e.p.e;
/* loaded from: classes3.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public int f14127e;

    /* renamed from: f  reason: collision with root package name */
    public int f14128f;

    /* renamed from: g  reason: collision with root package name */
    public float f14129g;

    /* renamed from: h  reason: collision with root package name */
    public float f14130h;
    public ValueAnimator i;
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
        this.f14127e = 150;
        this.f14130h = 0.0f;
    }

    public final void c() {
        if (this.i == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.i = valueAnimator;
            valueAnimator.setDuration(200L);
            this.i.setInterpolator(new DecelerateInterpolator());
            this.i.addUpdateListener(new a());
        }
        if (this.k == 0) {
            setOverScrollMode(2);
            int a2 = e.a(getContext());
            this.k = a2;
            this.j = (this.f14127e * 1.0f) / a2;
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
        if (scrollX > 0 && scrollX < this.f14128f && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i = this.f14127e;
        c();
        if (action != 0) {
            int i2 = 0;
            if (action != 1) {
                if (action == 2) {
                    float rawX = motionEvent.getRawX() - this.f14129g;
                    if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                        this.f14129g = motionEvent.getRawX();
                        return true;
                    }
                    float f2 = this.f14130h;
                    if (f2 * rawX < 0.0f) {
                        this.f14130h = f2 + rawX;
                    } else {
                        this.f14130h = f2 + (rawX * this.j);
                    }
                    this.f14129g = motionEvent.getRawX();
                    if (scrollX == 0) {
                        i2 = 1;
                    } else if (scrollX == this.f14128f) {
                        i2 = -1;
                    }
                    if (i2 != 0) {
                        float f3 = i2;
                        float f4 = this.f14130h;
                        if (f3 * f4 > i) {
                            this.f14130h = i2 * i;
                            this.f14129g = motionEvent.getRawX();
                        } else if (f3 * f4 < 0.0f) {
                            this.f14130h = 0.0f;
                            this.f14129g = motionEvent.getRawX();
                            setX(0.0f);
                            return super.onTouchEvent(motionEvent);
                        }
                        setX(this.f14130h);
                        return true;
                    }
                }
            }
            if (x != 0.0f) {
                this.f14130h = 0.0f;
                this.f14129g = 0.0f;
                this.i.setFloatValues(x, 0.0f);
                this.i.start();
                return true;
            }
        } else {
            if (this.i.isRunning()) {
                this.i.cancel();
            }
            this.f14129g = motionEvent.getRawX();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.f14128f = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public void setMaxOverScrollDistance(int i) {
        if (i <= 0) {
            return;
        }
        this.f14127e = i;
        this.j = (i * 1.0f) / this.k;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14127e = 150;
        this.f14130h = 0.0f;
    }
}
