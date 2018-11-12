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
    private int bjt;
    private int bju;
    private float bjv;
    private ValueAnimator bjw;
    private float mRatio;
    private int mScreenWidth;
    private float mStartX;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.bjt = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.bjv = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bjt = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.bjv = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.bju = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.bju && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.bjt;
        initIfNecessary();
        switch (action) {
            case 0:
                if (this.bjw.isRunning()) {
                    this.bjw.cancel();
                }
                this.mStartX = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.bjv = 0.0f;
                    this.mStartX = 0.0f;
                    this.bjw.setFloatValues(x, 0.0f);
                    this.bjw.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.mStartX;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.mStartX = motionEvent.getRawX();
                    return true;
                }
                if (this.bjv * rawX < 0.0f) {
                    this.bjv += rawX;
                } else {
                    this.bjv += rawX * this.mRatio;
                }
                this.mStartX = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.bju) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.bjv > i2) {
                        this.bjv = i * i2;
                        this.mStartX = motionEvent.getRawX();
                    } else if (i * this.bjv < 0.0f) {
                        this.bjv = 0.0f;
                        this.mStartX = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.bjv);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void initIfNecessary() {
        if (this.bjw == null) {
            this.bjw = new ValueAnimator();
            this.bjw.setDuration(200L);
            this.bjw.setInterpolator(new DecelerateInterpolator());
            this.bjw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.aO(getContext());
            this.mRatio = (1.0f * this.bjt) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.bjt = i;
            this.mRatio = (1.0f * this.bjt) / this.mScreenWidth;
        }
    }
}
