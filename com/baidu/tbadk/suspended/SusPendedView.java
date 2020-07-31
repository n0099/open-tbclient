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
    private float bfa;
    private float bfd;
    private LinearLayout eJr;
    private TranView eJs;
    private a eJt;
    private ValueAnimator eJu;
    private int eJv;
    private int eJw;
    private boolean exk;
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
        this.eJw = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.eJv = l.getEquipmentHeight(context);
        this.eJu = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.eJu.setDuration(300L);
        this.eJu.setInterpolator(new LinearInterpolator());
        this.eJu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.suspended.SusPendedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SusPendedView.this.eJv = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SusPendedView.this.mRatio = 1.0f - (SusPendedView.this.eJv / l.getEquipmentHeight(SusPendedView.this.getContext()));
                if (SusPendedView.this.eJv == 0) {
                    SusPendedView.this.mRatio = 1.0f;
                } else if (SusPendedView.this.eJv == l.getEquipmentHeight(SusPendedView.this.getContext())) {
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
            this.eJu.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.eJu == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.eJv == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bfa > this.bfd) {
                this.eJr.layout(i, (int) (this.bfa - this.bfd), i3, ((int) (this.bfa - this.bfd)) + this.eJr.getHeight());
                this.mContentView.layout(i, ((int) (this.bfa - this.bfd)) + this.eJr.getHeight(), i3, i4);
            }
        } else {
            this.eJr.layout(i, this.eJv, i3, this.eJv + this.eJr.getMeasuredHeight());
            this.mContentView.layout(i, this.eJv + this.eJr.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.eJs != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.eJs == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.eJu.isRunning()) {
            this.eJu.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bfa = motionEvent.getRawY();
                if (blX()) {
                    this.bfd = motionEvent.getRawY();
                    z = false;
                    break;
                } else {
                    this.bfd = 0.0f;
                    z = false;
                    break;
                }
            case 1:
            case 3:
                z = this.bfa > this.bfd && blX();
                this.mIsFinish = this.bfa - this.bfd > ((float) this.eJw) && blX();
                if (this.mIsFinish) {
                    this.eJu.setIntValues((int) (this.bfa - this.bfd), l.getEquipmentHeight(getContext()));
                    this.eJu.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.bfd = 0.0f;
                    this.bfa = this.bfd;
                    requestLayout();
                    break;
                }
                break;
            case 2:
                this.bfa = motionEvent.getRawY();
                if (this.bfd == 0.0f && blX()) {
                    this.bfd = motionEvent.getRawY();
                }
                this.mRatio = 1.0f - ((this.bfa - this.bfd) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bfa > this.bfd && blX()) {
            this.exk = true;
            requestLayout();
            return true;
        } else if (z) {
            this.exk = true;
            return true;
        } else {
            this.exk = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.eJu.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.eJu.start();
    }

    public void onDestroy() {
        this.eJu.cancel();
        this.eJu.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        this.eJr = linearLayout;
    }

    public void setContentViewTop(a aVar) {
        this.eJt = aVar;
    }

    public boolean blX() {
        if (this.eJt == null) {
            return false;
        }
        return this.eJt.blX();
    }

    public void setTranView(TranView tranView) {
        this.eJs = tranView;
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
