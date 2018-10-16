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
    private int biI;
    private int biJ;
    private float biK;
    private ValueAnimator biL;
    private float mRatio;
    private int mScreenWidth;
    private float mStartX;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.biI = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.biK = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.biI = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.biK = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.biJ = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.biJ && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.biI;
        initIfNecessary();
        switch (action) {
            case 0:
                if (this.biL.isRunning()) {
                    this.biL.cancel();
                }
                this.mStartX = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.biK = 0.0f;
                    this.mStartX = 0.0f;
                    this.biL.setFloatValues(x, 0.0f);
                    this.biL.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.mStartX;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.mStartX = motionEvent.getRawX();
                    return true;
                }
                if (this.biK * rawX < 0.0f) {
                    this.biK += rawX;
                } else {
                    this.biK += rawX * this.mRatio;
                }
                this.mStartX = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.biJ) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.biK > i2) {
                        this.biK = i * i2;
                        this.mStartX = motionEvent.getRawX();
                    } else if (i * this.biK < 0.0f) {
                        this.biK = 0.0f;
                        this.mStartX = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.biK);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void initIfNecessary() {
        if (this.biL == null) {
            this.biL = new ValueAnimator();
            this.biL.setDuration(200L);
            this.biL.setInterpolator(new DecelerateInterpolator());
            this.biL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.aO(getContext());
            this.mRatio = (1.0f * this.biI) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.biI = i;
            this.mRatio = (1.0f * this.biI) / this.mScreenWidth;
        }
    }
}
