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
    public long ftg;
    private float fth;
    private ValueAnimator fti;
    private a ftj;
    private int ftk;
    private boolean ftl;
    private ValueAnimator mAnimator;
    private Paint mPaint;
    RectF qc;

    /* loaded from: classes.dex */
    public interface a {
        void ajO();
    }

    public void setExtrusionRemind(boolean z) {
        this.ftl = z;
    }

    public void setOnBubbleAnimateListener(a aVar) {
        this.ftj = aVar;
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.ftg = 4000L;
        this.fth = 0.0f;
        this.mPaint = new Paint();
        this.bWt = new Paint();
        this.qc = new RectF();
        this.bYb = new Rect();
        this.ftl = false;
        a((AttributeSet) null, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ftg = 4000L;
        this.fth = 0.0f;
        this.mPaint = new Paint();
        this.bWt = new Paint();
        this.qc = new RectF();
        this.bYb = new Rect();
        this.ftl = false;
        a(attributeSet, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ftg = 4000L;
        this.fth = 0.0f;
        this.mPaint = new Paint();
        this.bWt = new Paint();
        this.qc = new RectF();
        this.bYb = new Rect();
        this.ftl = false;
        a(attributeSet, i);
    }

    public void blQ() {
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.ftl) {
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
                SmartBubbleAnimatedView.this.fth = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (SmartBubbleAnimatedView.this.ftl && (layoutParams2 instanceof LinearLayout.LayoutParams)) {
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
                SmartBubbleAnimatedView.this.blR();
            }
        }, this.ftg);
    }

    public void blR() {
        if (this.ftl) {
            if (this.ftj != null) {
                this.ftj.ajO();
                return;
            }
            return;
        }
        this.fti = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fti.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * layoutParams.height);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
                SmartBubbleAnimatedView.this.requestLayout();
            }
        });
        this.fti.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SmartBubbleAnimatedView.this.ftj != null) {
                    SmartBubbleAnimatedView.this.ftj.ajO();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (SmartBubbleAnimatedView.this.ftj != null) {
                    SmartBubbleAnimatedView.this.ftj.ajO();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fti.setDuration(300L);
        this.fti.start();
    }

    private void a(AttributeSet attributeSet, int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_link_tip_a));
        this.bWt.setColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_i));
        this.bWt.setTextSize(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds40));
        this.ftk = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds83);
    }

    public void onChangeSkinType(int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_link_tip_a));
        this.bWt.setColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_i));
        this.bWt.setTextSize(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds40));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height = ((1.0f - this.fth) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.fth * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.fth * getHeight()) / 2.0f);
        this.qc.set(((1.0f - this.fth) * getWidth()) / 2.0f, height, width, height2);
        canvas.drawRoundRect(this.qc, (height2 - height) / 2.0f, (height2 - height) / 2.0f, this.mPaint);
        this.bWt.getTextBounds(this.bZO, 0, this.bZO.length(), this.bYb);
        canvas.drawText(this.bZO, 0, this.bZO.length(), (getWidth() - this.bYb.width()) / 2, getHeight() - ((getHeight() - this.bYb.height()) / 2), this.bWt);
    }

    public int getTipViewHeight() {
        return this.ftk;
    }
}
