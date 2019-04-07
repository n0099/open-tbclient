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
    private float aHd;
    private int cyj;
    private int cyk;
    private float cyl;
    private ValueAnimator cym;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.cyj = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.cyl = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cyj = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.cyl = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.cyk = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.cyk && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.cyj;
        arq();
        switch (action) {
            case 0:
                if (this.cym.isRunning()) {
                    this.cym.cancel();
                }
                this.aHd = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.cyl = 0.0f;
                    this.aHd = 0.0f;
                    this.cym.setFloatValues(x, 0.0f);
                    this.cym.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.aHd;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.aHd = motionEvent.getRawX();
                    return true;
                }
                if (this.cyl * rawX < 0.0f) {
                    this.cyl += rawX;
                } else {
                    this.cyl += rawX * this.mRatio;
                }
                this.aHd = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.cyk) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.cyl > i2) {
                        this.cyl = i * i2;
                        this.aHd = motionEvent.getRawX();
                    } else if (i * this.cyl < 0.0f) {
                        this.cyl = 0.0f;
                        this.aHd = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.cyl);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void arq() {
        if (this.cym == null) {
            this.cym = new ValueAnimator();
            this.cym.setDuration(200L);
            this.cym.setInterpolator(new DecelerateInterpolator());
            this.cym.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.aO(getContext());
            this.mRatio = (1.0f * this.cyj) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.cyj = i;
            this.mRatio = (1.0f * this.cyj) / this.mScreenWidth;
        }
    }
}
