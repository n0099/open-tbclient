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
    private int baP;
    private int baQ;
    private float baR;
    private float baS;
    private ValueAnimator baT;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.baP = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.baS = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baP = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        this.baS = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.baQ = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.baQ && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.baP;
        Mx();
        switch (action) {
            case 0:
                if (this.baT.isRunning()) {
                    this.baT.cancel();
                }
                this.baR = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.baS = 0.0f;
                    this.baR = 0.0f;
                    this.baT.setFloatValues(x, 0.0f);
                    this.baT.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.baR;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.baR = motionEvent.getRawX();
                    return true;
                }
                if (this.baS * rawX < 0.0f) {
                    this.baS += rawX;
                } else {
                    this.baS += rawX * this.mRatio;
                }
                this.baR = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.baQ) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.baS > i2) {
                        this.baS = i * i2;
                        this.baR = motionEvent.getRawX();
                    } else if (i * this.baS < 0.0f) {
                        this.baS = 0.0f;
                        this.baR = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.baS);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void Mx() {
        if (this.baT == null) {
            this.baT = new ValueAnimator();
            this.baT.setDuration(200L);
            this.baT.setInterpolator(new DecelerateInterpolator());
            this.baT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.ah(getContext());
            this.mRatio = (1.0f * this.baP) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.baP = i;
            this.mRatio = (1.0f * this.baP) / this.mScreenWidth;
        }
    }
}
