package com.baidu.tbadk.widget.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private State aQd;
    private Mode aQe;
    private Mode aQf;
    T aQg;
    private FrameLayout aQh;
    private boolean aQi;
    private boolean aQj;
    private boolean aQk;
    private boolean aQl;
    private boolean aQm;
    private Interpolator aQn;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b aQo;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b aQp;
    private b<T> aQq;
    private c<T> aQr;
    private a<T> aQs;
    private PullToRefreshBase<T>.e aQt;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public enum Orientation {
        VERTICAL,
        HORIZONTAL
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
        void IA();
    }

    protected abstract boolean It();

    protected abstract boolean Iu();

    public abstract Orientation getPullToRefreshScrollDirection();

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
        return this.aQf;
    }

    public final boolean getFilterTouchEvents() {
        return this.aQk;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return k(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a k(boolean z, boolean z2) {
        return l(z, z2);
    }

    public final Mode getMode() {
        return this.aQe;
    }

    public final T getRefreshableView() {
        return this.aQg;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.aQi;
    }

    public final State getState() {
        return this.aQd;
    }

    public final boolean Ir() {
        return this.aQe.permitsPullToRefresh();
    }

    public final boolean Is() {
        return this.aQd == State.REFRESHING || this.aQd == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (Ir()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (Iy()) {
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
                        if (!this.aQj && Is()) {
                            return true;
                        }
                        if (Iy()) {
                            float y2 = motionEvent.getY();
                            float x2 = motionEvent.getX();
                            switch (getPullToRefreshScrollDirection()) {
                                case HORIZONTAL:
                                    f = x2 - this.mLastMotionX;
                                    f2 = y2 - this.mLastMotionY;
                                    break;
                                default:
                                    f = y2 - this.mLastMotionY;
                                    f2 = x2 - this.mLastMotionX;
                                    break;
                            }
                            float abs = Math.abs(f);
                            if (abs > this.mTouchSlop && (!this.aQk || abs > Math.abs(f2))) {
                                if (this.aQe.showHeaderLoadingLayout() && f >= 1.0f && Iu()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.aQe == Mode.BOTH) {
                                        this.aQf = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.aQe.showFooterLoadingLayout() && f <= -1.0f && It()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.aQe == Mode.BOTH) {
                                        this.aQf = Mode.PULL_FROM_END;
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

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (Ir()) {
            if (this.aQj || !Is()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (Iy()) {
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
                                if (this.aQd == State.RELEASE_TO_REFRESH && (this.aQq != null || this.aQr != null)) {
                                    a(State.REFRESHING, true);
                                    return true;
                                } else if (Is()) {
                                    fL(0);
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
                                Iz();
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
        this.aQj = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.aQk = z;
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
        if (mode != this.aQe) {
            this.aQe = mode;
            Iw();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.aQs = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.aQq = bVar;
        this.aQr = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.aQr = cVar;
        this.aQq = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.aQl = z;
    }

    public final void setRefreshing(boolean z) {
        if (!Is()) {
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
        k(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.aQn = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.aQi = z;
    }

    final void a(State state, boolean... zArr) {
        this.aQd = state;
        switch (this.aQd) {
            case RESET:
                onReset();
                break;
            case PULL_TO_REFRESH:
                onPullToRefresh();
                break;
            case RELEASE_TO_REFRESH:
                onReleaseToRefresh();
                break;
            case REFRESHING:
            case MANUAL_REFRESHING:
                ca(zArr[0]);
                break;
        }
        if (this.aQs != null) {
            this.aQs.a(this, this.aQd, this.aQf);
        }
    }

    protected final void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void a(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b l(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.aQe.showHeaderLoadingLayout()) {
            bVar.a(this.aQo);
        }
        if (z2 && this.aQe.showFooterLoadingLayout()) {
            bVar.a(this.aQp);
        }
        return bVar;
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getFooterLayout() {
        return this.aQp;
    }

    protected final int getFooterSize() {
        return this.aQp.getContentSize();
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getHeaderLayout() {
        return this.aQo;
    }

    protected final int getHeaderSize() {
        return this.aQo.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.aQh;
    }

    protected void f(Bundle bundle) {
    }

    protected void g(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (this.aQf) {
            case PULL_FROM_END:
                this.aQp.IF();
                return;
            case PULL_FROM_START:
                this.aQo.IF();
                return;
            default:
                return;
        }
    }

    protected void ca(boolean z) {
        if (this.aQe.showHeaderLoadingLayout()) {
            this.aQo.kZ();
        }
        if (this.aQe.showFooterLoadingLayout()) {
            this.aQp.kZ();
        }
        if (z) {
            if (this.aQi) {
                d dVar = new d() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.1
                    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.d
                    public void IA() {
                        PullToRefreshBase.this.Ix();
                    }
                };
                switch (this.aQf) {
                    case PULL_FROM_END:
                    case MANUAL_REFRESH_ONLY:
                        a(getFooterSize(), dVar);
                        return;
                    case PULL_FROM_START:
                    default:
                        a(-getHeaderSize(), dVar);
                        return;
                }
            }
            fL(0);
            return;
        }
        Ix();
    }

    protected void onReleaseToRefresh() {
        switch (this.aQf) {
            case PULL_FROM_END:
                this.aQp.kY();
                return;
            case PULL_FROM_START:
                this.aQo.kY();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.aQm = true;
        this.aQo.reset();
        this.aQp.reset();
        fL(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.aQf = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.aQj = bundle.getBoolean("ptr_disable_scrolling", false);
            this.aQi = bundle.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
            State mapIntToValue = State.mapIntToValue(bundle.getInt("ptr_state", 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                a(mapIntToValue, true);
            }
            f(bundle);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        g(bundle);
        bundle.putInt("ptr_state", this.aQd.getIntValue());
        bundle.putInt("ptr_mode", this.aQe.getIntValue());
        bundle.putInt("ptr_current_mode", this.aQf.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.aQj);
        bundle.putBoolean("ptr_show_refreshing_view", this.aQi);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Iv();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    protected final void Iv() {
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
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (this.aQe.showHeaderLoadingLayout()) {
                    this.aQo.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.aQe.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.aQp.setWidth(maximumPullScroll);
                    i4 = i5;
                    i3 = -maximumPullScroll;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                }
            case VERTICAL:
                if (this.aQe.showHeaderLoadingLayout()) {
                    this.aQo.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.aQe.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.aQp.setHeight(maximumPullScroll);
                    i6 = -maximumPullScroll;
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aQh.getLayoutParams();
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.aQh.requestLayout();
                    return;
                }
                return;
            case VERTICAL:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.aQh.requestLayout();
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final void setHeaderScroll(int i) {
        int maximumPullScroll = getMaximumPullScroll();
        int min = Math.min(maximumPullScroll, Math.max(-maximumPullScroll, i));
        if (this.aQm) {
            if (min < 0) {
                this.aQo.setVisibility(0);
            } else if (min > 0) {
                this.aQp.setVisibility(0);
            } else {
                this.aQo.setVisibility(4);
                this.aQp.setVisibility(4);
            }
        }
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                scrollTo(min, 0);
                return;
            case VERTICAL:
                scrollTo(0, min);
                return;
            default:
                return;
        }
    }

    protected final void fL(int i) {
        d(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void Iw() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.aQo.getParent()) {
            removeView(this.aQo);
        }
        if (this.aQe.showHeaderLoadingLayout()) {
            a(this.aQo, 0, loadingLayoutLayoutParams);
        }
        if (this == this.aQp.getParent()) {
            removeView(this.aQp);
        }
        if (this.aQe.showFooterLoadingLayout()) {
            a(this.aQp, loadingLayoutLayoutParams);
        }
        Iv();
        this.aQf = this.aQe != Mode.BOTH ? this.aQe : Mode.PULL_FROM_START;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ix() {
        if (this.aQq != null) {
            this.aQq.c(this);
        } else if (this.aQr != null) {
            if (this.aQf == Mode.PULL_FROM_START) {
                this.aQr.d(this);
            } else if (this.aQf == Mode.PULL_FROM_END) {
                this.aQr.e(this);
            }
        }
    }

    private boolean Iy() {
        switch (this.aQe) {
            case PULL_FROM_END:
                return It();
            case PULL_FROM_START:
                return Iu();
            case MANUAL_REFRESH_ONLY:
            default:
                return false;
            case BOTH:
                return It() || Iu();
        }
    }

    private void Iz() {
        float f;
        float f2;
        int round;
        int footerSize;
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                f = this.mInitialMotionX;
                f2 = this.mLastMotionX;
                break;
            default:
                f = this.mInitialMotionY;
                f2 = this.mLastMotionY;
                break;
        }
        switch (this.aQf) {
            case PULL_FROM_END:
                round = Math.round(Math.max(f - f2, 0.0f) / 2.0f);
                footerSize = getFooterSize();
                break;
            default:
                round = Math.round(Math.min(f - f2, 0.0f) / 2.0f);
                footerSize = getHeaderSize();
                break;
        }
        setHeaderScroll(round);
        if (round != 0 && !Is()) {
            float abs = Math.abs(round) / footerSize;
            switch (this.aQf) {
                case PULL_FROM_END:
                    this.aQp.onPull(abs);
                    break;
                default:
                    this.aQo.onPull(abs);
                    break;
            }
            if (this.aQd != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.aQd == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
                a(State.RELEASE_TO_REFRESH, new boolean[0]);
            }
        }
    }

    private LinearLayout.LayoutParams getLoadingLayoutLayoutParams() {
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                return new LinearLayout.LayoutParams(-2, -1);
            default:
                return new LinearLayout.LayoutParams(-1, -2);
        }
    }

    private int getMaximumPullScroll() {
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                return Math.round(getWidth() / 2.0f);
            default:
                return Math.round(getHeight() / 2.0f);
        }
    }

    private final void d(int i, long j) {
        a(i, j, 0L, null);
    }

    private final void a(int i, long j, long j2, d dVar) {
        int scrollX;
        if (this.aQt != null) {
            this.aQt.stop();
        }
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                scrollX = getScrollX();
                break;
            default:
                scrollX = getScrollY();
                break;
        }
        if (scrollX != i) {
            if (this.aQn == null) {
                this.aQn = new DecelerateInterpolator();
            }
            this.aQt = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.aQt, j2);
            } else {
                post(this.aQt);
            }
        }
    }

    /* loaded from: classes.dex */
    public enum AnimationStyle {
        ROTATE,
        FLIP;

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
            switch (this) {
                case FLIP:
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

        static Mode mapIntToValue(int i) {
            Mode[] values;
            for (Mode mode : values()) {
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

        boolean permitsPullToRefresh() {
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

        static State mapIntToValue(int i) {
            State[] values;
            for (State state : values()) {
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
        private final int aQC;
        private final int aQD;
        private d aQE;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aQF = true;
        private long mStartTime = -1;
        private int aQG = -1;

        public e(int i, int i2, long j, d dVar) {
            this.aQD = i;
            this.aQC = i2;
            this.mInterpolator = PullToRefreshBase.this.aQn;
            this.mDuration = j;
            this.aQE = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aQG = this.aQD - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aQD - this.aQC));
                PullToRefreshBase.this.setHeaderScroll(this.aQG);
            }
            if (this.aQF && this.aQC != this.aQG) {
                com.baidu.tbadk.widget.pulltorefresh.library.a.e.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.aQE != null) {
                this.aQE.IA();
            }
        }

        public void stop() {
            this.aQF = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
