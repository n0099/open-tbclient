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
    private float btA;
    private float btC;
    private boolean fez;
    private LinearLayout frC;
    private TranView frD;
    private a frE;
    private ValueAnimator frF;
    private int frG;
    private int frH;
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
        this.frH = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.frG = l.getEquipmentHeight(context);
        this.frF = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.frF.setDuration(300L);
        this.frF.setInterpolator(new LinearInterpolator());
        this.frF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.suspended.SusPendedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SusPendedView.this.frG = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SusPendedView.this.mRatio = 1.0f - (SusPendedView.this.frG / l.getEquipmentHeight(SusPendedView.this.getContext()));
                if (SusPendedView.this.frG == 0) {
                    SusPendedView.this.mRatio = 1.0f;
                } else if (SusPendedView.this.frG == l.getEquipmentHeight(SusPendedView.this.getContext())) {
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
            this.frF.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.frF == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.frG == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.btA > this.btC) {
                this.frC.layout(i, (int) (this.btA - this.btC), i3, ((int) (this.btA - this.btC)) + this.frC.getHeight());
                this.mContentView.layout(i, ((int) (this.btA - this.btC)) + this.frC.getHeight(), i3, i4);
            }
        } else {
            this.frC.layout(i, this.frG, i3, this.frG + this.frC.getMeasuredHeight());
            this.mContentView.layout(i, this.frG + this.frC.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.frD != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.frD == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.frF.isRunning()) {
            this.frF.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.btA = motionEvent.getRawY();
                if (bAs()) {
                    this.btC = motionEvent.getRawY();
                    z = false;
                    break;
                } else {
                    this.btC = 0.0f;
                    z = false;
                    break;
                }
            case 1:
            case 3:
                z = this.btA > this.btC && bAs();
                this.mIsFinish = this.btA - this.btC > ((float) this.frH) && bAs();
                if (this.mIsFinish) {
                    this.frF.setIntValues((int) (this.btA - this.btC), l.getEquipmentHeight(getContext()));
                    this.frF.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.btC = 0.0f;
                    this.btA = this.btC;
                    requestLayout();
                    break;
                }
                break;
            case 2:
                this.btA = motionEvent.getRawY();
                if (this.btC == 0.0f && bAs()) {
                    this.btC = motionEvent.getRawY();
                }
                this.mRatio = 1.0f - ((this.btA - this.btC) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.btA > this.btC && bAs()) {
            this.fez = true;
            requestLayout();
            return true;
        } else if (z) {
            this.fez = true;
            return true;
        } else {
            this.fez = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.frF.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.frF.start();
    }

    public void onDestroy() {
        this.frF.cancel();
        this.frF.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        this.frC = linearLayout;
    }

    public void setContentViewTop(a aVar) {
        this.frE = aVar;
    }

    public boolean bAs() {
        if (this.frE == null) {
            return false;
        }
        return this.frE.bAs();
    }

    public void setTranView(TranView tranView) {
        this.frD = tranView;
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
