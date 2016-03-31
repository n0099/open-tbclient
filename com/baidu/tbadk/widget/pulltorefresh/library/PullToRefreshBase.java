package com.baidu.tbadk.widget.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private static /* synthetic */ int[] aGN;
    private static /* synthetic */ int[] aHg;
    private static /* synthetic */ int[] aHh;
    private State aGO;
    private Mode aGP;
    private Mode aGQ;
    T aGR;
    private FrameLayout aGS;
    private boolean aGT;
    private boolean aGU;
    private boolean aGV;
    private boolean aGW;
    private boolean aGX;
    private Interpolator aGY;
    private AnimationStyle aGZ;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b aHa;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b aHb;
    private b<T> aHc;
    private c<T> aHd;
    private a<T> aHe;
    private PullToRefreshBase<T>.e aHf;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public enum Orientation {
        VERTICAL,
        HORIZONTAL;

        /* JADX DEBUG: Replace access to removed values field (aHm) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Orientation[] valuesCustom() {
            Orientation[] valuesCustom = values();
            int length = valuesCustom.length;
            Orientation[] orientationArr = new Orientation[length];
            System.arraycopy(valuesCustom, 0, orientationArr, 0, length);
            return orientationArr;
        }
    }

    /* loaded from: classes.dex */
    public interface a<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase, State state, Mode mode);
    }

    /* loaded from: classes.dex */
    public interface b<V extends View> {
        void c(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* loaded from: classes.dex */
    public interface c<V extends View> {
        void d(PullToRefreshBase<V> pullToRefreshBase);

        void e(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void Ie();
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract Orientation getPullToRefreshScrollDirection();

    protected abstract boolean nA();

    protected abstract boolean nB();

    static /* synthetic */ int[] HV() {
        int[] iArr = aGN;
        if (iArr == null) {
            iArr = new int[Orientation.valuesCustom().length];
            try {
                iArr[Orientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Orientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            aGN = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] Ic() {
        int[] iArr = aHg;
        if (iArr == null) {
            iArr = new int[State.valuesCustom().length];
            try {
                iArr[State.MANUAL_REFRESHING.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[State.OVERSCROLLING.ordinal()] = 6;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[State.PULL_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[State.RELEASE_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            aHg = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] Id() {
        int[] iArr = aHh;
        if (iArr == null) {
            iArr = new int[Mode.valuesCustom().length];
            try {
                iArr[Mode.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Mode.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Mode.MANUAL_REFRESH_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Mode.PULL_FROM_END.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            aHh = iArr;
        }
        return iArr;
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.aGO = State.RESET;
        this.aGP = Mode.getDefault();
        this.aGT = true;
        this.aGU = false;
        this.aGV = true;
        this.aGW = true;
        this.aGX = true;
        this.aGZ = AnimationStyle.getDefault();
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.aGO = State.RESET;
        this.aGP = Mode.getDefault();
        this.aGT = true;
        this.aGU = false;
        this.aGV = true;
        this.aGW = true;
        this.aGX = true;
        this.aGZ = AnimationStyle.getDefault();
        init(context, attributeSet);
    }

    public PullToRefreshBase(Context context, Mode mode) {
        super(context);
        this.mIsBeingDragged = false;
        this.aGO = State.RESET;
        this.aGP = Mode.getDefault();
        this.aGT = true;
        this.aGU = false;
        this.aGV = true;
        this.aGW = true;
        this.aGX = true;
        this.aGZ = AnimationStyle.getDefault();
        this.aGP = mode;
        init(context, null);
    }

    public PullToRefreshBase(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context);
        this.mIsBeingDragged = false;
        this.aGO = State.RESET;
        this.aGP = Mode.getDefault();
        this.aGT = true;
        this.aGU = false;
        this.aGV = true;
        this.aGW = true;
        this.aGX = true;
        this.aGZ = AnimationStyle.getDefault();
        this.aGP = mode;
        this.aGZ = animationStyle;
        init(context, null);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        T refreshableView = getRefreshableView();
        if (refreshableView instanceof ViewGroup) {
            ((ViewGroup) refreshableView).addView(view, i, layoutParams);
            return;
        }
        throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
    }

    public final Mode getCurrentMode() {
        return this.aGQ;
    }

    public final boolean getFilterTouchEvents() {
        return this.aGV;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return f(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a f(boolean z, boolean z2) {
        return g(z, z2);
    }

    public final Mode getMode() {
        return this.aGP;
    }

    public final T getRefreshableView() {
        return this.aGR;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.aGT;
    }

    public final State getState() {
        return this.aGO;
    }

    public final boolean HW() {
        return this.aGP.permitsPullToRefresh();
    }

    public final boolean HX() {
        return Build.VERSION.SDK_INT >= 9 && this.aGW && com.baidu.tbadk.widget.pulltorefresh.library.c.N(this.aGR);
    }

    public final boolean HY() {
        return this.aGO == State.REFRESHING || this.aGO == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (HW()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (nz()) {
                            float y = motionEvent.getY();
                            this.mInitialMotionY = y;
                            this.mLastMotionY = y;
                            float x = motionEvent.getX();
                            this.mInitialMotionX = x;
                            this.mLastMotionX = x;
                            this.mIsBeingDragged = false;
                            break;
                        }
                        break;
                    case 2:
                        if (!this.aGU && HY()) {
                            return true;
                        }
                        if (nz()) {
                            float y2 = motionEvent.getY();
                            float x2 = motionEvent.getX();
                            switch (HV()[getPullToRefreshScrollDirection().ordinal()]) {
                                case 2:
                                    f = x2 - this.mLastMotionX;
                                    f2 = y2 - this.mLastMotionY;
                                    break;
                                default:
                                    f = y2 - this.mLastMotionY;
                                    f2 = x2 - this.mLastMotionX;
                                    break;
                            }
                            float abs = Math.abs(f);
                            if (abs > this.mTouchSlop && (!this.aGV || abs > Math.abs(f2))) {
                                if (this.aGP.showHeaderLoadingLayout() && f >= 1.0f && nA()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.aGP == Mode.BOTH) {
                                        this.aGQ = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.aGP.showFooterLoadingLayout() && f <= -1.0f && nB()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.aGP == Mode.BOTH) {
                                        this.aGQ = Mode.PULL_FROM_END;
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                }
                return this.mIsBeingDragged;
            } else {
                return true;
            }
        }
        return false;
    }

    public final void HZ() {
        if (HY()) {
            a(State.RESET, new boolean[0]);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (HW()) {
            if (this.aGU || !HY()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (nz()) {
                                float y = motionEvent.getY();
                                this.mInitialMotionY = y;
                                this.mLastMotionY = y;
                                float x = motionEvent.getX();
                                this.mInitialMotionX = x;
                                this.mLastMotionX = x;
                                return true;
                            }
                            return false;
                        case 1:
                        case 3:
                            if (this.mIsBeingDragged) {
                                this.mIsBeingDragged = false;
                                if (this.aGO == State.RELEASE_TO_REFRESH && (this.aHc != null || this.aHd != null)) {
                                    a(State.REFRESHING, true);
                                    return true;
                                } else if (HY()) {
                                    fu(0);
                                    return true;
                                } else {
                                    a(State.RESET, new boolean[0]);
                                    return true;
                                }
                            }
                            return false;
                        case 2:
                            if (this.mIsBeingDragged) {
                                this.mLastMotionY = motionEvent.getY();
                                this.mLastMotionX = motionEvent.getX();
                                Ib();
                                return true;
                            }
                            return false;
                        default:
                            return false;
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public final void setScrollingWhileRefreshingEnabled(boolean z) {
        this.aGU = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.aGV = z;
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
        if (mode != this.aGP) {
            this.aGP = mode;
            nx();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.aHe = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.aHc = bVar;
        this.aHd = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.aHd = cVar;
        this.aHc = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.aGW = z;
    }

    public final void setRefreshing(boolean z) {
        if (!HY()) {
            a(State.MANUAL_REFRESHING, z);
        }
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        a(charSequence, Mode.BOTH);
    }

    public void a(CharSequence charSequence, Mode mode) {
        f(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.aGY = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.aGT = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(State state, boolean... zArr) {
        this.aGO = state;
        switch (Ic()[this.aGO.ordinal()]) {
            case 1:
                onReset();
                break;
            case 2:
                onPullToRefresh();
                break;
            case 3:
                onReleaseToRefresh();
                break;
            case 4:
            case 5:
                bO(zArr[0]);
                break;
        }
        if (this.aHe != null) {
            this.aHe.a(this, this.aGO, this.aGQ);
        }
    }

    protected final void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void a(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.a.b a(Context context, Mode mode, TypedArray typedArray) {
        com.baidu.tbadk.widget.pulltorefresh.library.a.b createLoadingLayout = this.aGZ.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b g(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.aGP.showHeaderLoadingLayout()) {
            bVar.a(this.aHa);
        }
        if (z2 && this.aGP.showFooterLoadingLayout()) {
            bVar.a(this.aHb);
        }
        return bVar;
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getFooterLayout() {
        return this.aHb;
    }

    protected final int getFooterSize() {
        return this.aHb.getContentSize();
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getHeaderLayout() {
        return this.aHa;
    }

    protected final int getHeaderSize() {
        return this.aHa.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.aGS;
    }

    protected void a(TypedArray typedArray) {
    }

    protected void d(Bundle bundle) {
    }

    protected void e(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (Id()[this.aGQ.ordinal()]) {
            case 2:
                this.aHa.nt();
                return;
            case 3:
                this.aHb.nt();
                return;
            default:
                return;
        }
    }

    protected void bO(boolean z) {
        if (this.aGP.showHeaderLoadingLayout()) {
            this.aHa.nb();
        }
        if (this.aGP.showFooterLoadingLayout()) {
            this.aHb.nb();
        }
        if (z) {
            if (this.aGT) {
                com.baidu.tbadk.widget.pulltorefresh.library.d dVar = new com.baidu.tbadk.widget.pulltorefresh.library.d(this);
                switch (Id()[this.aGQ.ordinal()]) {
                    case 3:
                    case 5:
                        a(getFooterSize(), dVar);
                        return;
                    case 4:
                    default:
                        a(-getHeaderSize(), dVar);
                        return;
                }
            }
            fu(0);
            return;
        }
        ny();
    }

    protected void onReleaseToRefresh() {
        switch (Id()[this.aGQ.ordinal()]) {
            case 2:
                this.aHa.na();
                return;
            case 3:
                this.aHb.na();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.aGX = true;
        this.aHa.reset();
        this.aHb.reset();
        fu(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.aGQ = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.aGU = bundle.getBoolean("ptr_disable_scrolling", false);
            this.aGT = bundle.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
            State mapIntToValue = State.mapIntToValue(bundle.getInt("ptr_state", 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                a(mapIntToValue, true);
            }
            d(bundle);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        e(bundle);
        bundle.putInt("ptr_state", this.aGO.getIntValue());
        bundle.putInt("ptr_mode", this.aGP.getIntValue());
        bundle.putInt("ptr_current_mode", this.aGQ.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.aGU);
        bundle.putBoolean("ptr_show_refreshing_view", this.aGT);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Ia();
        refreshRefreshableViewSize(i, i2);
        post(new com.baidu.tbadk.widget.pulltorefresh.library.e(this));
    }

    protected final void Ia() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        int maximumPullScroll = (int) (getMaximumPullScroll() * 1.2f);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        switch (HV()[getPullToRefreshScrollDirection().ordinal()]) {
            case 1:
                if (this.aGP.showHeaderLoadingLayout()) {
                    this.aHa.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.aGP.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.aHb.setHeight(maximumPullScroll);
                    i6 = -maximumPullScroll;
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                }
            case 2:
                if (this.aGP.showHeaderLoadingLayout()) {
                    this.aHa.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.aGP.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.aHb.setWidth(maximumPullScroll);
                    i4 = i5;
                    i3 = -maximumPullScroll;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                }
            default:
                i6 = paddingBottom;
                i3 = paddingRight;
                i2 = paddingTop;
                i4 = paddingLeft;
                break;
        }
        setPadding(i4, i2, i3, i6);
    }

    protected final void refreshRefreshableViewSize(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aGS.getLayoutParams();
        switch (HV()[getPullToRefreshScrollDirection().ordinal()]) {
            case 1:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.aGS.requestLayout();
                    return;
                }
                return;
            case 2:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.aGS.requestLayout();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setHeaderScroll(int i) {
        int maximumPullScroll = getMaximumPullScroll();
        int min = Math.min(maximumPullScroll, Math.max(-maximumPullScroll, i));
        if (this.aGX) {
            if (min < 0) {
                this.aHa.setVisibility(0);
            } else if (min > 0) {
                this.aHb.setVisibility(0);
            } else {
                this.aHa.setVisibility(4);
                this.aHb.setVisibility(4);
            }
        }
        switch (HV()[getPullToRefreshScrollDirection().ordinal()]) {
            case 1:
                scrollTo(0, min);
                return;
            case 2:
                scrollTo(min, 0);
                return;
            default:
                return;
        }
    }

    protected final void fu(int i) {
        c(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void nx() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.aHa.getParent()) {
            removeView(this.aHa);
        }
        if (this.aGP.showHeaderLoadingLayout()) {
            a(this.aHa, 0, loadingLayoutLayoutParams);
        }
        if (this == this.aHb.getParent()) {
            removeView(this.aHb);
        }
        if (this.aGP.showFooterLoadingLayout()) {
            a(this.aHb, loadingLayoutLayoutParams);
        }
        Ia();
        this.aGQ = this.aGP != Mode.BOTH ? this.aGP : Mode.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.aGS = new FrameLayout(context);
        this.aGS.addView(t, -1, -1);
        a(this.aGS, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny() {
        if (this.aHc != null) {
            this.aHc.c(this);
        } else if (this.aHd != null) {
            if (this.aGQ == Mode.PULL_FROM_START) {
                this.aHd.d(this);
            } else if (this.aGQ == Mode.PULL_FROM_END) {
                this.aHd.e(this);
            }
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        switch (HV()[getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
                setOrientation(0);
                break;
            default:
                setOrientation(1);
                break;
        }
        setGravity(17);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.l.PullToRefresh);
        if (obtainStyledAttributes.hasValue(4)) {
            this.aGP = Mode.mapIntToValue(obtainStyledAttributes.getInteger(4, 0));
        }
        if (obtainStyledAttributes.hasValue(12)) {
            this.aGZ = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(12, 0));
        }
        this.aGR = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.aGR);
        this.aHa = a(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.aHb = a(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(0)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            if (drawable != null) {
                this.aGR.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(16)) {
            com.baidu.tbadk.widget.pulltorefresh.library.a.d.au("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(16);
            if (drawable2 != null) {
                this.aGR.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(9)) {
            this.aGW = obtainStyledAttributes.getBoolean(9, true);
        }
        if (obtainStyledAttributes.hasValue(13)) {
            this.aGU = obtainStyledAttributes.getBoolean(13, false);
        }
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        nx();
    }

    private boolean nz() {
        switch (Id()[this.aGP.ordinal()]) {
            case 2:
                return nA();
            case 3:
                return nB();
            case 4:
                return nB() || nA();
            default:
                return false;
        }
    }

    private void Ib() {
        float f;
        float f2;
        int round;
        int footerSize;
        switch (HV()[getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
                f = this.mInitialMotionX;
                f2 = this.mLastMotionX;
                break;
            default:
                f = this.mInitialMotionY;
                f2 = this.mLastMotionY;
                break;
        }
        switch (Id()[this.aGQ.ordinal()]) {
            case 3:
                round = Math.round(Math.max(f - f2, 0.0f) / 2.0f);
                footerSize = getFooterSize();
                break;
            default:
                round = Math.round(Math.min(f - f2, 0.0f) / 2.0f);
                footerSize = getHeaderSize();
                break;
        }
        setHeaderScroll(round);
        if (round != 0 && !HY()) {
            float abs = Math.abs(round) / footerSize;
            switch (Id()[this.aGQ.ordinal()]) {
                case 3:
                    this.aHb.onPull(abs);
                    break;
                default:
                    this.aHa.onPull(abs);
                    break;
            }
            if (this.aGO != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.aGO == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
                a(State.RELEASE_TO_REFRESH, new boolean[0]);
            }
        }
    }

    private LinearLayout.LayoutParams getLoadingLayoutLayoutParams() {
        switch (HV()[getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
                return new LinearLayout.LayoutParams(-2, -1);
            default:
                return new LinearLayout.LayoutParams(-1, -2);
        }
    }

    private int getMaximumPullScroll() {
        switch (HV()[getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
                return Math.round(getWidth() / 2.0f);
            default:
                return Math.round(getHeight() / 2.0f);
        }
    }

    private final void c(int i, long j) {
        a(i, j, 0L, null);
    }

    private final void a(int i, long j, long j2, d dVar) {
        int scrollX;
        if (this.aHf != null) {
            this.aHf.stop();
        }
        switch (HV()[getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
                scrollX = getScrollX();
                break;
            default:
                scrollX = getScrollY();
                break;
        }
        if (scrollX != i) {
            if (this.aGY == null) {
                this.aGY = new DecelerateInterpolator();
            }
            this.aHf = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.aHf, j2);
            } else {
                post(this.aHf);
            }
        }
    }

    /* loaded from: classes.dex */
    public enum AnimationStyle {
        ROTATE,
        FLIP;
        
        private static /* synthetic */ int[] aHj;

        /* JADX DEBUG: Replace access to removed values field (aHk) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static AnimationStyle[] valuesCustom() {
            AnimationStyle[] valuesCustom = values();
            int length = valuesCustom.length;
            AnimationStyle[] animationStyleArr = new AnimationStyle[length];
            System.arraycopy(valuesCustom, 0, animationStyleArr, 0, length);
            return animationStyleArr;
        }

        static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$tbadk$widget$pulltorefresh$library$PullToRefreshBase$AnimationStyle() {
            int[] iArr = aHj;
            if (iArr == null) {
                iArr = new int[valuesCustom().length];
                try {
                    iArr[FLIP.ordinal()] = 2;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[ROTATE.ordinal()] = 1;
                } catch (NoSuchFieldError e2) {
                }
                aHj = iArr;
            }
            return iArr;
        }

        static AnimationStyle getDefault() {
            return ROTATE;
        }

        static AnimationStyle mapIntToValue(int i) {
            switch (i) {
                case 1:
                    return FLIP;
                default:
                    return ROTATE;
            }
        }

        com.baidu.tbadk.widget.pulltorefresh.library.a.b createLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
            switch ($SWITCH_TABLE$com$baidu$tbadk$widget$pulltorefresh$library$PullToRefreshBase$AnimationStyle()[ordinal()]) {
                case 2:
                    return new com.baidu.tbadk.widget.pulltorefresh.library.a.a(context, mode, orientation, typedArray);
                default:
                    return new com.baidu.tbadk.widget.pulltorefresh.library.a.c(context, mode, orientation, typedArray);
            }
        }
    }

    /* loaded from: classes.dex */
    public enum Mode {
        DISABLED(0),
        PULL_FROM_START(1),
        PULL_FROM_END(2),
        BOTH(3),
        MANUAL_REFRESH_ONLY(4);
        
        private int mIntValue;
        public static Mode PULL_DOWN_TO_REFRESH = PULL_FROM_START;
        public static Mode PULL_UP_TO_REFRESH = PULL_FROM_END;

        /* JADX DEBUG: Replace access to removed values field (aHl) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Mode[] valuesCustom() {
            Mode[] valuesCustom = values();
            int length = valuesCustom.length;
            Mode[] modeArr = new Mode[length];
            System.arraycopy(valuesCustom, 0, modeArr, 0, length);
            return modeArr;
        }

        static Mode mapIntToValue(int i) {
            Mode[] valuesCustom;
            for (Mode mode : valuesCustom()) {
                if (i == mode.getIntValue()) {
                    return mode;
                }
            }
            return getDefault();
        }

        static Mode getDefault() {
            return PULL_FROM_START;
        }

        Mode(int i) {
            this.mIntValue = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean permitsPullToRefresh() {
            return (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : true;
        }

        public boolean showHeaderLoadingLayout() {
            return this == PULL_FROM_START || this == BOTH;
        }

        public boolean showFooterLoadingLayout() {
            return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
        }

        int getIntValue() {
            return this.mIntValue;
        }
    }

    /* loaded from: classes.dex */
    public enum State {
        RESET(0),
        PULL_TO_REFRESH(1),
        RELEASE_TO_REFRESH(2),
        REFRESHING(8),
        MANUAL_REFRESHING(9),
        OVERSCROLLING(16);
        
        private int mIntValue;

        /* JADX DEBUG: Replace access to removed values field (aHt) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] valuesCustom = values();
            int length = valuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(valuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }

        static State mapIntToValue(int i) {
            State[] valuesCustom;
            for (State state : valuesCustom()) {
                if (i == state.getIntValue()) {
                    return state;
                }
            }
            return RESET;
        }

        State(int i) {
            this.mIntValue = i;
        }

        int getIntValue() {
            return this.mIntValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class e implements Runnable {
        private final int aHn;
        private final int aHo;
        private final long aHp;
        private d aHq;
        private final Interpolator mInterpolator;
        private boolean aHr = true;
        private long mStartTime = -1;
        private int aHs = -1;

        public e(int i, int i2, long j, d dVar) {
            this.aHo = i;
            this.aHn = i2;
            this.mInterpolator = PullToRefreshBase.this.aGY;
            this.aHp = j;
            this.aHq = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aHs = this.aHo - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.aHp, 1000L), 0L)) / 1000.0f) * (this.aHo - this.aHn));
                PullToRefreshBase.this.setHeaderScroll(this.aHs);
            }
            if (this.aHr && this.aHn != this.aHs) {
                com.baidu.tbadk.widget.pulltorefresh.library.a.e.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.aHq != null) {
                this.aHq.Ie();
            }
        }

        public void stop() {
            this.aHr = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
