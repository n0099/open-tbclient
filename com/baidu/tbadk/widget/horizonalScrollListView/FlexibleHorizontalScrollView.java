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
    private int baW;
    private int baX;
    private float baY;
    private float baZ;
    private ValueAnimator bba;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.baW = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.baZ = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baW = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.baZ = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.baX = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.baX && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.baW;
        Mx();
        switch (action) {
            case 0:
                if (this.bba.isRunning()) {
                    this.bba.cancel();
                }
                this.baY = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.baZ = 0.0f;
                    this.baY = 0.0f;
                    this.bba.setFloatValues(x, 0.0f);
                    this.bba.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.baY;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.baY = motionEvent.getRawX();
                    return true;
                }
                if (this.baZ * rawX < 0.0f) {
                    this.baZ += rawX;
                } else {
                    this.baZ += rawX * this.mRatio;
                }
                this.baY = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.baX) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.baZ > i2) {
                        this.baZ = i * i2;
                        this.baY = motionEvent.getRawX();
                    } else if (i * this.baZ < 0.0f) {
                        this.baZ = 0.0f;
                        this.baY = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.baZ);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void Mx() {
        if (this.bba == null) {
            this.bba = new ValueAnimator();
            this.bba.setDuration(200L);
            this.bba.setInterpolator(new DecelerateInterpolator());
            this.bba.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.ah(getContext());
            this.mRatio = (1.0f * this.baW) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.baW = i;
            this.mRatio = (1.0f * this.baW) / this.mScreenWidth;
        }
    }
}
