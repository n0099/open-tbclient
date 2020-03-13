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
    private float can;
    Rect dfH;
    public String dhk;
    public long gsH;
    private ValueAnimator gsI;
    private a gsJ;
    private int gsK;
    private boolean gsL;
    RectF jH;
    private ValueAnimator mAnimator;
    private Paint mPaint;
    private Paint mTextPaint;

    /* loaded from: classes.dex */
    public interface a {
        void aHX();
    }

    public void setExtrusionRemind(boolean z) {
        this.gsL = z;
    }

    public void setOnBubbleAnimateListener(a aVar) {
        this.gsJ = aVar;
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.gsH = 4000L;
        this.can = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.jH = new RectF();
        this.dfH = new Rect();
        this.gsL = false;
        a((AttributeSet) null, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gsH = 4000L;
        this.can = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.jH = new RectF();
        this.dfH = new Rect();
        this.gsL = false;
        a(attributeSet, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gsH = 4000L;
        this.can = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.jH = new RectF();
        this.dfH = new Rect();
        this.gsL = false;
        a(attributeSet, i);
    }

    public void bFR() {
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.gsL) {
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
                SmartBubbleAnimatedView.this.can = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (SmartBubbleAnimatedView.this.gsL && (layoutParams2 instanceof LinearLayout.LayoutParams)) {
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
        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.2
            @Override // java.lang.Runnable
            public void run() {
                SmartBubbleAnimatedView.this.bFS();
            }
        }, this.gsH);
    }

    public void bFS() {
        if (this.gsL) {
            if (this.gsJ != null) {
                this.gsJ.aHX();
                return;
            }
            return;
        }
        this.gsI = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.gsI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * layoutParams.height);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
                SmartBubbleAnimatedView.this.requestLayout();
            }
        });
        this.gsI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SmartBubbleAnimatedView.this.gsJ != null) {
                    SmartBubbleAnimatedView.this.gsJ.aHX();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (SmartBubbleAnimatedView.this.gsJ != null) {
                    SmartBubbleAnimatedView.this.gsJ.aHX();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gsI.setDuration(300L);
        this.gsI.start();
    }

    private void a(AttributeSet attributeSet, int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a));
        this.mTextPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds40));
        this.gsK = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds83);
    }

    public void onChangeSkinType(int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a));
        this.mTextPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds40));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height = ((1.0f - this.can) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.can * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.can * getHeight()) / 2.0f);
        this.jH.set(((1.0f - this.can) * getWidth()) / 2.0f, height, width, height2);
        canvas.drawRoundRect(this.jH, (height2 - height) / 2.0f, (height2 - height) / 2.0f, this.mPaint);
        this.mTextPaint.getTextBounds(this.dhk, 0, this.dhk.length(), this.dfH);
        canvas.drawText(this.dhk, 0, this.dhk.length(), (getWidth() - this.dfH.width()) / 2, getHeight() - ((getHeight() - this.dfH.height()) / 2), this.mTextPaint);
    }

    public int getTipViewHeight() {
        return this.gsK;
    }
}
