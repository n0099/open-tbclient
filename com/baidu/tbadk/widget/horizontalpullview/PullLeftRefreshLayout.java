package com.baidu.tbadk.widget.horizontalpullview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes3.dex */
public class PullLeftRefreshLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f13850e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.b1.h.a f13851f;

    /* renamed from: g  reason: collision with root package name */
    public View f13852g;

    /* renamed from: h  reason: collision with root package name */
    public int f13853h;

    /* renamed from: i  reason: collision with root package name */
    public int f13854i;
    public int j;
    public int k;
    public float l;
    public ValueAnimator m;
    public ValueAnimator n;
    public int o;
    public int p;
    public int q;
    public float r;
    public f s;
    public boolean t;
    public RecyclerView.OnScrollListener u;

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public int f13855a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f13856b = true;

        /* renamed from: c  reason: collision with root package name */
        public int f13857c = 0;

        /* renamed from: d  reason: collision with root package name */
        public ValueAnimator f13858d;

        /* renamed from: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0177a implements ValueAnimator.AnimatorUpdateListener {
            public C0177a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* loaded from: classes3.dex */
        public class b extends AnimatorListenerAdapter {
            public b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.f();
            }
        }

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
            this.f13855a = i2;
            if (PullLeftRefreshLayout.this.t && this.f13855a == 0 && !this.f13856b) {
                ValueAnimator valueAnimator = this.f13858d;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                int i3 = (int) (PullLeftRefreshLayout.this.l - 1.0f);
                if (this.f13857c > i3) {
                    this.f13857c = i3;
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(this.f13857c, 0);
                this.f13858d = ofInt;
                ofInt.setDuration(100L);
                this.f13858d.addUpdateListener(new C0177a());
                this.f13858d.addListener(new b());
                this.f13858d.start();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
            this.f13857c = i2;
            if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                this.f13856b = false;
            } else {
                this.f13856b = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator != null) {
                PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PullLeftRefreshLayout.this.f();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator != null) {
                PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends AnimatorListenerAdapter {

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PullLeftRefreshLayout.this.i();
            }
        }

        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PullLeftRefreshLayout.this.f();
            PullLeftRefreshLayout.this.postDelayed(new a(), 50L);
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.r = 0.0f;
        this.t = false;
        this.u = new a();
        g(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f2) {
        RecyclerView recyclerView = this.f13850e;
        if (recyclerView != null) {
            recyclerView.setTranslationX(f2);
        }
        View view = this.f13852g;
        if (view != null) {
            view.setTranslationX(this.f13854i + f2);
        }
    }

    public boolean e() {
        return ViewCompat.canScrollHorizontally(this.f13850e, 1);
    }

    public final void f() {
        this.f13853h = 0;
        this.r = 0.0f;
        setTranslationStatus(0.0f);
    }

    public final void g(Context context) {
    }

    public boolean h() {
        return this.t;
    }

    public void i() {
        f fVar = this.s;
        if (fVar != null) {
            fVar.a();
        }
    }

    public final void j() {
        ValueAnimator valueAnimator = this.m;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(Math.abs(this.r), 0.0f);
        this.m = ofFloat;
        ofFloat.setDuration(150L);
        this.m.addUpdateListener(new b());
        this.m.addListener(new c());
        this.m.start();
        View view = this.f13852g;
        if (view != null) {
            this.f13851f.b(view);
        }
    }

    public final void k() {
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(Math.abs(this.r), 0.0f);
        this.n = ofFloat;
        ofFloat.setDuration(150L);
        this.n.addUpdateListener(new d());
        this.n.addListener(new e());
        this.n.start();
        View view = this.f13852g;
        if (view != null) {
            this.f13851f.b(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        RecyclerView recyclerView = this.f13850e;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(this.u);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RecyclerView recyclerView = this.f13850e;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.u);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof RecyclerView) {
                RecyclerView recyclerView = (RecyclerView) childAt;
                this.f13850e = recyclerView;
                if (recyclerView != null) {
                    recyclerView.addOnScrollListener(this.u);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        if (r2 != 3) goto L9;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i2 = x - this.o;
                    this.o = x;
                    this.q = x;
                    this.p = y;
                    if (Math.abs(i2) > Math.abs(y - this.p) && this.t && i2 < 0 && !e() && this.f13853h == 0) {
                        if (getParent() != null) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        this.f13853h = 2;
                        d.a.i0.b1.h.a aVar = this.f13851f;
                        if (aVar != null) {
                            aVar.b(this.f13852g);
                        }
                        return true;
                    }
                }
            }
            this.o = 0;
            this.p = 0;
        } else {
            this.o = x;
            this.q = x;
            this.p = y;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f13853h == 0) {
            this.f13852g.setTranslationX(this.f13854i);
        }
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        View view = this.f13852g;
        if (view != null) {
            int measuredWidth = view.getMeasuredWidth();
            this.f13854i = measuredWidth;
            int i4 = measuredWidth * 2;
            this.k = i4;
            this.j = i4 + measuredWidth;
            this.l = measuredWidth;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
        if (r1 != 3) goto L14;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.t) {
            return super.onTouchEvent(motionEvent);
        }
        int x = (int) motionEvent.getX();
        motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i2 = x - this.q;
                    this.q = x;
                    float abs = this.r + (i2 * (1.0f - Math.abs(this.r / this.j)));
                    this.r = abs;
                    if (abs >= 0.0f) {
                        this.r = 0.0f;
                        this.f13850e.setTranslationX(0.0f);
                        d.a.i0.b1.h.a aVar = this.f13851f;
                        if (aVar != null) {
                            aVar.b(this.f13852g);
                        }
                    } else {
                        int i3 = this.j;
                        if (abs <= (-i3)) {
                            float f2 = -i3;
                            this.r = f2;
                            this.f13850e.setTranslationX(f2);
                            d.a.i0.b1.h.a aVar2 = this.f13851f;
                            if (aVar2 != null) {
                                aVar2.a(this.f13852g);
                            }
                        } else {
                            this.f13850e.setTranslationX(abs);
                            if (Math.abs(this.r) > this.l) {
                                d.a.i0.b1.h.a aVar3 = this.f13851f;
                                if (aVar3 != null) {
                                    aVar3.a(this.f13852g);
                                }
                            } else {
                                d.a.i0.b1.h.a aVar4 = this.f13851f;
                                if (aVar4 != null) {
                                    aVar4.b(this.f13852g);
                                }
                            }
                        }
                    }
                    View view = this.f13852g;
                    if (view != null) {
                        view.setTranslationX(this.f13854i + this.r);
                    }
                    return true;
                }
            }
            this.o = 0;
            this.q = 0;
            this.p = 0;
            if (Math.abs(this.r) < this.l) {
                j();
            } else {
                k();
            }
            return true;
        }
        this.q = x;
        return super.onTouchEvent(motionEvent);
    }

    public void setCallback(f fVar) {
        this.s = fVar;
    }

    public void setEnablePull(boolean z) {
        this.t = z;
    }

    public void setRefreshViewAndListener(d.a.i0.b1.h.a aVar) {
        this.f13851f = aVar;
        this.f13852g = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388613;
        this.f13852g.setLayoutParams(layoutParams);
        addView(this.f13852g, 0);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = 0.0f;
        this.t = false;
        this.u = new a();
        g(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.r = 0.0f;
        this.t = false;
        this.u = new a();
        g(context);
    }
}
