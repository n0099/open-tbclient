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
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class SusPendedView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f14007e;

    /* renamed from: f  reason: collision with root package name */
    public TranView f14008f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f14009g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.t0.a f14010h;
    public float i;
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
        if (this.f14008f == null) {
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
                    if (this.i == 0.0f && e()) {
                        this.i = motionEvent.getRawY();
                    }
                    this.p = 1.0f - ((this.j - this.i) / l.i(getContext()));
                }
            }
            z = this.j > this.i && e();
            boolean z2 = this.j - this.i > ((float) this.o) && e();
            this.l = z2;
            if (z2) {
                this.m.setIntValues((int) (this.j - this.i), l.i(getContext()));
                this.m.start();
            } else {
                this.p = 1.0f;
                this.i = 0.0f;
                this.j = 0.0f;
                requestLayout();
            }
            if (this.j <= this.i && e()) {
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
            this.i = motionEvent.getRawY();
        } else {
            this.i = 0.0f;
        }
        z = false;
        if (this.j <= this.i) {
        }
        if (!z) {
        }
    }

    public boolean e() {
        d.b.h0.t0.a aVar = this.f14010h;
        if (aVar == null) {
            return false;
        }
        return aVar.isOnViewTop();
    }

    public void f(int i) {
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
        if (f2 >= 0.0f && this.f14008f != null) {
            canvas.drawColor(Color.argb((int) (f2 * 168.0f), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.m == null) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int i5 = this.n;
        if (i5 == 0) {
            super.onLayout(z, i, i2, i3, i4);
            float f2 = this.j;
            float f3 = this.i;
            if (f2 <= f3 || !this.k) {
                return;
            }
            LinearLayout linearLayout = this.f14007e;
            linearLayout.layout(i, (int) (f2 - f3), i3, ((int) (f2 - f3)) + linearLayout.getHeight());
            this.f14009g.layout(i, ((int) (this.j - this.i)) + this.f14007e.getHeight(), i3, i4);
            return;
        }
        LinearLayout linearLayout2 = this.f14007e;
        linearLayout2.layout(i, i5, i3, linearLayout2.getMeasuredHeight() + i5);
        this.f14009g.layout(i, this.n + this.f14007e.getMeasuredHeight(), i3, i4);
    }

    public void setContentView(LinearLayout linearLayout) {
        this.f14009g = linearLayout;
    }

    public void setContentViewTop(d.b.h0.t0.a aVar) {
        this.f14010h = aVar;
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        this.f14007e = linearLayout;
    }

    public void setTranView(TranView tranView) {
        this.f14008f = tranView;
    }

    public SusPendedView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SusPendedView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
