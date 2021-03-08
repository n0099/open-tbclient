package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float dxQ;
    private int fTL;
    private int fTM;
    private float fTN;
    private ValueAnimator fTO;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.fTL = 150;
        this.fTN = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fTL = 150;
        this.fTN = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.fTM = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.fTM && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.fTL;
        atT();
        switch (action) {
            case 0:
                if (this.fTO.isRunning()) {
                    this.fTO.cancel();
                }
                this.dxQ = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.fTN = 0.0f;
                    this.dxQ = 0.0f;
                    this.fTO.setFloatValues(x, 0.0f);
                    this.fTO.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.dxQ;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.dxQ = motionEvent.getRawX();
                    return true;
                }
                if (this.fTN * rawX < 0.0f) {
                    this.fTN += rawX;
                } else {
                    this.fTN += rawX * this.mRatio;
                }
                this.dxQ = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.fTM) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.fTN > i2) {
                        this.fTN = i * i2;
                        this.dxQ = motionEvent.getRawX();
                    } else if (i * this.fTN < 0.0f) {
                        this.fTN = 0.0f;
                        this.dxQ = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.fTN);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void atT() {
        if (this.fTO == null) {
            this.fTO = new ValueAnimator();
            this.fTO.setDuration(200L);
            this.fTO.setInterpolator(new DecelerateInterpolator());
            this.fTO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.fTL) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.fTL = i;
            this.mRatio = (1.0f * this.fTL) / this.mScreenWidth;
        }
    }
}
