package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float cvH;
    private int ezU;
    private int ezV;
    private float ezW;
    private ValueAnimator ezX;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.ezU = 150;
        this.ezW = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ezU = 150;
        this.ezW = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.ezV = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.ezV && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.ezU;
        bhQ();
        switch (action) {
            case 0:
                if (this.ezX.isRunning()) {
                    this.ezX.cancel();
                }
                this.cvH = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.ezW = 0.0f;
                    this.cvH = 0.0f;
                    this.ezX.setFloatValues(x, 0.0f);
                    this.ezX.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.cvH;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.cvH = motionEvent.getRawX();
                    return true;
                }
                if (this.ezW * rawX < 0.0f) {
                    this.ezW += rawX;
                } else {
                    this.ezW += rawX * this.mRatio;
                }
                this.cvH = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.ezV) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.ezW > i2) {
                        this.ezW = i * i2;
                        this.cvH = motionEvent.getRawX();
                    } else if (i * this.ezW < 0.0f) {
                        this.ezW = 0.0f;
                        this.cvH = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.ezW);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bhQ() {
        if (this.ezX == null) {
            this.ezX = new ValueAnimator();
            this.ezX.setDuration(200L);
            this.ezX.setInterpolator(new DecelerateInterpolator());
            this.ezX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.ezU) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.ezU = i;
            this.mRatio = (1.0f * this.ezU) / this.mScreenWidth;
        }
    }
}
