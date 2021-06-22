package com.baidu.tbadk.widget.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.widget.pulltorefresh.library.internal.FlipLoadingLayout;
import com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout;
import com.baidu.tbadk.widget.pulltorefresh.library.internal.RotateLoadingLayout;
import com.baidu.tieba.R$styleable;
/* loaded from: classes3.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    public PullToRefreshBase<T>.h A;

    /* renamed from: e  reason: collision with root package name */
    public int f13365e;

    /* renamed from: f  reason: collision with root package name */
    public float f13366f;

    /* renamed from: g  reason: collision with root package name */
    public float f13367g;

    /* renamed from: h  reason: collision with root package name */
    public float f13368h;

    /* renamed from: i  reason: collision with root package name */
    public float f13369i;
    public boolean j;
    public State k;
    public Mode l;
    public Mode m;
    public T n;
    public FrameLayout o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public Interpolator t;
    public AnimationStyle u;
    public LoadingLayout v;
    public LoadingLayout w;
    public f<T> x;
    public e<T> y;
    public d<T> z;

    /* loaded from: classes3.dex */
    public enum AnimationStyle {
        ROTATE,
        FLIP;

        public static AnimationStyle getDefault() {
            return ROTATE;
        }

        public static AnimationStyle mapIntToValue(int i2) {
            if (i2 != 1) {
                return ROTATE;
            }
            return FLIP;
        }

        public LoadingLayout createLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
            if (c.f13375d[ordinal()] != 2) {
                return new RotateLoadingLayout(context, mode, orientation, typedArray);
            }
            return new FlipLoadingLayout(context, mode, orientation, typedArray);
        }
    }

    /* loaded from: classes3.dex */
    public enum Mode {
        DISABLED(0),
        PULL_FROM_START(1),
        PULL_FROM_END(2),
        BOTH(3),
        MANUAL_REFRESH_ONLY(4);
        
        public static Mode PULL_DOWN_TO_REFRESH;
        public static Mode PULL_UP_TO_REFRESH;
        public int mIntValue;

        static {
            Mode mode = PULL_FROM_START;
            Mode mode2 = PULL_FROM_END;
            PULL_DOWN_TO_REFRESH = mode;
            PULL_UP_TO_REFRESH = mode2;
        }

        Mode(int i2) {
            this.mIntValue = i2;
        }

        public static Mode getDefault() {
            return PULL_FROM_START;
        }

        public static Mode mapIntToValue(int i2) {
            Mode[] values;
            for (Mode mode : values()) {
                if (i2 == mode.getIntValue()) {
                    return mode;
                }
            }
            return getDefault();
        }

        public int getIntValue() {
            return this.mIntValue;
        }

        public boolean permitsPullToRefresh() {
            return (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : true;
        }

        public boolean showFooterLoadingLayout() {
            return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
        }

        public boolean showHeaderLoadingLayout() {
            return this == PULL_FROM_START || this == BOTH;
        }
    }

    /* loaded from: classes3.dex */
    public enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    /* loaded from: classes3.dex */
    public enum State {
        RESET(0),
        PULL_TO_REFRESH(1),
        RELEASE_TO_REFRESH(2),
        REFRESHING(8),
        MANUAL_REFRESHING(9),
        OVERSCROLLING(16);
        
        public int mIntValue;

        State(int i2) {
            this.mIntValue = i2;
        }

        public static State mapIntToValue(int i2) {
            State[] values;
            for (State state : values()) {
                if (i2 == state.getIntValue()) {
                    return state;
                }
            }
            return RESET;
        }

        public int getIntValue() {
            return this.mIntValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements g {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.g
        public void a() {
            PullToRefreshBase.this.f();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PullToRefreshBase.this.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f13372a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f13373b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f13374c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f13375d;

        static {
            int[] iArr = new int[AnimationStyle.values().length];
            f13375d = iArr;
            try {
                iArr[AnimationStyle.ROTATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13375d[AnimationStyle.FLIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Mode.values().length];
            f13374c = iArr2;
            try {
                iArr2[Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13374c[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13374c[Mode.MANUAL_REFRESH_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13374c[Mode.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[State.values().length];
            f13373b = iArr3;
            try {
                iArr3[State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13373b[State.PULL_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13373b[State.RELEASE_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13373b[State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13373b[State.MANUAL_REFRESHING.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f13373b[State.OVERSCROLLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr4 = new int[Orientation.values().length];
            f13372a = iArr4;
            try {
                iArr4[Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f13372a[Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase, State state, Mode mode);
    }

    /* loaded from: classes3.dex */
    public interface e<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);

        void b(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* loaded from: classes3.dex */
    public interface f<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a();
    }

    /* loaded from: classes3.dex */
    public final class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Interpolator f13376e;

        /* renamed from: f  reason: collision with root package name */
        public final int f13377f;

        /* renamed from: g  reason: collision with root package name */
        public final int f13378g;

        /* renamed from: h  reason: collision with root package name */
        public final long f13379h;

        /* renamed from: i  reason: collision with root package name */
        public g f13380i;
        public boolean j = true;
        public long k = -1;
        public int l = -1;

        public h(int i2, int i3, long j, g gVar) {
            this.f13378g = i2;
            this.f13377f = i3;
            this.f13376e = PullToRefreshBase.this.t;
            this.f13379h = j;
            this.f13380i = gVar;
        }

        public void a() {
            this.j = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.k == -1) {
                this.k = System.currentTimeMillis();
            } else {
                int round = this.f13378g - Math.round((this.f13378g - this.f13377f) * this.f13376e.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.k) * 1000) / this.f13379h, 1000L), 0L)) / 1000.0f));
                this.l = round;
                PullToRefreshBase.this.setHeaderScroll(round);
            }
            if (this.j && this.f13377f != this.l) {
                d.a.n0.b1.l.a.c.b.a(PullToRefreshBase.this, this);
                return;
            }
            g gVar = this.f13380i;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.j = false;
        this.k = State.RESET;
        this.l = Mode.getDefault();
        this.p = true;
        this.q = false;
        this.r = true;
        this.s = true;
        this.u = AnimationStyle.getDefault();
        l(context, null);
    }

    private LinearLayout.LayoutParams getLoadingLayoutLayoutParams() {
        if (c.f13372a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            return new LinearLayout.LayoutParams(-1, -2);
        }
        return new LinearLayout.LayoutParams(-2, -1);
    }

    private int getMaximumPullScroll() {
        if (c.f13372a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            return Math.round(getHeight() / 2.0f);
        }
        return Math.round(getWidth() / 2.0f);
    }

    public final void A(State state, boolean... zArr) {
        this.k = state;
        int i2 = c.f13373b[state.ordinal()];
        if (i2 == 1) {
            w();
        } else if (i2 == 2) {
            t();
        } else if (i2 == 3) {
            v();
        } else if (i2 == 4 || i2 == 5) {
            u(zArr[0]);
        }
        d<T> dVar = this.z;
        if (dVar != null) {
            dVar.a(this, this.k, this.m);
        }
    }

    public final void B(int i2) {
        C(i2, getPullToRefreshScrollDuration());
    }

    public final void C(int i2, long j) {
        D(i2, j, 0L, null);
    }

    public final void D(int i2, long j, long j2, g gVar) {
        int scrollX;
        PullToRefreshBase<T>.h hVar = this.A;
        if (hVar != null) {
            hVar.a();
        }
        if (c.f13372a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            scrollX = getScrollY();
        } else {
            scrollX = getScrollX();
        }
        int i3 = scrollX;
        if (i3 != i2) {
            if (this.t == null) {
                this.t = new DecelerateInterpolator();
            }
            PullToRefreshBase<T>.h hVar2 = new h(i3, i2, j, gVar);
            this.A = hVar2;
            if (j2 > 0) {
                postDelayed(hVar2, j2);
            } else {
                post(hVar2);
            }
        }
    }

    public final void E(int i2, g gVar) {
        D(i2, getPullToRefreshScrollDuration(), 0L, gVar);
    }

    public void F() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.v.getParent()) {
            removeView(this.v);
        }
        if (this.l.showHeaderLoadingLayout()) {
            d(this.v, 0, loadingLayoutLayoutParams);
        }
        if (this == this.w.getParent()) {
            removeView(this.w);
        }
        if (this.l.showFooterLoadingLayout()) {
            e(this.w, loadingLayoutLayoutParams);
        }
        y();
        Mode mode = this.l;
        if (mode == Mode.BOTH) {
            mode = Mode.PULL_FROM_START;
        }
        this.m = mode;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        T refreshableView = getRefreshableView();
        if (refreshableView instanceof ViewGroup) {
            ((ViewGroup) refreshableView).addView(view, i2, layoutParams);
            return;
        }
        throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
    }

    public final void c(Context context, T t) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.o = frameLayout;
        frameLayout.addView(t, -1, -1);
        e(this.o, new LinearLayout.LayoutParams(-1, -1));
    }

    public final void d(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
    }

    public final void e(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    public final void f() {
        f<T> fVar = this.x;
        if (fVar != null) {
            fVar.a(this);
            return;
        }
        e<T> eVar = this.y;
        if (eVar != null) {
            Mode mode = this.m;
            if (mode == Mode.PULL_FROM_START) {
                eVar.b(this);
            } else if (mode == Mode.PULL_FROM_END) {
                eVar.a(this);
            }
        }
    }

    public LoadingLayout g(Context context, Mode mode, TypedArray typedArray) {
        LoadingLayout createLoadingLayout = this.u.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    public final Mode getCurrentMode() {
        return this.m;
    }

    public final boolean getFilterTouchEvents() {
        return this.r;
    }

    public final LoadingLayout getFooterLayout() {
        return this.w;
    }

    public final int getFooterSize() {
        return this.w.getContentSize();
    }

    public final LoadingLayout getHeaderLayout() {
        return this.v;
    }

    public final int getHeaderSize() {
        return this.v.getContentSize();
    }

    public final d.a.n0.b1.l.a.a getLoadingLayoutProxy() {
        return j(true, true);
    }

    public final Mode getMode() {
        return this.l;
    }

    public abstract Orientation getPullToRefreshScrollDirection();

    public int getPullToRefreshScrollDuration() {
        return 200;
    }

    public int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    public final T getRefreshableView() {
        return this.n;
    }

    public FrameLayout getRefreshableViewWrapper() {
        return this.o;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.p;
    }

    public final State getState() {
        return this.k;
    }

    public d.a.n0.b1.l.a.b h(boolean z, boolean z2) {
        d.a.n0.b1.l.a.b bVar = new d.a.n0.b1.l.a.b();
        if (z && this.l.showHeaderLoadingLayout()) {
            bVar.a(this.v);
        }
        if (z2 && this.l.showFooterLoadingLayout()) {
            bVar.a(this.w);
        }
        return bVar;
    }

    public abstract T i(Context context, AttributeSet attributeSet);

    public final d.a.n0.b1.l.a.a j(boolean z, boolean z2) {
        return h(z, z2);
    }

    public void k(TypedArray typedArray) {
    }

    public final void l(Context context, AttributeSet attributeSet) {
        if (c.f13372a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
        setGravity(17);
        this.f13365e = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PullToRefresh);
        if (obtainStyledAttributes.hasValue(R$styleable.PullToRefresh_tb_ptrMode)) {
            this.l = Mode.mapIntToValue(obtainStyledAttributes.getInteger(R$styleable.PullToRefresh_tb_ptrMode, 0));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.PullToRefresh_tb_ptrAnimationStyle)) {
            this.u = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(R$styleable.PullToRefresh_tb_ptrAnimationStyle, 0));
        }
        T i2 = i(context, attributeSet);
        this.n = i2;
        c(context, i2);
        this.v = g(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.w = g(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(R$styleable.PullToRefresh_tb_ptrRefreshableViewBackground)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.PullToRefresh_tb_ptrRefreshableViewBackground);
            if (drawable != null) {
                this.n.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(R$styleable.PullToRefresh_tb_ptrAdapterViewBackground)) {
            d.a.n0.b1.l.a.c.a.a("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R$styleable.PullToRefresh_tb_ptrAdapterViewBackground);
            if (drawable2 != null) {
                this.n.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(R$styleable.PullToRefresh_tb_ptrOverScroll)) {
            obtainStyledAttributes.getBoolean(R$styleable.PullToRefresh_tb_ptrOverScroll, true);
        }
        if (obtainStyledAttributes.hasValue(R$styleable.PullToRefresh_tb_ptrScrollingWhileRefreshingEnabled)) {
            this.q = obtainStyledAttributes.getBoolean(R$styleable.PullToRefresh_tb_ptrScrollingWhileRefreshingEnabled, false);
        }
        k(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        F();
    }

    public final boolean m() {
        return this.l.permitsPullToRefresh();
    }

    public final boolean n() {
        int i2 = c.f13374c[this.l.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 4) {
                    return false;
                }
                return o() || p();
            }
            return p();
        }
        return o();
    }

    public abstract boolean o();

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (m()) {
            int action = motionEvent.getAction();
            if (action != 3 && action != 1) {
                if (action == 0 || !this.j) {
                    if (action != 0) {
                        if (action == 2) {
                            if (!this.q && q()) {
                                return true;
                            }
                            if (n()) {
                                float y = motionEvent.getY();
                                float x = motionEvent.getX();
                                if (c.f13372a[getPullToRefreshScrollDirection().ordinal()] != 1) {
                                    f2 = y - this.f13367g;
                                    f3 = x - this.f13366f;
                                } else {
                                    f2 = x - this.f13366f;
                                    f3 = y - this.f13367g;
                                }
                                float abs = Math.abs(f2);
                                if (abs > this.f13365e && (!this.r || abs > Math.abs(f3))) {
                                    if (this.l.showHeaderLoadingLayout() && f2 >= 1.0f && p()) {
                                        this.f13367g = y;
                                        this.f13366f = x;
                                        this.j = true;
                                        if (this.l == Mode.BOTH) {
                                            this.m = Mode.PULL_FROM_START;
                                        }
                                    } else if (this.l.showFooterLoadingLayout() && f2 <= -1.0f && o()) {
                                        this.f13367g = y;
                                        this.f13366f = x;
                                        this.j = true;
                                        if (this.l == Mode.BOTH) {
                                            this.m = Mode.PULL_FROM_END;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (n()) {
                        float y2 = motionEvent.getY();
                        this.f13369i = y2;
                        this.f13367g = y2;
                        float x2 = motionEvent.getX();
                        this.f13368h = x2;
                        this.f13366f = x2;
                        this.j = false;
                    }
                    return this.j;
                }
                return true;
            }
            this.j = false;
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.m = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.q = bundle.getBoolean("ptr_disable_scrolling", false);
            this.p = bundle.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
            State mapIntToValue = State.mapIntToValue(bundle.getInt("ptr_state", 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                A(mapIntToValue, true);
            }
            r(bundle);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        s(bundle);
        bundle.putInt("ptr_state", this.k.getIntValue());
        bundle.putInt("ptr_mode", this.l.getIntValue());
        bundle.putInt("ptr_current_mode", this.m.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.q);
        bundle.putBoolean("ptr_show_refreshing_view", this.p);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        y();
        z(i2, i3);
        post(new b());
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002d, code lost:
        if (r0 != 3) goto L22;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (m()) {
            if (this.q || !q()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    int action = motionEvent.getAction();
                    if (action != 0) {
                        if (action != 1) {
                            if (action == 2) {
                                if (this.j) {
                                    this.f13367g = motionEvent.getY();
                                    this.f13366f = motionEvent.getX();
                                    x();
                                    return true;
                                }
                            }
                        }
                        if (this.j) {
                            this.j = false;
                            if (this.k == State.RELEASE_TO_REFRESH && (this.x != null || this.y != null)) {
                                A(State.REFRESHING, true);
                                return true;
                            } else if (q()) {
                                B(0);
                                return true;
                            } else {
                                A(State.RESET, new boolean[0]);
                                return true;
                            }
                        }
                    } else if (n()) {
                        float y = motionEvent.getY();
                        this.f13369i = y;
                        this.f13367g = y;
                        float x = motionEvent.getX();
                        this.f13368h = x;
                        this.f13366f = x;
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public abstract boolean p();

    public final boolean q() {
        State state = this.k;
        return state == State.REFRESHING || state == State.MANUAL_REFRESHING;
    }

    public void r(Bundle bundle) {
    }

    public void s(Bundle bundle) {
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.r = z;
    }

    public final void setHeaderScroll(int i2) {
        int maximumPullScroll = getMaximumPullScroll();
        int min = Math.min(maximumPullScroll, Math.max(-maximumPullScroll, i2));
        if (this.s) {
            if (min < 0) {
                this.v.setVisibility(0);
            } else if (min > 0) {
                this.w.setVisibility(0);
            } else {
                this.v.setVisibility(4);
                this.w.setVisibility(4);
            }
        }
        int i3 = c.f13372a[getPullToRefreshScrollDirection().ordinal()];
        if (i3 == 1) {
            scrollTo(min, 0);
        } else if (i3 != 2) {
        } else {
            scrollTo(0, min);
        }
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public final void setMode(Mode mode) {
        if (mode != this.l) {
            this.l = mode;
            F();
        }
    }

    public void setOnPullEventListener(d<T> dVar) {
        this.z = dVar;
    }

    public final void setOnRefreshListener(f<T> fVar) {
        this.x = fVar;
        this.y = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
    }

    public final void setRefreshing() {
        setRefreshing(true);
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        setReleaseLabel(charSequence, Mode.BOTH);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.t = interpolator;
    }

    public final void setScrollingWhileRefreshingEnabled(boolean z) {
        this.q = z;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.p = z;
    }

    public void t() {
        int i2 = c.f13374c[this.m.ordinal()];
        if (i2 == 1) {
            this.w.d();
        } else if (i2 != 2) {
        } else {
            this.v.d();
        }
    }

    public void u(boolean z) {
        if (this.l.showHeaderLoadingLayout()) {
            this.v.f();
        }
        if (this.l.showFooterLoadingLayout()) {
            this.w.f();
        }
        if (z) {
            if (this.p) {
                a aVar = new a();
                int i2 = c.f13374c[this.m.ordinal()];
                if (i2 != 1 && i2 != 3) {
                    E(-getHeaderSize(), aVar);
                    return;
                } else {
                    E(getFooterSize(), aVar);
                    return;
                }
            }
            B(0);
            return;
        }
        f();
    }

    public void v() {
        int i2 = c.f13374c[this.m.ordinal()];
        if (i2 == 1) {
            this.w.h();
        } else if (i2 != 2) {
        } else {
            this.v.h();
        }
    }

    public void w() {
        this.j = false;
        this.s = true;
        this.v.j();
        this.w.j();
        B(0);
    }

    public final void x() {
        float f2;
        float f3;
        int round;
        int footerSize;
        if (c.f13372a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            f2 = this.f13369i;
            f3 = this.f13367g;
        } else {
            f2 = this.f13368h;
            f3 = this.f13366f;
        }
        if (c.f13374c[this.m.ordinal()] != 1) {
            round = Math.round(Math.min(f2 - f3, 0.0f) / 2.0f);
            footerSize = getHeaderSize();
        } else {
            round = Math.round(Math.max(f2 - f3, 0.0f) / 2.0f);
            footerSize = getFooterSize();
        }
        setHeaderScroll(round);
        if (round == 0 || q()) {
            return;
        }
        float abs = Math.abs(round) / footerSize;
        if (c.f13374c[this.m.ordinal()] != 1) {
            this.v.b(abs);
        } else {
            this.w.b(abs);
        }
        if (this.k != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
            A(State.PULL_TO_REFRESH, new boolean[0]);
        } else if (this.k != State.PULL_TO_REFRESH || footerSize >= Math.abs(round)) {
        } else {
            A(State.RELEASE_TO_REFRESH, new boolean[0]);
        }
    }

    public final void y() {
        int maximumPullScroll = (int) (getMaximumPullScroll() * 1.2f);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int i2 = c.f13372a[getPullToRefreshScrollDirection().ordinal()];
        if (i2 == 1) {
            if (this.l.showHeaderLoadingLayout()) {
                this.v.setWidth(maximumPullScroll);
                paddingLeft = -maximumPullScroll;
            } else {
                paddingLeft = 0;
            }
            if (this.l.showFooterLoadingLayout()) {
                this.w.setWidth(maximumPullScroll);
                paddingRight = -maximumPullScroll;
            } else {
                paddingRight = 0;
            }
        } else if (i2 == 2) {
            if (this.l.showHeaderLoadingLayout()) {
                this.v.setHeight(maximumPullScroll);
                paddingTop = -maximumPullScroll;
            } else {
                paddingTop = 0;
            }
            if (this.l.showFooterLoadingLayout()) {
                this.w.setHeight(maximumPullScroll);
                paddingBottom = -maximumPullScroll;
            } else {
                paddingBottom = 0;
            }
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public final void z(int i2, int i3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
        int i4 = c.f13372a[getPullToRefreshScrollDirection().ordinal()];
        if (i4 != 1) {
            if (i4 == 2 && layoutParams.height != i3) {
                layoutParams.height = i3;
                this.o.requestLayout();
            }
        } else if (layoutParams.width != i2) {
            layoutParams.width = i2;
            this.o.requestLayout();
        }
    }

    public void setLoadingDrawable(Drawable drawable, Mode mode) {
        j(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
    }

    public void setPullLabel(CharSequence charSequence, Mode mode) {
        j(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charSequence);
    }

    public final void setRefreshing(boolean z) {
        if (q()) {
            return;
        }
        A(State.MANUAL_REFRESHING, z);
    }

    public void setRefreshingLabel(CharSequence charSequence, Mode mode) {
        j(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence, Mode mode) {
        j(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public final void setOnRefreshListener(e<T> eVar) {
        this.y = eVar;
        this.x = null;
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
        this.k = State.RESET;
        this.l = Mode.getDefault();
        this.p = true;
        this.q = false;
        this.r = true;
        this.s = true;
        this.u = AnimationStyle.getDefault();
        l(context, attributeSet);
    }
}
