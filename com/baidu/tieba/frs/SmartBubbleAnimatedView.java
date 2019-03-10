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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SmartBubbleAnimatedView extends View {
    private Paint bOB;
    Rect bQj;
    public String bRT;
    public long fdf;
    private float fdg;
    private ValueAnimator fdh;
    private a fdi;
    private int fdj;
    private boolean fdk;
    private ValueAnimator mAnimator;
    private Paint mPaint;
    RectF sz;

    /* loaded from: classes.dex */
    public interface a {
        void aeS();
    }

    public void setExtrusionRemind(boolean z) {
        this.fdk = z;
    }

    public void setOnBubbleAnimateListener(a aVar) {
        this.fdi = aVar;
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.fdf = 4000L;
        this.fdg = 0.0f;
        this.mPaint = new Paint();
        this.bOB = new Paint();
        this.sz = new RectF();
        this.bQj = new Rect();
        this.fdk = false;
        a((AttributeSet) null, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdf = 4000L;
        this.fdg = 0.0f;
        this.mPaint = new Paint();
        this.bOB = new Paint();
        this.sz = new RectF();
        this.bQj = new Rect();
        this.fdk = false;
        a(attributeSet, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fdf = 4000L;
        this.fdg = 0.0f;
        this.mPaint = new Paint();
        this.bOB = new Paint();
        this.sz = new RectF();
        this.bQj = new Rect();
        this.fdk = false;
        a(attributeSet, i);
    }

    public void bey() {
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.fdk) {
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
                layoutParams2.height = com.baidu.adp.lib.util.l.h(SmartBubbleAnimatedView.this.getContext(), d.e.tbds83);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.fdg = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (SmartBubbleAnimatedView.this.fdk && (layoutParams2 instanceof LinearLayout.LayoutParams)) {
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
        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.2
            @Override // java.lang.Runnable
            public void run() {
                SmartBubbleAnimatedView.this.bez();
            }
        }, this.fdf);
    }

    public void bez() {
        if (this.fdk) {
            if (this.fdi != null) {
                this.fdi.aeS();
                return;
            }
            return;
        }
        this.fdh = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fdh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * layoutParams.height);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
                SmartBubbleAnimatedView.this.requestLayout();
            }
        });
        this.fdh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SmartBubbleAnimatedView.this.fdi != null) {
                    SmartBubbleAnimatedView.this.fdi.aeS();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (SmartBubbleAnimatedView.this.fdi != null) {
                    SmartBubbleAnimatedView.this.fdi.aeS();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fdh.setDuration(300L);
        this.fdh.start();
    }

    private void a(AttributeSet attributeSet, int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_link_tip_a));
        this.bOB.setColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_cont_i));
        this.bOB.setTextSize(com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds40));
        this.fdj = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds83);
    }

    public void onChangeSkinType(int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_link_tip_a));
        this.bOB.setColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_cont_i));
        this.bOB.setTextSize(com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds40));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height = ((1.0f - this.fdg) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.fdg * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.fdg * getHeight()) / 2.0f);
        this.sz.set(((1.0f - this.fdg) * getWidth()) / 2.0f, height, width, height2);
        canvas.drawRoundRect(this.sz, (height2 - height) / 2.0f, (height2 - height) / 2.0f, this.mPaint);
        this.bOB.getTextBounds(this.bRT, 0, this.bRT.length(), this.bQj);
        canvas.drawText(this.bRT, 0, this.bRT.length(), (getWidth() - this.bQj.width()) / 2, getHeight() - ((getHeight() - this.bQj.height()) / 2), this.bOB);
    }

    public int getTipViewHeight() {
        return this.fdj;
    }
}
