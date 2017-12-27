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
    private int bFo;
    private int bFp;
    private float bFq;
    private float bFr;
    private ValueAnimator bFs;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.bFo = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.bFr = 0.0f;
        init();
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bFo = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.bFr = 0.0f;
        init();
    }

    private void init() {
        this.bFs = new ValueAnimator();
        this.bFs.setDuration(200L);
        this.bFs.setInterpolator(new DecelerateInterpolator());
        this.bFs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        setOverScrollMode(2);
        this.mScreenWidth = e.ao(getContext());
        this.mRatio = (1.0f * this.bFo) / this.mScreenWidth;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.bFp = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.bFp && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.bFo;
        switch (action) {
            case 0:
                if (this.bFs.isRunning()) {
                    this.bFs.cancel();
                }
                this.bFq = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.bFr = 0.0f;
                    this.bFq = 0.0f;
                    this.bFs.setFloatValues(x, 0.0f);
                    this.bFs.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.bFq;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.bFq = motionEvent.getRawX();
                    return true;
                }
                if (this.bFr * rawX < 0.0f) {
                    this.bFr += rawX;
                } else {
                    this.bFr += rawX * this.mRatio;
                }
                this.bFq = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.bFp) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.bFr > i2) {
                        this.bFr = i * i2;
                        this.bFq = motionEvent.getRawX();
                    } else if (i * this.bFr < 0.0f) {
                        this.bFr = 0.0f;
                        this.bFq = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.bFr);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.bFo = i;
            this.mRatio = (1.0f * this.bFo) / this.mScreenWidth;
        }
    }
}
