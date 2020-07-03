package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float cAs;
    private int eJj;
    private int eJk;
    private float eJl;
    private ValueAnimator eJm;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.eJj = 150;
        this.eJl = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eJj = 150;
        this.eJl = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.eJk = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.eJk && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.eJj;
        bkf();
        switch (action) {
            case 0:
                if (this.eJm.isRunning()) {
                    this.eJm.cancel();
                }
                this.cAs = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.eJl = 0.0f;
                    this.cAs = 0.0f;
                    this.eJm.setFloatValues(x, 0.0f);
                    this.eJm.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.cAs;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.cAs = motionEvent.getRawX();
                    return true;
                }
                if (this.eJl * rawX < 0.0f) {
                    this.eJl += rawX;
                } else {
                    this.eJl += rawX * this.mRatio;
                }
                this.cAs = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.eJk) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.eJl > i2) {
                        this.eJl = i * i2;
                        this.cAs = motionEvent.getRawX();
                    } else if (i * this.eJl < 0.0f) {
                        this.eJl = 0.0f;
                        this.cAs = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.eJl);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bkf() {
        if (this.eJm == null) {
            this.eJm = new ValueAnimator();
            this.eJm.setDuration(200L);
            this.eJm.setInterpolator(new DecelerateInterpolator());
            this.eJm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.eJj) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.eJj = i;
            this.mRatio = (1.0f * this.eJj) / this.mScreenWidth;
        }
    }
}
