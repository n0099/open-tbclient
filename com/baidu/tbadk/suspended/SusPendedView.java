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
    private float bGT;
    private float bGV;
    private LinearLayout fLH;
    private TranView fLI;
    private a fLJ;
    private ValueAnimator fLK;
    private int fLL;
    private int fLM;
    private boolean fyn;
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
        this.fLM = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.fLL = l.getEquipmentHeight(context);
        this.fLK = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.fLK.setDuration(300L);
        this.fLK.setInterpolator(new LinearInterpolator());
        this.fLK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.suspended.SusPendedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SusPendedView.this.fLL = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SusPendedView.this.mRatio = 1.0f - (SusPendedView.this.fLL / l.getEquipmentHeight(SusPendedView.this.getContext()));
                if (SusPendedView.this.fLL == 0) {
                    SusPendedView.this.mRatio = 1.0f;
                } else if (SusPendedView.this.fLL == l.getEquipmentHeight(SusPendedView.this.getContext())) {
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
            this.fLK.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fLK == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.fLL == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bGT > this.bGV && this.fyn) {
                this.fLH.layout(i, (int) (this.bGT - this.bGV), i3, ((int) (this.bGT - this.bGV)) + this.fLH.getHeight());
                this.mContentView.layout(i, ((int) (this.bGT - this.bGV)) + this.fLH.getHeight(), i3, i4);
            }
        } else {
            this.fLH.layout(i, this.fLL, i3, this.fLL + this.fLH.getMeasuredHeight());
            this.mContentView.layout(i, this.fLL + this.fLH.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.fLI != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.fLI == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fLK.isRunning()) {
            this.fLK.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bGT = motionEvent.getRawY();
                if (bEH()) {
                    this.bGV = motionEvent.getRawY();
                    z = false;
                    break;
                } else {
                    this.bGV = 0.0f;
                    z = false;
                    break;
                }
            case 1:
            case 3:
                z = this.bGT > this.bGV && bEH();
                this.mIsFinish = this.bGT - this.bGV > ((float) this.fLM) && bEH();
                if (this.mIsFinish) {
                    this.fLK.setIntValues((int) (this.bGT - this.bGV), l.getEquipmentHeight(getContext()));
                    this.fLK.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.bGV = 0.0f;
                    this.bGT = this.bGV;
                    requestLayout();
                    break;
                }
                break;
            case 2:
                this.bGT = motionEvent.getRawY();
                if (this.bGV == 0.0f && bEH()) {
                    this.bGV = motionEvent.getRawY();
                }
                this.mRatio = 1.0f - ((this.bGT - this.bGV) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bGT > this.bGV && bEH()) {
            this.fyn = true;
            requestLayout();
            return true;
        } else if (z) {
            this.fyn = true;
            return true;
        } else {
            this.fyn = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.fLK.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.fLK.start();
    }

    public void onDestroy() {
        this.fLK.cancel();
        this.fLK.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        this.fLH = linearLayout;
    }

    public void setContentViewTop(a aVar) {
        this.fLJ = aVar;
    }

    public boolean bEH() {
        if (this.fLJ == null) {
            return false;
        }
        return this.fLJ.bEH();
    }

    public void setTranView(TranView tranView) {
        this.fLI = tranView;
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
