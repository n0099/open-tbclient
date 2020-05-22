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
    RectF Fg;
    private float cMA;
    Rect dTH;
    public String dVI;
    public long hrq;
    private ValueAnimator hrr;
    private a hrs;
    private int hrt;
    private boolean hru;
    private ValueAnimator mAnimator;
    private Paint mPaint;
    private Paint mTextPaint;

    /* loaded from: classes.dex */
    public interface a {
        void aWy();
    }

    public void setExtrusionRemind(boolean z) {
        this.hru = z;
    }

    public void setOnBubbleAnimateListener(a aVar) {
        this.hrs = aVar;
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.hrq = 4000L;
        this.cMA = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.Fg = new RectF();
        this.dTH = new Rect();
        this.hru = false;
        a((AttributeSet) null, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hrq = 4000L;
        this.cMA = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.Fg = new RectF();
        this.dTH = new Rect();
        this.hru = false;
        a(attributeSet, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hrq = 4000L;
        this.cMA = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.Fg = new RectF();
        this.dTH = new Rect();
        this.hru = false;
        a(attributeSet, i);
    }

    public void bWZ() {
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.hru) {
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
                SmartBubbleAnimatedView.this.cMA = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (SmartBubbleAnimatedView.this.hru && (layoutParams2 instanceof LinearLayout.LayoutParams)) {
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
        com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.2
            @Override // java.lang.Runnable
            public void run() {
                SmartBubbleAnimatedView.this.bXa();
            }
        }, this.hrq);
    }

    public void bXa() {
        if (this.hru) {
            if (this.hrs != null) {
                this.hrs.aWy();
                return;
            }
            return;
        }
        this.hrr = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.hrr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * layoutParams.height);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
                SmartBubbleAnimatedView.this.requestLayout();
            }
        });
        this.hrr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SmartBubbleAnimatedView.this.hrs != null) {
                    SmartBubbleAnimatedView.this.hrs.aWy();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (SmartBubbleAnimatedView.this.hrs != null) {
                    SmartBubbleAnimatedView.this.hrs.aWy();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hrr.setDuration(300L);
        this.hrr.start();
    }

    private void a(AttributeSet attributeSet, int i) {
        this.mPaint.setColor(com.baidu.tieba.tbadkCore.c.l(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a), 0.83f));
        this.mTextPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds32));
        this.hrt = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds83);
    }

    public void onChangeSkinType(int i) {
        this.mPaint.setColor(com.baidu.tieba.tbadkCore.c.l(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a), 0.83f));
        this.mTextPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds32));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height = ((1.0f - this.cMA) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.cMA * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.cMA * getHeight()) / 2.0f);
        this.Fg.set(((1.0f - this.cMA) * getWidth()) / 2.0f, height, width, height2);
        canvas.drawRoundRect(this.Fg, (height2 - height) / 2.0f, (height2 - height) / 2.0f, this.mPaint);
        this.mTextPaint.getTextBounds(this.dVI, 0, this.dVI.length(), this.dTH);
        canvas.drawText(this.dVI, 0, this.dVI.length(), (getWidth() - this.dTH.width()) / 2, getHeight() - ((getHeight() - this.dTH.height()) / 2), this.mTextPaint);
    }

    public int getTipViewHeight() {
        return this.hrt;
    }
}
