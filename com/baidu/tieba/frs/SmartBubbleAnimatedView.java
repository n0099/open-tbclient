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
    private Paint bXC;
    Rect bZk;
    public String caY;
    public long fyB;
    private float fyC;
    private ValueAnimator fyD;
    private a fyE;
    private int fyF;
    private boolean fyG;
    private ValueAnimator mAnimator;
    private Paint mPaint;
    RectF qe;

    /* loaded from: classes.dex */
    public interface a {
        void akV();
    }

    public void setExtrusionRemind(boolean z) {
        this.fyG = z;
    }

    public void setOnBubbleAnimateListener(a aVar) {
        this.fyE = aVar;
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.fyB = 4000L;
        this.fyC = 0.0f;
        this.mPaint = new Paint();
        this.bXC = new Paint();
        this.qe = new RectF();
        this.bZk = new Rect();
        this.fyG = false;
        a((AttributeSet) null, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fyB = 4000L;
        this.fyC = 0.0f;
        this.mPaint = new Paint();
        this.bXC = new Paint();
        this.qe = new RectF();
        this.bZk = new Rect();
        this.fyG = false;
        a(attributeSet, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fyB = 4000L;
        this.fyC = 0.0f;
        this.mPaint = new Paint();
        this.bXC = new Paint();
        this.qe = new RectF();
        this.bZk = new Rect();
        this.fyG = false;
        a(attributeSet, i);
    }

    public void bob() {
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.fyG) {
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
                SmartBubbleAnimatedView.this.fyC = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (SmartBubbleAnimatedView.this.fyG && (layoutParams2 instanceof LinearLayout.LayoutParams)) {
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
                SmartBubbleAnimatedView.this.boc();
            }
        }, this.fyB);
    }

    public void boc() {
        if (this.fyG) {
            if (this.fyE != null) {
                this.fyE.akV();
                return;
            }
            return;
        }
        this.fyD = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fyD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * layoutParams.height);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
                SmartBubbleAnimatedView.this.requestLayout();
            }
        });
        this.fyD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SmartBubbleAnimatedView.this.fyE != null) {
                    SmartBubbleAnimatedView.this.fyE.akV();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (SmartBubbleAnimatedView.this.fyE != null) {
                    SmartBubbleAnimatedView.this.fyE.akV();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fyD.setDuration(300L);
        this.fyD.start();
    }

    private void a(AttributeSet attributeSet, int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a));
        this.bXC.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.bXC.setTextSize(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds40));
        this.fyF = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds83);
    }

    public void onChangeSkinType(int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a));
        this.bXC.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.bXC.setTextSize(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds40));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height = ((1.0f - this.fyC) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.fyC * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.fyC * getHeight()) / 2.0f);
        this.qe.set(((1.0f - this.fyC) * getWidth()) / 2.0f, height, width, height2);
        canvas.drawRoundRect(this.qe, (height2 - height) / 2.0f, (height2 - height) / 2.0f, this.mPaint);
        this.bXC.getTextBounds(this.caY, 0, this.caY.length(), this.bZk);
        canvas.drawText(this.caY, 0, this.caY.length(), (getWidth() - this.bZk.width()) / 2, getHeight() - ((getHeight() - this.bZk.height()) / 2), this.bXC);
    }

    public int getTipViewHeight() {
        return this.fyF;
    }
}
