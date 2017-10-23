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
    private State aPZ;
    private Mode aQa;
    private Mode aQb;
    T aQc;
    private FrameLayout aQd;
    private boolean aQe;
    private boolean aQf;
    private boolean aQg;
    private boolean aQh;
    private boolean aQi;
    private Interpolator aQj;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b aQk;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b aQl;
    private b<T> aQm;
    private c<T> aQn;
    private a<T> aQo;
    private PullToRefreshBase<T>.e aQp;
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
        void Iq();
    }

    protected abstract boolean Ij();

    protected abstract boolean Ik();

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
        return this.aQb;
    }

    public final boolean getFilterTouchEvents() {
        return this.aQg;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return k(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a k(boolean z, boolean z2) {
        return l(z, z2);
    }

    public final Mode getMode() {
        return this.aQa;
    }

    public final T getRefreshableView() {
        return this.aQc;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.aQe;
    }

    public final State getState() {
        return this.aPZ;
    }

    public final boolean Ih() {
        return this.aQa.permitsPullToRefresh();
    }

    public final boolean Ii() {
        return this.aPZ == State.REFRESHING || this.aPZ == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (Ih()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (Io()) {
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
                        if (!this.aQf && Ii()) {
                            return true;
                        }
                        if (Io()) {
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
                            if (abs > this.mTouchSlop && (!this.aQg || abs > Math.abs(f2))) {
                                if (this.aQa.showHeaderLoadingLayout() && f >= 1.0f && Ik()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.aQa == Mode.BOTH) {
                                        this.aQb = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.aQa.showFooterLoadingLayout() && f <= -1.0f && Ij()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.aQa == Mode.BOTH) {
                                        this.aQb = Mode.PULL_FROM_END;
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
        if (Ih()) {
            if (this.aQf || !Ii()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (Io()) {
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
                                if (this.aPZ == State.RELEASE_TO_REFRESH && (this.aQm != null || this.aQn != null)) {
                                    a(State.REFRESHING, true);
                                    return true;
                                } else if (Ii()) {
                                    fK(0);
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
                                Ip();
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
        this.aQf = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.aQg = z;
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
        if (mode != this.aQa) {
            this.aQa = mode;
            Im();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.aQo = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.aQm = bVar;
        this.aQn = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.aQn = cVar;
        this.aQm = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.aQh = z;
    }

    public final void setRefreshing(boolean z) {
        if (!Ii()) {
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
        this.aQj = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.aQe = z;
    }

    final void a(State state, boolean... zArr) {
        this.aPZ = state;
        switch (this.aPZ) {
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
                cf(zArr[0]);
                break;
        }
        if (this.aQo != null) {
            this.aQo.a(this, this.aPZ, this.aQb);
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
        if (z && this.aQa.showHeaderLoadingLayout()) {
            bVar.a(this.aQk);
        }
        if (z2 && this.aQa.showFooterLoadingLayout()) {
            bVar.a(this.aQl);
        }
        return bVar;
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getFooterLayout() {
        return this.aQl;
    }

    protected final int getFooterSize() {
        return this.aQl.getContentSize();
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getHeaderLayout() {
        return this.aQk;
    }

    protected final int getHeaderSize() {
        return this.aQk.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.aQd;
    }

    protected void f(Bundle bundle) {
    }

    protected void g(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (this.aQb) {
            case PULL_FROM_END:
                this.aQl.Iv();
                return;
            case PULL_FROM_START:
                this.aQk.Iv();
                return;
            default:
                return;
        }
    }

    protected void cf(boolean z) {
        if (this.aQa.showHeaderLoadingLayout()) {
            this.aQk.lf();
        }
        if (this.aQa.showFooterLoadingLayout()) {
            this.aQl.lf();
        }
        if (z) {
            if (this.aQe) {
                d dVar = new d() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.1
                    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.d
                    public void Iq() {
                        PullToRefreshBase.this.In();
                    }
                };
                switch (this.aQb) {
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
            fK(0);
            return;
        }
        In();
    }

    protected void onReleaseToRefresh() {
        switch (this.aQb) {
            case PULL_FROM_END:
                this.aQl.le();
                return;
            case PULL_FROM_START:
                this.aQk.le();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.aQi = true;
        this.aQk.reset();
        this.aQl.reset();
        fK(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.aQb = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.aQf = bundle.getBoolean("ptr_disable_scrolling", false);
            this.aQe = bundle.getBoolean("ptr_show_refreshing_view", true);
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
        bundle.putInt("ptr_state", this.aPZ.getIntValue());
        bundle.putInt("ptr_mode", this.aQa.getIntValue());
        bundle.putInt("ptr_current_mode", this.aQb.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.aQf);
        bundle.putBoolean("ptr_show_refreshing_view", this.aQe);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Il();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    protected final void Il() {
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
                if (this.aQa.showHeaderLoadingLayout()) {
                    this.aQk.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.aQa.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.aQl.setWidth(maximumPullScroll);
                    i4 = i5;
                    i3 = -maximumPullScroll;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                }
            case VERTICAL:
                if (this.aQa.showHeaderLoadingLayout()) {
                    this.aQk.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.aQa.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.aQl.setHeight(maximumPullScroll);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aQd.getLayoutParams();
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.aQd.requestLayout();
                    return;
                }
                return;
            case VERTICAL:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.aQd.requestLayout();
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
        if (this.aQi) {
            if (min < 0) {
                this.aQk.setVisibility(0);
            } else if (min > 0) {
                this.aQl.setVisibility(0);
            } else {
                this.aQk.setVisibility(4);
                this.aQl.setVisibility(4);
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

    protected final void fK(int i) {
        d(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void Im() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.aQk.getParent()) {
            removeView(this.aQk);
        }
        if (this.aQa.showHeaderLoadingLayout()) {
            a(this.aQk, 0, loadingLayoutLayoutParams);
        }
        if (this == this.aQl.getParent()) {
            removeView(this.aQl);
        }
        if (this.aQa.showFooterLoadingLayout()) {
            a(this.aQl, loadingLayoutLayoutParams);
        }
        Il();
        this.aQb = this.aQa != Mode.BOTH ? this.aQa : Mode.PULL_FROM_START;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void In() {
        if (this.aQm != null) {
            this.aQm.c(this);
        } else if (this.aQn != null) {
            if (this.aQb == Mode.PULL_FROM_START) {
                this.aQn.d(this);
            } else if (this.aQb == Mode.PULL_FROM_END) {
                this.aQn.e(this);
            }
        }
    }

    private boolean Io() {
        switch (this.aQa) {
            case PULL_FROM_END:
                return Ij();
            case PULL_FROM_START:
                return Ik();
            case MANUAL_REFRESH_ONLY:
            default:
                return false;
            case BOTH:
                return Ij() || Ik();
        }
    }

    private void Ip() {
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
        switch (this.aQb) {
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
        if (round != 0 && !Ii()) {
            float abs = Math.abs(round) / footerSize;
            switch (this.aQb) {
                case PULL_FROM_END:
                    this.aQl.onPull(abs);
                    break;
                default:
                    this.aQk.onPull(abs);
                    break;
            }
            if (this.aPZ != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.aPZ == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
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
        if (this.aQp != null) {
            this.aQp.stop();
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
            if (this.aQj == null) {
                this.aQj = new DecelerateInterpolator();
            }
            this.aQp = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.aQp, j2);
            } else {
                post(this.aQp);
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
        private d aQA;
        private final int aQy;
        private final int aQz;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aQB = true;
        private long mStartTime = -1;
        private int aQC = -1;

        public e(int i, int i2, long j, d dVar) {
            this.aQz = i;
            this.aQy = i2;
            this.mInterpolator = PullToRefreshBase.this.aQj;
            this.mDuration = j;
            this.aQA = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aQC = this.aQz - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aQz - this.aQy));
                PullToRefreshBase.this.setHeaderScroll(this.aQC);
            }
            if (this.aQB && this.aQy != this.aQC) {
                com.baidu.tbadk.widget.pulltorefresh.library.a.e.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.aQA != null) {
                this.aQA.Iq();
            }
        }

        public void stop() {
            this.aQB = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
