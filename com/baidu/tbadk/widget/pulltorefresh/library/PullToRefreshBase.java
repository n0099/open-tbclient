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
    private static /* synthetic */ int[] aHF;
    private static /* synthetic */ int[] aHG;
    private static /* synthetic */ int[] aHm;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b aHA;
    private b<T> aHB;
    private c<T> aHC;
    private a<T> aHD;
    private PullToRefreshBase<T>.e aHE;
    private State aHn;
    private Mode aHo;
    private Mode aHp;
    T aHq;
    private FrameLayout aHr;
    private boolean aHs;
    private boolean aHt;
    private boolean aHu;
    private boolean aHv;
    private boolean aHw;
    private Interpolator aHx;
    private AnimationStyle aHy;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b aHz;
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

        /* JADX DEBUG: Replace access to removed values field (aHL) with 'values()' method */
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
        void HS();
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract Orientation getPullToRefreshScrollDirection();

    protected abstract boolean isReadyForPullEnd();

    protected abstract boolean isReadyForPullStart();

    static /* synthetic */ int[] HO() {
        int[] iArr = aHm;
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
            aHm = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] HQ() {
        int[] iArr = aHF;
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
            aHF = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] HR() {
        int[] iArr = aHG;
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
            aHG = iArr;
        }
        return iArr;
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.aHn = State.RESET;
        this.aHo = Mode.getDefault();
        this.aHs = true;
        this.aHt = false;
        this.aHu = true;
        this.aHv = true;
        this.aHw = true;
        this.aHy = AnimationStyle.getDefault();
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.aHn = State.RESET;
        this.aHo = Mode.getDefault();
        this.aHs = true;
        this.aHt = false;
        this.aHu = true;
        this.aHv = true;
        this.aHw = true;
        this.aHy = AnimationStyle.getDefault();
        init(context, attributeSet);
    }

    public PullToRefreshBase(Context context, Mode mode) {
        super(context);
        this.mIsBeingDragged = false;
        this.aHn = State.RESET;
        this.aHo = Mode.getDefault();
        this.aHs = true;
        this.aHt = false;
        this.aHu = true;
        this.aHv = true;
        this.aHw = true;
        this.aHy = AnimationStyle.getDefault();
        this.aHo = mode;
        init(context, null);
    }

    public PullToRefreshBase(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context);
        this.mIsBeingDragged = false;
        this.aHn = State.RESET;
        this.aHo = Mode.getDefault();
        this.aHs = true;
        this.aHt = false;
        this.aHu = true;
        this.aHv = true;
        this.aHw = true;
        this.aHy = AnimationStyle.getDefault();
        this.aHo = mode;
        this.aHy = animationStyle;
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
        return this.aHp;
    }

    public final boolean getFilterTouchEvents() {
        return this.aHu;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return i(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a i(boolean z, boolean z2) {
        return j(z, z2);
    }

    public final Mode getMode() {
        return this.aHo;
    }

    public final T getRefreshableView() {
        return this.aHq;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.aHs;
    }

    public final State getState() {
        return this.aHn;
    }

    public final boolean isPullToRefreshEnabled() {
        return this.aHo.permitsPullToRefresh();
    }

    public final boolean isPullToRefreshOverScrollEnabled() {
        return Build.VERSION.SDK_INT >= 9 && this.aHv && com.baidu.tbadk.widget.pulltorefresh.library.c.O(this.aHq);
    }

    public final boolean isRefreshing() {
        return this.aHn == State.REFRESHING || this.aHn == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (isPullToRefreshEnabled()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (kI()) {
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
                        if (!this.aHt && isRefreshing()) {
                            return true;
                        }
                        if (kI()) {
                            float y2 = motionEvent.getY();
                            float x2 = motionEvent.getX();
                            switch (HO()[getPullToRefreshScrollDirection().ordinal()]) {
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
                            if (abs > this.mTouchSlop && (!this.aHu || abs > Math.abs(f2))) {
                                if (this.aHo.showHeaderLoadingLayout() && f >= 1.0f && isReadyForPullStart()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.aHo == Mode.BOTH) {
                                        this.aHp = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.aHo.showFooterLoadingLayout() && f <= -1.0f && isReadyForPullEnd()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.aHo == Mode.BOTH) {
                                        this.aHp = Mode.PULL_FROM_END;
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

    public final void onRefreshComplete() {
        if (isRefreshing()) {
            a(State.RESET, new boolean[0]);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (isPullToRefreshEnabled()) {
            if (this.aHt || !isRefreshing()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (kI()) {
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
                                if (this.aHn == State.RELEASE_TO_REFRESH && (this.aHB != null || this.aHC != null)) {
                                    a(State.REFRESHING, true);
                                    return true;
                                } else if (isRefreshing()) {
                                    smoothScrollTo(0);
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
                                HP();
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
        this.aHt = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.aHu = z;
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
        if (mode != this.aHo) {
            this.aHo = mode;
            updateUIForMode();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.aHD = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.aHB = bVar;
        this.aHC = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.aHC = cVar;
        this.aHB = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.aHv = z;
    }

    public final void setRefreshing(boolean z) {
        if (!isRefreshing()) {
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
        i(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.aHx = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.aHs = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(State state, boolean... zArr) {
        this.aHn = state;
        switch (HQ()[this.aHn.ordinal()]) {
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
                onRefreshing(zArr[0]);
                break;
        }
        if (this.aHD != null) {
            this.aHD.a(this, this.aHn, this.aHp);
        }
    }

    protected final void addViewInternal(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void addViewInternal(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.a.b a(Context context, Mode mode, TypedArray typedArray) {
        com.baidu.tbadk.widget.pulltorefresh.library.a.b createLoadingLayout = this.aHy.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b j(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.aHo.showHeaderLoadingLayout()) {
            bVar.a(this.aHz);
        }
        if (z2 && this.aHo.showFooterLoadingLayout()) {
            bVar.a(this.aHA);
        }
        return bVar;
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getFooterLayout() {
        return this.aHA;
    }

    protected final int getFooterSize() {
        return this.aHA.getContentSize();
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getHeaderLayout() {
        return this.aHz;
    }

    protected final int getHeaderSize() {
        return this.aHz.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.aHr;
    }

    protected void handleStyledAttributes(TypedArray typedArray) {
    }

    protected void onPtrRestoreInstanceState(Bundle bundle) {
    }

    protected void onPtrSaveInstanceState(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (HR()[this.aHp.ordinal()]) {
            case 2:
                this.aHz.kE();
                return;
            case 3:
                this.aHA.kE();
                return;
            default:
                return;
        }
    }

    protected void onRefreshing(boolean z) {
        if (this.aHo.showHeaderLoadingLayout()) {
            this.aHz.km();
        }
        if (this.aHo.showFooterLoadingLayout()) {
            this.aHA.km();
        }
        if (z) {
            if (this.aHs) {
                com.baidu.tbadk.widget.pulltorefresh.library.d dVar = new com.baidu.tbadk.widget.pulltorefresh.library.d(this);
                switch (HR()[this.aHp.ordinal()]) {
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
            smoothScrollTo(0);
            return;
        }
        kH();
    }

    protected void onReleaseToRefresh() {
        switch (HR()[this.aHp.ordinal()]) {
            case 2:
                this.aHz.kl();
                return;
            case 3:
                this.aHA.kl();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.aHw = true;
        this.aHz.reset();
        this.aHA.reset();
        smoothScrollTo(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.aHp = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.aHt = bundle.getBoolean("ptr_disable_scrolling", false);
            this.aHs = bundle.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
            State mapIntToValue = State.mapIntToValue(bundle.getInt("ptr_state", 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                a(mapIntToValue, true);
            }
            onPtrRestoreInstanceState(bundle);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        onPtrSaveInstanceState(bundle);
        bundle.putInt("ptr_state", this.aHn.getIntValue());
        bundle.putInt("ptr_mode", this.aHo.getIntValue());
        bundle.putInt("ptr_current_mode", this.aHp.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.aHt);
        bundle.putBoolean("ptr_show_refreshing_view", this.aHs);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        refreshLoadingViewsSize();
        refreshRefreshableViewSize(i, i2);
        post(new com.baidu.tbadk.widget.pulltorefresh.library.e(this));
    }

    protected final void refreshLoadingViewsSize() {
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
        switch (HO()[getPullToRefreshScrollDirection().ordinal()]) {
            case 1:
                if (this.aHo.showHeaderLoadingLayout()) {
                    this.aHz.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.aHo.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.aHA.setHeight(maximumPullScroll);
                    i6 = -maximumPullScroll;
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                }
            case 2:
                if (this.aHo.showHeaderLoadingLayout()) {
                    this.aHz.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.aHo.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.aHA.setWidth(maximumPullScroll);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aHr.getLayoutParams();
        switch (HO()[getPullToRefreshScrollDirection().ordinal()]) {
            case 1:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.aHr.requestLayout();
                    return;
                }
                return;
            case 2:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.aHr.requestLayout();
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
        if (this.aHw) {
            if (min < 0) {
                this.aHz.setVisibility(0);
            } else if (min > 0) {
                this.aHA.setVisibility(0);
            } else {
                this.aHz.setVisibility(4);
                this.aHA.setVisibility(4);
            }
        }
        switch (HO()[getPullToRefreshScrollDirection().ordinal()]) {
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

    protected final void smoothScrollTo(int i) {
        c(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void updateUIForMode() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.aHz.getParent()) {
            removeView(this.aHz);
        }
        if (this.aHo.showHeaderLoadingLayout()) {
            addViewInternal(this.aHz, 0, loadingLayoutLayoutParams);
        }
        if (this == this.aHA.getParent()) {
            removeView(this.aHA);
        }
        if (this.aHo.showFooterLoadingLayout()) {
            addViewInternal(this.aHA, loadingLayoutLayoutParams);
        }
        refreshLoadingViewsSize();
        this.aHp = this.aHo != Mode.BOTH ? this.aHo : Mode.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.aHr = new FrameLayout(context);
        this.aHr.addView(t, -1, -1);
        addViewInternal(this.aHr, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kH() {
        if (this.aHB != null) {
            this.aHB.c(this);
        } else if (this.aHC != null) {
            if (this.aHp == Mode.PULL_FROM_START) {
                this.aHC.d(this);
            } else if (this.aHp == Mode.PULL_FROM_END) {
                this.aHC.e(this);
            }
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        switch (HO()[getPullToRefreshScrollDirection().ordinal()]) {
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
            this.aHo = Mode.mapIntToValue(obtainStyledAttributes.getInteger(4, 0));
        }
        if (obtainStyledAttributes.hasValue(12)) {
            this.aHy = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(12, 0));
        }
        this.aHq = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.aHq);
        this.aHz = a(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.aHA = a(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(0)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            if (drawable != null) {
                this.aHq.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(16)) {
            com.baidu.tbadk.widget.pulltorefresh.library.a.d.at("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(16);
            if (drawable2 != null) {
                this.aHq.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(9)) {
            this.aHv = obtainStyledAttributes.getBoolean(9, true);
        }
        if (obtainStyledAttributes.hasValue(13)) {
            this.aHt = obtainStyledAttributes.getBoolean(13, false);
        }
        handleStyledAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        updateUIForMode();
    }

    private boolean kI() {
        switch (HR()[this.aHo.ordinal()]) {
            case 2:
                return isReadyForPullStart();
            case 3:
                return isReadyForPullEnd();
            case 4:
                return isReadyForPullEnd() || isReadyForPullStart();
            default:
                return false;
        }
    }

    private void HP() {
        float f;
        float f2;
        int round;
        int footerSize;
        switch (HO()[getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
                f = this.mInitialMotionX;
                f2 = this.mLastMotionX;
                break;
            default:
                f = this.mInitialMotionY;
                f2 = this.mLastMotionY;
                break;
        }
        switch (HR()[this.aHp.ordinal()]) {
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
        if (round != 0 && !isRefreshing()) {
            float abs = Math.abs(round) / footerSize;
            switch (HR()[this.aHp.ordinal()]) {
                case 3:
                    this.aHA.onPull(abs);
                    break;
                default:
                    this.aHz.onPull(abs);
                    break;
            }
            if (this.aHn != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.aHn == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
                a(State.RELEASE_TO_REFRESH, new boolean[0]);
            }
        }
    }

    private LinearLayout.LayoutParams getLoadingLayoutLayoutParams() {
        switch (HO()[getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
                return new LinearLayout.LayoutParams(-2, -1);
            default:
                return new LinearLayout.LayoutParams(-1, -2);
        }
    }

    private int getMaximumPullScroll() {
        switch (HO()[getPullToRefreshScrollDirection().ordinal()]) {
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
        if (this.aHE != null) {
            this.aHE.stop();
        }
        switch (HO()[getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
                scrollX = getScrollX();
                break;
            default:
                scrollX = getScrollY();
                break;
        }
        if (scrollX != i) {
            if (this.aHx == null) {
                this.aHx = new DecelerateInterpolator();
            }
            this.aHE = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.aHE, j2);
            } else {
                post(this.aHE);
            }
        }
    }

    /* loaded from: classes.dex */
    public enum AnimationStyle {
        ROTATE,
        FLIP;
        
        private static /* synthetic */ int[] aHI;

        /* JADX DEBUG: Replace access to removed values field (aHJ) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static AnimationStyle[] valuesCustom() {
            AnimationStyle[] valuesCustom = values();
            int length = valuesCustom.length;
            AnimationStyle[] animationStyleArr = new AnimationStyle[length];
            System.arraycopy(valuesCustom, 0, animationStyleArr, 0, length);
            return animationStyleArr;
        }

        static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$tbadk$widget$pulltorefresh$library$PullToRefreshBase$AnimationStyle() {
            int[] iArr = aHI;
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
                aHI = iArr;
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

        /* JADX DEBUG: Replace access to removed values field (aHK) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (aHS) with 'values()' method */
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
        private final int aHM;
        private final int aHN;
        private final long aHO;
        private d aHP;
        private final Interpolator mInterpolator;
        private boolean aHQ = true;
        private long mStartTime = -1;
        private int aHR = -1;

        public e(int i, int i2, long j, d dVar) {
            this.aHN = i;
            this.aHM = i2;
            this.mInterpolator = PullToRefreshBase.this.aHx;
            this.aHO = j;
            this.aHP = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aHR = this.aHN - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.aHO, 1000L), 0L)) / 1000.0f) * (this.aHN - this.aHM));
                PullToRefreshBase.this.setHeaderScroll(this.aHR);
            }
            if (this.aHQ && this.aHM != this.aHR) {
                com.baidu.tbadk.widget.pulltorefresh.library.a.e.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.aHP != null) {
                this.aHP.HS();
            }
        }

        public void stop() {
            this.aHQ = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
