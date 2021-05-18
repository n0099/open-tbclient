package com.baidu.tbadk.suspended;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class SusPendedView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f13016e;

    /* renamed from: f  reason: collision with root package name */
    public TranView f13017f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f13018g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.t0.a f13019h;

    /* renamed from: i  reason: collision with root package name */
    public float f13020i;
    public float j;
    public boolean k;
    public boolean l;
    public ValueAnimator m;
    public int n;
    public int o;
    public float p;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SusPendedView.this.n = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            SusPendedView susPendedView = SusPendedView.this;
            susPendedView.p = 1.0f - (susPendedView.n / l.i(SusPendedView.this.getContext()));
            if (SusPendedView.this.n == 0) {
                SusPendedView.this.p = 1.0f;
            } else if (SusPendedView.this.n == l.i(SusPendedView.this.getContext())) {
                SusPendedView.this.p = 0.0f;
                if (SusPendedView.this.l && (SusPendedView.this.getContext() instanceof Activity)) {
                    ((Activity) SusPendedView.this.getContext()).finish();
                }
            }
            SusPendedView.this.requestLayout();
        }
    }

    public SusPendedView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
        if (r0 != 3) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d9  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.f13017f == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.m.isRunning()) {
            this.m.end();
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.j = motionEvent.getRawY();
                    if (this.f13020i == 0.0f && e()) {
                        this.f13020i = motionEvent.getRawY();
                    }
                    this.p = 1.0f - ((this.j - this.f13020i) / l.i(getContext()));
                }
            }
            z = this.j > this.f13020i && e();
            boolean z2 = this.j - this.f13020i > ((float) this.o) && e();
            this.l = z2;
            if (z2) {
                this.m.setIntValues((int) (this.j - this.f13020i), l.i(getContext()));
                this.m.start();
            } else {
                this.p = 1.0f;
                this.f13020i = 0.0f;
                this.j = 0.0f;
                requestLayout();
            }
            if (this.j <= this.f13020i && e()) {
                this.k = true;
                requestLayout();
                return true;
            } else if (!z) {
                this.k = true;
                return true;
            } else {
                this.k = false;
                return super.dispatchTouchEvent(motionEvent);
            }
        }
        this.j = motionEvent.getRawY();
        if (e()) {
            this.f13020i = motionEvent.getRawY();
        } else {
            this.f13020i = 0.0f;
        }
        z = false;
        if (this.j <= this.f13020i) {
        }
        if (!z) {
        }
    }

    public boolean e() {
        d.a.j0.t0.a aVar = this.f13019h;
        if (aVar == null) {
            return false;
        }
        return aVar.isOnViewTop();
    }

    public void f(int i2) {
    }

    public void g() {
        this.m.cancel();
        this.m.removeAllUpdateListeners();
        clearAnimation();
    }

    public boolean getIsFinish() {
        return this.l;
    }

    public void h() {
        this.l = true;
        this.m.setIntValues(0, l.i(getContext()));
        this.m.start();
    }

    public void i() {
        if (this.p == 0.0f) {
            this.m.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        float f2 = this.p;
        if (f2 >= 0.0f && this.f13017f != null) {
            canvas.drawColor(Color.argb((int) (f2 * 168.0f), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.m == null) {
            super.onLayout(z, i2, i3, i4, i5);
            return;
        }
        int i6 = this.n;
        if (i6 == 0) {
            super.onLayout(z, i2, i3, i4, i5);
            float f2 = this.j;
            float f3 = this.f13020i;
            if (f2 <= f3 || !this.k) {
                return;
            }
            LinearLayout linearLayout = this.f13016e;
            linearLayout.layout(i2, (int) (f2 - f3), i4, ((int) (f2 - f3)) + linearLayout.getHeight());
            this.f13018g.layout(i2, ((int) (this.j - this.f13020i)) + this.f13016e.getHeight(), i4, i5);
            return;
        }
        LinearLayout linearLayout2 = this.f13016e;
        linearLayout2.layout(i2, i6, i4, linearLayout2.getMeasuredHeight() + i6);
        this.f13018g.layout(i2, this.n + this.f13016e.getMeasuredHeight(), i4, i5);
    }

    public void setContentView(LinearLayout linearLayout) {
        this.f13018g = linearLayout;
    }

    public void setContentViewTop(d.a.j0.t0.a aVar) {
        this.f13019h = aVar;
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        this.f13016e = linearLayout;
    }

    public void setTranView(TranView tranView) {
        this.f13017f = tranView;
    }

    public SusPendedView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SusPendedView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.p = 0.0f;
        this.o = (l.i(context) / 3) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.n = l.i(context);
        ValueAnimator ofInt = ValueAnimator.ofInt(l.i(context), 0);
        this.m = ofInt;
        ofInt.setDuration(300L);
        this.m.setInterpolator(new LinearInterpolator());
        this.m.addUpdateListener(new a());
    }
}
