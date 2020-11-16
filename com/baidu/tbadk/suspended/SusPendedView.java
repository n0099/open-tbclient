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
    private float byb;
    private float byd;
    private boolean fjA;
    private LinearLayout fwJ;
    private TranView fwK;
    private a fwL;
    private ValueAnimator fwM;
    private int fwN;
    private int fwO;
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
        this.fwO = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.fwN = l.getEquipmentHeight(context);
        this.fwM = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.fwM.setDuration(300L);
        this.fwM.setInterpolator(new LinearInterpolator());
        this.fwM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.suspended.SusPendedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SusPendedView.this.fwN = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SusPendedView.this.mRatio = 1.0f - (SusPendedView.this.fwN / l.getEquipmentHeight(SusPendedView.this.getContext()));
                if (SusPendedView.this.fwN == 0) {
                    SusPendedView.this.mRatio = 1.0f;
                } else if (SusPendedView.this.fwN == l.getEquipmentHeight(SusPendedView.this.getContext())) {
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
            this.fwM.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fwM == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.fwN == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.byb > this.byd && this.fjA) {
                this.fwJ.layout(i, (int) (this.byb - this.byd), i3, ((int) (this.byb - this.byd)) + this.fwJ.getHeight());
                this.mContentView.layout(i, ((int) (this.byb - this.byd)) + this.fwJ.getHeight(), i3, i4);
            }
        } else {
            this.fwJ.layout(i, this.fwN, i3, this.fwN + this.fwJ.getMeasuredHeight());
            this.mContentView.layout(i, this.fwN + this.fwJ.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.fwK != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.fwK == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fwM.isRunning()) {
            this.fwM.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.byb = motionEvent.getRawY();
                if (bCk()) {
                    this.byd = motionEvent.getRawY();
                    z = false;
                    break;
                } else {
                    this.byd = 0.0f;
                    z = false;
                    break;
                }
            case 1:
            case 3:
                z = this.byb > this.byd && bCk();
                this.mIsFinish = this.byb - this.byd > ((float) this.fwO) && bCk();
                if (this.mIsFinish) {
                    this.fwM.setIntValues((int) (this.byb - this.byd), l.getEquipmentHeight(getContext()));
                    this.fwM.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.byd = 0.0f;
                    this.byb = this.byd;
                    requestLayout();
                    break;
                }
                break;
            case 2:
                this.byb = motionEvent.getRawY();
                if (this.byd == 0.0f && bCk()) {
                    this.byd = motionEvent.getRawY();
                }
                this.mRatio = 1.0f - ((this.byb - this.byd) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.byb > this.byd && bCk()) {
            this.fjA = true;
            requestLayout();
            return true;
        } else if (z) {
            this.fjA = true;
            return true;
        } else {
            this.fjA = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.fwM.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.fwM.start();
    }

    public void onDestroy() {
        this.fwM.cancel();
        this.fwM.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        this.fwJ = linearLayout;
    }

    public void setContentViewTop(a aVar) {
        this.fwL = aVar;
    }

    public boolean bCk() {
        if (this.fwL == null) {
            return false;
        }
        return this.fwL.bCk();
    }

    public void setTranView(TranView tranView) {
        this.fwK = tranView;
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
