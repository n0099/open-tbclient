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
    private float bWh;
    Rect dbo;
    public String dcR;
    public long gqr;
    private ValueAnimator gqs;
    private a gqt;
    private int gqu;
    private boolean gqv;
    RectF jD;
    private ValueAnimator mAnimator;
    private Paint mPaint;
    private Paint mTextPaint;

    /* loaded from: classes.dex */
    public interface a {
        void aFF();
    }

    public void setExtrusionRemind(boolean z) {
        this.gqv = z;
    }

    public void setOnBubbleAnimateListener(a aVar) {
        this.gqt = aVar;
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.gqr = 4000L;
        this.bWh = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.jD = new RectF();
        this.dbo = new Rect();
        this.gqv = false;
        a((AttributeSet) null, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gqr = 4000L;
        this.bWh = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.jD = new RectF();
        this.dbo = new Rect();
        this.gqv = false;
        a(attributeSet, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gqr = 4000L;
        this.bWh = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.jD = new RectF();
        this.dbo = new Rect();
        this.gqv = false;
        a(attributeSet, i);
    }

    public void bEm() {
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.gqv) {
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
                SmartBubbleAnimatedView.this.bWh = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (SmartBubbleAnimatedView.this.gqv && (layoutParams2 instanceof LinearLayout.LayoutParams)) {
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
                SmartBubbleAnimatedView.this.bEn();
            }
        }, this.gqr);
    }

    public void bEn() {
        if (this.gqv) {
            if (this.gqt != null) {
                this.gqt.aFF();
                return;
            }
            return;
        }
        this.gqs = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.gqs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * layoutParams.height);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
                SmartBubbleAnimatedView.this.requestLayout();
            }
        });
        this.gqs.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SmartBubbleAnimatedView.this.gqt != null) {
                    SmartBubbleAnimatedView.this.gqt.aFF();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (SmartBubbleAnimatedView.this.gqt != null) {
                    SmartBubbleAnimatedView.this.gqt.aFF();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gqs.setDuration(300L);
        this.gqs.start();
    }

    private void a(AttributeSet attributeSet, int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a));
        this.mTextPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds40));
        this.gqu = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds83);
    }

    public void onChangeSkinType(int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a));
        this.mTextPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds40));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height = ((1.0f - this.bWh) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.bWh * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.bWh * getHeight()) / 2.0f);
        this.jD.set(((1.0f - this.bWh) * getWidth()) / 2.0f, height, width, height2);
        canvas.drawRoundRect(this.jD, (height2 - height) / 2.0f, (height2 - height) / 2.0f, this.mPaint);
        this.mTextPaint.getTextBounds(this.dcR, 0, this.dcR.length(), this.dbo);
        canvas.drawText(this.dcR, 0, this.dcR.length(), (getWidth() - this.dbo.width()) / 2, getHeight() - ((getHeight() - this.dbo.height()) / 2), this.mTextPaint);
    }

    public int getTipViewHeight() {
        return this.gqu;
    }
}
