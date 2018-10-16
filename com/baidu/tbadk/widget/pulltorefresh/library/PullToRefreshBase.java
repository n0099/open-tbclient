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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private boolean blA;
    private boolean blB;
    private Interpolator blC;
    private AnimationStyle blD;
    private LoadingLayout blE;
    private LoadingLayout blF;
    private b<T> blG;
    private c<T> blH;
    private a<T> blI;
    private PullToRefreshBase<T>.e blJ;
    private State blu;
    private Mode blv;
    private Mode blw;
    private boolean blx;
    private boolean bly;
    private boolean blz;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private float mLastMotionX;
    private float mLastMotionY;
    T mRefreshableView;
    private FrameLayout mRefreshableViewWrapper;
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
        void QH();
    }

    protected abstract boolean QB();

    protected abstract boolean QC();

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract Orientation getPullToRefreshScrollDirection();

    public PullToRefreshBase(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.blu = State.RESET;
        this.blv = Mode.getDefault();
        this.blx = true;
        this.bly = false;
        this.blz = true;
        this.blA = true;
        this.blB = true;
        this.blD = AnimationStyle.getDefault();
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.blu = State.RESET;
        this.blv = Mode.getDefault();
        this.blx = true;
        this.bly = false;
        this.blz = true;
        this.blA = true;
        this.blB = true;
        this.blD = AnimationStyle.getDefault();
        init(context, attributeSet);
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
        return this.blw;
    }

    public final boolean getFilterTouchEvents() {
        return this.blz;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return l(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a l(boolean z, boolean z2) {
        return m(z, z2);
    }

    public final Mode getMode() {
        return this.blv;
    }

    public final T getRefreshableView() {
        return this.mRefreshableView;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.blx;
    }

    public final State getState() {
        return this.blu;
    }

    public final boolean QA() {
        return this.blv.permitsPullToRefresh();
    }

    public final boolean isRefreshing() {
        return this.blu == State.REFRESHING || this.blu == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (QA()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (QF()) {
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
                        if (!this.bly && isRefreshing()) {
                            return true;
                        }
                        if (QF()) {
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
                            if (abs > this.mTouchSlop && (!this.blz || abs > Math.abs(f2))) {
                                if (this.blv.showHeaderLoadingLayout() && f >= 1.0f && QC()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.blv == Mode.BOTH) {
                                        this.blw = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.blv.showFooterLoadingLayout() && f <= -1.0f && QB()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.blv == Mode.BOTH) {
                                        this.blw = Mode.PULL_FROM_END;
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
        if (QA()) {
            if (this.bly || !isRefreshing()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (QF()) {
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
                                if (this.blu == State.RELEASE_TO_REFRESH && (this.blG != null || this.blH != null)) {
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
                                QG();
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
        this.bly = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.blz = z;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    public void setLoadingDrawable(Drawable drawable, Mode mode) {
        l(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public final void setMode(Mode mode) {
        if (mode != this.blv) {
            this.blv = mode;
            QD();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.blI = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.blG = bVar;
        this.blH = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.blH = cVar;
        this.blG = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public void setPullLabel(CharSequence charSequence, Mode mode) {
        l(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.blA = z;
    }

    public final void setRefreshing() {
        setRefreshing(true);
    }

    public final void setRefreshing(boolean z) {
        if (!isRefreshing()) {
            a(State.MANUAL_REFRESHING, z);
        }
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setRefreshingLabel(charSequence);
    }

    public void setRefreshingLabel(CharSequence charSequence, Mode mode) {
        l(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        setReleaseLabel(charSequence, Mode.BOTH);
    }

    public void setReleaseLabel(CharSequence charSequence, Mode mode) {
        l(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.blC = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.blx = z;
    }

    final void a(State state, boolean... zArr) {
        this.blu = state;
        switch (this.blu) {
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
                cG(zArr[0]);
                break;
        }
        if (this.blI != null) {
            this.blI.a(this, this.blu, this.blw);
        }
    }

    protected final void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void a(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected LoadingLayout a(Context context, Mode mode, TypedArray typedArray) {
        LoadingLayout createLoadingLayout = this.blD.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b m(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.blv.showHeaderLoadingLayout()) {
            bVar.a(this.blE);
        }
        if (z2 && this.blv.showFooterLoadingLayout()) {
            bVar.a(this.blF);
        }
        return bVar;
    }

    protected final LoadingLayout getFooterLayout() {
        return this.blF;
    }

    protected final int getFooterSize() {
        return this.blF.getContentSize();
    }

    protected final LoadingLayout getHeaderLayout() {
        return this.blE;
    }

    protected final int getHeaderSize() {
        return this.blE.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.mRefreshableViewWrapper;
    }

    protected void a(TypedArray typedArray) {
    }

    protected void g(Bundle bundle) {
    }

    protected void h(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (this.blw) {
            case PULL_FROM_END:
                this.blF.pullToRefresh();
                return;
            case PULL_FROM_START:
                this.blE.pullToRefresh();
                return;
            default:
                return;
        }
    }

    protected void cG(boolean z) {
        if (this.blv.showHeaderLoadingLayout()) {
            this.blE.refreshing();
        }
        if (this.blv.showFooterLoadingLayout()) {
            this.blF.refreshing();
        }
        if (z) {
            if (this.blx) {
                d dVar = new d() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.1
                    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.d
                    public void QH() {
                        PullToRefreshBase.this.QE();
                    }
                };
                switch (this.blw) {
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
            smoothScrollTo(0);
            return;
        }
        QE();
    }

    protected void onReleaseToRefresh() {
        switch (this.blw) {
            case PULL_FROM_END:
                this.blF.releaseToRefresh();
                return;
            case PULL_FROM_START:
                this.blE.releaseToRefresh();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.blB = true;
        this.blE.reset();
        this.blF.reset();
        smoothScrollTo(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.blw = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.bly = bundle.getBoolean("ptr_disable_scrolling", false);
            this.blx = bundle.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
            State mapIntToValue = State.mapIntToValue(bundle.getInt("ptr_state", 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                a(mapIntToValue, true);
            }
            g(bundle);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        h(bundle);
        bundle.putInt("ptr_state", this.blu.getIntValue());
        bundle.putInt("ptr_mode", this.blv.getIntValue());
        bundle.putInt("ptr_current_mode", this.blw.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.bly);
        bundle.putBoolean("ptr_show_refreshing_view", this.blx);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        refreshLoadingViewsSize();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
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
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (this.blv.showHeaderLoadingLayout()) {
                    this.blE.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.blv.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.blF.setWidth(maximumPullScroll);
                    i4 = i5;
                    i3 = -maximumPullScroll;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                }
            case VERTICAL:
                if (this.blv.showHeaderLoadingLayout()) {
                    this.blE.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.blv.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.blF.setHeight(maximumPullScroll);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRefreshableViewWrapper.getLayoutParams();
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.mRefreshableViewWrapper.requestLayout();
                    return;
                }
                return;
            case VERTICAL:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.mRefreshableViewWrapper.requestLayout();
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
        if (this.blB) {
            if (min < 0) {
                this.blE.setVisibility(0);
            } else if (min > 0) {
                this.blF.setVisibility(0);
            } else {
                this.blE.setVisibility(4);
                this.blF.setVisibility(4);
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

    protected final void smoothScrollTo(int i) {
        f(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void QD() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.blE.getParent()) {
            removeView(this.blE);
        }
        if (this.blv.showHeaderLoadingLayout()) {
            a(this.blE, 0, loadingLayoutLayoutParams);
        }
        if (this == this.blF.getParent()) {
            removeView(this.blF);
        }
        if (this.blv.showFooterLoadingLayout()) {
            a(this.blF, loadingLayoutLayoutParams);
        }
        refreshLoadingViewsSize();
        this.blw = this.blv != Mode.BOTH ? this.blv : Mode.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.mRefreshableViewWrapper = new FrameLayout(context);
        this.mRefreshableViewWrapper.addView(t, -1, -1);
        a(this.mRefreshableViewWrapper, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QE() {
        if (this.blG != null) {
            this.blG.c(this);
        } else if (this.blH != null) {
            if (this.blw == Mode.PULL_FROM_START) {
                this.blH.d(this);
            } else if (this.blw == Mode.PULL_FROM_END) {
                this.blH.e(this);
            }
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                setOrientation(0);
                break;
            default:
                setOrientation(1);
                break;
        }
        setGravity(17);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.PullToRefresh);
        if (obtainStyledAttributes.hasValue(e.l.PullToRefresh_tb_ptrMode)) {
            this.blv = Mode.mapIntToValue(obtainStyledAttributes.getInteger(e.l.PullToRefresh_tb_ptrMode, 0));
        }
        if (obtainStyledAttributes.hasValue(e.l.PullToRefresh_tb_ptrAnimationStyle)) {
            this.blD = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(e.l.PullToRefresh_tb_ptrAnimationStyle, 0));
        }
        this.mRefreshableView = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.mRefreshableView);
        this.blE = a(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.blF = a(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(e.l.PullToRefresh_tb_ptrRefreshableViewBackground)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(e.l.PullToRefresh_tb_ptrRefreshableViewBackground);
            if (drawable != null) {
                this.mRefreshableView.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(e.l.PullToRefresh_tb_ptrAdapterViewBackground)) {
            com.baidu.tbadk.widget.pulltorefresh.library.internal.a.aP("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(e.l.PullToRefresh_tb_ptrAdapterViewBackground);
            if (drawable2 != null) {
                this.mRefreshableView.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(e.l.PullToRefresh_tb_ptrOverScroll)) {
            this.blA = obtainStyledAttributes.getBoolean(e.l.PullToRefresh_tb_ptrOverScroll, true);
        }
        if (obtainStyledAttributes.hasValue(e.l.PullToRefresh_tb_ptrScrollingWhileRefreshingEnabled)) {
            this.bly = obtainStyledAttributes.getBoolean(e.l.PullToRefresh_tb_ptrScrollingWhileRefreshingEnabled, false);
        }
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        QD();
    }

    private boolean QF() {
        switch (this.blv) {
            case PULL_FROM_END:
                return QB();
            case PULL_FROM_START:
                return QC();
            case MANUAL_REFRESH_ONLY:
            default:
                return false;
            case BOTH:
                return QB() || QC();
        }
    }

    private void QG() {
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
        switch (this.blw) {
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
            switch (this.blw) {
                case PULL_FROM_END:
                    this.blF.onPull(abs);
                    break;
                default:
                    this.blE.onPull(abs);
                    break;
            }
            if (this.blu != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.blu == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
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

    private final void f(int i, long j) {
        a(i, j, 0L, null);
    }

    private final void a(int i, long j, long j2, d dVar) {
        int scrollX;
        if (this.blJ != null) {
            this.blJ.stop();
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
            if (this.blC == null) {
                this.blC = new DecelerateInterpolator();
            }
            this.blJ = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.blJ, j2);
            } else {
                post(this.blJ);
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

        LoadingLayout createLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
            switch (this) {
                case FLIP:
                    return new FlipLoadingLayout(context, mode, orientation, typedArray);
                default:
                    return new RotateLoadingLayout(context, mode, orientation, typedArray);
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
        private d blP;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private final int mScrollFromY;
        private final int mScrollToY;
        private boolean mContinueRunning = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;

        public e(int i, int i2, long j, d dVar) {
            this.mScrollFromY = i;
            this.mScrollToY = i2;
            this.mInterpolator = PullToRefreshBase.this.blC;
            this.mDuration = j;
            this.blP = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.mScrollFromY - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.mScrollFromY - this.mScrollToY));
                PullToRefreshBase.this.setHeaderScroll(this.mCurrentY);
            }
            if (this.mContinueRunning && this.mScrollToY != this.mCurrentY) {
                com.baidu.tbadk.widget.pulltorefresh.library.internal.b.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.blP != null) {
                this.blP.QH();
            }
        }

        public void stop() {
            this.mContinueRunning = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
