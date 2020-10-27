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
    RectF GD;
    private float dAy;
    Rect eNx;
    public String eQa;
    public long iGs;
    private ValueAnimator iGt;
    private a iGu;
    private int iGv;
    private boolean iGw;
    private ValueAnimator mAnimator;
    private Paint mPaint;
    private Paint mTextPaint;

    /* loaded from: classes.dex */
    public interface a {
        void bql();
    }

    public void setExtrusionRemind(boolean z) {
        this.iGw = z;
    }

    public void setOnBubbleAnimateListener(a aVar) {
        this.iGu = aVar;
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.iGs = 4000L;
        this.dAy = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.GD = new RectF();
        this.eNx = new Rect();
        this.iGw = false;
        a((AttributeSet) null, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iGs = 4000L;
        this.dAy = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.GD = new RectF();
        this.eNx = new Rect();
        this.iGw = false;
        a(attributeSet, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iGs = 4000L;
        this.dAy = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.GD = new RectF();
        this.eNx = new Rect();
        this.iGw = false;
        a(attributeSet, i);
    }

    public void cyd() {
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.iGw) {
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
                SmartBubbleAnimatedView.this.dAy = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (SmartBubbleAnimatedView.this.iGw && (layoutParams2 instanceof LinearLayout.LayoutParams)) {
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
        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.2
            @Override // java.lang.Runnable
            public void run() {
                SmartBubbleAnimatedView.this.cye();
            }
        }, this.iGs);
    }

    public void cye() {
        if (this.iGw) {
            if (this.iGu != null) {
                this.iGu.bql();
                return;
            }
            return;
        }
        this.iGt = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.iGt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * layoutParams.height);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
                SmartBubbleAnimatedView.this.requestLayout();
            }
        });
        this.iGt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SmartBubbleAnimatedView.this.iGu != null) {
                    SmartBubbleAnimatedView.this.iGu.bql();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (SmartBubbleAnimatedView.this.iGu != null) {
                    SmartBubbleAnimatedView.this.iGu.bql();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iGt.setDuration(300L);
        this.iGt.start();
    }

    private void a(AttributeSet attributeSet, int i) {
        this.mPaint.setColor(com.baidu.tieba.tbadkCore.c.m(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_link_tip_a), 0.83f));
        this.mTextPaint.setColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_a));
        this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds32));
        this.iGv = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds83);
    }

    public void onChangeSkinType(int i) {
        this.mPaint.setColor(com.baidu.tieba.tbadkCore.c.m(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_link_tip_a), 0.83f));
        this.mTextPaint.setColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_a));
        this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds32));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height = ((1.0f - this.dAy) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.dAy * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.dAy * getHeight()) / 2.0f);
        this.GD.set(((1.0f - this.dAy) * getWidth()) / 2.0f, height, width, height2);
        canvas.drawRoundRect(this.GD, (height2 - height) / 2.0f, (height2 - height) / 2.0f, this.mPaint);
        this.mTextPaint.getTextBounds(this.eQa, 0, this.eQa.length(), this.eNx);
        canvas.drawText(this.eQa, 0, this.eQa.length(), (getWidth() - this.eNx.width()) / 2, getHeight() - ((getHeight() - this.eNx.height()) / 2), this.mTextPaint);
    }

    public int getTipViewHeight() {
        return this.iGv;
    }
}
