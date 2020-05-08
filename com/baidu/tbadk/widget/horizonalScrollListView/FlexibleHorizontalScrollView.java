package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float ckd;
    private int ele;
    private int elf;
    private float elg;
    private ValueAnimator elh;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.ele = 150;
        this.elg = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ele = 150;
        this.elg = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.elf = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.elf && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.ele;
        bbD();
        switch (action) {
            case 0:
                if (this.elh.isRunning()) {
                    this.elh.cancel();
                }
                this.ckd = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.elg = 0.0f;
                    this.ckd = 0.0f;
                    this.elh.setFloatValues(x, 0.0f);
                    this.elh.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.ckd;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.ckd = motionEvent.getRawX();
                    return true;
                }
                if (this.elg * rawX < 0.0f) {
                    this.elg += rawX;
                } else {
                    this.elg += rawX * this.mRatio;
                }
                this.ckd = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.elf) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.elg > i2) {
                        this.elg = i * i2;
                        this.ckd = motionEvent.getRawX();
                    } else if (i * this.elg < 0.0f) {
                        this.elg = 0.0f;
                        this.ckd = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.elg);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bbD() {
        if (this.elh == null) {
            this.elh = new ValueAnimator();
            this.elh.setDuration(200L);
            this.elh.setInterpolator(new DecelerateInterpolator());
            this.elh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.ele) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.ele = i;
            this.mRatio = (1.0f * this.ele) / this.mScreenWidth;
        }
    }
}
