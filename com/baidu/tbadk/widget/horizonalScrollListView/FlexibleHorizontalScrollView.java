package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float bGV;
    private int dGA;
    private int dGB;
    private float dGC;
    private ValueAnimator dGD;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.dGA = 150;
        this.dGC = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dGA = 150;
        this.dGC = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.dGB = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.dGB && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.dGA;
        aQX();
        switch (action) {
            case 0:
                if (this.dGD.isRunning()) {
                    this.dGD.cancel();
                }
                this.bGV = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.dGC = 0.0f;
                    this.bGV = 0.0f;
                    this.dGD.setFloatValues(x, 0.0f);
                    this.dGD.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.bGV;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.bGV = motionEvent.getRawX();
                    return true;
                }
                if (this.dGC * rawX < 0.0f) {
                    this.dGC += rawX;
                } else {
                    this.dGC += rawX * this.mRatio;
                }
                this.bGV = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.dGB) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.dGC > i2) {
                        this.dGC = i * i2;
                        this.bGV = motionEvent.getRawX();
                    } else if (i * this.dGC < 0.0f) {
                        this.dGC = 0.0f;
                        this.bGV = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.dGC);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void aQX() {
        if (this.dGD == null) {
            this.dGD = new ValueAnimator();
            this.dGD.setDuration(200L);
            this.dGD.setInterpolator(new DecelerateInterpolator());
            this.dGD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.dGA) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.dGA = i;
            this.mRatio = (1.0f * this.dGA) / this.mScreenWidth;
        }
    }
}
