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
    private Paint bWt;
    Rect bYb;
    public String bZO;
    public long ftf;
    private float ftg;
    private ValueAnimator fth;
    private a fti;
    private int ftj;
    private boolean ftk;
    private ValueAnimator mAnimator;
    private Paint mPaint;
    RectF qc;

    /* loaded from: classes.dex */
    public interface a {
        void ajO();
    }

    public void setExtrusionRemind(boolean z) {
        this.ftk = z;
    }

    public void setOnBubbleAnimateListener(a aVar) {
        this.fti = aVar;
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.ftf = 4000L;
        this.ftg = 0.0f;
        this.mPaint = new Paint();
        this.bWt = new Paint();
        this.qc = new RectF();
        this.bYb = new Rect();
        this.ftk = false;
        a((AttributeSet) null, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ftf = 4000L;
        this.ftg = 0.0f;
        this.mPaint = new Paint();
        this.bWt = new Paint();
        this.qc = new RectF();
        this.bYb = new Rect();
        this.ftk = false;
        a(attributeSet, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ftf = 4000L;
        this.ftg = 0.0f;
        this.mPaint = new Paint();
        this.bWt = new Paint();
        this.qc = new RectF();
        this.bYb = new Rect();
        this.ftk = false;
        a(attributeSet, i);
    }

    public void blN() {
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.ftk) {
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
                layoutParams2.height = com.baidu.adp.lib.util.l.g(SmartBubbleAnimatedView.this.getContext(), R.dimen.tbds83);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.ftg = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (SmartBubbleAnimatedView.this.ftk && (layoutParams2 instanceof LinearLayout.LayoutParams)) {
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
        com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.2
            @Override // java.lang.Runnable
            public void run() {
                SmartBubbleAnimatedView.this.blO();
            }
        }, this.ftf);
    }

    public void blO() {
        if (this.ftk) {
            if (this.fti != null) {
                this.fti.ajO();
                return;
            }
            return;
        }
        this.fth = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fth.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * layoutParams.height);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
                SmartBubbleAnimatedView.this.requestLayout();
            }
        });
        this.fth.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SmartBubbleAnimatedView.this.fti != null) {
                    SmartBubbleAnimatedView.this.fti.ajO();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (SmartBubbleAnimatedView.this.fti != null) {
                    SmartBubbleAnimatedView.this.fti.ajO();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fth.setDuration(300L);
        this.fth.start();
    }

    private void a(AttributeSet attributeSet, int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_link_tip_a));
        this.bWt.setColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_i));
        this.bWt.setTextSize(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds40));
        this.ftj = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds83);
    }

    public void onChangeSkinType(int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_link_tip_a));
        this.bWt.setColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_i));
        this.bWt.setTextSize(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds40));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height = ((1.0f - this.ftg) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.ftg * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.ftg * getHeight()) / 2.0f);
        this.qc.set(((1.0f - this.ftg) * getWidth()) / 2.0f, height, width, height2);
        canvas.drawRoundRect(this.qc, (height2 - height) / 2.0f, (height2 - height) / 2.0f, this.mPaint);
        this.bWt.getTextBounds(this.bZO, 0, this.bZO.length(), this.bYb);
        canvas.drawText(this.bZO, 0, this.bZO.length(), (getWidth() - this.bYb.width()) / 2, getHeight() - ((getHeight() - this.bYb.height()) / 2), this.bWt);
    }

    public int getTipViewHeight() {
        return this.ftj;
    }
}
