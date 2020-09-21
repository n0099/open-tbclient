package com.baidu.tbadk.suspended;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SusPendedView extends LinearLayout {
    private float bnH;
    private float bnJ;
    private boolean eJW;
    private LinearLayout eWR;
    private TranView eWS;
    private a eWT;
    private ValueAnimator eWU;
    private int eWV;
    private int eWW;
    private LinearLayout mContentView;
    private boolean mIsFinish;
    private float mRatio;

    public SusPendedView(Context context) {
        this(context, null);
    }

    public SusPendedView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SusPendedView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRatio = 0.0f;
        this.eWW = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.eWV = l.getEquipmentHeight(context);
        this.eWU = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.eWU.setDuration(300L);
        this.eWU.setInterpolator(new LinearInterpolator());
        this.eWU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.suspended.SusPendedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SusPendedView.this.eWV = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SusPendedView.this.mRatio = 1.0f - (SusPendedView.this.eWV / l.getEquipmentHeight(SusPendedView.this.getContext()));
                if (SusPendedView.this.eWV == 0) {
                    SusPendedView.this.mRatio = 1.0f;
                } else if (SusPendedView.this.eWV == l.getEquipmentHeight(SusPendedView.this.getContext())) {
                    SusPendedView.this.mRatio = 0.0f;
                    if (SusPendedView.this.mIsFinish && (SusPendedView.this.getContext() instanceof Activity)) {
                        ((Activity) SusPendedView.this.getContext()).finish();
                    }
                }
                SusPendedView.this.requestLayout();
            }
        });
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.eWU.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.eWU == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.eWV == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bnH > this.bnJ) {
                this.eWR.layout(i, (int) (this.bnH - this.bnJ), i3, ((int) (this.bnH - this.bnJ)) + this.eWR.getHeight());
                this.mContentView.layout(i, ((int) (this.bnH - this.bnJ)) + this.eWR.getHeight(), i3, i4);
            }
        } else {
            this.eWR.layout(i, this.eWV, i3, this.eWV + this.eWR.getMeasuredHeight());
            this.mContentView.layout(i, this.eWV + this.eWR.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.eWS != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.eWS == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.eWU.isRunning()) {
            this.eWU.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bnH = motionEvent.getRawY();
                if (bvP()) {
                    this.bnJ = motionEvent.getRawY();
                    z = false;
                    break;
                } else {
                    this.bnJ = 0.0f;
                    z = false;
                    break;
                }
            case 1:
            case 3:
                z = this.bnH > this.bnJ && bvP();
                this.mIsFinish = this.bnH - this.bnJ > ((float) this.eWW) && bvP();
                if (this.mIsFinish) {
                    this.eWU.setIntValues((int) (this.bnH - this.bnJ), l.getEquipmentHeight(getContext()));
                    this.eWU.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.bnJ = 0.0f;
                    this.bnH = this.bnJ;
                    requestLayout();
                    break;
                }
                break;
            case 2:
                this.bnH = motionEvent.getRawY();
                if (this.bnJ == 0.0f && bvP()) {
                    this.bnJ = motionEvent.getRawY();
                }
                this.mRatio = 1.0f - ((this.bnH - this.bnJ) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bnH > this.bnJ && bvP()) {
            this.eJW = true;
            requestLayout();
            return true;
        } else if (z) {
            this.eJW = true;
            return true;
        } else {
            this.eJW = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.eWU.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.eWU.start();
    }

    public void onDestroy() {
        this.eWU.cancel();
        this.eWU.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        this.eWR = linearLayout;
    }

    public void setContentViewTop(a aVar) {
        this.eWT = aVar;
    }

    public boolean bvP() {
        if (this.eWT == null) {
            return false;
        }
        return this.eWT.bvP();
    }

    public void setTranView(TranView tranView) {
        this.eWS = tranView;
    }

    public void setContentView(LinearLayout linearLayout) {
        this.mContentView = linearLayout;
    }

    public void onChangeSkinType(int i) {
    }

    public boolean getIsFinish() {
        return this.mIsFinish;
    }
}
