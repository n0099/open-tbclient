package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    private float cNy;
    private int fdi;
    private int fdj;
    private float fdk;
    private ValueAnimator fdl;
    private float mRatio;
    private int mScreenWidth;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        this.fdi = 150;
        this.fdk = 0.0f;
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdi = 150;
        this.fdk = 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.fdj = i5;
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int scrollX = getScrollX();
        float x = getX();
        if (scrollX > 0 && scrollX < this.fdj && x == 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        int i2 = this.fdi;
        amm();
        switch (action) {
            case 0:
                if (this.fdl.isRunning()) {
                    this.fdl.cancel();
                }
                this.cNy = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (x != 0.0f) {
                    this.fdk = 0.0f;
                    this.cNy = 0.0f;
                    this.fdl.setFloatValues(x, 0.0f);
                    this.fdl.start();
                    return true;
                }
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.cNy;
                if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                    this.cNy = motionEvent.getRawX();
                    return true;
                }
                if (this.fdk * rawX < 0.0f) {
                    this.fdk += rawX;
                } else {
                    this.fdk += rawX * this.mRatio;
                }
                this.cNy = motionEvent.getRawX();
                if (scrollX == 0) {
                    i = 1;
                } else if (scrollX == this.fdj) {
                    i = -1;
                }
                if (i != 0) {
                    if (i * this.fdk > i2) {
                        this.fdk = i * i2;
                        this.cNy = motionEvent.getRawX();
                    } else if (i * this.fdk < 0.0f) {
                        this.fdk = 0.0f;
                        this.cNy = motionEvent.getRawX();
                        setX(0.0f);
                        return super.onTouchEvent(motionEvent);
                    }
                    setX(this.fdk);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void amm() {
        if (this.fdl == null) {
            this.fdl = new ValueAnimator();
            this.fdl.setDuration(200L);
            this.fdl.setInterpolator(new DecelerateInterpolator());
            this.fdl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlexibleHorizontalScrollView.this.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mScreenWidth == 0) {
            setOverScrollMode(2);
            this.mScreenWidth = e.getEquipmentWidth(getContext());
            this.mRatio = (1.0f * this.fdi) / this.mScreenWidth;
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i > 0) {
            this.fdi = i;
            this.mRatio = (1.0f * this.fdi) / this.mScreenWidth;
        }
    }
}
