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
    private float bDj;
    private float bDl;
    private int fJA;
    private int fJB;
    private LinearLayout fJw;
    private TranView fJx;
    private a fJy;
    private ValueAnimator fJz;
    private boolean fvX;
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
        this.fJB = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.fJA = l.getEquipmentHeight(context);
        this.fJz = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.fJz.setDuration(300L);
        this.fJz.setInterpolator(new LinearInterpolator());
        this.fJz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.suspended.SusPendedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SusPendedView.this.fJA = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SusPendedView.this.mRatio = 1.0f - (SusPendedView.this.fJA / l.getEquipmentHeight(SusPendedView.this.getContext()));
                if (SusPendedView.this.fJA == 0) {
                    SusPendedView.this.mRatio = 1.0f;
                } else if (SusPendedView.this.fJA == l.getEquipmentHeight(SusPendedView.this.getContext())) {
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
            this.fJz.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fJz == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.fJA == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bDj > this.bDl && this.fvX) {
                this.fJw.layout(i, (int) (this.bDj - this.bDl), i3, ((int) (this.bDj - this.bDl)) + this.fJw.getHeight());
                this.mContentView.layout(i, ((int) (this.bDj - this.bDl)) + this.fJw.getHeight(), i3, i4);
            }
        } else {
            this.fJw.layout(i, this.fJA, i3, this.fJA + this.fJw.getMeasuredHeight());
            this.mContentView.layout(i, this.fJA + this.fJw.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.fJx != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.fJx == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fJz.isRunning()) {
            this.fJz.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bDj = motionEvent.getRawY();
                if (bEp()) {
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
                z = this.bDj > this.bDl && bEp();
                this.mIsFinish = this.bDj - this.bDl > ((float) this.fJB) && bEp();
                if (this.mIsFinish) {
                    this.fJz.setIntValues((int) (this.bDj - this.bDl), l.getEquipmentHeight(getContext()));
                    this.fJz.start();
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
                if (this.bDl == 0.0f && bEp()) {
                    this.bDl = motionEvent.getRawY();
                }
                this.mRatio = 1.0f - ((this.bDj - this.bDl) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bDj > this.bDl && bEp()) {
            this.fvX = true;
            requestLayout();
            return true;
        } else if (z) {
            this.fvX = true;
            return true;
        } else {
            this.fvX = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.fJz.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.fJz.start();
    }

    public void onDestroy() {
        this.fJz.cancel();
        this.fJz.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        this.fJw = linearLayout;
    }

    public void setContentViewTop(a aVar) {
        this.fJy = aVar;
    }

    public boolean bEp() {
        if (this.fJy == null) {
            return false;
        }
        return this.fJy.bEp();
    }

    public void setTranView(TranView tranView) {
        this.fJx = tranView;
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
