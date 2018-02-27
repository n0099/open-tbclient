package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends b {
    private int bHv;
    private int bHw;
    private float bHx;
    private float bHy;
    private ValueAnimator bHz;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.bHv = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.bHy = 0.0f;
        init();
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHv = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.bHy = 0.0f;
        init();
    }

    private void init() {
        this.bHz = new ValueAnimator();
        this.bHz.setDuration(200L);
        this.bHz.setInterpolator(new DecelerateInterpolator());
        this.bHz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        setOverScrollMode(2);
        this.mScreenWidth = e.ao(getContext());
        this.mRatio = (1.0f * this.bHv) / this.mScreenWidth;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.bHw = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.bHw && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.bHv;
        switch (action) {
            case 0:
                if (this.bHz.isRunning()) {
                    this.bHz.cancel();
                }
                this.bHx = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.bHy = 0.0f;
                    this.bHx = 0.0f;
                    this.bHz.setFloatValues(x, 0.0f);
                    this.bHz.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.bHx;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.bHx = motionEvent.getRawX();
                    return true;
                }
                if (this.bHy * rawX < 0.0f) {
                    this.bHy += rawX;
                } else {
                    this.bHy += rawX * this.mRatio;
                }
                this.bHx = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.bHw) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.bHy > i2) {
                        this.bHy = i * i2;
                        this.bHx = motionEvent.getRawX();
                    } else if (i * this.bHy < 0.0f) {
                        this.bHy = 0.0f;
                        this.bHx = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.bHy);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.bHv = i;
            this.mRatio = (1.0f * this.bHv) / this.mScreenWidth;
        }
    }
}
