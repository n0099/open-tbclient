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
    private Interpolator bjO;
    T cBR;
    private FrameLayout cBS;
    private AnimationStyle eMA;
    private LoadingLayout eMB;
    private LoadingLayout eMC;
    private b<T> eMD;
    private c<T> eME;
    private a<T> eMF;
    private PullToRefreshBase<T>.e eMG;
    private State eMs;
    private Mode eMt;
    private Mode eMu;
    private boolean eMv;
    private boolean eMw;
    private boolean eMx;
    private boolean eMy;
    private boolean eMz;
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
        void Jb();
    }

    protected abstract boolean bkG();

    protected abstract boolean bkH();

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract Orientation getPullToRefreshScrollDirection();

    public PullToRefreshBase(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.eMs = State.RESET;
        this.eMt = Mode.getDefault();
        this.eMv = true;
        this.eMw = false;
        this.eMx = true;
        this.eMy = true;
        this.eMz = true;
        this.eMA = AnimationStyle.getDefault();
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.eMs = State.RESET;
        this.eMt = Mode.getDefault();
        this.eMv = true;
        this.eMw = false;
        this.eMx = true;
        this.eMy = true;
        this.eMz = true;
        this.eMA = AnimationStyle.getDefault();
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
        return this.eMu;
    }

    public final boolean getFilterTouchEvents() {
        return this.eMx;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return B(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a B(boolean z, boolean z2) {
        return C(z, z2);
    }

    public final Mode getMode() {
        return this.eMt;
    }

    public final T getRefreshableView() {
        return this.cBR;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.eMv;
    }

    public final State getState() {
        return this.eMs;
    }

    public final boolean bkF() {
        return this.eMt.permitsPullToRefresh();
    }

    public final boolean isRefreshing() {
        return this.eMs == State.REFRESHING || this.eMs == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (bkF()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (bkK()) {
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
                        if (!this.eMw && isRefreshing()) {
                            return true;
                        }
                        if (bkK()) {
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
                            if (abs > this.mTouchSlop && (!this.eMx || abs > Math.abs(f2))) {
                                if (this.eMt.showHeaderLoadingLayout() && f >= 1.0f && bkH()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.eMt == Mode.BOTH) {
                                        this.eMu = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.eMt.showFooterLoadingLayout() && f <= -1.0f && bkG()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.eMt == Mode.BOTH) {
                                        this.eMu = Mode.PULL_FROM_END;
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
        if (bkF()) {
            if (this.eMw || !isRefreshing()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (bkK()) {
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
                                if (this.eMs == State.RELEASE_TO_REFRESH && (this.eMD != null || this.eME != null)) {
                                    a(State.REFRESHING, true);
                                    return true;
                                } else if (isRefreshing()) {
                                    gA(0);
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
                                bkL();
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
        this.eMw = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.eMx = z;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    public void setLoadingDrawable(Drawable drawable, Mode mode) {
        B(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public final void setMode(Mode mode) {
        if (mode != this.eMt) {
            this.eMt = mode;
            bkI();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.eMF = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.eMD = bVar;
        this.eME = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.eME = cVar;
        this.eMD = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public void setPullLabel(CharSequence charSequence, Mode mode) {
        B(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.eMy = z;
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
        B(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        setReleaseLabel(charSequence, Mode.BOTH);
    }

    public void setReleaseLabel(CharSequence charSequence, Mode mode) {
        B(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.bjO = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.eMv = z;
    }

    final void a(State state, boolean... zArr) {
        this.eMs = state;
        switch (this.eMs) {
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
                iR(zArr[0]);
                break;
        }
        if (this.eMF != null) {
            this.eMF.a(this, this.eMs, this.eMu);
        }
    }

    protected final void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void a(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected LoadingLayout a(Context context, Mode mode, TypedArray typedArray) {
        LoadingLayout createLoadingLayout = this.eMA.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b C(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.eMt.showHeaderLoadingLayout()) {
            bVar.a(this.eMB);
        }
        if (z2 && this.eMt.showFooterLoadingLayout()) {
            bVar.a(this.eMC);
        }
        return bVar;
    }

    protected final LoadingLayout getFooterLayout() {
        return this.eMC;
    }

    protected final int getFooterSize() {
        return this.eMC.getContentSize();
    }

    protected final LoadingLayout getHeaderLayout() {
        return this.eMB;
    }

    protected final int getHeaderSize() {
        return this.eMB.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.cBS;
    }

    protected void a(TypedArray typedArray) {
    }

    protected void af(Bundle bundle) {
    }

    protected void ag(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (this.eMu) {
            case PULL_FROM_END:
                this.eMC.pullToRefresh();
                return;
            case PULL_FROM_START:
                this.eMB.pullToRefresh();
                return;
            default:
                return;
        }
    }

    protected void iR(boolean z) {
        if (this.eMt.showHeaderLoadingLayout()) {
            this.eMB.refreshing();
        }
        if (this.eMt.showFooterLoadingLayout()) {
            this.eMC.refreshing();
        }
        if (z) {
            if (this.eMv) {
                d dVar = new d() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.1
                    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.d
                    public void Jb() {
                        PullToRefreshBase.this.bkJ();
                    }
                };
                switch (this.eMu) {
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
            gA(0);
            return;
        }
        bkJ();
    }

    protected void onReleaseToRefresh() {
        switch (this.eMu) {
            case PULL_FROM_END:
                this.eMC.releaseToRefresh();
                return;
            case PULL_FROM_START:
                this.eMB.releaseToRefresh();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.eMz = true;
        this.eMB.reset();
        this.eMC.reset();
        gA(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.eMu = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.eMw = bundle.getBoolean("ptr_disable_scrolling", false);
            this.eMv = bundle.getBoolean("ptr_show_refreshing_view", true);
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
        bundle.putInt("ptr_state", this.eMs.getIntValue());
        bundle.putInt("ptr_mode", this.eMt.getIntValue());
        bundle.putInt("ptr_current_mode", this.eMu.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.eMw);
        bundle.putBoolean("ptr_show_refreshing_view", this.eMv);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aoV();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    protected final void aoV() {
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
                if (this.eMt.showHeaderLoadingLayout()) {
                    this.eMB.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.eMt.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.eMC.setWidth(maximumPullScroll);
                    i4 = i5;
                    i3 = -maximumPullScroll;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                }
            case VERTICAL:
                if (this.eMt.showHeaderLoadingLayout()) {
                    this.eMB.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.eMt.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.eMC.setHeight(maximumPullScroll);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cBS.getLayoutParams();
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.cBS.requestLayout();
                    return;
                }
                return;
            case VERTICAL:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.cBS.requestLayout();
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
        if (this.eMz) {
            if (min < 0) {
                this.eMB.setVisibility(0);
            } else if (min > 0) {
                this.eMC.setVisibility(0);
            } else {
                this.eMB.setVisibility(4);
                this.eMC.setVisibility(4);
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

    protected final void gA(int i) {
        u(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void bkI() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.eMB.getParent()) {
            removeView(this.eMB);
        }
        if (this.eMt.showHeaderLoadingLayout()) {
            a(this.eMB, 0, loadingLayoutLayoutParams);
        }
        if (this == this.eMC.getParent()) {
            removeView(this.eMC);
        }
        if (this.eMt.showFooterLoadingLayout()) {
            a(this.eMC, loadingLayoutLayoutParams);
        }
        aoV();
        this.eMu = this.eMt != Mode.BOTH ? this.eMt : Mode.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.cBS = new FrameLayout(context);
        this.cBS.addView(t, -1, -1);
        a(this.cBS, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkJ() {
        if (this.eMD != null) {
            this.eMD.c(this);
        } else if (this.eME != null) {
            if (this.eMu == Mode.PULL_FROM_START) {
                this.eME.d(this);
            } else if (this.eMu == Mode.PULL_FROM_END) {
                this.eME.e(this);
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
            this.eMt = Mode.mapIntToValue(obtainStyledAttributes.getInteger(12, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.eMA = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(1, 0));
        }
        this.cBR = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.cBR);
        this.eMB = a(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.eMC = a(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(9)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(9);
            if (drawable != null) {
                this.cBR.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(3)) {
            com.baidu.tbadk.widget.pulltorefresh.library.internal.a.du("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(3);
            if (drawable2 != null) {
                this.cBR.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.eMy = obtainStyledAttributes.getBoolean(6, true);
        }
        if (obtainStyledAttributes.hasValue(15)) {
            this.eMw = obtainStyledAttributes.getBoolean(15, false);
        }
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        bkI();
    }

    private boolean bkK() {
        switch (this.eMt) {
            case PULL_FROM_END:
                return bkG();
            case PULL_FROM_START:
                return bkH();
            case MANUAL_REFRESH_ONLY:
            default:
                return false;
            case BOTH:
                return bkG() || bkH();
        }
    }

    private void bkL() {
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
        switch (this.eMu) {
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
            switch (this.eMu) {
                case PULL_FROM_END:
                    this.eMC.onPull(abs);
                    break;
                default:
                    this.eMB.onPull(abs);
                    break;
            }
            if (this.eMs != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.eMs == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
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
        if (this.eMG != null) {
            this.eMG.stop();
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
            if (this.bjO == null) {
                this.bjO = new DecelerateInterpolator();
            }
            this.eMG = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.eMG, j2);
            } else {
                post(this.eMG);
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
        private final int bjZ;
        private final int bka;
        private d eMM;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bkc = true;
        private long mStartTime = -1;
        private int bkd = -1;

        public e(int i, int i2, long j, d dVar) {
            this.bka = i;
            this.bjZ = i2;
            this.mInterpolator = PullToRefreshBase.this.bjO;
            this.mDuration = j;
            this.eMM = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bkd = this.bka - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bka - this.bjZ));
                PullToRefreshBase.this.setHeaderScroll(this.bkd);
            }
            if (this.bkc && this.bjZ != this.bkd) {
                com.baidu.tbadk.widget.pulltorefresh.library.internal.b.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.eMM != null) {
                this.eMM.Jb();
            }
        }

        public void stop() {
            this.bkc = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
