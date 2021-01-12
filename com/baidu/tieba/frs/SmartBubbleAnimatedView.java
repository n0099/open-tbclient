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
    private Paint bex;
    private float dPP;
    private ValueAnimator duB;
    Rect feD;
    public String fht;
    public long jfB;
    private ValueAnimator jfC;
    private a jfD;
    private int jfE;
    private boolean jfF;
    private Paint mPaint;
    RectF rectF;

    /* loaded from: classes.dex */
    public interface a {
        void bud();
    }

    public void setExtrusionRemind(boolean z) {
        this.jfF = z;
    }

    public void setOnBubbleAnimateListener(a aVar) {
        this.jfD = aVar;
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.jfB = 4000L;
        this.dPP = 0.0f;
        this.mPaint = new Paint();
        this.bex = new Paint();
        this.rectF = new RectF();
        this.feD = new Rect();
        this.jfF = false;
        a((AttributeSet) null, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jfB = 4000L;
        this.dPP = 0.0f;
        this.mPaint = new Paint();
        this.bex = new Paint();
        this.rectF = new RectF();
        this.feD = new Rect();
        this.jfF = false;
        a(attributeSet, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jfB = 4000L;
        this.dPP = 0.0f;
        this.mPaint = new Paint();
        this.bex = new Paint();
        this.rectF = new RectF();
        this.feD = new Rect();
        this.jfF = false;
        a(attributeSet, i);
    }

    public void cDC() {
        this.duB = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.jfF) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).topMargin = 20;
                setLayoutParams(layoutParams);
            }
        }
        this.duB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams2 = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams2.height = com.baidu.adp.lib.util.l.getDimens(SmartBubbleAnimatedView.this.getContext(), R.dimen.tbds83);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.dPP = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (SmartBubbleAnimatedView.this.jfF && (layoutParams2 instanceof LinearLayout.LayoutParams)) {
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
        this.duB.setDuration(400L);
        this.duB.start();
        com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.2
            @Override // java.lang.Runnable
            public void run() {
                SmartBubbleAnimatedView.this.cDD();
            }
        }, this.jfB);
    }

    public void cDD() {
        if (this.jfF) {
            if (this.jfD != null) {
                this.jfD.bud();
                return;
            }
            return;
        }
        this.jfC = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jfC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * layoutParams.height);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
                SmartBubbleAnimatedView.this.requestLayout();
            }
        });
        this.jfC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SmartBubbleAnimatedView.this.jfD != null) {
                    SmartBubbleAnimatedView.this.jfD.bud();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (SmartBubbleAnimatedView.this.jfD != null) {
                    SmartBubbleAnimatedView.this.jfD.bud();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jfC.setDuration(300L);
        this.jfC.start();
    }

    private void a(AttributeSet attributeSet, int i) {
        this.mPaint.setColor(com.baidu.tieba.tbadkCore.c.m(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0302), 0.83f));
        this.bex.setColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0101));
        this.bex.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds32));
        this.jfE = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds83);
    }

    public void onChangeSkinType(int i) {
        this.mPaint.setColor(com.baidu.tieba.tbadkCore.c.m(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0302), 0.83f));
        this.bex.setColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0101));
        this.bex.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds32));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height = ((1.0f - this.dPP) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.dPP * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.dPP * getHeight()) / 2.0f);
        this.rectF.set(((1.0f - this.dPP) * getWidth()) / 2.0f, height, width, height2);
        canvas.drawRoundRect(this.rectF, (height2 - height) / 2.0f, (height2 - height) / 2.0f, this.mPaint);
        this.bex.getTextBounds(this.fht, 0, this.fht.length(), this.feD);
        canvas.drawText(this.fht, 0, this.fht.length(), (getWidth() - this.feD.width()) / 2, getHeight() - ((getHeight() - this.feD.height()) / 2), this.bex);
    }

    public int getTipViewHeight() {
        return this.jfE;
    }
}
