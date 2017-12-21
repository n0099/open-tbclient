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
    private int aRB;
    private int aRC;
    private float aRD;
    private float aRE;
    private ValueAnimator aRF;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.aRB = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.aRE = 0.0f;
        init();
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aRB = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.aRE = 0.0f;
        init();
    }

    private void init() {
        this.aRF = new ValueAnimator();
        this.aRF.setDuration(200L);
        this.aRF.setInterpolator(new DecelerateInterpolator());
        this.aRF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        setOverScrollMode(2);
        this.mScreenWidth = e.ac(getContext());
        this.mRatio = (1.0f * this.aRB) / this.mScreenWidth;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.aRC = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.aRC && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int i2 = this.aRB;
        switch (action) {
            case 0:
                if (this.aRF.isRunning()) {
                    this.aRF.cancel();
                }
                this.aRD = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.aRE = 0.0f;
                    this.aRD = 0.0f;
                    this.aRF.setFloatValues(x, 0.0f);
                    this.aRF.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.aRD;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.aRD = motionEvent.getRawX();
                    return true;
                }
                if (this.aRE * rawX < 0.0f) {
                    this.aRE += rawX;
                } else {
                    this.aRE += rawX * this.mRatio;
                }
                this.aRD = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.aRC) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.aRE > i2) {
                        this.aRE = i * i2;
                        this.aRD = motionEvent.getRawX();
                    } else if (i * this.aRE < 0.0f) {
                        this.aRE = 0.0f;
                        this.aRD = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.aRE);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.aRB = i;
            this.mRatio = (1.0f * this.aRB) / this.mScreenWidth;
        }
    }
}
