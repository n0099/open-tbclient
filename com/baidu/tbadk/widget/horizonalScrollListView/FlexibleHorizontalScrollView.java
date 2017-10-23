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
    private int aOj;
    private int aOk;
    private float aOl;
    private float aOm;
    private ValueAnimator aOn;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.aOj = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.aOm = 0.0f;
        init();
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOj = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.aOm = 0.0f;
        init();
    }

    private void init() {
        this.aOn = new ValueAnimator();
        this.aOn.setDuration(200L);
        this.aOn.setInterpolator(new DecelerateInterpolator());
        this.aOn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        setOverScrollMode(2);
        this.mScreenWidth = e.ad(getContext());
        this.mRatio = (1.0f * this.aOj) / this.mScreenWidth;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.aOk = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.aOk && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int i2 = this.aOj;
        switch (action) {
            case 0:
                if (this.aOn.isRunning()) {
                    this.aOn.cancel();
                }
                this.aOl = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.aOm = 0.0f;
                    this.aOl = 0.0f;
                    this.aOn.setFloatValues(x, 0.0f);
                    this.aOn.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.aOl;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.aOl = motionEvent.getRawX();
                    return true;
                }
                if (this.aOm * rawX < 0.0f) {
                    this.aOm += rawX;
                } else {
                    this.aOm += rawX * this.mRatio;
                }
                this.aOl = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.aOk) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.aOm > i2) {
                        this.aOm = i * i2;
                        this.aOl = motionEvent.getRawX();
                    } else if (i * this.aOm < 0.0f) {
                        this.aOm = 0.0f;
                        this.aOl = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.aOm);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.aOj = i;
            this.mRatio = (1.0f * this.aOj) / this.mScreenWidth;
        }
    }
}
