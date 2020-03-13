package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float bLc;
    private int dKT;
    private int dKU;
    private float dKV;
    private ValueAnimator dKW;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.dKT = 150;
        this.dKV = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dKT = 150;
        this.dKV = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.dKU = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.dKU && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.dKT;
        aTr();
        switch (action) {
            case 0:
                if (this.dKW.isRunning()) {
                    this.dKW.cancel();
                }
                this.bLc = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.dKV = 0.0f;
                    this.bLc = 0.0f;
                    this.dKW.setFloatValues(x, 0.0f);
                    this.dKW.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.bLc;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.bLc = motionEvent.getRawX();
                    return true;
                }
                if (this.dKV * rawX < 0.0f) {
                    this.dKV += rawX;
                } else {
                    this.dKV += rawX * this.mRatio;
                }
                this.bLc = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.dKU) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.dKV > i2) {
                        this.dKV = i * i2;
                        this.bLc = motionEvent.getRawX();
                    } else if (i * this.dKV < 0.0f) {
                        this.dKV = 0.0f;
                        this.bLc = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.dKV);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void aTr() {
        if (this.dKW == null) {
            this.dKW = new ValueAnimator();
            this.dKW.setDuration(200L);
            this.dKW.setInterpolator(new DecelerateInterpolator());
            this.dKW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.dKT) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.dKT = i;
            this.mRatio = (1.0f * this.dKT) / this.mScreenWidth;
        }
    }
}
