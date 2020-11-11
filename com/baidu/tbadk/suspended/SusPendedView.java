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
    private float bzM;
    private float bzO;
    private boolean fks;
    private LinearLayout fxu;
    private TranView fxv;
    private a fxw;
    private ValueAnimator fxx;
    private int fxy;
    private int fxz;
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
        this.fxz = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.fxy = l.getEquipmentHeight(context);
        this.fxx = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.fxx.setDuration(300L);
        this.fxx.setInterpolator(new LinearInterpolator());
        this.fxx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.suspended.SusPendedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SusPendedView.this.fxy = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SusPendedView.this.mRatio = 1.0f - (SusPendedView.this.fxy / l.getEquipmentHeight(SusPendedView.this.getContext()));
                if (SusPendedView.this.fxy == 0) {
                    SusPendedView.this.mRatio = 1.0f;
                } else if (SusPendedView.this.fxy == l.getEquipmentHeight(SusPendedView.this.getContext())) {
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
            this.fxx.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fxx == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.fxy == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bzM > this.bzO) {
                this.fxu.layout(i, (int) (this.bzM - this.bzO), i3, ((int) (this.bzM - this.bzO)) + this.fxu.getHeight());
                this.mContentView.layout(i, ((int) (this.bzM - this.bzO)) + this.fxu.getHeight(), i3, i4);
            }
        } else {
            this.fxu.layout(i, this.fxy, i3, this.fxy + this.fxu.getMeasuredHeight());
            this.mContentView.layout(i, this.fxy + this.fxu.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.fxv != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.fxv == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fxx.isRunning()) {
            this.fxx.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bzM = motionEvent.getRawY();
                if (bCR()) {
                    this.bzO = motionEvent.getRawY();
                    z = false;
                    break;
                } else {
                    this.bzO = 0.0f;
                    z = false;
                    break;
                }
            case 1:
            case 3:
                z = this.bzM > this.bzO && bCR();
                this.mIsFinish = this.bzM - this.bzO > ((float) this.fxz) && bCR();
                if (this.mIsFinish) {
                    this.fxx.setIntValues((int) (this.bzM - this.bzO), l.getEquipmentHeight(getContext()));
                    this.fxx.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.bzO = 0.0f;
                    this.bzM = this.bzO;
                    requestLayout();
                    break;
                }
                break;
            case 2:
                this.bzM = motionEvent.getRawY();
                if (this.bzO == 0.0f && bCR()) {
                    this.bzO = motionEvent.getRawY();
                }
                this.mRatio = 1.0f - ((this.bzM - this.bzO) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bzM > this.bzO && bCR()) {
            this.fks = true;
            requestLayout();
            return true;
        } else if (z) {
            this.fks = true;
            return true;
        } else {
            this.fks = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.fxx.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.fxx.start();
    }

    public void onDestroy() {
        this.fxx.cancel();
        this.fxx.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        this.fxu = linearLayout;
    }

    public void setContentViewTop(a aVar) {
        this.fxw = aVar;
    }

    public boolean bCR() {
        if (this.fxw == null) {
            return false;
        }
        return this.fxw.bCR();
    }

    public void setTranView(TranView tranView) {
        this.fxv = tranView;
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
