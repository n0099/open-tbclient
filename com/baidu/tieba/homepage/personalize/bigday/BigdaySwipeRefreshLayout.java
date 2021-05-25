package com.baidu.tieba.homepage.personalize.bigday;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import d.a.c.e.p.l;
import d.a.m0.r.f0.f;
/* loaded from: classes4.dex */
public class BigdaySwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final int[] M = {16842766};
    public int A;
    public Animation B;
    public int C;
    public boolean D;
    public int E;
    public boolean F;
    public int G;
    public Animation.AnimationListener H;
    public final Animation I;
    public final Animation J;
    public final Animation K;
    public Runnable L;

    /* renamed from: e  reason: collision with root package name */
    public int f16435e;

    /* renamed from: f  reason: collision with root package name */
    public View f16436f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16437g;

    /* renamed from: h  reason: collision with root package name */
    public int f16438h;

    /* renamed from: i  reason: collision with root package name */
    public float f16439i;
    public float j;
    public final NestedScrollingParentHelper k;
    public final NestedScrollingChildHelper l;
    public final int[] m;
    public final int[] n;
    public boolean o;
    public int p;
    public float q;
    public float r;
    public boolean s;
    public int t;
    public boolean u;
    public final DecelerateInterpolator v;
    public k w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BigdaySwipeRefreshLayout.this.F) {
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = BigdaySwipeRefreshLayout.this;
                bigdaySwipeRefreshLayout.z = -bigdaySwipeRefreshLayout.C;
            }
            BigdaySwipeRefreshLayout.this.F = false;
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = BigdaySwipeRefreshLayout.this;
            bigdaySwipeRefreshLayout2.j(bigdaySwipeRefreshLayout2.p, bigdaySwipeRefreshLayout2.H, 200);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        @SuppressLint({"NewApi"})
        public void onAnimationEnd(Animation animation) {
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = BigdaySwipeRefreshLayout.this;
            if (bigdaySwipeRefreshLayout.f16437g) {
                bigdaySwipeRefreshLayout.A();
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = BigdaySwipeRefreshLayout.this;
                bigdaySwipeRefreshLayout2.p = bigdaySwipeRefreshLayout2.w.getView().getTop();
                return;
            }
            bigdaySwipeRefreshLayout.C();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f.j {
        public c() {
        }

        @Override // d.a.m0.r.f0.f.j
        public void a(int i2) {
            BigdaySwipeRefreshLayout.this.G = i2;
            BigdaySwipeRefreshLayout.this.F = true;
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = BigdaySwipeRefreshLayout.this;
            bigdaySwipeRefreshLayout.p = (bigdaySwipeRefreshLayout.p - bigdaySwipeRefreshLayout.z) - bigdaySwipeRefreshLayout.G;
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = BigdaySwipeRefreshLayout.this;
            bigdaySwipeRefreshLayout2.z = -bigdaySwipeRefreshLayout2.G;
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout3 = BigdaySwipeRefreshLayout.this;
            bigdaySwipeRefreshLayout3.G(bigdaySwipeRefreshLayout3.z - bigdaySwipeRefreshLayout3.p, false);
        }

        @Override // d.a.m0.r.f0.f.j
        public void onAnimationEnd() {
            BigdaySwipeRefreshLayout.this.setRefreshing(false);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends Animation {
        public d() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            BigdaySwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BigdaySwipeRefreshLayout.this.w.g();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Animation.AnimationListener {
        public f() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BigdaySwipeRefreshLayout.this.I(null);
            BigdaySwipeRefreshLayout.this.o();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class g extends Animation {
        public g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            int i2;
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = BigdaySwipeRefreshLayout.this;
            if (bigdaySwipeRefreshLayout.w == null) {
                return;
            }
            if (!bigdaySwipeRefreshLayout.D) {
                i2 = bigdaySwipeRefreshLayout.A - Math.abs(bigdaySwipeRefreshLayout.z);
            } else {
                i2 = bigdaySwipeRefreshLayout.A;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = BigdaySwipeRefreshLayout.this;
            int i3 = bigdaySwipeRefreshLayout2.y;
            BigdaySwipeRefreshLayout.this.G((i3 + ((int) ((i2 - i3) * f2))) - bigdaySwipeRefreshLayout2.w.getView().getTop(), false);
        }
    }

    /* loaded from: classes4.dex */
    public class h extends Animation {
        public h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = BigdaySwipeRefreshLayout.this;
            k kVar = bigdaySwipeRefreshLayout.w;
            if (kVar == null) {
                return;
            }
            int i2 = bigdaySwipeRefreshLayout.y;
            BigdaySwipeRefreshLayout.this.G((i2 + ((int) ((-i2) * f2))) - kVar.getView().getTop(), false);
        }
    }

    /* loaded from: classes4.dex */
    public class i extends Animation {
        public i() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            BigdaySwipeRefreshLayout.this.w(f2);
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BigdaySwipeRefreshLayout.this.F) {
                BigdaySwipeRefreshLayout.this.F = false;
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = BigdaySwipeRefreshLayout.this;
                bigdaySwipeRefreshLayout.z = -bigdaySwipeRefreshLayout.C;
                BigdaySwipeRefreshLayout.this.requestLayout();
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = BigdaySwipeRefreshLayout.this;
                bigdaySwipeRefreshLayout2.j(bigdaySwipeRefreshLayout2.p, bigdaySwipeRefreshLayout2.H, 200);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface k extends BdSwipeRefreshLayout.i {
        void f();

        void g();

        int h();

        void j();
    }

    public BigdaySwipeRefreshLayout(Context context) {
        this(context, null);
    }

    @SuppressLint({"NewApi"})
    private void setColorViewAlpha(int i2) {
        k kVar = this.w;
        if (kVar == null || kVar.getView() == null || this.w.getView().getBackground() == null) {
            return;
        }
        this.w.getView().getBackground().setAlpha(i2);
    }

    public final void A() {
        k kVar = this.w;
        if (kVar != null) {
            this.f16435e = 2;
            kVar.m();
        }
    }

    public final void B() {
        k kVar = this.w;
        if (kVar != null) {
            this.f16435e = 1;
            kVar.d();
        }
    }

    public void C() {
        o();
        if (getLayoutParams() instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = this.E;
        }
        k kVar = this.w;
        if (kVar != null) {
            kVar.getView().setVisibility(8);
            k kVar2 = this.w;
            if (kVar2 instanceof d.a.m0.r.f0.f) {
                ((d.a.m0.r.f0.f) kVar2).J();
            }
            setColorViewAlpha(255);
            G(this.z - this.p, true);
            this.p = -this.C;
        }
    }

    public void D() {
        if (this.f16435e == 6) {
            if (getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = this.E;
            }
            j(this.p, null, 400);
            this.f16437g = false;
            this.f16435e = 4;
        }
    }

    public final void E(boolean z, boolean z2) {
        F(z, z2, null);
    }

    public final void F(boolean z, boolean z2, f.i iVar) {
        if (this.f16437g != z) {
            q(z);
            n();
            this.f16437g = z;
            if (z) {
                h(this.p, this.H);
            } else {
                m(iVar);
            }
        }
    }

    public void G(int i2, boolean z) {
        k kVar = this.w;
        if (kVar == null) {
            return;
        }
        kVar.getView().bringToFront();
        ViewCompat.offsetTopAndBottom(this.w.getView(), i2);
        View view = this.f16436f;
        if (view != null) {
            ViewCompat.offsetTopAndBottom(view, i2);
        }
        this.p = this.w.getView().getTop();
        if (!z || Build.VERSION.SDK_INT >= 11) {
            return;
        }
        invalidate();
    }

    @SuppressLint({"NewApi"})
    public final void H(float f2) {
        float f3 = this.r;
        int i2 = this.f16438h;
        if (f2 - f3 <= i2 || this.s) {
            return;
        }
        this.q = f3 + i2;
        this.s = true;
    }

    public void I(Animation.AnimationListener animationListener) {
        d dVar = new d();
        this.B = dVar;
        dVar.setDuration(150L);
        this.B.setAnimationListener(animationListener);
        k kVar = this.w;
        if (kVar != null) {
            kVar.getView().clearAnimation();
            this.w.getView().startAnimation(this.B);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.l.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.l.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.l.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.l.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.x;
        return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.k.getNestedScrollAxes();
    }

    public k getProgressView() {
        return this.w;
    }

    public final void h(int i2, Animation.AnimationListener animationListener) {
        if (this.w == null) {
            return;
        }
        this.y = i2;
        this.I.reset();
        this.I.setDuration(200L);
        this.I.setInterpolator(this.v);
        if (animationListener != null) {
            this.I.setAnimationListener(animationListener);
        }
        if (this.w.getView().getVisibility() != 0) {
            this.w.getView().setVisibility(0);
        }
        this.w.getView().clearAnimation();
        this.w.getView().startAnimation(this.I);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.l.hasNestedScrollingParent();
    }

    public final void i(int i2, Animation.AnimationListener animationListener) {
        if (this.w == null) {
            return;
        }
        this.y = i2;
        this.J.reset();
        this.J.setDuration(500L);
        this.J.setInterpolator(this.v);
        if (animationListener != null) {
            this.J.setAnimationListener(animationListener);
        }
        this.w.getView().clearAnimation();
        this.w.getView().startAnimation(this.J);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.l.isNestedScrollingEnabled();
    }

    public void j(int i2, Animation.AnimationListener animationListener, int i3) {
        if (this.w == null) {
            return;
        }
        this.y = i2;
        this.K.reset();
        this.K.setDuration(i3);
        this.K.setInterpolator(this.v);
        if (animationListener != null) {
            this.K.setAnimationListener(animationListener);
        }
        this.w.getView().clearAnimation();
        this.w.getView().startAnimation(this.K);
    }

    public boolean k() {
        return ViewCompat.canScrollVertically(this.f16436f, -1);
    }

    public final void l() {
        this.f16437g = false;
        j(this.p, new f(), 200);
        if ((getLayoutParams() instanceof FrameLayout.LayoutParams) && ((FrameLayout.LayoutParams) getLayoutParams()).topMargin == 0) {
            ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = this.E;
        }
    }

    public final void m(f.i iVar) {
        if (this.w != null) {
            this.f16435e = 3;
            if (iVar != null && u()) {
                k kVar = this.w;
                if (kVar instanceof d.a.m0.r.f0.f) {
                    ((d.a.m0.r.f0.f) kVar).Q(iVar);
                    setExecuteMsgAnimation(true);
                    this.w.k();
                    d.a.c.e.m.e.a().removeCallbacks(this.L);
                    d.a.c.e.m.e.a().postDelayed(this.L, 3000L);
                    return;
                }
            }
            setExecuteMsgAnimation(false);
            this.w.k();
            postDelayed(new a(), this.w.getCompleteAnimTime());
        }
    }

    public final void n() {
        if (this.f16436f == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                k kVar = this.w;
                if (kVar == null || !childAt.equals(kVar.getView())) {
                    this.f16436f = childAt;
                    return;
                }
            }
        }
    }

    public void o() {
        k kVar = this.w;
        if (kVar != null) {
            this.f16435e = 4;
            this.f16437g = false;
            kVar.getView().clearAnimation();
            this.w.onFinish();
            if (this.F) {
                int i2 = this.C;
                this.z = -i2;
                this.p = (this.p - i2) + this.G;
            }
            this.F = false;
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        n();
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.u && actionMasked == 0) {
            this.u = false;
        }
        if (!isEnabled() || this.u || k() || this.o) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.t;
                    if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) < 0) {
                        return false;
                    }
                    H(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        x(motionEvent);
                    }
                }
            }
            this.s = false;
            this.t = -1;
        } else {
            int pointerId = motionEvent.getPointerId(0);
            this.t = pointerId;
            this.s = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.r = motionEvent.getY(findPointerIndex2);
        }
        return this.s;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingTop;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f16436f == null) {
            n();
        }
        View view = this.f16436f;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        if (this.F) {
            paddingTop = getPaddingTop() + this.G;
        } else {
            paddingTop = (getPaddingTop() + this.p) - this.z;
        }
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        k kVar = this.w;
        if (kVar != null) {
            int measuredWidth2 = kVar.getView().getMeasuredWidth();
            int measuredHeight2 = this.w.getView().getMeasuredHeight();
            k kVar2 = this.w;
            if (kVar2 != null) {
                if (this.F) {
                    kVar2.getView().layout(paddingLeft, 0, measuredWidth2 + paddingLeft, measuredHeight2);
                    return;
                }
                View view2 = kVar2.getView();
                int i6 = this.p;
                view2.layout(paddingLeft, i6, measuredWidth2 + paddingLeft, measuredHeight2 + i6);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f16436f == null) {
            n();
        }
        View view = this.f16436f;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        k kVar = this.w;
        if (kVar != null) {
            if (this.F) {
                kVar.getView().measure(View.MeasureSpec.makeMeasureSpec(l.k(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(this.G, 1073741824));
                this.z = -this.G;
            } else {
                kVar.getView().measure(View.MeasureSpec.makeMeasureSpec(l.k(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(this.C, 1073741824));
                this.z = -this.C;
            }
            this.x = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.w.getView()) {
                    this.x = i4;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        int i2;
        int i3 = this.f16435e;
        if ((i3 == 3 || i3 == 2) && f3 > 0.0f && (i2 = this.p) > this.z) {
            j(i2, null, 200);
        }
        return dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        k kVar;
        int i2 = this.f16435e;
        if (i2 == 3 || i2 == 2 || (kVar = this.w) == null || kVar.getView() == null || this.w.getView().getBottom() <= 0) {
            return dispatchNestedPreFling(f2, f3);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.j;
            if (f2 > 0.0f) {
                float f3 = i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.j = 0.0f;
                } else {
                    this.j = f2 - f3;
                    iArr[1] = i3;
                }
                v(this.j);
            }
        }
        if (this.w != null && this.D && i3 > 0 && this.j == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.w.getView().setVisibility(8);
        }
        int[] iArr2 = this.m;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
        int i4 = i3 - iArr[1];
        if ((t() || this.f16435e == 3) && Math.abs(i4) > 0) {
            if ((i4 <= 0 || this.p <= this.z) && (i4 >= 0 || this.p >= this.z + this.A || k())) {
                return;
            }
            v(Math.max(Math.min(this.A, (this.p - this.z) - i4), 0.0f));
            iArr[1] = iArr[1] + i4;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.n);
        int i6 = i5 + this.n[1];
        if (i6 >= 0 || k() || this.f16437g) {
            return;
        }
        float abs = this.j + Math.abs(i6);
        this.j = abs;
        v(abs);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.k.onNestedScrollAccepted(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.j = 0.0f;
        this.o = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (!isEnabled() || this.u || (i2 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.k.onStopNestedScroll(view);
        this.o = false;
        float f2 = this.j;
        if (f2 > 0.0f) {
            p(f2);
            this.j = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.w.getView().getAnimation() != null && !this.w.getView().getAnimation().hasEnded()) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.u && actionMasked == 0) {
            this.u = false;
        }
        if (!isEnabled() || this.u || k() || this.f16437g || this.o) {
            return false;
        }
        if (actionMasked == 0) {
            this.t = motionEvent.getPointerId(0);
            this.s = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.t);
            if (findPointerIndex < 0) {
                return false;
            }
            if (this.s) {
                this.s = false;
                p((motionEvent.getY(findPointerIndex) - this.q) * 0.5f);
            }
            this.t = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.t);
            if (findPointerIndex2 < 0) {
                return false;
            }
            float y = motionEvent.getY(findPointerIndex2);
            H(y);
            if (this.s) {
                float f2 = (y - this.q) * 0.5f;
                if (f2 <= 0.0f) {
                    return false;
                }
                v(f2);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                if (actionIndex < 0) {
                    return false;
                }
                this.t = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                x(motionEvent);
            }
        }
        return true;
    }

    public final void p(float f2) {
        k kVar = this.w;
        if (kVar == null) {
            return;
        }
        if (kVar.h() > 0 && this.p - this.z > this.w.h()) {
            this.f16435e = 6;
            this.w.j();
            ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = 0;
            this.f16437g = false;
            i(this.p, new e());
        } else if (this.p - this.z > this.A) {
            E(true, true);
        } else {
            l();
        }
    }

    public final void q(boolean z) {
        if (z && this.w != null) {
            if (this.F) {
                this.z = -this.C;
            }
            this.F = false;
            if (u()) {
                k kVar = this.w;
                if (kVar instanceof d.a.m0.r.f0.f) {
                    ((d.a.m0.r.f0.f) kVar).J();
                }
            }
        }
    }

    public void r() {
        n();
        this.f16437g = false;
        w(1.0f);
        C();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.f16436f instanceof AbsListView)) {
            View view = this.f16436f;
            if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    public final boolean s() {
        return Build.VERSION.SDK_INT < 11;
    }

    public void setAnimationProgress(float f2) {
        if (s()) {
            setColorViewAlpha((int) (f2 * 255.0f));
            return;
        }
        k kVar = this.w;
        if (kVar != null) {
            ViewCompat.setScaleX(kVar.getView(), f2);
            ViewCompat.setScaleY(this.w.getView(), f2);
        }
    }

    public void setCustomDistances(int i2, int i3, int i4) {
        this.f16439i = i3;
        this.A = i2;
        this.C = i4;
        int i5 = -i4;
        this.p = i5;
        this.z = i5;
        w(1.0f);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        C();
    }

    public void setExecuteMsgAnimation(boolean z) {
        k kVar = this.w;
        if (kVar != null && (kVar instanceof d.a.m0.r.f0.f)) {
            ((d.a.m0.r.f0.f) kVar).O(z);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.l.setNestedScrollingEnabled(z);
    }

    public void setProgressView(k kVar) {
        if (kVar == null || kVar.getView() == null || kVar == this.w) {
            return;
        }
        int i2 = this.f16435e;
        if (i2 == 4 || i2 == 6) {
            k kVar2 = this.w;
            if (kVar2 != null) {
                removeView(kVar2.getView());
            }
            this.w = kVar;
            kVar.getView().setVisibility(8);
            addView(this.w.getView(), 0);
            if (kVar instanceof d.a.n0.b1.g.i.a) {
                ((d.a.n0.b1.g.i.a) kVar).S(new c());
            }
        }
    }

    public void setRefreshing(boolean z) {
        E(z, false);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.l.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.l.stopNestedScroll();
    }

    public boolean t() {
        return this.f16437g;
    }

    public boolean u() {
        k kVar = this.w;
        if (kVar != null && (kVar instanceof d.a.m0.r.f0.f)) {
            return ((d.a.m0.r.f0.f) kVar).M();
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public final void v(float f2) {
        int i2;
        if (this.w == null) {
            return;
        }
        float min = Math.min(1.0f, Math.abs(f2 / this.f16439i));
        Math.max(min - 0.4d, 0.0d);
        float abs = Math.abs(f2) - this.f16439i;
        int i3 = this.A;
        if (this.w.h() > 0) {
            i3 = this.w.h();
        }
        if (this.D) {
            i3 -= this.z;
        }
        float f3 = i3;
        double max = Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f;
        float pow = ((float) (max - Math.pow(max, 2.0d))) * 2.0f;
        int i4 = this.z + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
        if (this.w.getView().getVisibility() != 0) {
            this.w.getView().setVisibility(0);
        }
        ViewCompat.setScaleX(this.w.getView(), 1.0f);
        ViewCompat.setScaleY(this.w.getView(), 1.0f);
        if (!this.f16437g && (i2 = this.f16435e) != 3 && i2 != 6) {
            int i5 = this.z;
            int i6 = this.p;
            if (i5 < i6) {
                if (i6 - i5 < this.A) {
                    if (i2 != 0) {
                        y();
                    }
                } else if (this.w.h() > 0 && this.p - this.z > this.w.h()) {
                    this.f16435e = 5;
                    this.w.f();
                } else if (this.f16435e != 1) {
                    B();
                }
            }
            this.w.e((this.p - this.z) / this.A, pow);
        }
        G(i4 - this.p, true);
    }

    public void w(float f2) {
        k kVar = this.w;
        if (kVar == null) {
            return;
        }
        int i2 = this.y;
        G((i2 + ((int) ((this.z - i2) * f2))) - kVar.getView().getTop(), false);
    }

    public final void x(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (motionEvent.getPointerId(actionIndex) == this.t) {
            this.t = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    public final void y() {
        k kVar = this.w;
        if (kVar != null) {
            this.f16435e = 0;
            kVar.c();
        }
    }

    public void z(f.i iVar) {
        if (iVar == null) {
            setRefreshing(false);
        } else if (!u()) {
            setRefreshing(false);
        } else {
            F(false, false, iVar);
        }
    }

    public BigdaySwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16435e = 4;
        this.f16437g = false;
        this.f16439i = -1.0f;
        this.m = new int[2];
        this.n = new int[2];
        this.t = -1;
        this.x = -1;
        this.F = false;
        this.H = new b();
        this.I = new g();
        this.J = new h();
        this.K = new i();
        this.L = new j();
        this.f16438h = ViewConfiguration.get(context).getScaledTouchSlop();
        this.v = new DecelerateInterpolator(2.0f);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.k = new NestedScrollingParentHelper(this);
        this.l = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, M);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        this.E = 0;
    }
}
