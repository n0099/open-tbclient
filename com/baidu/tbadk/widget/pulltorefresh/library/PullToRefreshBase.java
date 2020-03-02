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
    private Interpolator aDh;
    T bMB;
    private FrameLayout bMC;
    private State dMT;
    private Mode dMU;
    private Mode dMV;
    private boolean dMW;
    private boolean dMX;
    private boolean dMY;
    private boolean dMZ;
    private boolean dNa;
    private AnimationStyle dNb;
    private LoadingLayout dNc;
    private LoadingLayout dNd;
    private b<T> dNe;
    private c<T> dNf;
    private a<T> dNg;
    private PullToRefreshBase<T>.e dNh;
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
        void AR();
    }

    protected abstract boolean aTK();

    protected abstract boolean aTL();

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract Orientation getPullToRefreshScrollDirection();

    public PullToRefreshBase(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.dMT = State.RESET;
        this.dMU = Mode.getDefault();
        this.dMW = true;
        this.dMX = false;
        this.dMY = true;
        this.dMZ = true;
        this.dNa = true;
        this.dNb = AnimationStyle.getDefault();
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.dMT = State.RESET;
        this.dMU = Mode.getDefault();
        this.dMW = true;
        this.dMX = false;
        this.dMY = true;
        this.dMZ = true;
        this.dNa = true;
        this.dNb = AnimationStyle.getDefault();
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
        return this.dMV;
    }

    public final boolean getFilterTouchEvents() {
        return this.dMY;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return y(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a y(boolean z, boolean z2) {
        return z(z, z2);
    }

    public final Mode getMode() {
        return this.dMU;
    }

    public final T getRefreshableView() {
        return this.bMB;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.dMW;
    }

    public final State getState() {
        return this.dMT;
    }

    public final boolean aTJ() {
        return this.dMU.permitsPullToRefresh();
    }

    public final boolean isRefreshing() {
        return this.dMT == State.REFRESHING || this.dMT == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (aTJ()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (aTO()) {
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
                        if (!this.dMX && isRefreshing()) {
                            return true;
                        }
                        if (aTO()) {
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
                            if (abs > this.mTouchSlop && (!this.dMY || abs > Math.abs(f2))) {
                                if (this.dMU.showHeaderLoadingLayout() && f >= 1.0f && aTL()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.dMU == Mode.BOTH) {
                                        this.dMV = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.dMU.showFooterLoadingLayout() && f <= -1.0f && aTK()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.dMU == Mode.BOTH) {
                                        this.dMV = Mode.PULL_FROM_END;
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
        if (aTJ()) {
            if (this.dMX || !isRefreshing()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (aTO()) {
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
                                if (this.dMT == State.RELEASE_TO_REFRESH && (this.dNe != null || this.dNf != null)) {
                                    a(State.REFRESHING, true);
                                    return true;
                                } else if (isRefreshing()) {
                                    fO(0);
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
                                aTP();
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
        this.dMX = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.dMY = z;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    public void setLoadingDrawable(Drawable drawable, Mode mode) {
        y(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public final void setMode(Mode mode) {
        if (mode != this.dMU) {
            this.dMU = mode;
            aTM();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.dNg = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.dNe = bVar;
        this.dNf = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.dNf = cVar;
        this.dNe = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public void setPullLabel(CharSequence charSequence, Mode mode) {
        y(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.dMZ = z;
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
        y(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        setReleaseLabel(charSequence, Mode.BOTH);
    }

    public void setReleaseLabel(CharSequence charSequence, Mode mode) {
        y(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.aDh = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.dMW = z;
    }

    final void a(State state, boolean... zArr) {
        this.dMT = state;
        switch (this.dMT) {
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
                hj(zArr[0]);
                break;
        }
        if (this.dNg != null) {
            this.dNg.a(this, this.dMT, this.dMV);
        }
    }

    protected final void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void a(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected LoadingLayout a(Context context, Mode mode, TypedArray typedArray) {
        LoadingLayout createLoadingLayout = this.dNb.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b z(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.dMU.showHeaderLoadingLayout()) {
            bVar.a(this.dNc);
        }
        if (z2 && this.dMU.showFooterLoadingLayout()) {
            bVar.a(this.dNd);
        }
        return bVar;
    }

    protected final LoadingLayout getFooterLayout() {
        return this.dNd;
    }

    protected final int getFooterSize() {
        return this.dNd.getContentSize();
    }

    protected final LoadingLayout getHeaderLayout() {
        return this.dNc;
    }

    protected final int getHeaderSize() {
        return this.dNc.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.bMC;
    }

    protected void a(TypedArray typedArray) {
    }

    protected void Z(Bundle bundle) {
    }

    protected void aa(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (this.dMV) {
            case PULL_FROM_END:
                this.dNd.pullToRefresh();
                return;
            case PULL_FROM_START:
                this.dNc.pullToRefresh();
                return;
            default:
                return;
        }
    }

    protected void hj(boolean z) {
        if (this.dMU.showHeaderLoadingLayout()) {
            this.dNc.refreshing();
        }
        if (this.dMU.showFooterLoadingLayout()) {
            this.dNd.refreshing();
        }
        if (z) {
            if (this.dMW) {
                d dVar = new d() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.1
                    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.d
                    public void AR() {
                        PullToRefreshBase.this.aTN();
                    }
                };
                switch (this.dMV) {
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
            fO(0);
            return;
        }
        aTN();
    }

    protected void onReleaseToRefresh() {
        switch (this.dMV) {
            case PULL_FROM_END:
                this.dNd.releaseToRefresh();
                return;
            case PULL_FROM_START:
                this.dNc.releaseToRefresh();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.dNa = true;
        this.dNc.reset();
        this.dNd.reset();
        fO(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.dMV = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.dMX = bundle.getBoolean("ptr_disable_scrolling", false);
            this.dMW = bundle.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
            State mapIntToValue = State.mapIntToValue(bundle.getInt("ptr_state", 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                a(mapIntToValue, true);
            }
            Z(bundle);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        aa(bundle);
        bundle.putInt("ptr_state", this.dMT.getIntValue());
        bundle.putInt("ptr_mode", this.dMU.getIntValue());
        bundle.putInt("ptr_current_mode", this.dMV.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.dMX);
        bundle.putBoolean("ptr_show_refreshing_view", this.dMW);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        abU();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    protected final void abU() {
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
                if (this.dMU.showHeaderLoadingLayout()) {
                    this.dNc.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.dMU.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.dNd.setWidth(maximumPullScroll);
                    i4 = i5;
                    i3 = -maximumPullScroll;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                }
            case VERTICAL:
                if (this.dMU.showHeaderLoadingLayout()) {
                    this.dNc.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.dMU.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.dNd.setHeight(maximumPullScroll);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bMC.getLayoutParams();
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.bMC.requestLayout();
                    return;
                }
                return;
            case VERTICAL:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.bMC.requestLayout();
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
        if (this.dNa) {
            if (min < 0) {
                this.dNc.setVisibility(0);
            } else if (min > 0) {
                this.dNd.setVisibility(0);
            } else {
                this.dNc.setVisibility(4);
                this.dNd.setVisibility(4);
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

    protected final void fO(int i) {
        t(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void aTM() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.dNc.getParent()) {
            removeView(this.dNc);
        }
        if (this.dMU.showHeaderLoadingLayout()) {
            a(this.dNc, 0, loadingLayoutLayoutParams);
        }
        if (this == this.dNd.getParent()) {
            removeView(this.dNd);
        }
        if (this.dMU.showFooterLoadingLayout()) {
            a(this.dNd, loadingLayoutLayoutParams);
        }
        abU();
        this.dMV = this.dMU != Mode.BOTH ? this.dMU : Mode.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.bMC = new FrameLayout(context);
        this.bMC.addView(t, -1, -1);
        a(this.bMC, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTN() {
        if (this.dNe != null) {
            this.dNe.c(this);
        } else if (this.dNf != null) {
            if (this.dMV == Mode.PULL_FROM_START) {
                this.dNf.d(this);
            } else if (this.dMV == Mode.PULL_FROM_END) {
                this.dNf.e(this);
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
        if (obtainStyledAttributes.hasValue(12)) {
            this.dMU = Mode.mapIntToValue(obtainStyledAttributes.getInteger(12, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.dNb = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(1, 0));
        }
        this.bMB = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.bMB);
        this.dNc = a(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.dNd = a(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(9)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(9);
            if (drawable != null) {
                this.bMB.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(3)) {
            com.baidu.tbadk.widget.pulltorefresh.library.internal.a.cI("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(3);
            if (drawable2 != null) {
                this.bMB.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.dMZ = obtainStyledAttributes.getBoolean(6, true);
        }
        if (obtainStyledAttributes.hasValue(15)) {
            this.dMX = obtainStyledAttributes.getBoolean(15, false);
        }
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        aTM();
    }

    private boolean aTO() {
        switch (this.dMU) {
            case PULL_FROM_END:
                return aTK();
            case PULL_FROM_START:
                return aTL();
            case MANUAL_REFRESH_ONLY:
            default:
                return false;
            case BOTH:
                return aTK() || aTL();
        }
    }

    private void aTP() {
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
        switch (this.dMV) {
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
            switch (this.dMV) {
                case PULL_FROM_END:
                    this.dNd.onPull(abs);
                    break;
                default:
                    this.dNc.onPull(abs);
                    break;
            }
            if (this.dMT != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.dMT == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
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

    private final void t(int i, long j) {
        a(i, j, 0L, null);
    }

    private final void a(int i, long j, long j2, d dVar) {
        int scrollX;
        if (this.dNh != null) {
            this.dNh.stop();
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
            if (this.aDh == null) {
                this.aDh = new DecelerateInterpolator();
            }
            this.dNh = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.dNh, j2);
            } else {
                post(this.dNh);
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
        private final int aDs;
        private final int aDt;
        private d dNn;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aDv = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;

        public e(int i, int i2, long j, d dVar) {
            this.aDt = i;
            this.aDs = i2;
            this.mInterpolator = PullToRefreshBase.this.aDh;
            this.mDuration = j;
            this.dNn = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.aDt - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aDt - this.aDs));
                PullToRefreshBase.this.setHeaderScroll(this.mCurrentY);
            }
            if (this.aDv && this.aDs != this.mCurrentY) {
                com.baidu.tbadk.widget.pulltorefresh.library.internal.b.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.dNn != null) {
                this.dNn.AR();
            }
        }

        public void stop() {
            this.aDv = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
