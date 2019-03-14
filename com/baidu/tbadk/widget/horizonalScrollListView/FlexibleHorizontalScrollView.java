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
    private float aHa;
    private int cyh;
    private int cyi;
    private float cyj;
    private ValueAnimator cyk;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.cyh = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.cyj = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cyh = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.cyj = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.cyi = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.cyi && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.cyh;
        art();
        switch (action) {
            case 0:
                if (this.cyk.isRunning()) {
                    this.cyk.cancel();
                }
                this.aHa = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.cyj = 0.0f;
                    this.aHa = 0.0f;
                    this.cyk.setFloatValues(x, 0.0f);
                    this.cyk.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.aHa;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.aHa = motionEvent.getRawX();
                    return true;
                }
                if (this.cyj * rawX < 0.0f) {
                    this.cyj += rawX;
                } else {
                    this.cyj += rawX * this.mRatio;
                }
                this.aHa = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.cyi) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.cyj > i2) {
                        this.cyj = i * i2;
                        this.aHa = motionEvent.getRawX();
                    } else if (i * this.cyj < 0.0f) {
                        this.cyj = 0.0f;
                        this.aHa = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.cyj);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void art() {
        if (this.cyk == null) {
            this.cyk = new ValueAnimator();
            this.cyk.setDuration(200L);
            this.cyk.setInterpolator(new DecelerateInterpolator());
            this.cyk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.aO(getContext());
            this.mRatio = (1.0f * this.cyh) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.cyh = i;
            this.mRatio = (1.0f * this.cyh) / this.mScreenWidth;
        }
    }
}
