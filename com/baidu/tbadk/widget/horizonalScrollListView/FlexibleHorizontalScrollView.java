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
    private ValueAnimator bFA;
    private int bFw;
    private int bFx;
    private float bFy;
    private float bFz;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.bFw = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.bFz = 0.0f;
        init();
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bFw = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.bFz = 0.0f;
        init();
    }

    private void init() {
        this.bFA = new ValueAnimator();
        this.bFA.setDuration(200L);
        this.bFA.setInterpolator(new DecelerateInterpolator());
        this.bFA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        setOverScrollMode(2);
        this.mScreenWidth = e.ao(getContext());
        this.mRatio = (1.0f * this.bFw) / this.mScreenWidth;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.bFx = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.bFx && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.bFw;
        switch (action) {
            case 0:
                if (this.bFA.isRunning()) {
                    this.bFA.cancel();
                }
                this.bFy = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.bFz = 0.0f;
                    this.bFy = 0.0f;
                    this.bFA.setFloatValues(x, 0.0f);
                    this.bFA.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.bFy;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.bFy = motionEvent.getRawX();
                    return true;
                }
                if (this.bFz * rawX < 0.0f) {
                    this.bFz += rawX;
                } else {
                    this.bFz += rawX * this.mRatio;
                }
                this.bFy = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.bFx) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.bFz > i2) {
                        this.bFz = i * i2;
                        this.bFy = motionEvent.getRawX();
                    } else if (i * this.bFz < 0.0f) {
                        this.bFz = 0.0f;
                        this.bFy = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.bFz);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.bFw = i;
            this.mRatio = (1.0f * this.bFw) / this.mScreenWidth;
        }
    }
}
