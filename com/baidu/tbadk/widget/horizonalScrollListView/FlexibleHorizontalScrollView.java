package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float dwp;
    private int fSl;
    private int fSm;
    private float fSn;
    private ValueAnimator fSo;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.fSl = 150;
        this.fSn = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fSl = 150;
        this.fSn = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.fSm = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.fSm && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.fSl;
        atQ();
        switch (action) {
            case 0:
                if (this.fSo.isRunning()) {
                    this.fSo.cancel();
                }
                this.dwp = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.fSn = 0.0f;
                    this.dwp = 0.0f;
                    this.fSo.setFloatValues(x, 0.0f);
                    this.fSo.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.dwp;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.dwp = motionEvent.getRawX();
                    return true;
                }
                if (this.fSn * rawX < 0.0f) {
                    this.fSn += rawX;
                } else {
                    this.fSn += rawX * this.mRatio;
                }
                this.dwp = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.fSm) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.fSn > i2) {
                        this.fSn = i * i2;
                        this.dwp = motionEvent.getRawX();
                    } else if (i * this.fSn < 0.0f) {
                        this.fSn = 0.0f;
                        this.dwp = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.fSn);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void atQ() {
        if (this.fSo == null) {
            this.fSo = new ValueAnimator();
            this.fSo.setDuration(200L);
            this.fSo.setInterpolator(new DecelerateInterpolator());
            this.fSo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.fSl) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.fSl = i;
            this.mRatio = (1.0f * this.fSl) / this.mScreenWidth;
        }
    }
}
