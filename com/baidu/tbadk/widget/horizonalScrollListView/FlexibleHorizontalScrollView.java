package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float dmq;
    private int fDn;
    private int fDo;
    private float fDp;
    private ValueAnimator fDq;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.fDn = 150;
        this.fDp = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fDn = 150;
        this.fDp = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.fDo = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.fDo && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.fDn;
        asL();
        switch (action) {
            case 0:
                if (this.fDq.isRunning()) {
                    this.fDq.cancel();
                }
                this.dmq = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.fDp = 0.0f;
                    this.dmq = 0.0f;
                    this.fDq.setFloatValues(x, 0.0f);
                    this.fDq.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.dmq;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.dmq = motionEvent.getRawX();
                    return true;
                }
                if (this.fDp * rawX < 0.0f) {
                    this.fDp += rawX;
                } else {
                    this.fDp += rawX * this.mRatio;
                }
                this.dmq = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.fDo) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.fDp > i2) {
                        this.fDp = i * i2;
                        this.dmq = motionEvent.getRawX();
                    } else if (i * this.fDp < 0.0f) {
                        this.fDp = 0.0f;
                        this.dmq = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.fDp);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void asL() {
        if (this.fDq == null) {
            this.fDq = new ValueAnimator();
            this.fDq.setDuration(200L);
            this.fDq.setInterpolator(new DecelerateInterpolator());
            this.fDq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.fDn) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.fDn = i;
            this.mRatio = (1.0f * this.fDn) / this.mScreenWidth;
        }
    }
}
