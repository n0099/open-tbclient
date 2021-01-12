package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float duh;
    private int fPY;
    private int fPZ;
    private float fQa;
    private ValueAnimator fQb;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.fPY = 150;
        this.fQa = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fPY = 150;
        this.fQa = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.fPZ = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.fPZ && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.fPY;
        ats();
        switch (action) {
            case 0:
                if (this.fQb.isRunning()) {
                    this.fQb.cancel();
                }
                this.duh = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.fQa = 0.0f;
                    this.duh = 0.0f;
                    this.fQb.setFloatValues(x, 0.0f);
                    this.fQb.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.duh;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.duh = motionEvent.getRawX();
                    return true;
                }
                if (this.fQa * rawX < 0.0f) {
                    this.fQa += rawX;
                } else {
                    this.fQa += rawX * this.mRatio;
                }
                this.duh = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.fPZ) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.fQa > i2) {
                        this.fQa = i * i2;
                        this.duh = motionEvent.getRawX();
                    } else if (i * this.fQa < 0.0f) {
                        this.fQa = 0.0f;
                        this.duh = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.fQa);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void ats() {
        if (this.fQb == null) {
            this.fQb = new ValueAnimator();
            this.fQb.setDuration(200L);
            this.fQb.setInterpolator(new DecelerateInterpolator());
            this.fQb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.fPY) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.fPY = i;
            this.mRatio = (1.0f * this.fPY) / this.mScreenWidth;
        }
    }
}
