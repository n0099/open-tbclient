package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float aIX;
    private int cGu;
    private int cGv;
    private float cGw;
    private ValueAnimator cGx;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.cGu = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.cGw = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cGu = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.cGw = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.cGv = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.cGv && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.cGu;
        awx();
        switch (action) {
            case 0:
                if (this.cGx.isRunning()) {
                    this.cGx.cancel();
                }
                this.aIX = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.cGw = 0.0f;
                    this.aIX = 0.0f;
                    this.cGx.setFloatValues(x, 0.0f);
                    this.cGx.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.aIX;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.aIX = motionEvent.getRawX();
                    return true;
                }
                if (this.cGw * rawX < 0.0f) {
                    this.cGw += rawX;
                } else {
                    this.cGw += rawX * this.mRatio;
                }
                this.aIX = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.cGv) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.cGw > i2) {
                        this.cGw = i * i2;
                        this.aIX = motionEvent.getRawX();
                    } else if (i * this.cGw < 0.0f) {
                        this.cGw = 0.0f;
                        this.aIX = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.cGw);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void awx() {
        if (this.cGx == null) {
            this.cGx = new ValueAnimator();
            this.cGx.setDuration(200L);
            this.cGx.setInterpolator(new DecelerateInterpolator());
            this.cGx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.af(getContext());
            this.mRatio = (1.0f * this.cGu) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.cGu = i;
            this.mRatio = (1.0f * this.cGu) / this.mScreenWidth;
        }
    }
}
