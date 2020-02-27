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
    private float cal;
    Rect dft;
    public String dgW;
    public long gss;
    private ValueAnimator gst;
    private a gsu;
    private int gsv;
    private boolean gsw;
    RectF jH;
    private ValueAnimator mAnimator;
    private Paint mPaint;
    private Paint mTextPaint;

    /* loaded from: classes.dex */
    public interface a {
        void aHU();
    }

    public void setExtrusionRemind(boolean z) {
        this.gsw = z;
    }

    public void setOnBubbleAnimateListener(a aVar) {
        this.gsu = aVar;
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.gss = 4000L;
        this.cal = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.jH = new RectF();
        this.dft = new Rect();
        this.gsw = false;
        a((AttributeSet) null, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gss = 4000L;
        this.cal = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.jH = new RectF();
        this.dft = new Rect();
        this.gsw = false;
        a(attributeSet, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gss = 4000L;
        this.cal = 0.0f;
        this.mPaint = new Paint();
        this.mTextPaint = new Paint();
        this.jH = new RectF();
        this.dft = new Rect();
        this.gsw = false;
        a(attributeSet, i);
    }

    public void bFO() {
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.gsw) {
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
                SmartBubbleAnimatedView.this.cal = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (SmartBubbleAnimatedView.this.gsw && (layoutParams2 instanceof LinearLayout.LayoutParams)) {
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
                SmartBubbleAnimatedView.this.bFP();
            }
        }, this.gss);
    }

    public void bFP() {
        if (this.gsw) {
            if (this.gsu != null) {
                this.gsu.aHU();
                return;
            }
            return;
        }
        this.gst = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.gst.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * layoutParams.height);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
                SmartBubbleAnimatedView.this.requestLayout();
            }
        });
        this.gst.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SmartBubbleAnimatedView.this.gsu != null) {
                    SmartBubbleAnimatedView.this.gsu.aHU();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (SmartBubbleAnimatedView.this.gsu != null) {
                    SmartBubbleAnimatedView.this.gsu.aHU();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gst.setDuration(300L);
        this.gst.start();
    }

    private void a(AttributeSet attributeSet, int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a));
        this.mTextPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds40));
        this.gsv = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds83);
    }

    public void onChangeSkinType(int i) {
        this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_a));
        this.mTextPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_i));
        this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds40));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height = ((1.0f - this.cal) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.cal * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.cal * getHeight()) / 2.0f);
        this.jH.set(((1.0f - this.cal) * getWidth()) / 2.0f, height, width, height2);
        canvas.drawRoundRect(this.jH, (height2 - height) / 2.0f, (height2 - height) / 2.0f, this.mPaint);
        this.mTextPaint.getTextBounds(this.dgW, 0, this.dgW.length(), this.dft);
        canvas.drawText(this.dgW, 0, this.dgW.length(), (getWidth() - this.dft.width()) / 2, getHeight() - ((getHeight() - this.dft.height()) / 2), this.mTextPaint);
    }

    public int getTipViewHeight() {
        return this.gsv;
    }
}
