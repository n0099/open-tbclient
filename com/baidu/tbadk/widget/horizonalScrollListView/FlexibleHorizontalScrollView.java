package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float dic;
    private int fxU;
    private int fxV;
    private float fxW;
    private ValueAnimator fxX;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.fxU = 150;
        this.fxW = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fxU = 150;
        this.fxW = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.fxV = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.fxV && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.fxU;
        aqS();
        switch (action) {
            case 0:
                if (this.fxX.isRunning()) {
                    this.fxX.cancel();
                }
                this.dic = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.fxW = 0.0f;
                    this.dic = 0.0f;
                    this.fxX.setFloatValues(x, 0.0f);
                    this.fxX.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.dic;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.dic = motionEvent.getRawX();
                    return true;
                }
                if (this.fxW * rawX < 0.0f) {
                    this.fxW += rawX;
                } else {
                    this.fxW += rawX * this.mRatio;
                }
                this.dic = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.fxV) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.fxW > i2) {
                        this.fxW = i * i2;
                        this.dic = motionEvent.getRawX();
                    } else if (i * this.fxW < 0.0f) {
                        this.fxW = 0.0f;
                        this.dic = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.fxW);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void aqS() {
        if (this.fxX == null) {
            this.fxX = new ValueAnimator();
            this.fxX.setDuration(200L);
            this.fxX.setInterpolator(new DecelerateInterpolator());
            this.fxX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.fxU) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.fxU = i;
            this.mRatio = (1.0f * this.fxU) / this.mScreenWidth;
        }
    }
}
