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
    private Paint bXw;
    Rect bZe;
    public String caR;
    public long fyc;
    private float fyd;
    private ValueAnimator fye;
    private a fyf;
    private int fyg;
    private boolean fyh;
    private ValueAnimator mAnimator;
    private Paint mPaint;
    RectF qe;

    /* loaded from: classes.dex */
    public interface a {
        void akT();
    }

    public void setExtrusionRemind(boolean z) {
        this.fyh = z;
    }

    public void setOnBubbleAnimateListener(a aVar) {
        this.fyf = aVar;
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.fyc = 4000L;
        this.fyd = 0.0f;
        this.mPaint = new Paint();
        this.bXw = new Paint();
        this.qe = new RectF();
        this.bZe = new Rect();
        this.fyh = false;
        a((AttributeSet) null, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fyc = 4000L;
        this.fyd = 0.0f;
        this.mPaint = new Paint();
        this.bXw = new Paint();
        this.qe = new RectF();
        this.bZe = new Rect();
        this.fyh = false;
        a(attributeSet, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fyc = 4000L;
        this.fyd = 0.0f;
        this.mPaint = new Paint();
        this.bXw = new Paint();
        this.qe = new RectF();
        this.bZe = new Rect();
        this.fyh = false;
        a(attributeSet, i);
    }

    public void bnR() {
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.fyh) {
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
                SmartBubbleAnimatedView.this.fyd = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (SmartBubbleAnimatedView.this.fyh && (layoutParams2 instanceof LinearLayout.LayoutParams)) {
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
        com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.2
            @Override // java.lang.Runnable
            public void run() {
                SmartBubbleAnimatedView.this.bnS();
            }
        }, this.fyc);
    }

    public void bnS() {
        if (this.fyh) {
            if (this.fyf != null) {
                this.fyf.akT();
                return;
            }
            return;
        }
        this.fye = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fye.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * layoutParams.height);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
                SmartBubbleAnimatedView.this.requestLayout();
            }
        });
        this.fye.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SmartBubbleAnimatedView.this.fyf != null) {
                    SmartBubbleAnimatedView.this.fyf.akT();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (SmartBubbleAnimatedView.this.fyf != null) {
                    SmartBubbleAnimatedView.this.fyf.akT();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fye.setDuration(300L);
        this.fye.start();
    }

    private void a(AttributeSet attributeSet, int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a));
        this.bXw.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.bXw.setTextSize(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds40));
        this.fyg = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds83);
    }

    public void onChangeSkinType(int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a));
        this.bXw.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.bXw.setTextSize(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds40));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height = ((1.0f - this.fyd) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.fyd * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.fyd * getHeight()) / 2.0f);
        this.qe.set(((1.0f - this.fyd) * getWidth()) / 2.0f, height, width, height2);
        canvas.drawRoundRect(this.qe, (height2 - height) / 2.0f, (height2 - height) / 2.0f, this.mPaint);
        this.bXw.getTextBounds(this.caR, 0, this.caR.length(), this.bZe);
        canvas.drawText(this.caR, 0, this.caR.length(), (getWidth() - this.bZe.width()) / 2, getHeight() - ((getHeight() - this.bZe.height()) / 2), this.bXw);
    }

    public int getTipViewHeight() {
        return this.fyg;
    }
}
