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
    private float beH;
    private float beJ;
    private LinearLayout eDc;
    private TranView eDd;
    private a eDe;
    private ValueAnimator eDf;
    private int eDg;
    private int eDh;
    private boolean eqS;
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
        this.eDh = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.eDg = l.getEquipmentHeight(context);
        this.eDf = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.eDf.setDuration(300L);
        this.eDf.setInterpolator(new LinearInterpolator());
        this.eDf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.suspended.SusPendedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SusPendedView.this.eDg = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SusPendedView.this.mRatio = 1.0f - (SusPendedView.this.eDg / l.getEquipmentHeight(SusPendedView.this.getContext()));
                if (SusPendedView.this.eDg == 0) {
                    SusPendedView.this.mRatio = 1.0f;
                } else if (SusPendedView.this.eDg == l.getEquipmentHeight(SusPendedView.this.getContext())) {
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
            this.eDf.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.eDf == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.eDg == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.beH > this.beJ) {
                this.eDc.layout(i, (int) (this.beH - this.beJ), i3, ((int) (this.beH - this.beJ)) + this.eDc.getHeight());
                this.mContentView.layout(i, ((int) (this.beH - this.beJ)) + this.eDc.getHeight(), i3, i4);
            }
        } else {
            this.eDc.layout(i, this.eDg, i3, this.eDg + this.eDc.getMeasuredHeight());
            this.mContentView.layout(i, this.eDg + this.eDc.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.eDd != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.eDd == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.eDf.isRunning()) {
            this.eDf.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.beH = motionEvent.getRawY();
                if (bim()) {
                    this.beJ = motionEvent.getRawY();
                    z = false;
                    break;
                } else {
                    this.beJ = 0.0f;
                    z = false;
                    break;
                }
            case 1:
            case 3:
                z = this.beH > this.beJ && bim();
                this.mIsFinish = this.beH - this.beJ > ((float) this.eDh) && bim();
                if (this.mIsFinish) {
                    this.eDf.setIntValues((int) (this.beH - this.beJ), l.getEquipmentHeight(getContext()));
                    this.eDf.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.beJ = 0.0f;
                    this.beH = this.beJ;
                    requestLayout();
                    break;
                }
                break;
            case 2:
                this.beH = motionEvent.getRawY();
                if (this.beJ == 0.0f && bim()) {
                    this.beJ = motionEvent.getRawY();
                }
                this.mRatio = 1.0f - ((this.beH - this.beJ) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.beH > this.beJ && bim()) {
            this.eqS = true;
            requestLayout();
            return true;
        } else if (z) {
            this.eqS = true;
            return true;
        } else {
            this.eqS = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.eDf.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.eDf.start();
    }

    public void onDestroy() {
        this.eDf.cancel();
        this.eDf.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        this.eDc = linearLayout;
    }

    public void setContentViewTop(a aVar) {
        this.eDe = aVar;
    }

    public boolean bim() {
        if (this.eDe == null) {
            return false;
        }
        return this.eDe.bim();
    }

    public void setTranView(TranView tranView) {
        this.eDd = tranView;
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
