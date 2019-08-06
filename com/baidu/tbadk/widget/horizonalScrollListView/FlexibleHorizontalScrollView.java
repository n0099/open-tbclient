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
    private int cHV;
    private int cHW;
    private float cHX;
    private ValueAnimator cHY;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.cHV = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.cHX = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cHV = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.cHX = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.cHW = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.cHW && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.cHV;
        axL();
        switch (action) {
            case 0:
                if (this.cHY.isRunning()) {
                    this.cHY.cancel();
                }
                this.aJF = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.cHX = 0.0f;
                    this.aJF = 0.0f;
                    this.cHY.setFloatValues(x, 0.0f);
                    this.cHY.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.aJF;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.aJF = motionEvent.getRawX();
                    return true;
                }
                if (this.cHX * rawX < 0.0f) {
                    this.cHX += rawX;
                } else {
                    this.cHX += rawX * this.mRatio;
                }
                this.aJF = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.cHW) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.cHX > i2) {
                        this.cHX = i * i2;
                        this.aJF = motionEvent.getRawX();
                    } else if (i * this.cHX < 0.0f) {
                        this.cHX = 0.0f;
                        this.aJF = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.cHX);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void axL() {
        if (this.cHY == null) {
            this.cHY = new ValueAnimator();
            this.cHY.setDuration(200L);
            this.cHY.setInterpolator(new DecelerateInterpolator());
            this.cHY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.af(getContext());
            this.mRatio = (1.0f * this.cHV) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.cHV = i;
            this.mRatio = (1.0f * this.cHV) / this.mScreenWidth;
        }
    }
}
