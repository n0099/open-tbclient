package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float dnY;
    private int fDK;
    private int fDL;
    private float fDM;
    private ValueAnimator fDN;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.fDK = 150;
        this.fDM = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fDK = 150;
        this.fDM = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.fDL = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.fDL && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.fDK;
        att();
        switch (action) {
            case 0:
                if (this.fDN.isRunning()) {
                    this.fDN.cancel();
                }
                this.dnY = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.fDM = 0.0f;
                    this.dnY = 0.0f;
                    this.fDN.setFloatValues(x, 0.0f);
                    this.fDN.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.dnY;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.dnY = motionEvent.getRawX();
                    return true;
                }
                if (this.fDM * rawX < 0.0f) {
                    this.fDM += rawX;
                } else {
                    this.fDM += rawX * this.mRatio;
                }
                this.dnY = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.fDL) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.fDM > i2) {
                        this.fDM = i * i2;
                        this.dnY = motionEvent.getRawX();
                    } else if (i * this.fDM < 0.0f) {
                        this.fDM = 0.0f;
                        this.dnY = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.fDM);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void att() {
        if (this.fDN == null) {
            this.fDN = new ValueAnimator();
            this.fDN.setDuration(200L);
            this.fDN.setInterpolator(new DecelerateInterpolator());
            this.fDN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.fDK) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.fDK = i;
            this.mRatio = (1.0f * this.fDK) / this.mScreenWidth;
        }
    }
}
