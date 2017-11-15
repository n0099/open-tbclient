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
    private float aOA;
    private float aOB;
    private ValueAnimator aOC;
    private int aOy;
    private int aOz;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.aOy = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.aOB = 0.0f;
        init();
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOy = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.aOB = 0.0f;
        init();
    }

    private void init() {
        this.aOC = new ValueAnimator();
        this.aOC.setDuration(200L);
        this.aOC.setInterpolator(new DecelerateInterpolator());
        this.aOC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        setOverScrollMode(2);
        this.mScreenWidth = e.ac(getContext());
        this.mRatio = (1.0f * this.aOy) / this.mScreenWidth;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.aOz = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.aOz && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int i2 = this.aOy;
        switch (action) {
            case 0:
                if (this.aOC.isRunning()) {
                    this.aOC.cancel();
                }
                this.aOA = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.aOB = 0.0f;
                    this.aOA = 0.0f;
                    this.aOC.setFloatValues(x, 0.0f);
                    this.aOC.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.aOA;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.aOA = motionEvent.getRawX();
                    return true;
                }
                if (this.aOB * rawX < 0.0f) {
                    this.aOB += rawX;
                } else {
                    this.aOB += rawX * this.mRatio;
                }
                this.aOA = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.aOz) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.aOB > i2) {
                        this.aOB = i * i2;
                        this.aOA = motionEvent.getRawX();
                    } else if (i * this.aOB < 0.0f) {
                        this.aOB = 0.0f;
                        this.aOA = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.aOB);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.aOy = i;
            this.mRatio = (1.0f * this.aOy) / this.mScreenWidth;
        }
    }
}
