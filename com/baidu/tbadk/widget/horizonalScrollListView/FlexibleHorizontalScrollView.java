package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes2.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float cLu;
    private int fal;
    private int fam;
    private float fan;
    private ValueAnimator fao;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.fal = 150;
        this.fan = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fal = 150;
        this.fan = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.fam = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.fam && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.fal;
        alC();
        switch (action) {
            case 0:
                if (this.fao.isRunning()) {
                    this.fao.cancel();
                }
                this.cLu = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.fan = 0.0f;
                    this.cLu = 0.0f;
                    this.fao.setFloatValues(x, 0.0f);
                    this.fao.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.cLu;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.cLu = motionEvent.getRawX();
                    return true;
                }
                if (this.fan * rawX < 0.0f) {
                    this.fan += rawX;
                } else {
                    this.fan += rawX * this.mRatio;
                }
                this.cLu = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.fam) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.fan > i2) {
                        this.fan = i * i2;
                        this.cLu = motionEvent.getRawX();
                    } else if (i * this.fan < 0.0f) {
                        this.fan = 0.0f;
                        this.cLu = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.fan);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void alC() {
        if (this.fao == null) {
            this.fao = new ValueAnimator();
            this.fao.setDuration(200L);
            this.fao.setInterpolator(new DecelerateInterpolator());
            this.fao.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.fal) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.fal = i;
            this.mRatio = (1.0f * this.fal) / this.mScreenWidth;
        }
    }
}
