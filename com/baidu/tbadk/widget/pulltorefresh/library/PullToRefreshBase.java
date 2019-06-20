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
import com.baidu.tieba.c;
/* loaded from: classes.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    T aKY;
    private FrameLayout aKZ;
    private AnimationStyle cJA;
    private LoadingLayout cJB;
    private LoadingLayout cJC;
    private b<T> cJD;
    private c<T> cJE;
    private a<T> cJF;
    private PullToRefreshBase<T>.e cJG;
    private State cJr;
    private Mode cJs;
    private Mode cJt;
    private boolean cJu;
    private boolean cJv;
    private boolean cJw;
    private boolean cJx;
    private boolean cJy;
    private Interpolator cJz;
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
        void axw();
    }

    protected abstract boolean axq();

    protected abstract boolean axr();

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract Orientation getPullToRefreshScrollDirection();

    public PullToRefreshBase(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.cJr = State.RESET;
        this.cJs = Mode.getDefault();
        this.cJu = true;
        this.cJv = false;
        this.cJw = true;
        this.cJx = true;
        this.cJy = true;
        this.cJA = AnimationStyle.getDefault();
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.cJr = State.RESET;
        this.cJs = Mode.getDefault();
        this.cJu = true;
        this.cJv = false;
        this.cJw = true;
        this.cJx = true;
        this.cJy = true;
        this.cJA = AnimationStyle.getDefault();
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
        return this.cJt;
    }

    public final boolean getFilterTouchEvents() {
        return this.cJw;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return q(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a q(boolean z, boolean z2) {
        return r(z, z2);
    }

    public final Mode getMode() {
        return this.cJs;
    }

    public final T getRefreshableView() {
        return this.aKY;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.cJu;
    }

    public final State getState() {
        return this.cJr;
    }

    public final boolean axp() {
        return this.cJs.permitsPullToRefresh();
    }

    public final boolean isRefreshing() {
        return this.cJr == State.REFRESHING || this.cJr == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (axp()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (axu()) {
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
                        if (!this.cJv && isRefreshing()) {
                            return true;
                        }
                        if (axu()) {
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
                            if (abs > this.mTouchSlop && (!this.cJw || abs > Math.abs(f2))) {
                                if (this.cJs.showHeaderLoadingLayout() && f >= 1.0f && axr()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.cJs == Mode.BOTH) {
                                        this.cJt = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.cJs.showFooterLoadingLayout() && f <= -1.0f && axq()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.cJs == Mode.BOTH) {
                                        this.cJt = Mode.PULL_FROM_END;
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
        if (axp()) {
            if (this.cJv || !isRefreshing()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (axu()) {
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
                                if (this.cJr == State.RELEASE_TO_REFRESH && (this.cJD != null || this.cJE != null)) {
                                    a(State.REFRESHING, true);
                                    return true;
                                } else if (isRefreshing()) {
                                    db(0);
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
                                axv();
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
        this.cJv = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.cJw = z;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    public void setLoadingDrawable(Drawable drawable, Mode mode) {
        q(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public final void setMode(Mode mode) {
        if (mode != this.cJs) {
            this.cJs = mode;
            axs();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.cJF = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.cJD = bVar;
        this.cJE = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.cJE = cVar;
        this.cJD = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public void setPullLabel(CharSequence charSequence, Mode mode) {
        q(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.cJx = z;
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
        q(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        setReleaseLabel(charSequence, Mode.BOTH);
    }

    public void setReleaseLabel(CharSequence charSequence, Mode mode) {
        q(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.cJz = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.cJu = z;
    }

    final void a(State state, boolean... zArr) {
        this.cJr = state;
        switch (this.cJr) {
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
                fO(zArr[0]);
                break;
        }
        if (this.cJF != null) {
            this.cJF.a(this, this.cJr, this.cJt);
        }
    }

    protected final void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void a(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected LoadingLayout a(Context context, Mode mode, TypedArray typedArray) {
        LoadingLayout createLoadingLayout = this.cJA.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b r(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.cJs.showHeaderLoadingLayout()) {
            bVar.a(this.cJB);
        }
        if (z2 && this.cJs.showFooterLoadingLayout()) {
            bVar.a(this.cJC);
        }
        return bVar;
    }

    protected final LoadingLayout getFooterLayout() {
        return this.cJC;
    }

    protected final int getFooterSize() {
        return this.cJC.getContentSize();
    }

    protected final LoadingLayout getHeaderLayout() {
        return this.cJB;
    }

    protected final int getHeaderSize() {
        return this.cJB.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.aKZ;
    }

    protected void a(TypedArray typedArray) {
    }

    protected void F(Bundle bundle) {
    }

    protected void G(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (this.cJt) {
            case PULL_FROM_END:
                this.cJC.pullToRefresh();
                return;
            case PULL_FROM_START:
                this.cJB.pullToRefresh();
                return;
            default:
                return;
        }
    }

    protected void fO(boolean z) {
        if (this.cJs.showHeaderLoadingLayout()) {
            this.cJB.refreshing();
        }
        if (this.cJs.showFooterLoadingLayout()) {
            this.cJC.refreshing();
        }
        if (z) {
            if (this.cJu) {
                d dVar = new d() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.1
                    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.d
                    public void axw() {
                        PullToRefreshBase.this.axt();
                    }
                };
                switch (this.cJt) {
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
            db(0);
            return;
        }
        axt();
    }

    protected void onReleaseToRefresh() {
        switch (this.cJt) {
            case PULL_FROM_END:
                this.cJC.releaseToRefresh();
                return;
            case PULL_FROM_START:
                this.cJB.releaseToRefresh();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.cJy = true;
        this.cJB.reset();
        this.cJC.reset();
        db(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.cJt = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.cJv = bundle.getBoolean("ptr_disable_scrolling", false);
            this.cJu = bundle.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
            State mapIntToValue = State.mapIntToValue(bundle.getInt("ptr_state", 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                a(mapIntToValue, true);
            }
            F(bundle);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        G(bundle);
        bundle.putInt("ptr_state", this.cJr.getIntValue());
        bundle.putInt("ptr_mode", this.cJs.getIntValue());
        bundle.putInt("ptr_current_mode", this.cJt.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.cJv);
        bundle.putBoolean("ptr_show_refreshing_view", this.cJu);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        JI();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    protected final void JI() {
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
                if (this.cJs.showHeaderLoadingLayout()) {
                    this.cJB.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.cJs.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.cJC.setWidth(maximumPullScroll);
                    i4 = i5;
                    i3 = -maximumPullScroll;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                }
            case VERTICAL:
                if (this.cJs.showHeaderLoadingLayout()) {
                    this.cJB.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.cJs.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.cJC.setHeight(maximumPullScroll);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aKZ.getLayoutParams();
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.aKZ.requestLayout();
                    return;
                }
                return;
            case VERTICAL:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.aKZ.requestLayout();
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
        if (this.cJy) {
            if (min < 0) {
                this.cJB.setVisibility(0);
            } else if (min > 0) {
                this.cJC.setVisibility(0);
            } else {
                this.cJB.setVisibility(4);
                this.cJC.setVisibility(4);
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

    protected final void db(int i) {
        p(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void axs() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.cJB.getParent()) {
            removeView(this.cJB);
        }
        if (this.cJs.showHeaderLoadingLayout()) {
            a(this.cJB, 0, loadingLayoutLayoutParams);
        }
        if (this == this.cJC.getParent()) {
            removeView(this.cJC);
        }
        if (this.cJs.showFooterLoadingLayout()) {
            a(this.cJC, loadingLayoutLayoutParams);
        }
        JI();
        this.cJt = this.cJs != Mode.BOTH ? this.cJs : Mode.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.aKZ = new FrameLayout(context);
        this.aKZ.addView(t, -1, -1);
        a(this.aKZ, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axt() {
        if (this.cJD != null) {
            this.cJD.c(this);
        } else if (this.cJE != null) {
            if (this.cJt == Mode.PULL_FROM_START) {
                this.cJE.d(this);
            } else if (this.cJt == Mode.PULL_FROM_END) {
                this.cJE.e(this);
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.PullToRefresh);
        if (obtainStyledAttributes.hasValue(12)) {
            this.cJs = Mode.mapIntToValue(obtainStyledAttributes.getInteger(12, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.cJA = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(1, 0));
        }
        this.aKY = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.aKY);
        this.cJB = a(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.cJC = a(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(9)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(9);
            if (drawable != null) {
                this.aKY.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(3)) {
            com.baidu.tbadk.widget.pulltorefresh.library.internal.a.ci("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(3);
            if (drawable2 != null) {
                this.aKY.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.cJx = obtainStyledAttributes.getBoolean(6, true);
        }
        if (obtainStyledAttributes.hasValue(15)) {
            this.cJv = obtainStyledAttributes.getBoolean(15, false);
        }
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        axs();
    }

    private boolean axu() {
        switch (this.cJs) {
            case PULL_FROM_END:
                return axq();
            case PULL_FROM_START:
                return axr();
            case MANUAL_REFRESH_ONLY:
            default:
                return false;
            case BOTH:
                return axq() || axr();
        }
    }

    private void axv() {
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
        switch (this.cJt) {
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
            switch (this.cJt) {
                case PULL_FROM_END:
                    this.cJC.onPull(abs);
                    break;
                default:
                    this.cJB.onPull(abs);
                    break;
            }
            if (this.cJr != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.cJr == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
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

    private final void p(int i, long j) {
        a(i, j, 0L, null);
    }

    private final void a(int i, long j, long j2, d dVar) {
        int scrollX;
        if (this.cJG != null) {
            this.cJG.stop();
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
            if (this.cJz == null) {
                this.cJz = new DecelerateInterpolator();
            }
            this.cJG = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.cJG, j2);
            } else {
                post(this.cJG);
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
        private final int aLq;
        private final int aLr;
        private d cJM;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aLs = true;
        private long mStartTime = -1;
        private int aLt = -1;

        public e(int i, int i2, long j, d dVar) {
            this.aLr = i;
            this.aLq = i2;
            this.mInterpolator = PullToRefreshBase.this.cJz;
            this.mDuration = j;
            this.cJM = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aLt = this.aLr - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aLr - this.aLq));
                PullToRefreshBase.this.setHeaderScroll(this.aLt);
            }
            if (this.aLs && this.aLq != this.aLt) {
                com.baidu.tbadk.widget.pulltorefresh.library.internal.b.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.cJM != null) {
                this.cJM.axw();
            }
        }

        public void stop() {
            this.aLs = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
