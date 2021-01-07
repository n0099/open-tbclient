package com.baidu.tbadk.suspended;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SusPendedView extends LinearLayout {
    private float bHV;
    private float bHX;
    private boolean fAF;
    private LinearLayout fOd;
    private TranView fOe;
    private a fOf;
    private ValueAnimator fOg;
    private int fOh;
    private int fOi;
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
        this.fOi = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.fOh = l.getEquipmentHeight(context);
        this.fOg = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.fOg.setDuration(300L);
        this.fOg.setInterpolator(new LinearInterpolator());
        this.fOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.suspended.SusPendedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SusPendedView.this.fOh = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SusPendedView.this.mRatio = 1.0f - (SusPendedView.this.fOh / l.getEquipmentHeight(SusPendedView.this.getContext()));
                if (SusPendedView.this.fOh == 0) {
                    SusPendedView.this.mRatio = 1.0f;
                } else if (SusPendedView.this.fOh == l.getEquipmentHeight(SusPendedView.this.getContext())) {
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
            this.fOg.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fOg == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.fOh == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bHV > this.bHX && this.fAF) {
                this.fOd.layout(i, (int) (this.bHV - this.bHX), i3, ((int) (this.bHV - this.bHX)) + this.fOd.getHeight());
                this.mContentView.layout(i, ((int) (this.bHV - this.bHX)) + this.fOd.getHeight(), i3, i4);
            }
        } else {
            this.fOd.layout(i, this.fOh, i3, this.fOh + this.fOd.getMeasuredHeight());
            this.mContentView.layout(i, this.fOh + this.fOd.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.fOe != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.fOe == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fOg.isRunning()) {
            this.fOg.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bHV = motionEvent.getRawY();
                if (bIh()) {
                    this.bHX = motionEvent.getRawY();
                    z = false;
                    break;
                } else {
                    this.bHX = 0.0f;
                    z = false;
                    break;
                }
            case 1:
            case 3:
                z = this.bHV > this.bHX && bIh();
                this.mIsFinish = this.bHV - this.bHX > ((float) this.fOi) && bIh();
                if (this.mIsFinish) {
                    this.fOg.setIntValues((int) (this.bHV - this.bHX), l.getEquipmentHeight(getContext()));
                    this.fOg.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.bHX = 0.0f;
                    this.bHV = this.bHX;
                    requestLayout();
                    break;
                }
                break;
            case 2:
                this.bHV = motionEvent.getRawY();
                if (this.bHX == 0.0f && bIh()) {
                    this.bHX = motionEvent.getRawY();
                }
                this.mRatio = 1.0f - ((this.bHV - this.bHX) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bHV > this.bHX && bIh()) {
            this.fAF = true;
            requestLayout();
            return true;
        } else if (z) {
            this.fAF = true;
            return true;
        } else {
            this.fAF = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.fOg.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.fOg.start();
    }

    public void onDestroy() {
        this.fOg.cancel();
        this.fOg.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        this.fOd = linearLayout;
    }

    public void setContentViewTop(a aVar) {
        this.fOf = aVar;
    }

    public boolean bIh() {
        if (this.fOf == null) {
            return false;
        }
        return this.fOf.bIh();
    }

    public void setTranView(TranView tranView) {
        this.fOe = tranView;
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
