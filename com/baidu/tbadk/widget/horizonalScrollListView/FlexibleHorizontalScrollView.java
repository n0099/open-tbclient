package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float bdr;
    private int cSR;
    private int cSS;
    private float cST;
    private ValueAnimator cSU;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.cSR = 150;
        this.cST = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cSR = 150;
        this.cST = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.cSS = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.cSS && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.cSR;
        ayH();
        switch (action) {
            case 0:
                if (this.cSU.isRunning()) {
                    this.cSU.cancel();
                }
                this.bdr = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.cST = 0.0f;
                    this.bdr = 0.0f;
                    this.cSU.setFloatValues(x, 0.0f);
                    this.cSU.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.bdr;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.bdr = motionEvent.getRawX();
                    return true;
                }
                if (this.cST * rawX < 0.0f) {
                    this.cST += rawX;
                } else {
                    this.cST += rawX * this.mRatio;
                }
                this.bdr = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.cSS) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.cST > i2) {
                        this.cST = i * i2;
                        this.bdr = motionEvent.getRawX();
                    } else if (i * this.cST < 0.0f) {
                        this.cST = 0.0f;
                        this.bdr = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.cST);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void ayH() {
        if (this.cSU == null) {
            this.cSU = new ValueAnimator();
            this.cSU.setDuration(200L);
            this.cSU.setInterpolator(new DecelerateInterpolator());
            this.cSU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.cSR) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.cSR = i;
            this.mRatio = (1.0f * this.cSR) / this.mScreenWidth;
        }
    }
}
