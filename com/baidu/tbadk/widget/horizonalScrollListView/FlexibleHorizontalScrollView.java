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
    private int aOq;
    private int aOr;
    private float aOs;
    private float aOt;
    private ValueAnimator aOu;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.aOq = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.aOt = 0.0f;
        init();
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOq = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.aOt = 0.0f;
        init();
    }

    private void init() {
        this.aOu = new ValueAnimator();
        this.aOu.setDuration(200L);
        this.aOu.setInterpolator(new DecelerateInterpolator());
        this.aOu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        setOverScrollMode(2);
        this.mScreenWidth = e.ac(getContext());
        this.mRatio = (1.0f * this.aOq) / this.mScreenWidth;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.aOr = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.aOr && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int i2 = this.aOq;
        switch (action) {
            case 0:
                if (this.aOu.isRunning()) {
                    this.aOu.cancel();
                }
                this.aOs = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.aOt = 0.0f;
                    this.aOs = 0.0f;
                    this.aOu.setFloatValues(x, 0.0f);
                    this.aOu.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.aOs;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.aOs = motionEvent.getRawX();
                    return true;
                }
                if (this.aOt * rawX < 0.0f) {
                    this.aOt += rawX;
                } else {
                    this.aOt += rawX * this.mRatio;
                }
                this.aOs = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.aOr) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.aOt > i2) {
                        this.aOt = i * i2;
                        this.aOs = motionEvent.getRawX();
                    } else if (i * this.aOt < 0.0f) {
                        this.aOt = 0.0f;
                        this.aOs = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.aOt);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.aOq = i;
            this.mRatio = (1.0f * this.aOq) / this.mScreenWidth;
        }
    }
}
