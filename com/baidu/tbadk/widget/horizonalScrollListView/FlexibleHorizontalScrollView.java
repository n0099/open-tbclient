package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float bGl;
    private int dGr;
    private int dGs;
    private float dGt;
    private ValueAnimator dGu;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.dGr = 150;
        this.dGt = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dGr = 150;
        this.dGt = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.dGs = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.dGs && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.dGr;
        aQE();
        switch (action) {
            case 0:
                if (this.dGu.isRunning()) {
                    this.dGu.cancel();
                }
                this.bGl = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.dGt = 0.0f;
                    this.bGl = 0.0f;
                    this.dGu.setFloatValues(x, 0.0f);
                    this.dGu.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.bGl;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.bGl = motionEvent.getRawX();
                    return true;
                }
                if (this.dGt * rawX < 0.0f) {
                    this.dGt += rawX;
                } else {
                    this.dGt += rawX * this.mRatio;
                }
                this.bGl = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.dGs) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.dGt > i2) {
                        this.dGt = i * i2;
                        this.bGl = motionEvent.getRawX();
                    } else if (i * this.dGt < 0.0f) {
                        this.dGt = 0.0f;
                        this.bGl = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.dGt);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void aQE() {
        if (this.dGu == null) {
            this.dGu = new ValueAnimator();
            this.dGu.setDuration(200L);
            this.dGu.setInterpolator(new DecelerateInterpolator());
            this.dGu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.dGr) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.dGr = i;
            this.mRatio = (1.0f * this.dGr) / this.mScreenWidth;
        }
    }
}
