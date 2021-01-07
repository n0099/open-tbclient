package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float dyT;
    private int fUF;
    private int fUG;
    private float fUH;
    private ValueAnimator fUI;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.fUF = 150;
        this.fUH = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fUF = 150;
        this.fUH = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.fUG = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.fUG && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.fUF;
        axm();
        switch (action) {
            case 0:
                if (this.fUI.isRunning()) {
                    this.fUI.cancel();
                }
                this.dyT = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.fUH = 0.0f;
                    this.dyT = 0.0f;
                    this.fUI.setFloatValues(x, 0.0f);
                    this.fUI.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.dyT;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.dyT = motionEvent.getRawX();
                    return true;
                }
                if (this.fUH * rawX < 0.0f) {
                    this.fUH += rawX;
                } else {
                    this.fUH += rawX * this.mRatio;
                }
                this.dyT = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.fUG) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.fUH > i2) {
                        this.fUH = i * i2;
                        this.dyT = motionEvent.getRawX();
                    } else if (i * this.fUH < 0.0f) {
                        this.fUH = 0.0f;
                        this.dyT = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.fUH);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void axm() {
        if (this.fUI == null) {
            this.fUI = new ValueAnimator();
            this.fUI.setDuration(200L);
            this.fUI.setInterpolator(new DecelerateInterpolator());
            this.fUI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.fUF) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.fUF = i;
            this.mRatio = (1.0f * this.fUF) / this.mScreenWidth;
        }
    }
}
