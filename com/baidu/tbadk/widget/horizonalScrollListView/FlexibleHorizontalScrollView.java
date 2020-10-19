package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float cZB;
    private int fpv;
    private int fpw;
    private float fpx;
    private ValueAnimator fpy;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.fpv = 150;
        this.fpx = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fpv = 150;
        this.fpx = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.fpw = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.fpw && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.fpv;
        aoX();
        switch (action) {
            case 0:
                if (this.fpy.isRunning()) {
                    this.fpy.cancel();
                }
                this.cZB = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.fpx = 0.0f;
                    this.cZB = 0.0f;
                    this.fpy.setFloatValues(x, 0.0f);
                    this.fpy.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.cZB;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.cZB = motionEvent.getRawX();
                    return true;
                }
                if (this.fpx * rawX < 0.0f) {
                    this.fpx += rawX;
                } else {
                    this.fpx += rawX * this.mRatio;
                }
                this.cZB = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.fpw) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.fpx > i2) {
                        this.fpx = i * i2;
                        this.cZB = motionEvent.getRawX();
                    } else if (i * this.fpx < 0.0f) {
                        this.fpx = 0.0f;
                        this.cZB = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.fpx);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void aoX() {
        if (this.fpy == null) {
            this.fpy = new ValueAnimator();
            this.fpy.setDuration(200L);
            this.fpy.setInterpolator(new DecelerateInterpolator());
            this.fpy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.fpv) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.fpv = i;
            this.mRatio = (1.0f * this.fpv) / this.mScreenWidth;
        }
    }
}
