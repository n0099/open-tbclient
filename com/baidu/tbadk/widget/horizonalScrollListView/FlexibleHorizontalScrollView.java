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
    private int beo;
    private int bep;
    private float beq;
    private float ber;
    private ValueAnimator bes;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.beo = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.ber = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.beo = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.ber = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.bep = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.bep && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.beo;
        NP();
        switch (action) {
            case 0:
                if (this.bes.isRunning()) {
                    this.bes.cancel();
                }
                this.beq = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.ber = 0.0f;
                    this.beq = 0.0f;
                    this.bes.setFloatValues(x, 0.0f);
                    this.bes.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.beq;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.beq = motionEvent.getRawX();
                    return true;
                }
                if (this.ber * rawX < 0.0f) {
                    this.ber += rawX;
                } else {
                    this.ber += rawX * this.mRatio;
                }
                this.beq = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.bep) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.ber > i2) {
                        this.ber = i * i2;
                        this.beq = motionEvent.getRawX();
                    } else if (i * this.ber < 0.0f) {
                        this.ber = 0.0f;
                        this.beq = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.ber);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void NP() {
        if (this.bes == null) {
            this.bes = new ValueAnimator();
            this.bes.setDuration(200L);
            this.bes.setInterpolator(new DecelerateInterpolator());
            this.bes.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.aO(getContext());
            this.mRatio = (1.0f * this.beo) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.beo = i;
            this.mRatio = (1.0f * this.beo) / this.mScreenWidth;
        }
    }
}
