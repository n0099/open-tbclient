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
    private Paint aiW;
    Rect cnR;
    public String cpn;
    public long fyL;
    private float fyM;
    private ValueAnimator fyN;
    private a fyO;
    private int fyP;
    private boolean fyQ;
    RectF hQ;
    private ValueAnimator mAnimator;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void anT();
    }

    public void setExtrusionRemind(boolean z) {
        this.fyQ = z;
    }

    public void setOnBubbleAnimateListener(a aVar) {
        this.fyO = aVar;
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.fyL = 4000L;
        this.fyM = 0.0f;
        this.mPaint = new Paint();
        this.aiW = new Paint();
        this.hQ = new RectF();
        this.cnR = new Rect();
        this.fyQ = false;
        a((AttributeSet) null, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fyL = 4000L;
        this.fyM = 0.0f;
        this.mPaint = new Paint();
        this.aiW = new Paint();
        this.hQ = new RectF();
        this.cnR = new Rect();
        this.fyQ = false;
        a(attributeSet, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fyL = 4000L;
        this.fyM = 0.0f;
        this.mPaint = new Paint();
        this.aiW = new Paint();
        this.hQ = new RectF();
        this.cnR = new Rect();
        this.fyQ = false;
        a(attributeSet, i);
    }

    public void blO() {
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.fyQ) {
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
                SmartBubbleAnimatedView.this.fyM = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (SmartBubbleAnimatedView.this.fyQ && (layoutParams2 instanceof LinearLayout.LayoutParams)) {
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
                SmartBubbleAnimatedView.this.blP();
            }
        }, this.fyL);
    }

    public void blP() {
        if (this.fyQ) {
            if (this.fyO != null) {
                this.fyO.anT();
                return;
            }
            return;
        }
        this.fyN = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fyN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * layoutParams.height);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
                SmartBubbleAnimatedView.this.requestLayout();
            }
        });
        this.fyN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SmartBubbleAnimatedView.this.fyO != null) {
                    SmartBubbleAnimatedView.this.fyO.anT();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (SmartBubbleAnimatedView.this.fyO != null) {
                    SmartBubbleAnimatedView.this.fyO.anT();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fyN.setDuration(300L);
        this.fyN.start();
    }

    private void a(AttributeSet attributeSet, int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a));
        this.aiW.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.aiW.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds40));
        this.fyP = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds83);
    }

    public void onChangeSkinType(int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a));
        this.aiW.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.aiW.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds40));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height = ((1.0f - this.fyM) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.fyM * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.fyM * getHeight()) / 2.0f);
        this.hQ.set(((1.0f - this.fyM) * getWidth()) / 2.0f, height, width, height2);
        canvas.drawRoundRect(this.hQ, (height2 - height) / 2.0f, (height2 - height) / 2.0f, this.mPaint);
        this.aiW.getTextBounds(this.cpn, 0, this.cpn.length(), this.cnR);
        canvas.drawText(this.cpn, 0, this.cpn.length(), (getWidth() - this.cnR.width()) / 2, getHeight() - ((getHeight() - this.cnR.height()) / 2), this.aiW);
    }

    public int getTipViewHeight() {
        return this.fyP;
    }
}
