package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float aJF;
    private int cHO;
    private int cHP;
    private float cHQ;
    private ValueAnimator cHR;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.cHO = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.cHQ = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cHO = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.cHQ = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.cHP = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.cHP && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.cHO;
        axJ();
        switch (action) {
            case 0:
                if (this.cHR.isRunning()) {
                    this.cHR.cancel();
                }
                this.aJF = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.cHQ = 0.0f;
                    this.aJF = 0.0f;
                    this.cHR.setFloatValues(x, 0.0f);
                    this.cHR.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.aJF;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.aJF = motionEvent.getRawX();
                    return true;
                }
                if (this.cHQ * rawX < 0.0f) {
                    this.cHQ += rawX;
                } else {
                    this.cHQ += rawX * this.mRatio;
                }
                this.aJF = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.cHP) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.cHQ > i2) {
                        this.cHQ = i * i2;
                        this.aJF = motionEvent.getRawX();
                    } else if (i * this.cHQ < 0.0f) {
                        this.cHQ = 0.0f;
                        this.aJF = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.cHQ);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void axJ() {
        if (this.cHR == null) {
            this.cHR = new ValueAnimator();
            this.cHR.setDuration(200L);
            this.cHR.setInterpolator(new DecelerateInterpolator());
            this.cHR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.af(getContext());
            this.mRatio = (1.0f * this.cHO) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.cHO = i;
            this.mRatio = (1.0f * this.cHO) / this.mScreenWidth;
        }
    }
}
