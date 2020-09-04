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
    private float bkO;
    private float bkQ;
    private boolean eHP;
    private LinearLayout eUb;
    private TranView eUc;
    private a eUd;
    private ValueAnimator eUe;
    private int eUf;
    private int eUg;
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
        this.eUg = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.eUf = l.getEquipmentHeight(context);
        this.eUe = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.eUe.setDuration(300L);
        this.eUe.setInterpolator(new LinearInterpolator());
        this.eUe.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.suspended.SusPendedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SusPendedView.this.eUf = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SusPendedView.this.mRatio = 1.0f - (SusPendedView.this.eUf / l.getEquipmentHeight(SusPendedView.this.getContext()));
                if (SusPendedView.this.eUf == 0) {
                    SusPendedView.this.mRatio = 1.0f;
                } else if (SusPendedView.this.eUf == l.getEquipmentHeight(SusPendedView.this.getContext())) {
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
            this.eUe.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.eUe == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.eUf == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bkO > this.bkQ) {
                this.eUb.layout(i, (int) (this.bkO - this.bkQ), i3, ((int) (this.bkO - this.bkQ)) + this.eUb.getHeight());
                this.mContentView.layout(i, ((int) (this.bkO - this.bkQ)) + this.eUb.getHeight(), i3, i4);
            }
        } else {
            this.eUb.layout(i, this.eUf, i3, this.eUf + this.eUb.getMeasuredHeight());
            this.mContentView.layout(i, this.eUf + this.eUb.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.eUc != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.eUc == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.eUe.isRunning()) {
            this.eUe.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bkO = motionEvent.getRawY();
                if (buL()) {
                    this.bkQ = motionEvent.getRawY();
                    z = false;
                    break;
                } else {
                    this.bkQ = 0.0f;
                    z = false;
                    break;
                }
            case 1:
            case 3:
                z = this.bkO > this.bkQ && buL();
                this.mIsFinish = this.bkO - this.bkQ > ((float) this.eUg) && buL();
                if (this.mIsFinish) {
                    this.eUe.setIntValues((int) (this.bkO - this.bkQ), l.getEquipmentHeight(getContext()));
                    this.eUe.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.bkQ = 0.0f;
                    this.bkO = this.bkQ;
                    requestLayout();
                    break;
                }
                break;
            case 2:
                this.bkO = motionEvent.getRawY();
                if (this.bkQ == 0.0f && buL()) {
                    this.bkQ = motionEvent.getRawY();
                }
                this.mRatio = 1.0f - ((this.bkO - this.bkQ) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bkO > this.bkQ && buL()) {
            this.eHP = true;
            requestLayout();
            return true;
        } else if (z) {
            this.eHP = true;
            return true;
        } else {
            this.eHP = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.eUe.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.eUe.start();
    }

    public void onDestroy() {
        this.eUe.cancel();
        this.eUe.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        this.eUb = linearLayout;
    }

    public void setContentViewTop(a aVar) {
        this.eUd = aVar;
    }

    public boolean buL() {
        if (this.eUd == null) {
            return false;
        }
        return this.eUd.buL();
    }

    public void setTranView(TranView tranView) {
        this.eUc = tranView;
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
