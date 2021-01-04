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
    private Paint bjo;
    private float dUB;
    private ValueAnimator dzn;
    Rect fjo;
    public String fme;
    public long jki;
    private ValueAnimator jkj;
    private a jkk;
    private int jkl;
    private boolean jkm;
    private Paint mPaint;
    RectF rectF;

    /* loaded from: classes.dex */
    public interface a {
        void bxW();
    }

    public void setExtrusionRemind(boolean z) {
        this.jkm = z;
    }

    public void setOnBubbleAnimateListener(a aVar) {
        this.jkk = aVar;
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.jki = 4000L;
        this.dUB = 0.0f;
        this.mPaint = new Paint();
        this.bjo = new Paint();
        this.rectF = new RectF();
        this.fjo = new Rect();
        this.jkm = false;
        a((AttributeSet) null, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jki = 4000L;
        this.dUB = 0.0f;
        this.mPaint = new Paint();
        this.bjo = new Paint();
        this.rectF = new RectF();
        this.fjo = new Rect();
        this.jkm = false;
        a(attributeSet, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jki = 4000L;
        this.dUB = 0.0f;
        this.mPaint = new Paint();
        this.bjo = new Paint();
        this.rectF = new RectF();
        this.fjo = new Rect();
        this.jkm = false;
        a(attributeSet, i);
    }

    public void cHt() {
        this.dzn = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.jkm) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).topMargin = 20;
                setLayoutParams(layoutParams);
            }
        }
        this.dzn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams2 = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams2.height = com.baidu.adp.lib.util.l.getDimens(SmartBubbleAnimatedView.this.getContext(), R.dimen.tbds83);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.dUB = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (SmartBubbleAnimatedView.this.jkm && (layoutParams2 instanceof LinearLayout.LayoutParams)) {
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
        this.dzn.setDuration(400L);
        this.dzn.start();
        com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.2
            @Override // java.lang.Runnable
            public void run() {
                SmartBubbleAnimatedView.this.cHu();
            }
        }, this.jki);
    }

    public void cHu() {
        if (this.jkm) {
            if (this.jkk != null) {
                this.jkk.bxW();
                return;
            }
            return;
        }
        this.jkj = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jkj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * layoutParams.height);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
                SmartBubbleAnimatedView.this.requestLayout();
            }
        });
        this.jkj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SmartBubbleAnimatedView.this.jkk != null) {
                    SmartBubbleAnimatedView.this.jkk.bxW();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (SmartBubbleAnimatedView.this.jkk != null) {
                    SmartBubbleAnimatedView.this.jkk.bxW();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jkj.setDuration(300L);
        this.jkj.start();
    }

    private void a(AttributeSet attributeSet, int i) {
        this.mPaint.setColor(com.baidu.tieba.tbadkCore.c.m(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0302), 0.83f));
        this.bjo.setColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0101));
        this.bjo.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds32));
        this.jkl = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds83);
    }

    public void onChangeSkinType(int i) {
        this.mPaint.setColor(com.baidu.tieba.tbadkCore.c.m(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0302), 0.83f));
        this.bjo.setColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0101));
        this.bjo.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds32));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height = ((1.0f - this.dUB) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.dUB * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.dUB * getHeight()) / 2.0f);
        this.rectF.set(((1.0f - this.dUB) * getWidth()) / 2.0f, height, width, height2);
        canvas.drawRoundRect(this.rectF, (height2 - height) / 2.0f, (height2 - height) / 2.0f, this.mPaint);
        this.bjo.getTextBounds(this.fme, 0, this.fme.length(), this.fjo);
        canvas.drawText(this.fme, 0, this.fme.length(), (getWidth() - this.fjo.width()) / 2, getHeight() - ((getHeight() - this.fjo.height()) / 2), this.bjo);
    }

    public int getTipViewHeight() {
        return this.jkl;
    }
}
