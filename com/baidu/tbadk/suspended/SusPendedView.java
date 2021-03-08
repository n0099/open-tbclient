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
    private float bIt;
    private float bIv;
    private LinearLayout fNh;
    private TranView fNi;
    private a fNj;
    private ValueAnimator fNk;
    private int fNl;
    private int fNm;
    private boolean fzM;
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
        this.fNm = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.fNl = l.getEquipmentHeight(context);
        this.fNk = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.fNk.setDuration(300L);
        this.fNk.setInterpolator(new LinearInterpolator());
        this.fNk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.suspended.SusPendedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SusPendedView.this.fNl = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SusPendedView.this.mRatio = 1.0f - (SusPendedView.this.fNl / l.getEquipmentHeight(SusPendedView.this.getContext()));
                if (SusPendedView.this.fNl == 0) {
                    SusPendedView.this.mRatio = 1.0f;
                } else if (SusPendedView.this.fNl == l.getEquipmentHeight(SusPendedView.this.getContext())) {
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
            this.fNk.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fNk == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.fNl == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bIt > this.bIv && this.fzM) {
                this.fNh.layout(i, (int) (this.bIt - this.bIv), i3, ((int) (this.bIt - this.bIv)) + this.fNh.getHeight());
                this.mContentView.layout(i, ((int) (this.bIt - this.bIv)) + this.fNh.getHeight(), i3, i4);
            }
        } else {
            this.fNh.layout(i, this.fNl, i3, this.fNl + this.fNh.getMeasuredHeight());
            this.mContentView.layout(i, this.fNl + this.fNh.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.fNi != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.fNi == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fNk.isRunning()) {
            this.fNk.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bIt = motionEvent.getRawY();
                if (bEL()) {
                    this.bIv = motionEvent.getRawY();
                    z = false;
                    break;
                } else {
                    this.bIv = 0.0f;
                    z = false;
                    break;
                }
            case 1:
            case 3:
                z = this.bIt > this.bIv && bEL();
                this.mIsFinish = this.bIt - this.bIv > ((float) this.fNm) && bEL();
                if (this.mIsFinish) {
                    this.fNk.setIntValues((int) (this.bIt - this.bIv), l.getEquipmentHeight(getContext()));
                    this.fNk.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.bIv = 0.0f;
                    this.bIt = this.bIv;
                    requestLayout();
                    break;
                }
                break;
            case 2:
                this.bIt = motionEvent.getRawY();
                if (this.bIv == 0.0f && bEL()) {
                    this.bIv = motionEvent.getRawY();
                }
                this.mRatio = 1.0f - ((this.bIt - this.bIv) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bIt > this.bIv && bEL()) {
            this.fzM = true;
            requestLayout();
            return true;
        } else if (z) {
            this.fzM = true;
            return true;
        } else {
            this.fzM = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.fNk.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.fNk.start();
    }

    public void onDestroy() {
        this.fNk.cancel();
        this.fNk.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        this.fNh = linearLayout;
    }

    public void setContentViewTop(a aVar) {
        this.fNj = aVar;
    }

    public boolean bEL() {
        if (this.fNj == null) {
            return false;
        }
        return this.fNj.bEL();
    }

    public void setTranView(TranView tranView) {
        this.fNi = tranView;
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
