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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private static /* synthetic */ int[] aEc;
    private static /* synthetic */ int[] aEv;
    private static /* synthetic */ int[] aEw;
    private State aEd;
    private Mode aEe;
    private Mode aEf;
    T aEg;
    private FrameLayout aEh;
    private boolean aEi;
    private boolean aEj;
    private boolean aEk;
    private boolean aEl;
    private boolean aEm;
    private Interpolator aEn;
    private AnimationStyle aEo;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b aEp;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b aEq;
    private b<T> aEr;
    private c<T> aEs;
    private a<T> aEt;
    private PullToRefreshBase<T>.e aEu;
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

        /* JADX DEBUG: Replace access to removed values field (aEB) with 'values()' method */
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
        void Gv();
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract Orientation getPullToRefreshScrollDirection();

    protected abstract boolean isReadyForPullEnd();

    protected abstract boolean isReadyForPullStart();

    static /* synthetic */ int[] Gr() {
        int[] iArr = aEc;
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
            aEc = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] Gt() {
        int[] iArr = aEv;
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
            aEv = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] Gu() {
        int[] iArr = aEw;
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
            aEw = iArr;
        }
        return iArr;
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.aEd = State.RESET;
        this.aEe = Mode.getDefault();
        this.aEi = true;
        this.aEj = false;
        this.aEk = true;
        this.aEl = true;
        this.aEm = true;
        this.aEo = AnimationStyle.getDefault();
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.aEd = State.RESET;
        this.aEe = Mode.getDefault();
        this.aEi = true;
        this.aEj = false;
        this.aEk = true;
        this.aEl = true;
        this.aEm = true;
        this.aEo = AnimationStyle.getDefault();
        init(context, attributeSet);
    }

    public PullToRefreshBase(Context context, Mode mode) {
        super(context);
        this.mIsBeingDragged = false;
        this.aEd = State.RESET;
        this.aEe = Mode.getDefault();
        this.aEi = true;
        this.aEj = false;
        this.aEk = true;
        this.aEl = true;
        this.aEm = true;
        this.aEo = AnimationStyle.getDefault();
        this.aEe = mode;
        init(context, null);
    }

    public PullToRefreshBase(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context);
        this.mIsBeingDragged = false;
        this.aEd = State.RESET;
        this.aEe = Mode.getDefault();
        this.aEi = true;
        this.aEj = false;
        this.aEk = true;
        this.aEl = true;
        this.aEm = true;
        this.aEo = AnimationStyle.getDefault();
        this.aEe = mode;
        this.aEo = animationStyle;
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
        return this.aEf;
    }

    public final boolean getFilterTouchEvents() {
        return this.aEk;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return g(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a g(boolean z, boolean z2) {
        return h(z, z2);
    }

    public final Mode getMode() {
        return this.aEe;
    }

    public final T getRefreshableView() {
        return this.aEg;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.aEi;
    }

    public final State getState() {
        return this.aEd;
    }

    public final boolean isPullToRefreshEnabled() {
        return this.aEe.permitsPullToRefresh();
    }

    public final boolean isPullToRefreshOverScrollEnabled() {
        return Build.VERSION.SDK_INT >= 9 && this.aEl && com.baidu.tbadk.widget.pulltorefresh.library.c.N(this.aEg);
    }

    public final boolean isRefreshing() {
        return this.aEd == State.REFRESHING || this.aEd == State.MANUAL_REFRESHING;
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
                        if (jN()) {
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
                        if (!this.aEj && isRefreshing()) {
                            return true;
                        }
                        if (jN()) {
                            float y2 = motionEvent.getY();
                            float x2 = motionEvent.getX();
                            switch (Gr()[getPullToRefreshScrollDirection().ordinal()]) {
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
                            if (abs > this.mTouchSlop && (!this.aEk || abs > Math.abs(f2))) {
                                if (this.aEe.showHeaderLoadingLayout() && f >= 1.0f && isReadyForPullStart()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.aEe == Mode.BOTH) {
                                        this.aEf = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.aEe.showFooterLoadingLayout() && f <= -1.0f && isReadyForPullEnd()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.aEe == Mode.BOTH) {
                                        this.aEf = Mode.PULL_FROM_END;
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
            if (this.aEj || !isRefreshing()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (jN()) {
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
                                if (this.aEd == State.RELEASE_TO_REFRESH && (this.aEr != null || this.aEs != null)) {
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
                                Gs();
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
        this.aEj = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.aEk = z;
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
        if (mode != this.aEe) {
            this.aEe = mode;
            updateUIForMode();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.aEt = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.aEr = bVar;
        this.aEs = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.aEs = cVar;
        this.aEr = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.aEl = z;
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
        g(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.aEn = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.aEi = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(State state, boolean... zArr) {
        this.aEd = state;
        switch (Gt()[this.aEd.ordinal()]) {
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
        if (this.aEt != null) {
            this.aEt.a(this, this.aEd, this.aEf);
        }
    }

    protected final void addViewInternal(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void addViewInternal(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.a.b a(Context context, Mode mode, TypedArray typedArray) {
        com.baidu.tbadk.widget.pulltorefresh.library.a.b createLoadingLayout = this.aEo.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b h(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.aEe.showHeaderLoadingLayout()) {
            bVar.a(this.aEp);
        }
        if (z2 && this.aEe.showFooterLoadingLayout()) {
            bVar.a(this.aEq);
        }
        return bVar;
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getFooterLayout() {
        return this.aEq;
    }

    protected final int getFooterSize() {
        return this.aEq.getContentSize();
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getHeaderLayout() {
        return this.aEp;
    }

    protected final int getHeaderSize() {
        return this.aEp.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.aEh;
    }

    protected void handleStyledAttributes(TypedArray typedArray) {
    }

    protected void onPtrRestoreInstanceState(Bundle bundle) {
    }

    protected void onPtrSaveInstanceState(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (Gu()[this.aEf.ordinal()]) {
            case 2:
                this.aEp.jJ();
                return;
            case 3:
                this.aEq.jJ();
                return;
            default:
                return;
        }
    }

    protected void onRefreshing(boolean z) {
        if (this.aEe.showHeaderLoadingLayout()) {
            this.aEp.jr();
        }
        if (this.aEe.showFooterLoadingLayout()) {
            this.aEq.jr();
        }
        if (z) {
            if (this.aEi) {
                com.baidu.tbadk.widget.pulltorefresh.library.d dVar = new com.baidu.tbadk.widget.pulltorefresh.library.d(this);
                switch (Gu()[this.aEf.ordinal()]) {
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
        jM();
    }

    protected void onReleaseToRefresh() {
        switch (Gu()[this.aEf.ordinal()]) {
            case 2:
                this.aEp.jq();
                return;
            case 3:
                this.aEq.jq();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.aEm = true;
        this.aEp.reset();
        this.aEq.reset();
        smoothScrollTo(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.aEf = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.aEj = bundle.getBoolean("ptr_disable_scrolling", false);
            this.aEi = bundle.getBoolean("ptr_show_refreshing_view", true);
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
        bundle.putInt("ptr_state", this.aEd.getIntValue());
        bundle.putInt("ptr_mode", this.aEe.getIntValue());
        bundle.putInt("ptr_current_mode", this.aEf.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.aEj);
        bundle.putBoolean("ptr_show_refreshing_view", this.aEi);
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
        switch (Gr()[getPullToRefreshScrollDirection().ordinal()]) {
            case 1:
                if (this.aEe.showHeaderLoadingLayout()) {
                    this.aEp.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.aEe.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.aEq.setHeight(maximumPullScroll);
                    i6 = -maximumPullScroll;
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                }
            case 2:
                if (this.aEe.showHeaderLoadingLayout()) {
                    this.aEp.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.aEe.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.aEq.setWidth(maximumPullScroll);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEh.getLayoutParams();
        switch (Gr()[getPullToRefreshScrollDirection().ordinal()]) {
            case 1:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.aEh.requestLayout();
                    return;
                }
                return;
            case 2:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.aEh.requestLayout();
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
        if (this.aEm) {
            if (min < 0) {
                this.aEp.setVisibility(0);
            } else if (min > 0) {
                this.aEq.setVisibility(0);
            } else {
                this.aEp.setVisibility(4);
                this.aEq.setVisibility(4);
            }
        }
        switch (Gr()[getPullToRefreshScrollDirection().ordinal()]) {
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
        if (this == this.aEp.getParent()) {
            removeView(this.aEp);
        }
        if (this.aEe.showHeaderLoadingLayout()) {
            addViewInternal(this.aEp, 0, loadingLayoutLayoutParams);
        }
        if (this == this.aEq.getParent()) {
            removeView(this.aEq);
        }
        if (this.aEe.showFooterLoadingLayout()) {
            addViewInternal(this.aEq, loadingLayoutLayoutParams);
        }
        refreshLoadingViewsSize();
        this.aEf = this.aEe != Mode.BOTH ? this.aEe : Mode.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.aEh = new FrameLayout(context);
        this.aEh.addView(t, -1, -1);
        addViewInternal(this.aEh, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jM() {
        if (this.aEr != null) {
            this.aEr.c(this);
        } else if (this.aEs != null) {
            if (this.aEf == Mode.PULL_FROM_START) {
                this.aEs.d(this);
            } else if (this.aEf == Mode.PULL_FROM_END) {
                this.aEs.e(this);
            }
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        switch (Gr()[getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
                setOrientation(0);
                break;
            default:
                setOrientation(1);
                break;
        }
        setGravity(17);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u.l.PullToRefresh);
        if (obtainStyledAttributes.hasValue(4)) {
            this.aEe = Mode.mapIntToValue(obtainStyledAttributes.getInteger(4, 0));
        }
        if (obtainStyledAttributes.hasValue(12)) {
            this.aEo = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(12, 0));
        }
        this.aEg = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.aEg);
        this.aEp = a(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.aEq = a(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(0)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            if (drawable != null) {
                this.aEg.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(16)) {
            com.baidu.tbadk.widget.pulltorefresh.library.a.d.at("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(16);
            if (drawable2 != null) {
                this.aEg.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(9)) {
            this.aEl = obtainStyledAttributes.getBoolean(9, true);
        }
        if (obtainStyledAttributes.hasValue(13)) {
            this.aEj = obtainStyledAttributes.getBoolean(13, false);
        }
        handleStyledAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        updateUIForMode();
    }

    private boolean jN() {
        switch (Gu()[this.aEe.ordinal()]) {
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

    private void Gs() {
        float f;
        float f2;
        int round;
        int footerSize;
        switch (Gr()[getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
                f = this.mInitialMotionX;
                f2 = this.mLastMotionX;
                break;
            default:
                f = this.mInitialMotionY;
                f2 = this.mLastMotionY;
                break;
        }
        switch (Gu()[this.aEf.ordinal()]) {
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
            switch (Gu()[this.aEf.ordinal()]) {
                case 3:
                    this.aEq.onPull(abs);
                    break;
                default:
                    this.aEp.onPull(abs);
                    break;
            }
            if (this.aEd != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.aEd == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
                a(State.RELEASE_TO_REFRESH, new boolean[0]);
            }
        }
    }

    private LinearLayout.LayoutParams getLoadingLayoutLayoutParams() {
        switch (Gr()[getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
                return new LinearLayout.LayoutParams(-2, -1);
            default:
                return new LinearLayout.LayoutParams(-1, -2);
        }
    }

    private int getMaximumPullScroll() {
        switch (Gr()[getPullToRefreshScrollDirection().ordinal()]) {
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
        if (this.aEu != null) {
            this.aEu.stop();
        }
        switch (Gr()[getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
                scrollX = getScrollX();
                break;
            default:
                scrollX = getScrollY();
                break;
        }
        if (scrollX != i) {
            if (this.aEn == null) {
                this.aEn = new DecelerateInterpolator();
            }
            this.aEu = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.aEu, j2);
            } else {
                post(this.aEu);
            }
        }
    }

    /* loaded from: classes.dex */
    public enum AnimationStyle {
        ROTATE,
        FLIP;
        
        private static /* synthetic */ int[] aEy;

        /* JADX DEBUG: Replace access to removed values field (aEz) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static AnimationStyle[] valuesCustom() {
            AnimationStyle[] valuesCustom = values();
            int length = valuesCustom.length;
            AnimationStyle[] animationStyleArr = new AnimationStyle[length];
            System.arraycopy(valuesCustom, 0, animationStyleArr, 0, length);
            return animationStyleArr;
        }

        static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$tbadk$widget$pulltorefresh$library$PullToRefreshBase$AnimationStyle() {
            int[] iArr = aEy;
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
                aEy = iArr;
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

        /* JADX DEBUG: Replace access to removed values field (aEA) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (aEI) with 'values()' method */
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
        private final int aEC;
        private final int aED;
        private final long aEE;
        private d aEF;
        private final Interpolator mInterpolator;
        private boolean aEG = true;
        private long mStartTime = -1;
        private int aEH = -1;

        public e(int i, int i2, long j, d dVar) {
            this.aED = i;
            this.aEC = i2;
            this.mInterpolator = PullToRefreshBase.this.aEn;
            this.aEE = j;
            this.aEF = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aEH = this.aED - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.aEE, 1000L), 0L)) / 1000.0f) * (this.aED - this.aEC));
                PullToRefreshBase.this.setHeaderScroll(this.aEH);
            }
            if (this.aEG && this.aEC != this.aEH) {
                com.baidu.tbadk.widget.pulltorefresh.library.a.e.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.aEF != null) {
                this.aEF.Gv();
            }
        }

        public void stop() {
            this.aEG = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
