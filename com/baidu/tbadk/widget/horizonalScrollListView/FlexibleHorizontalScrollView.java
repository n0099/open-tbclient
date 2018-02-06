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
    private int bHI;
    private int bHJ;
    private float bHK;
    private float bHL;
    private ValueAnimator bHM;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.bHI = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.bHL = 0.0f;
        init();
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHI = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.bHL = 0.0f;
        init();
    }

    private void init() {
        this.bHM = new ValueAnimator();
        this.bHM.setDuration(200L);
        this.bHM.setInterpolator(new DecelerateInterpolator());
        this.bHM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        setOverScrollMode(2);
        this.mScreenWidth = e.ao(getContext());
        this.mRatio = (1.0f * this.bHI) / this.mScreenWidth;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.bHJ = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.bHJ && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.bHI;
        switch (action) {
            case 0:
                if (this.bHM.isRunning()) {
                    this.bHM.cancel();
                }
                this.bHK = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.bHL = 0.0f;
                    this.bHK = 0.0f;
                    this.bHM.setFloatValues(x, 0.0f);
                    this.bHM.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.bHK;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.bHK = motionEvent.getRawX();
                    return true;
                }
                if (this.bHL * rawX < 0.0f) {
                    this.bHL += rawX;
                } else {
                    this.bHL += rawX * this.mRatio;
                }
                this.bHK = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.bHJ) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.bHL > i2) {
                        this.bHL = i * i2;
                        this.bHK = motionEvent.getRawX();
                    } else if (i * this.bHL < 0.0f) {
                        this.bHL = 0.0f;
                        this.bHK = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.bHL);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.bHI = i;
            this.mRatio = (1.0f * this.bHI) / this.mScreenWidth;
        }
    }
}
