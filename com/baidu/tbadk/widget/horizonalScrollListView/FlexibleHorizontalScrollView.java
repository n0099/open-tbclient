package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends b {
    private int bFE;
    private int bFF;
    private float bFG;
    private float bFH;
    private ValueAnimator bFI;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.bFE = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.bFH = 0.0f;
        init();
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bFE = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.bFH = 0.0f;
        init();
    }

    private void init() {
        this.bFI = new ValueAnimator();
        this.bFI.setDuration(200L);
        this.bFI.setInterpolator(new DecelerateInterpolator());
        this.bFI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        setOverScrollMode(2);
        this.mScreenWidth = e.ao(getContext());
        this.mRatio = (1.0f * this.bFE) / this.mScreenWidth;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.bFF = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.bFF && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.bFE;
        switch (action) {
            case 0:
                if (this.bFI.isRunning()) {
                    this.bFI.cancel();
                }
                this.bFG = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.bFH = 0.0f;
                    this.bFG = 0.0f;
                    this.bFI.setFloatValues(x, 0.0f);
                    this.bFI.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.bFG;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.bFG = motionEvent.getRawX();
                    return true;
                }
                if (this.bFH * rawX < 0.0f) {
                    this.bFH += rawX;
                } else {
                    this.bFH += rawX * this.mRatio;
                }
                this.bFG = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.bFF) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.bFH > i2) {
                        this.bFH = i * i2;
                        this.bFG = motionEvent.getRawX();
                    } else if (i * this.bFH < 0.0f) {
                        this.bFH = 0.0f;
                        this.bFG = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.bFH);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.bFE = i;
            this.mRatio = (1.0f * this.bFE) / this.mScreenWidth;
        }
    }
}
