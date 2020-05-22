package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float cvH;
    private int ezJ;
    private int ezK;
    private float ezL;
    private ValueAnimator ezM;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.ezJ = 150;
        this.ezL = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ezJ = 150;
        this.ezL = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.ezK = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.ezK && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.ezJ;
        bhO();
        switch (action) {
            case 0:
                if (this.ezM.isRunning()) {
                    this.ezM.cancel();
                }
                this.cvH = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.ezL = 0.0f;
                    this.cvH = 0.0f;
                    this.ezM.setFloatValues(x, 0.0f);
                    this.ezM.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.cvH;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.cvH = motionEvent.getRawX();
                    return true;
                }
                if (this.ezL * rawX < 0.0f) {
                    this.ezL += rawX;
                } else {
                    this.ezL += rawX * this.mRatio;
                }
                this.cvH = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.ezK) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.ezL > i2) {
                        this.ezL = i * i2;
                        this.cvH = motionEvent.getRawX();
                    } else if (i * this.ezL < 0.0f) {
                        this.ezL = 0.0f;
                        this.cvH = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.ezL);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bhO() {
        if (this.ezM == null) {
            this.ezM = new ValueAnimator();
            this.ezM.setDuration(200L);
            this.ezM.setInterpolator(new DecelerateInterpolator());
            this.ezM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.ezJ) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.ezJ = i;
            this.mRatio = (1.0f * this.ezJ) / this.mScreenWidth;
        }
    }
}
