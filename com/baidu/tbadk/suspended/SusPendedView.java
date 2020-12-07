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
    private float bDj;
    private float bDl;
    private a fEA;
    private ValueAnimator fEB;
    private int fEC;
    private int fED;
    private LinearLayout fEy;
    private TranView fEz;
    private boolean fqY;
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
        this.fED = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.fEC = l.getEquipmentHeight(context);
        this.fEB = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.fEB.setDuration(300L);
        this.fEB.setInterpolator(new LinearInterpolator());
        this.fEB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.suspended.SusPendedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SusPendedView.this.fEC = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SusPendedView.this.mRatio = 1.0f - (SusPendedView.this.fEC / l.getEquipmentHeight(SusPendedView.this.getContext()));
                if (SusPendedView.this.fEC == 0) {
                    SusPendedView.this.mRatio = 1.0f;
                } else if (SusPendedView.this.fEC == l.getEquipmentHeight(SusPendedView.this.getContext())) {
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
            this.fEB.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fEB == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.fEC == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bDj > this.bDl && this.fqY) {
                this.fEy.layout(i, (int) (this.bDj - this.bDl), i3, ((int) (this.bDj - this.bDl)) + this.fEy.getHeight());
                this.mContentView.layout(i, ((int) (this.bDj - this.bDl)) + this.fEy.getHeight(), i3, i4);
            }
        } else {
            this.fEy.layout(i, this.fEC, i3, this.fEC + this.fEy.getMeasuredHeight());
            this.mContentView.layout(i, this.fEC + this.fEy.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.fEz != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.fEz == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fEB.isRunning()) {
            this.fEB.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bDj = motionEvent.getRawY();
                if (bFL()) {
                    this.bDl = motionEvent.getRawY();
                    z = false;
                    break;
                } else {
                    this.bDl = 0.0f;
                    z = false;
                    break;
                }
            case 1:
            case 3:
                z = this.bDj > this.bDl && bFL();
                this.mIsFinish = this.bDj - this.bDl > ((float) this.fED) && bFL();
                if (this.mIsFinish) {
                    this.fEB.setIntValues((int) (this.bDj - this.bDl), l.getEquipmentHeight(getContext()));
                    this.fEB.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.bDl = 0.0f;
                    this.bDj = this.bDl;
                    requestLayout();
                    break;
                }
                break;
            case 2:
                this.bDj = motionEvent.getRawY();
                if (this.bDl == 0.0f && bFL()) {
                    this.bDl = motionEvent.getRawY();
                }
                this.mRatio = 1.0f - ((this.bDj - this.bDl) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bDj > this.bDl && bFL()) {
            this.fqY = true;
            requestLayout();
            return true;
        } else if (z) {
            this.fqY = true;
            return true;
        } else {
            this.fqY = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.fEB.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.fEB.start();
    }

    public void onDestroy() {
        this.fEB.cancel();
        this.fEB.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        this.fEy = linearLayout;
    }

    public void setContentViewTop(a aVar) {
        this.fEA = aVar;
    }

    public boolean bFL() {
        if (this.fEA == null) {
            return false;
        }
        return this.fEA.bFL();
    }

    public void setTranView(TranView tranView) {
        this.fEz = tranView;
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
