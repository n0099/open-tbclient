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
    private int aZT;
    private int aZU;
    private float aZV;
    private float aZW;
    private ValueAnimator aZX;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.aZT = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.aZW = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZT = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.aZW = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.aZU = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.aZU && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.aZT;
        Mf();
        switch (action) {
            case 0:
                if (this.aZX.isRunning()) {
                    this.aZX.cancel();
                }
                this.aZV = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.aZW = 0.0f;
                    this.aZV = 0.0f;
                    this.aZX.setFloatValues(x, 0.0f);
                    this.aZX.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.aZV;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.aZV = motionEvent.getRawX();
                    return true;
                }
                if (this.aZW * rawX < 0.0f) {
                    this.aZW += rawX;
                } else {
                    this.aZW += rawX * this.mRatio;
                }
                this.aZV = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.aZU) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.aZW > i2) {
                        this.aZW = i * i2;
                        this.aZV = motionEvent.getRawX();
                    } else if (i * this.aZW < 0.0f) {
                        this.aZW = 0.0f;
                        this.aZV = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.aZW);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void Mf() {
        if (this.aZX == null) {
            this.aZX = new ValueAnimator();
            this.aZX.setDuration(200L);
            this.aZX.setInterpolator(new DecelerateInterpolator());
            this.aZX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.ah(getContext());
            this.mRatio = (1.0f * this.aZT) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.aZT = i;
            this.mRatio = (1.0f * this.aZT) / this.mScreenWidth;
        }
    }
}
