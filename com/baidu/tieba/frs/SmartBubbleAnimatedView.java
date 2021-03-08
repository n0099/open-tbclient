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
    private Paint bjh;
    private float dTw;
    private ValueAnimator dyk;
    Rect fiu;
    public String fll;
    public long jng;
    private ValueAnimator jnh;
    private a jni;
    private int jnj;
    private boolean jnk;
    private Paint mPaint;
    RectF rectF;

    /* loaded from: classes.dex */
    public interface a {
        void buA();
    }

    public void setExtrusionRemind(boolean z) {
        this.jnk = z;
    }

    public void setOnBubbleAnimateListener(a aVar) {
        this.jni = aVar;
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.jng = 4000L;
        this.dTw = 0.0f;
        this.mPaint = new Paint();
        this.bjh = new Paint();
        this.rectF = new RectF();
        this.fiu = new Rect();
        this.jnk = false;
        a((AttributeSet) null, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jng = 4000L;
        this.dTw = 0.0f;
        this.mPaint = new Paint();
        this.bjh = new Paint();
        this.rectF = new RectF();
        this.fiu = new Rect();
        this.jnk = false;
        a(attributeSet, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jng = 4000L;
        this.dTw = 0.0f;
        this.mPaint = new Paint();
        this.bjh = new Paint();
        this.rectF = new RectF();
        this.fiu = new Rect();
        this.jnk = false;
        a(attributeSet, i);
    }

    public void cFb() {
        this.dyk = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.jnk) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).topMargin = 20;
                setLayoutParams(layoutParams);
            }
        }
        this.dyk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams2 = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams2.height = com.baidu.adp.lib.util.l.getDimens(SmartBubbleAnimatedView.this.getContext(), R.dimen.tbds83);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.dTw = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (SmartBubbleAnimatedView.this.jnk && (layoutParams2 instanceof LinearLayout.LayoutParams)) {
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
        this.dyk.setDuration(400L);
        this.dyk.start();
        com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.2
            @Override // java.lang.Runnable
            public void run() {
                SmartBubbleAnimatedView.this.cFc();
            }
        }, this.jng);
    }

    public void cFc() {
        if (this.jnk) {
            if (this.jni != null) {
                this.jni.buA();
                return;
            }
            return;
        }
        this.jnh = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jnh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
                layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * layoutParams.height);
                SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
                SmartBubbleAnimatedView.this.requestLayout();
            }
        });
        this.jnh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.SmartBubbleAnimatedView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SmartBubbleAnimatedView.this.jni != null) {
                    SmartBubbleAnimatedView.this.jni.buA();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (SmartBubbleAnimatedView.this.jni != null) {
                    SmartBubbleAnimatedView.this.jni.buA();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jnh.setDuration(300L);
        this.jnh.start();
    }

    private void a(AttributeSet attributeSet, int i) {
        this.mPaint.setColor(com.baidu.tieba.tbadkCore.c.l(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0302), 0.83f));
        this.bjh.setColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0101));
        this.bjh.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds32));
        this.jnj = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds83);
    }

    public void onChangeSkinType(int i) {
        this.mPaint.setColor(com.baidu.tieba.tbadkCore.c.l(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0302), 0.83f));
        this.bjh.setColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0101));
        this.bjh.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds32));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height = ((1.0f - this.dTw) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.dTw * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.dTw * getHeight()) / 2.0f);
        this.rectF.set(((1.0f - this.dTw) * getWidth()) / 2.0f, height, width, height2);
        canvas.drawRoundRect(this.rectF, (height2 - height) / 2.0f, (height2 - height) / 2.0f, this.mPaint);
        this.bjh.getTextBounds(this.fll, 0, this.fll.length(), this.fiu);
        canvas.drawText(this.fll, 0, this.fll.length(), (getWidth() - this.fiu.width()) / 2, getHeight() - ((getHeight() - this.fiu.height()) / 2), this.bjh);
    }

    public int getTipViewHeight() {
        return this.jnj;
    }
}
