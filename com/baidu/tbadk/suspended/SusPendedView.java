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
/* loaded from: classes2.dex */
public class SusPendedView extends LinearLayout {
    private float bkL;
    private float bkN;
    private boolean eHL;
    private LinearLayout eTX;
    private TranView eTY;
    private a eTZ;
    private ValueAnimator eUa;
    private int eUb;
    private int eUc;
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
        this.eUc = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.eUb = l.getEquipmentHeight(context);
        this.eUa = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.eUa.setDuration(300L);
        this.eUa.setInterpolator(new LinearInterpolator());
        this.eUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.suspended.SusPendedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SusPendedView.this.eUb = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SusPendedView.this.mRatio = 1.0f - (SusPendedView.this.eUb / l.getEquipmentHeight(SusPendedView.this.getContext()));
                if (SusPendedView.this.eUb == 0) {
                    SusPendedView.this.mRatio = 1.0f;
                } else if (SusPendedView.this.eUb == l.getEquipmentHeight(SusPendedView.this.getContext())) {
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
            this.eUa.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.eUa == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.eUb == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bkL > this.bkN) {
                this.eTX.layout(i, (int) (this.bkL - this.bkN), i3, ((int) (this.bkL - this.bkN)) + this.eTX.getHeight());
                this.mContentView.layout(i, ((int) (this.bkL - this.bkN)) + this.eTX.getHeight(), i3, i4);
            }
        } else {
            this.eTX.layout(i, this.eUb, i3, this.eUb + this.eTX.getMeasuredHeight());
            this.mContentView.layout(i, this.eUb + this.eTX.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.eTY != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.eTY == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.eUa.isRunning()) {
            this.eUa.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bkL = motionEvent.getRawY();
                if (buK()) {
                    this.bkN = motionEvent.getRawY();
                    z = false;
                    break;
                } else {
                    this.bkN = 0.0f;
                    z = false;
                    break;
                }
            case 1:
            case 3:
                z = this.bkL > this.bkN && buK();
                this.mIsFinish = this.bkL - this.bkN > ((float) this.eUc) && buK();
                if (this.mIsFinish) {
                    this.eUa.setIntValues((int) (this.bkL - this.bkN), l.getEquipmentHeight(getContext()));
                    this.eUa.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.bkN = 0.0f;
                    this.bkL = this.bkN;
                    requestLayout();
                    break;
                }
                break;
            case 2:
                this.bkL = motionEvent.getRawY();
                if (this.bkN == 0.0f && buK()) {
                    this.bkN = motionEvent.getRawY();
                }
                this.mRatio = 1.0f - ((this.bkL - this.bkN) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bkL > this.bkN && buK()) {
            this.eHL = true;
            requestLayout();
            return true;
        } else if (z) {
            this.eHL = true;
            return true;
        } else {
            this.eHL = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.eUa.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.eUa.start();
    }

    public void onDestroy() {
        this.eUa.cancel();
        this.eUa.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        this.eTX = linearLayout;
    }

    public void setContentViewTop(a aVar) {
        this.eTZ = aVar;
    }

    public boolean buK() {
        if (this.eTZ == null) {
            return false;
        }
        return this.eTZ.buK();
    }

    public void setTranView(TranView tranView) {
        this.eTY = tranView;
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
