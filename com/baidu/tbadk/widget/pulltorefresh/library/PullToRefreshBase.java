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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private Interpolator bIL;
    T dwZ;
    private FrameLayout dxa;
    private State fTc;
    private Mode fTd;
    private Mode fTe;
    private boolean fTf;
    private boolean fTg;
    private boolean fTh;
    private boolean fTi;
    private boolean fTj;
    private AnimationStyle fTk;
    private LoadingLayout fTl;
    private LoadingLayout fTm;
    private b<T> fTn;
    private c<T> fTo;
    private a<T> fTp;
    private PullToRefreshBase<T>.e fTq;
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
        void Tl();
    }

    protected abstract boolean bGX();

    protected abstract boolean bGY();

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract Orientation getPullToRefreshScrollDirection();

    public PullToRefreshBase(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.fTc = State.RESET;
        this.fTd = Mode.getDefault();
        this.fTf = true;
        this.fTg = false;
        this.fTh = true;
        this.fTi = true;
        this.fTj = true;
        this.fTk = AnimationStyle.getDefault();
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.fTc = State.RESET;
        this.fTd = Mode.getDefault();
        this.fTf = true;
        this.fTg = false;
        this.fTh = true;
        this.fTi = true;
        this.fTj = true;
        this.fTk = AnimationStyle.getDefault();
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
        return this.fTe;
    }

    public final boolean getFilterTouchEvents() {
        return this.fTh;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return F(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a F(boolean z, boolean z2) {
        return G(z, z2);
    }

    public final Mode getMode() {
        return this.fTd;
    }

    public final T getRefreshableView() {
        return this.dwZ;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.fTf;
    }

    public final State getState() {
        return this.fTc;
    }

    public final boolean bGW() {
        return this.fTd.permitsPullToRefresh();
    }

    public final boolean isRefreshing() {
        return this.fTc == State.REFRESHING || this.fTc == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (bGW()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (bHb()) {
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
                        if (!this.fTg && isRefreshing()) {
                            return true;
                        }
                        if (bHb()) {
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
                            if (abs > this.mTouchSlop && (!this.fTh || abs > Math.abs(f2))) {
                                if (this.fTd.showHeaderLoadingLayout() && f >= 1.0f && bGY()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.fTd == Mode.BOTH) {
                                        this.fTe = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.fTd.showFooterLoadingLayout() && f <= -1.0f && bGX()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.fTd == Mode.BOTH) {
                                        this.fTe = Mode.PULL_FROM_END;
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
        if (bGW()) {
            if (this.fTg || !isRefreshing()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (bHb()) {
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
                                if (this.fTc == State.RELEASE_TO_REFRESH && (this.fTn != null || this.fTo != null)) {
                                    a(State.REFRESHING, true);
                                    return true;
                                } else if (isRefreshing()) {
                                    iG(0);
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
                                bHc();
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
        this.fTg = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.fTh = z;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    public void setLoadingDrawable(Drawable drawable, Mode mode) {
        F(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public final void setMode(Mode mode) {
        if (mode != this.fTd) {
            this.fTd = mode;
            bGZ();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.fTp = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.fTn = bVar;
        this.fTo = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.fTo = cVar;
        this.fTn = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public void setPullLabel(CharSequence charSequence, Mode mode) {
        F(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.fTi = z;
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
        F(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        setReleaseLabel(charSequence, Mode.BOTH);
    }

    public void setReleaseLabel(CharSequence charSequence, Mode mode) {
        F(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.bIL = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.fTf = z;
    }

    final void a(State state, boolean... zArr) {
        this.fTc = state;
        switch (this.fTc) {
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
                lE(zArr[0]);
                break;
        }
        if (this.fTp != null) {
            this.fTp.a(this, this.fTc, this.fTe);
        }
    }

    protected final void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void d(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected LoadingLayout a(Context context, Mode mode, TypedArray typedArray) {
        LoadingLayout createLoadingLayout = this.fTk.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b G(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.fTd.showHeaderLoadingLayout()) {
            bVar.a(this.fTl);
        }
        if (z2 && this.fTd.showFooterLoadingLayout()) {
            bVar.a(this.fTm);
        }
        return bVar;
    }

    protected final LoadingLayout getFooterLayout() {
        return this.fTm;
    }

    protected final int getFooterSize() {
        return this.fTm.getContentSize();
    }

    protected final LoadingLayout getHeaderLayout() {
        return this.fTl;
    }

    protected final int getHeaderSize() {
        return this.fTl.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.dxa;
    }

    protected void a(TypedArray typedArray) {
    }

    protected void af(Bundle bundle) {
    }

    protected void ag(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (this.fTe) {
            case PULL_FROM_END:
                this.fTm.pullToRefresh();
                return;
            case PULL_FROM_START:
                this.fTl.pullToRefresh();
                return;
            default:
                return;
        }
    }

    protected void lE(boolean z) {
        if (this.fTd.showHeaderLoadingLayout()) {
            this.fTl.refreshing();
        }
        if (this.fTd.showFooterLoadingLayout()) {
            this.fTm.refreshing();
        }
        if (z) {
            if (this.fTf) {
                d dVar = new d() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.1
                    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.d
                    public void Tl() {
                        PullToRefreshBase.this.bHa();
                    }
                };
                switch (this.fTe) {
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
            iG(0);
            return;
        }
        bHa();
    }

    protected void onReleaseToRefresh() {
        switch (this.fTe) {
            case PULL_FROM_END:
                this.fTm.releaseToRefresh();
                return;
            case PULL_FROM_START:
                this.fTl.releaseToRefresh();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.fTj = true;
        this.fTl.reset();
        this.fTm.reset();
        iG(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.fTe = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.fTg = bundle.getBoolean("ptr_disable_scrolling", false);
            this.fTf = bundle.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
            State mapIntToValue = State.mapIntToValue(bundle.getInt("ptr_state", 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                a(mapIntToValue, true);
            }
            af(bundle);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        ag(bundle);
        bundle.putInt("ptr_state", this.fTc.getIntValue());
        bundle.putInt("ptr_mode", this.fTd.getIntValue());
        bundle.putInt("ptr_current_mode", this.fTe.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.fTg);
        bundle.putBoolean("ptr_show_refreshing_view", this.fTf);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aGU();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    protected final void aGU() {
        int i;
        int i2;
        int maximumPullScroll = (int) (getMaximumPullScroll() * 1.2f);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (this.fTd.showHeaderLoadingLayout()) {
                    this.fTl.setWidth(maximumPullScroll);
                    i2 = -maximumPullScroll;
                } else {
                    i2 = 0;
                }
                if (!this.fTd.showFooterLoadingLayout()) {
                    paddingRight = 0;
                    paddingLeft = i2;
                    break;
                } else {
                    this.fTm.setWidth(maximumPullScroll);
                    paddingRight = -maximumPullScroll;
                    paddingLeft = i2;
                    break;
                }
            case VERTICAL:
                if (this.fTd.showHeaderLoadingLayout()) {
                    this.fTl.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.fTd.showFooterLoadingLayout()) {
                    paddingBottom = 0;
                    paddingTop = i;
                    break;
                } else {
                    this.fTm.setHeight(maximumPullScroll);
                    paddingBottom = -maximumPullScroll;
                    paddingTop = i;
                    break;
                }
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    protected final void refreshRefreshableViewSize(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dxa.getLayoutParams();
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.dxa.requestLayout();
                    return;
                }
                return;
            case VERTICAL:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.dxa.requestLayout();
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
        if (this.fTj) {
            if (min < 0) {
                this.fTl.setVisibility(0);
            } else if (min > 0) {
                this.fTm.setVisibility(0);
            } else {
                this.fTl.setVisibility(4);
                this.fTm.setVisibility(4);
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

    protected final void iG(int i) {
        u(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void bGZ() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.fTl.getParent()) {
            removeView(this.fTl);
        }
        if (this.fTd.showHeaderLoadingLayout()) {
            a(this.fTl, 0, loadingLayoutLayoutParams);
        }
        if (this == this.fTm.getParent()) {
            removeView(this.fTm);
        }
        if (this.fTd.showFooterLoadingLayout()) {
            d(this.fTm, loadingLayoutLayoutParams);
        }
        aGU();
        this.fTe = this.fTd != Mode.BOTH ? this.fTd : Mode.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.dxa = new FrameLayout(context);
        this.dxa.addView(t, -1, -1);
        d(this.dxa, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHa() {
        if (this.fTn != null) {
            this.fTn.c(this);
        } else if (this.fTo != null) {
            if (this.fTe == Mode.PULL_FROM_START) {
                this.fTo.d(this);
            } else if (this.fTe == Mode.PULL_FROM_END) {
                this.fTo.e(this);
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PullToRefresh);
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_tb_ptrMode)) {
            this.fTd = Mode.mapIntToValue(obtainStyledAttributes.getInteger(R.styleable.PullToRefresh_tb_ptrMode, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_tb_ptrAnimationStyle)) {
            this.fTk = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(R.styleable.PullToRefresh_tb_ptrAnimationStyle, 0));
        }
        this.dwZ = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.dwZ);
        this.fTl = a(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.fTm = a(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_tb_ptrRefreshableViewBackground)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.PullToRefresh_tb_ptrRefreshableViewBackground);
            if (drawable != null) {
                this.dwZ.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_tb_ptrAdapterViewBackground)) {
            com.baidu.tbadk.widget.pulltorefresh.library.internal.a.ef("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.PullToRefresh_tb_ptrAdapterViewBackground);
            if (drawable2 != null) {
                this.dwZ.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_tb_ptrOverScroll)) {
            this.fTi = obtainStyledAttributes.getBoolean(R.styleable.PullToRefresh_tb_ptrOverScroll, true);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_tb_ptrScrollingWhileRefreshingEnabled)) {
            this.fTg = obtainStyledAttributes.getBoolean(R.styleable.PullToRefresh_tb_ptrScrollingWhileRefreshingEnabled, false);
        }
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        bGZ();
    }

    private boolean bHb() {
        switch (this.fTd) {
            case PULL_FROM_END:
                return bGX();
            case PULL_FROM_START:
                return bGY();
            case MANUAL_REFRESH_ONLY:
            default:
                return false;
            case BOTH:
                return bGX() || bGY();
        }
    }

    private void bHc() {
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
        switch (this.fTe) {
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
            switch (this.fTe) {
                case PULL_FROM_END:
                    this.fTm.onPull(abs);
                    break;
                default:
                    this.fTl.onPull(abs);
                    break;
            }
            if (this.fTc != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.fTc == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
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

    private final void u(int i, long j) {
        a(i, j, 0L, null);
    }

    private final void a(int i, long j, long j2, d dVar) {
        int scrollX;
        if (this.fTq != null) {
            this.fTq.stop();
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
            if (this.bIL == null) {
                this.bIL = new DecelerateInterpolator();
            }
            this.fTq = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.fTq, j2);
            } else {
                post(this.fTq);
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
        private final int bIW;
        private final int bIX;
        private d fTw;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bIZ = true;
        private long mStartTime = -1;
        private int bJa = -1;

        public e(int i, int i2, long j, d dVar) {
            this.bIX = i;
            this.bIW = i2;
            this.mInterpolator = PullToRefreshBase.this.bIL;
            this.mDuration = j;
            this.fTw = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bJa = this.bIX - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bIX - this.bIW));
                PullToRefreshBase.this.setHeaderScroll(this.bJa);
            }
            if (this.bIZ && this.bIW != this.bJa) {
                com.baidu.tbadk.widget.pulltorefresh.library.internal.b.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.fTw != null) {
                this.fTw.Tl();
            }
        }

        public void stop() {
            this.bIZ = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
