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
    private Paint ajo;
    Rect coI;
    public String cqf;
    public long fzC;
    private float fzD;
    private ValueAnimator fzE;
    private a fzF;
    private int fzG;
    private boolean fzH;
    RectF iu;
    private ValueAnimator mAnimator;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void anV();
    }

    public void setExtrusionRemind(boolean z) {
        this.fzH = z;
    }

    public void setOnBubbleAnimateListener(a aVar) {
        this.fzF = aVar;
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.fzC = 4000L;
        this.fzD = 0.0f;
        this.mPaint = new Paint();
        this.ajo = new Paint();
        this.iu = new RectF();
        this.coI = new Rect();
        this.fzH = false;
        a((AttributeSet) null, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fzC = 4000L;
        this.fzD = 0.0f;
        this.mPaint = new Paint();
        this.ajo = new Paint();
        this.iu = new RectF();
        this.coI = new Rect();
        this.fzH = false;
        a(attributeSet, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fzC = 4000L;
        this.fzD = 0.0f;
        this.mPaint = new Paint();
        this.ajo = new Paint();
        this.iu = new RectF();
        this.coI = new Rect();
        this.fzH = false;
        a(attributeSet, i);
    }

    public void blQ() {
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.fzH) {
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
                SmartBubbleAnimatedView.this.fzD = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (SmartBubbleAnimatedView.this.fzH && (layoutParams2 instanceof LinearLayout.LayoutParams)) {
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
        com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.2
            @Override // java.lang.Runnable
            public void run() {
                SmartBubbleAnimatedView.this.blR();
            }
        }, this.fzC);
    }

    public void blR() {
        if (this.fzH) {
            if (this.fzF != null) {
                this.fzF.anV();
                return;
            }
            return;
        }
        this.fzE = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fzE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * layoutParams.height);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
                SmartBubbleAnimatedView.this.requestLayout();
            }
        });
        this.fzE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SmartBubbleAnimatedView.this.fzF != null) {
                    SmartBubbleAnimatedView.this.fzF.anV();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (SmartBubbleAnimatedView.this.fzF != null) {
                    SmartBubbleAnimatedView.this.fzF.anV();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fzE.setDuration(300L);
        this.fzE.start();
    }

    private void a(AttributeSet attributeSet, int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a));
        this.ajo.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.ajo.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds40));
        this.fzG = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds83);
    }

    public void onChangeSkinType(int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a));
        this.ajo.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.ajo.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds40));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height = ((1.0f - this.fzD) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.fzD * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.fzD * getHeight()) / 2.0f);
        this.iu.set(((1.0f - this.fzD) * getWidth()) / 2.0f, height, width, height2);
        canvas.drawRoundRect(this.iu, (height2 - height) / 2.0f, (height2 - height) / 2.0f, this.mPaint);
        this.ajo.getTextBounds(this.cqf, 0, this.cqf.length(), this.coI);
        canvas.drawText(this.cqf, 0, this.cqf.length(), (getWidth() - this.coI.width()) / 2, getHeight() - ((getHeight() - this.coI.height()) / 2), this.ajo);
    }

    public int getTipViewHeight() {
        return this.fzG;
    }
}
