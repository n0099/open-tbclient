package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float bLb;
    private int dKG;
    private int dKH;
    private float dKI;
    private ValueAnimator dKJ;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.dKG = 150;
        this.dKI = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dKG = 150;
        this.dKI = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.dKH = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.dKH && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.dKG;
        aTq();
        switch (action) {
            case 0:
                if (this.dKJ.isRunning()) {
                    this.dKJ.cancel();
                }
                this.bLb = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.dKI = 0.0f;
                    this.bLb = 0.0f;
                    this.dKJ.setFloatValues(x, 0.0f);
                    this.dKJ.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.bLb;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.bLb = motionEvent.getRawX();
                    return true;
                }
                if (this.dKI * rawX < 0.0f) {
                    this.dKI += rawX;
                } else {
                    this.dKI += rawX * this.mRatio;
                }
                this.bLb = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.dKH) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.dKI > i2) {
                        this.dKI = i * i2;
                        this.bLb = motionEvent.getRawX();
                    } else if (i * this.dKI < 0.0f) {
                        this.dKI = 0.0f;
                        this.bLb = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.dKI);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void aTq() {
        if (this.dKJ == null) {
            this.dKJ = new ValueAnimator();
            this.dKJ.setDuration(200L);
            this.dKJ.setInterpolator(new DecelerateInterpolator());
            this.dKJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.dKG) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.dKG = i;
            this.mRatio = (1.0f * this.dKG) / this.mScreenWidth;
        }
    }
}
