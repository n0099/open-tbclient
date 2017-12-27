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
    private State bHb;
    private Mode bHc;
    private Mode bHd;
    T bHe;
    private FrameLayout bHf;
    private boolean bHg;
    private boolean bHh;
    private boolean bHi;
    private boolean bHj;
    private boolean bHk;
    private Interpolator bHl;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b bHm;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b bHn;
    private b<T> bHo;
    private c<T> bHp;
    private a<T> bHq;
    private PullToRefreshBase<T>.e bHr;
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
        void QG();
    }

    protected abstract boolean QA();

    protected abstract boolean Qz();

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
        return this.bHd;
    }

    public final boolean getFilterTouchEvents() {
        return this.bHi;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return m(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a m(boolean z, boolean z2) {
        return n(z, z2);
    }

    public final Mode getMode() {
        return this.bHc;
    }

    public final T getRefreshableView() {
        return this.bHe;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.bHg;
    }

    public final State getState() {
        return this.bHb;
    }

    public final boolean Qy() {
        return this.bHc.permitsPullToRefresh();
    }

    public final boolean isRefreshing() {
        return this.bHb == State.REFRESHING || this.bHb == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (Qy()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (QE()) {
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
                        if (!this.bHh && isRefreshing()) {
                            return true;
                        }
                        if (QE()) {
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
                            if (abs > this.mTouchSlop && (!this.bHi || abs > Math.abs(f2))) {
                                if (this.bHc.showHeaderLoadingLayout() && f >= 1.0f && QA()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.bHc == Mode.BOTH) {
                                        this.bHd = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.bHc.showFooterLoadingLayout() && f <= -1.0f && Qz()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.bHc == Mode.BOTH) {
                                        this.bHd = Mode.PULL_FROM_END;
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
        if (Qy()) {
            if (this.bHh || !isRefreshing()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (QE()) {
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
                                if (this.bHb == State.RELEASE_TO_REFRESH && (this.bHo != null || this.bHp != null)) {
                                    a(State.REFRESHING, true);
                                    return true;
                                } else if (isRefreshing()) {
                                    iQ(0);
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
                                QF();
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
        this.bHh = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.bHi = z;
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
        if (mode != this.bHc) {
            this.bHc = mode;
            QC();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.bHq = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.bHo = bVar;
        this.bHp = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.bHp = cVar;
        this.bHo = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.bHj = z;
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
        m(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.bHl = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.bHg = z;
    }

    final void a(State state, boolean... zArr) {
        this.bHb = state;
        switch (this.bHb) {
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
                cI(zArr[0]);
                break;
        }
        if (this.bHq != null) {
            this.bHq.a(this, this.bHb, this.bHd);
        }
    }

    protected final void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void a(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b n(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.bHc.showHeaderLoadingLayout()) {
            bVar.a(this.bHm);
        }
        if (z2 && this.bHc.showFooterLoadingLayout()) {
            bVar.a(this.bHn);
        }
        return bVar;
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getFooterLayout() {
        return this.bHn;
    }

    protected final int getFooterSize() {
        return this.bHn.getContentSize();
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getHeaderLayout() {
        return this.bHm;
    }

    protected final int getHeaderSize() {
        return this.bHm.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.bHf;
    }

    protected void i(Bundle bundle) {
    }

    protected void j(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (this.bHd) {
            case PULL_FROM_END:
                this.bHn.sU();
                return;
            case PULL_FROM_START:
                this.bHm.sU();
                return;
            default:
                return;
        }
    }

    protected void cI(boolean z) {
        if (this.bHc.showHeaderLoadingLayout()) {
            this.bHm.sw();
        }
        if (this.bHc.showFooterLoadingLayout()) {
            this.bHn.sw();
        }
        if (z) {
            if (this.bHg) {
                d dVar = new d() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.1
                    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.d
                    public void QG() {
                        PullToRefreshBase.this.QD();
                    }
                };
                switch (this.bHd) {
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
            iQ(0);
            return;
        }
        QD();
    }

    protected void onReleaseToRefresh() {
        switch (this.bHd) {
            case PULL_FROM_END:
                this.bHn.sv();
                return;
            case PULL_FROM_START:
                this.bHm.sv();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.bHk = true;
        this.bHm.reset();
        this.bHn.reset();
        iQ(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.bHd = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.bHh = bundle.getBoolean("ptr_disable_scrolling", false);
            this.bHg = bundle.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
            State mapIntToValue = State.mapIntToValue(bundle.getInt("ptr_state", 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                a(mapIntToValue, true);
            }
            i(bundle);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        j(bundle);
        bundle.putInt("ptr_state", this.bHb.getIntValue());
        bundle.putInt("ptr_mode", this.bHc.getIntValue());
        bundle.putInt("ptr_current_mode", this.bHd.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.bHh);
        bundle.putBoolean("ptr_show_refreshing_view", this.bHg);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        QB();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    protected final void QB() {
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
                if (this.bHc.showHeaderLoadingLayout()) {
                    this.bHm.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.bHc.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.bHn.setWidth(maximumPullScroll);
                    i4 = i5;
                    i3 = -maximumPullScroll;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                }
            case VERTICAL:
                if (this.bHc.showHeaderLoadingLayout()) {
                    this.bHm.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.bHc.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.bHn.setHeight(maximumPullScroll);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHf.getLayoutParams();
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.bHf.requestLayout();
                    return;
                }
                return;
            case VERTICAL:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.bHf.requestLayout();
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
        if (this.bHk) {
            if (min < 0) {
                this.bHm.setVisibility(0);
            } else if (min > 0) {
                this.bHn.setVisibility(0);
            } else {
                this.bHm.setVisibility(4);
                this.bHn.setVisibility(4);
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

    protected final void iQ(int i) {
        d(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void QC() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.bHm.getParent()) {
            removeView(this.bHm);
        }
        if (this.bHc.showHeaderLoadingLayout()) {
            a(this.bHm, 0, loadingLayoutLayoutParams);
        }
        if (this == this.bHn.getParent()) {
            removeView(this.bHn);
        }
        if (this.bHc.showFooterLoadingLayout()) {
            a(this.bHn, loadingLayoutLayoutParams);
        }
        QB();
        this.bHd = this.bHc != Mode.BOTH ? this.bHc : Mode.PULL_FROM_START;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QD() {
        if (this.bHo != null) {
            this.bHo.c(this);
        } else if (this.bHp != null) {
            if (this.bHd == Mode.PULL_FROM_START) {
                this.bHp.d(this);
            } else if (this.bHd == Mode.PULL_FROM_END) {
                this.bHp.e(this);
            }
        }
    }

    private boolean QE() {
        switch (this.bHc) {
            case PULL_FROM_END:
                return Qz();
            case PULL_FROM_START:
                return QA();
            case MANUAL_REFRESH_ONLY:
            default:
                return false;
            case BOTH:
                return Qz() || QA();
        }
    }

    private void QF() {
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
        switch (this.bHd) {
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
        if (round != 0 && !isRefreshing()) {
            float abs = Math.abs(round) / footerSize;
            switch (this.bHd) {
                case PULL_FROM_END:
                    this.bHn.onPull(abs);
                    break;
                default:
                    this.bHm.onPull(abs);
                    break;
            }
            if (this.bHb != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.bHb == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
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
        if (this.bHr != null) {
            this.bHr.stop();
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
            if (this.bHl == null) {
                this.bHl = new DecelerateInterpolator();
            }
            this.bHr = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.bHr, j2);
            } else {
                post(this.bHr);
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
        private final int bHA;
        private final int bHB;
        private d bHC;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bHD = true;
        private long mStartTime = -1;
        private int bHE = -1;

        public e(int i, int i2, long j, d dVar) {
            this.bHB = i;
            this.bHA = i2;
            this.mInterpolator = PullToRefreshBase.this.bHl;
            this.mDuration = j;
            this.bHC = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bHE = this.bHB - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bHB - this.bHA));
                PullToRefreshBase.this.setHeaderScroll(this.bHE);
            }
            if (this.bHD && this.bHA != this.bHE) {
                com.baidu.tbadk.widget.pulltorefresh.library.a.e.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.bHC != null) {
                this.bHC.QG();
            }
        }

        public void stop() {
            this.bHD = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
