package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float bLa;
    private int dKF;
    private int dKG;
    private float dKH;
    private ValueAnimator dKI;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.dKF = 150;
        this.dKH = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dKF = 150;
        this.dKH = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.dKG = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.dKG && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.dKF;
        aTo();
        switch (action) {
            case 0:
                if (this.dKI.isRunning()) {
                    this.dKI.cancel();
                }
                this.bLa = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.dKH = 0.0f;
                    this.bLa = 0.0f;
                    this.dKI.setFloatValues(x, 0.0f);
                    this.dKI.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.bLa;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.bLa = motionEvent.getRawX();
                    return true;
                }
                if (this.dKH * rawX < 0.0f) {
                    this.dKH += rawX;
                } else {
                    this.dKH += rawX * this.mRatio;
                }
                this.bLa = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.dKG) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.dKH > i2) {
                        this.dKH = i * i2;
                        this.bLa = motionEvent.getRawX();
                    } else if (i * this.dKH < 0.0f) {
                        this.dKH = 0.0f;
                        this.bLa = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.dKH);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void aTo() {
        if (this.dKI == null) {
            this.dKI = new ValueAnimator();
            this.dKI.setDuration(200L);
            this.dKI.setInterpolator(new DecelerateInterpolator());
            this.dKI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.dKF) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.dKF = i;
            this.mRatio = (1.0f * this.dKF) / this.mScreenWidth;
        }
    }
}
