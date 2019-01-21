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
    private int bnJ;
    private int bnK;
    private float bnL;
    private ValueAnimator bnM;
    private float mRatio;
    private int mScreenWidth;
    private float mStartX;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.bnJ = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.bnL = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bnJ = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.bnL = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.bnK = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.bnK && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.bnJ;
        initIfNecessary();
        switch (action) {
            case 0:
                if (this.bnM.isRunning()) {
                    this.bnM.cancel();
                }
                this.mStartX = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.bnL = 0.0f;
                    this.mStartX = 0.0f;
                    this.bnM.setFloatValues(x, 0.0f);
                    this.bnM.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.mStartX;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.mStartX = motionEvent.getRawX();
                    return true;
                }
                if (this.bnL * rawX < 0.0f) {
                    this.bnL += rawX;
                } else {
                    this.bnL += rawX * this.mRatio;
                }
                this.mStartX = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.bnK) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.bnL > i2) {
                        this.bnL = i * i2;
                        this.mStartX = motionEvent.getRawX();
                    } else if (i * this.bnL < 0.0f) {
                        this.bnL = 0.0f;
                        this.mStartX = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.bnL);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void initIfNecessary() {
        if (this.bnM == null) {
            this.bnM = new ValueAnimator();
            this.bnM.setDuration(200L);
            this.bnM.setInterpolator(new DecelerateInterpolator());
            this.bnM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.aO(getContext());
            this.mRatio = (1.0f * this.bnJ) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.bnJ = i;
            this.mRatio = (1.0f * this.bnJ) / this.mScreenWidth;
        }
    }
}
