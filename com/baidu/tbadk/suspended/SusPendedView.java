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
    private float bru;
    private float brw;
    private boolean eWd;
    private LinearLayout fjd;
    private TranView fje;
    private a fjf;
    private ValueAnimator fjg;
    private int fjh;
    private int fji;
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
        this.fji = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.fjh = l.getEquipmentHeight(context);
        this.fjg = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.fjg.setDuration(300L);
        this.fjg.setInterpolator(new LinearInterpolator());
        this.fjg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.suspended.SusPendedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SusPendedView.this.fjh = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SusPendedView.this.mRatio = 1.0f - (SusPendedView.this.fjh / l.getEquipmentHeight(SusPendedView.this.getContext()));
                if (SusPendedView.this.fjh == 0) {
                    SusPendedView.this.mRatio = 1.0f;
                } else if (SusPendedView.this.fjh == l.getEquipmentHeight(SusPendedView.this.getContext())) {
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
            this.fjg.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fjg == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.fjh == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bru > this.brw) {
                this.fjd.layout(i, (int) (this.bru - this.brw), i3, ((int) (this.bru - this.brw)) + this.fjd.getHeight());
                this.mContentView.layout(i, ((int) (this.bru - this.brw)) + this.fjd.getHeight(), i3, i4);
            }
        } else {
            this.fjd.layout(i, this.fjh, i3, this.fjh + this.fjd.getMeasuredHeight());
            this.mContentView.layout(i, this.fjh + this.fjd.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.fje != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.fje == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fjg.isRunning()) {
            this.fjg.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bru = motionEvent.getRawY();
                if (byz()) {
                    this.brw = motionEvent.getRawY();
                    z = false;
                    break;
                } else {
                    this.brw = 0.0f;
                    z = false;
                    break;
                }
            case 1:
            case 3:
                z = this.bru > this.brw && byz();
                this.mIsFinish = this.bru - this.brw > ((float) this.fji) && byz();
                if (this.mIsFinish) {
                    this.fjg.setIntValues((int) (this.bru - this.brw), l.getEquipmentHeight(getContext()));
                    this.fjg.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.brw = 0.0f;
                    this.bru = this.brw;
                    requestLayout();
                    break;
                }
                break;
            case 2:
                this.bru = motionEvent.getRawY();
                if (this.brw == 0.0f && byz()) {
                    this.brw = motionEvent.getRawY();
                }
                this.mRatio = 1.0f - ((this.bru - this.brw) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bru > this.brw && byz()) {
            this.eWd = true;
            requestLayout();
            return true;
        } else if (z) {
            this.eWd = true;
            return true;
        } else {
            this.eWd = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.fjg.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.fjg.start();
    }

    public void onDestroy() {
        this.fjg.cancel();
        this.fjg.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        this.fjd = linearLayout;
    }

    public void setContentViewTop(a aVar) {
        this.fjf = aVar;
    }

    public boolean byz() {
        if (this.fjf == null) {
            return false;
        }
        return this.fjf.byz();
    }

    public void setTranView(TranView tranView) {
        this.fje = tranView;
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
