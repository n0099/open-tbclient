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
    private float bHA;
    private float bHB;
    private ValueAnimator bHC;
    private int bHy;
    private int bHz;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.bHy = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.bHB = 0.0f;
        init();
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHy = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.bHB = 0.0f;
        init();
    }

    private void init() {
        this.bHC = new ValueAnimator();
        this.bHC.setDuration(200L);
        this.bHC.setInterpolator(new DecelerateInterpolator());
        this.bHC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        setOverScrollMode(2);
        this.mScreenWidth = e.ao(getContext());
        this.mRatio = (1.0f * this.bHy) / this.mScreenWidth;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.bHz = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.bHz && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.bHy;
        switch (action) {
            case 0:
                if (this.bHC.isRunning()) {
                    this.bHC.cancel();
                }
                this.bHA = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.bHB = 0.0f;
                    this.bHA = 0.0f;
                    this.bHC.setFloatValues(x, 0.0f);
                    this.bHC.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.bHA;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.bHA = motionEvent.getRawX();
                    return true;
                }
                if (this.bHB * rawX < 0.0f) {
                    this.bHB += rawX;
                } else {
                    this.bHB += rawX * this.mRatio;
                }
                this.bHA = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.bHz) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.bHB > i2) {
                        this.bHB = i * i2;
                        this.bHA = motionEvent.getRawX();
                    } else if (i * this.bHB < 0.0f) {
                        this.bHB = 0.0f;
                        this.bHA = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.bHB);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.bHy = i;
            this.mRatio = (1.0f * this.bHy) / this.mScreenWidth;
        }
    }
}
