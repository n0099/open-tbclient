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
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class SmartBubbleAnimatedView extends View {

    /* renamed from: e  reason: collision with root package name */
    public String f15956e;

    /* renamed from: f  reason: collision with root package name */
    public long f15957f;

    /* renamed from: g  reason: collision with root package name */
    public float f15958g;

    /* renamed from: h  reason: collision with root package name */
    public ValueAnimator f15959h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f15960i;
    public Paint j;
    public Paint k;
    public RectF l;
    public Rect m;
    public e n;
    public int o;
    public boolean p;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
            layoutParams.height = l.g(SmartBubbleAnimatedView.this.getContext(), R.dimen.tbds83);
            SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            SmartBubbleAnimatedView.this.f15958g = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (SmartBubbleAnimatedView.this.p && (layoutParams instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                int i2 = layoutParams2.topMargin;
                if (i2 > 0) {
                    layoutParams2.topMargin = i2 - 5;
                }
                if (layoutParams2.topMargin < 0) {
                    layoutParams2.topMargin = 0;
                }
            }
            SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
            SmartBubbleAnimatedView.this.requestLayout();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartBubbleAnimatedView.this.f();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
            layoutParams.height = (int) (layoutParams.height * ((Float) valueAnimator.getAnimatedValue()).floatValue());
            SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
            SmartBubbleAnimatedView.this.requestLayout();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Animator.AnimatorListener {
        public d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (SmartBubbleAnimatedView.this.n != null) {
                SmartBubbleAnimatedView.this.n.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (SmartBubbleAnimatedView.this.n != null) {
                SmartBubbleAnimatedView.this.n.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.f15957f = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
        this.f15958g = 0.0f;
        this.j = new Paint();
        this.k = new Paint();
        this.l = new RectF();
        this.m = new Rect();
        this.p = false;
        d(null, 0);
    }

    public final void d(AttributeSet attributeSet, int i2) {
        this.j.setColor(d.a.j0.d3.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.83f));
        this.k.setColor(SkinManager.getColor(R.color.CAM_X0101));
        this.k.setTextSize(l.g(getContext(), R.dimen.tbds32));
        this.o = l.g(getContext(), R.dimen.tbds83);
    }

    public void e(int i2) {
        this.j.setColor(d.a.j0.d3.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.83f));
        this.k.setColor(SkinManager.getColor(R.color.CAM_X0101));
        this.k.setTextSize(l.g(getContext(), R.dimen.tbds32));
        invalidate();
    }

    public void f() {
        if (this.p) {
            e eVar = this.n;
            if (eVar != null) {
                eVar.a();
                return;
            }
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f15960i = ofFloat;
        ofFloat.addUpdateListener(new c());
        this.f15960i.addListener(new d());
        this.f15960i.setDuration(300L);
        this.f15960i.start();
    }

    public void g() {
        this.f15959h = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.p) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).topMargin = 20;
                setLayoutParams(layoutParams);
            }
        }
        this.f15959h.addUpdateListener(new a());
        this.f15959h.setDuration(400L);
        this.f15959h.start();
        d.a.c.e.m.e.a().postDelayed(new b(), this.f15957f);
    }

    public int getTipViewHeight() {
        return this.o;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float height = ((1.0f - this.f15958g) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.f15958g * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.f15958g * getHeight()) / 2.0f);
        this.l.set(((1.0f - this.f15958g) * getWidth()) / 2.0f, height, width, height2);
        float f2 = (height2 - height) / 2.0f;
        canvas.drawRoundRect(this.l, f2, f2, this.j);
        Paint paint = this.k;
        String str = this.f15956e;
        paint.getTextBounds(str, 0, str.length(), this.m);
        int width2 = this.m.width();
        int height3 = this.m.height();
        String str2 = this.f15956e;
        canvas.drawText(str2, 0, str2.length(), (getWidth() - width2) / 2, getHeight() - ((getHeight() - height3) / 2), this.k);
    }

    public void setExtrusionRemind(boolean z) {
        this.p = z;
    }

    public void setOnBubbleAnimateListener(e eVar) {
        this.n = eVar;
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15957f = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
        this.f15958g = 0.0f;
        this.j = new Paint();
        this.k = new Paint();
        this.l = new RectF();
        this.m = new Rect();
        this.p = false;
        d(attributeSet, 0);
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15957f = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
        this.f15958g = 0.0f;
        this.j = new Paint();
        this.k = new Paint();
        this.l = new RectF();
        this.m = new Rect();
        this.p = false;
        d(attributeSet, i2);
    }
}
