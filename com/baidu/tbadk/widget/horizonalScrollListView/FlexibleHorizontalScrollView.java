package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float bcZ;
    private int cSa;
    private int cSb;
    private float cSc;
    private ValueAnimator cSd;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.cSa = 150;
        this.cSc = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cSa = 150;
        this.cSc = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.cSb = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.cSb && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.cSa;
        ayF();
        switch (action) {
            case 0:
                if (this.cSd.isRunning()) {
                    this.cSd.cancel();
                }
                this.bcZ = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.cSc = 0.0f;
                    this.bcZ = 0.0f;
                    this.cSd.setFloatValues(x, 0.0f);
                    this.cSd.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.bcZ;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.bcZ = motionEvent.getRawX();
                    return true;
                }
                if (this.cSc * rawX < 0.0f) {
                    this.cSc += rawX;
                } else {
                    this.cSc += rawX * this.mRatio;
                }
                this.bcZ = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.cSb) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.cSc > i2) {
                        this.cSc = i * i2;
                        this.bcZ = motionEvent.getRawX();
                    } else if (i * this.cSc < 0.0f) {
                        this.cSc = 0.0f;
                        this.bcZ = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.cSc);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void ayF() {
        if (this.cSd == null) {
            this.cSd = new ValueAnimator();
            this.cSd.setDuration(200L);
            this.cSd.setInterpolator(new DecelerateInterpolator());
            this.cSd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.cSa) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.cSa = i;
            this.mRatio = (1.0f * this.cSa) / this.mScreenWidth;
        }
    }
}
