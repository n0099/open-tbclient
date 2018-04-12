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
    private int aRY;
    private int aRZ;
    private float aSa;
    private float aSb;
    private ValueAnimator aSc;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.aRY = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.aSb = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aRY = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.aSb = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.aRZ = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.aRZ && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.aRY;
        IL();
        switch (action) {
            case 0:
                if (this.aSc.isRunning()) {
                    this.aSc.cancel();
                }
                this.aSa = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.aSb = 0.0f;
                    this.aSa = 0.0f;
                    this.aSc.setFloatValues(x, 0.0f);
                    this.aSc.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.aSa;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.aSa = motionEvent.getRawX();
                    return true;
                }
                if (this.aSb * rawX < 0.0f) {
                    this.aSb += rawX;
                } else {
                    this.aSb += rawX * this.mRatio;
                }
                this.aSa = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.aRZ) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.aSb > i2) {
                        this.aSb = i * i2;
                        this.aSa = motionEvent.getRawX();
                    } else if (i * this.aSb < 0.0f) {
                        this.aSb = 0.0f;
                        this.aSa = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.aSb);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void IL() {
        if (this.aSc == null) {
            this.aSc = new ValueAnimator();
            this.aSc.setDuration(200L);
            this.aSc.setInterpolator(new DecelerateInterpolator());
            this.aSc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.af(getContext());
            this.mRatio = (1.0f * this.aRY) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.aRY = i;
            this.mRatio = (1.0f * this.aRY) / this.mScreenWidth;
        }
    }
}
