package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends b {
    private ValueAnimator aOA;
    private int aOw;
    private int aOx;
    private float aOy;
    private float aOz;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.aOw = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.aOz = 0.0f;
        init();
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOw = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.aOz = 0.0f;
        init();
    }

    private void init() {
        this.aOA = new ValueAnimator();
        this.aOA.setDuration(200L);
        this.aOA.setInterpolator(new DecelerateInterpolator());
        this.aOA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        setOverScrollMode(2);
        this.mScreenWidth = e.ad(getContext());
        this.mRatio = (1.0f * this.aOw) / this.mScreenWidth;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.aOx = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.aOx && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int i2 = this.aOw;
        switch (action) {
            case 0:
                if (this.aOA.isRunning()) {
                    this.aOA.cancel();
                }
                this.aOy = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.aOz = 0.0f;
                    this.aOy = 0.0f;
                    this.aOA.setFloatValues(x, 0.0f);
                    this.aOA.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.aOy;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.aOy = motionEvent.getRawX();
                    return true;
                }
                if (this.aOz * rawX < 0.0f) {
                    this.aOz += rawX;
                } else {
                    this.aOz += rawX * this.mRatio;
                }
                this.aOy = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.aOx) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.aOz > i2) {
                        this.aOz = i * i2;
                        this.aOy = motionEvent.getRawX();
                    } else if (i * this.aOz < 0.0f) {
                        this.aOz = 0.0f;
                        this.aOy = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.aOz);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.aOw = i;
            this.mRatio = (1.0f * this.aOw) / this.mScreenWidth;
        }
    }
}
