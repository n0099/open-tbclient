package com.baidu.tieba.frs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SmartBubbleAnimatedView extends View {
    private float bVV;
    Rect dbd;
    public String dcH;
    public long gni;
    private ValueAnimator gnj;
    private a gnk;
    private int gnl;
    private boolean gnm;
    RectF jE;
    private ValueAnimator mAnimator;
    private Paint mPaint;
    private Paint mTextPaint;

    /* loaded from: classes.dex */
    public interface a {
        void aFm();
    }

    public void setExtrusionRemind(boolean z) {
        this.gnm = z;
    }

    public void setOnBubbleAnimateListener(a aVar) {
        this.gnk = aVar;
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.gni = 4000L;
        this.bVV = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.jE = new RectF();
        this.dbd = new Rect();
        this.gnm = false;
        a((AttributeSet) null, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gni = 4000L;
        this.bVV = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.jE = new RectF();
        this.dbd = new Rect();
        this.gnm = false;
        a(attributeSet, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gni = 4000L;
        this.bVV = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.jE = new RectF();
        this.dbd = new Rect();
        this.gnm = false;
        a(attributeSet, i);
    }

    public void bDk() {
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.gnm) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).topMargin = 20;
                setLayoutParams(layoutParams);
            }
        }
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams2 = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams2.height = com.baidu.adp.lib.util.l.getDimens(SmartBubbleAnimatedView.this.getContext(), R.dimen.tbds83);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.bVV = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (SmartBubbleAnimatedView.this.gnm && (layoutParams2 instanceof LinearLayout.LayoutParams)) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                    if (layoutParams3.topMargin > 0) {
                        layoutParams3.topMargin -= 5;
                    }
                    if (layoutParams3.topMargin < 0) {
                        layoutParams3.topMargin = 0;
                    }
                }
                SmartBubbleAnimatedView.this.setLayoutParams(layoutParams2);
                SmartBubbleAnimatedView.this.requestLayout();
            }
        });
        this.mAnimator.setDuration(400L);
        this.mAnimator.start();
        com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.2
            @Override // java.lang.Runnable
            public void run() {
                SmartBubbleAnimatedView.this.bDl();
            }
        }, this.gni);
    }

    public void bDl() {
        if (this.gnm) {
            if (this.gnk != null) {
                this.gnk.aFm();
                return;
            }
            return;
        }
        this.gnj = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.gnj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * layoutParams.height);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
                SmartBubbleAnimatedView.this.requestLayout();
            }
        });
        this.gnj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SmartBubbleAnimatedView.this.gnk != null) {
                    SmartBubbleAnimatedView.this.gnk.aFm();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (SmartBubbleAnimatedView.this.gnk != null) {
                    SmartBubbleAnimatedView.this.gnk.aFm();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gnj.setDuration(300L);
        this.gnj.start();
    }

    private void a(AttributeSet attributeSet, int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a));
        this.mTextPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds40));
        this.gnl = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds83);
    }

    public void onChangeSkinType(int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a));
        this.mTextPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds40));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height = ((1.0f - this.bVV) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.bVV * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.bVV * getHeight()) / 2.0f);
        this.jE.set(((1.0f - this.bVV) * getWidth()) / 2.0f, height, width, height2);
        canvas.drawRoundRect(this.jE, (height2 - height) / 2.0f, (height2 - height) / 2.0f, this.mPaint);
        this.mTextPaint.getTextBounds(this.dcH, 0, this.dcH.length(), this.dbd);
        canvas.drawText(this.dcH, 0, this.dcH.length(), (getWidth() - this.dbd.width()) / 2, getHeight() - ((getHeight() - this.dbd.height()) / 2), this.mTextPaint);
    }

    public int getTipViewHeight() {
        return this.gnl;
    }
}
