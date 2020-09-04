package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float cLy;
    private int fap;
    private int faq;
    private float far;
    private ValueAnimator fas;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.fap = 150;
        this.far = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fap = 150;
        this.far = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.faq = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.faq && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.fap;
        alC();
        switch (action) {
            case 0:
                if (this.fas.isRunning()) {
                    this.fas.cancel();
                }
                this.cLy = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.far = 0.0f;
                    this.cLy = 0.0f;
                    this.fas.setFloatValues(x, 0.0f);
                    this.fas.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.cLy;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.cLy = motionEvent.getRawX();
                    return true;
                }
                if (this.far * rawX < 0.0f) {
                    this.far += rawX;
                } else {
                    this.far += rawX * this.mRatio;
                }
                this.cLy = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.faq) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.far > i2) {
                        this.far = i * i2;
                        this.cLy = motionEvent.getRawX();
                    } else if (i * this.far < 0.0f) {
                        this.far = 0.0f;
                        this.cLy = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.far);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void alC() {
        if (this.fas == null) {
            this.fas = new ValueAnimator();
            this.fas.setDuration(200L);
            this.fas.setInterpolator(new DecelerateInterpolator());
            this.fas.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.fap) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.fap = i;
            this.mRatio = (1.0f * this.fap) / this.mScreenWidth;
        }
    }
}
