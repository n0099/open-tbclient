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
    private float aRA;
    private float aRB;
    private ValueAnimator aRC;
    private int aRy;
    private int aRz;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.aRy = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.aRB = 0.0f;
        init();
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aRy = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.aRB = 0.0f;
        init();
    }

    private void init() {
        this.aRC = new ValueAnimator();
        this.aRC.setDuration(200L);
        this.aRC.setInterpolator(new DecelerateInterpolator());
        this.aRC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        setOverScrollMode(2);
        this.mScreenWidth = e.ac(getContext());
        this.mRatio = (1.0f * this.aRy) / this.mScreenWidth;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.aRz = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.aRz && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int i2 = this.aRy;
        switch (action) {
            case 0:
                if (this.aRC.isRunning()) {
                    this.aRC.cancel();
                }
                this.aRA = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.aRB = 0.0f;
                    this.aRA = 0.0f;
                    this.aRC.setFloatValues(x, 0.0f);
                    this.aRC.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.aRA;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.aRA = motionEvent.getRawX();
                    return true;
                }
                if (this.aRB * rawX < 0.0f) {
                    this.aRB += rawX;
                } else {
                    this.aRB += rawX * this.mRatio;
                }
                this.aRA = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.aRz) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.aRB > i2) {
                        this.aRB = i * i2;
                        this.aRA = motionEvent.getRawX();
                    } else if (i * this.aRB < 0.0f) {
                        this.aRB = 0.0f;
                        this.aRA = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.aRB);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.aRy = i;
            this.mRatio = (1.0f * this.aRy) / this.mScreenWidth;
        }
    }
}
