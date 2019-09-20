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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    T aMe;
    private FrameLayout aMf;
    private State cLI;
    private Mode cLJ;
    private Mode cLK;
    private boolean cLL;
    private boolean cLM;
    private boolean cLN;
    private boolean cLO;
    private boolean cLP;
    private Interpolator cLQ;
    private AnimationStyle cLR;
    private LoadingLayout cLS;
    private LoadingLayout cLT;
    private b<T> cLU;
    private c<T> cLV;
    private a<T> cLW;
    private PullToRefreshBase<T>.e cLX;
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
        void ayW();
    }

    protected abstract boolean ayQ();

    protected abstract boolean ayR();

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract Orientation getPullToRefreshScrollDirection();

    public PullToRefreshBase(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.cLI = State.RESET;
        this.cLJ = Mode.getDefault();
        this.cLL = true;
        this.cLM = false;
        this.cLN = true;
        this.cLO = true;
        this.cLP = true;
        this.cLR = AnimationStyle.getDefault();
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.cLI = State.RESET;
        this.cLJ = Mode.getDefault();
        this.cLL = true;
        this.cLM = false;
        this.cLN = true;
        this.cLO = true;
        this.cLP = true;
        this.cLR = AnimationStyle.getDefault();
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
        return this.cLK;
    }

    public final boolean getFilterTouchEvents() {
        return this.cLN;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return s(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a s(boolean z, boolean z2) {
        return t(z, z2);
    }

    public final Mode getMode() {
        return this.cLJ;
    }

    public final T getRefreshableView() {
        return this.aMe;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.cLL;
    }

    public final State getState() {
        return this.cLI;
    }

    public final boolean ayP() {
        return this.cLJ.permitsPullToRefresh();
    }

    public final boolean isRefreshing() {
        return this.cLI == State.REFRESHING || this.cLI == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (ayP()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (ayU()) {
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
                        if (!this.cLM && isRefreshing()) {
                            return true;
                        }
                        if (ayU()) {
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
                            if (abs > this.mTouchSlop && (!this.cLN || abs > Math.abs(f2))) {
                                if (this.cLJ.showHeaderLoadingLayout() && f >= 1.0f && ayR()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.cLJ == Mode.BOTH) {
                                        this.cLK = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.cLJ.showFooterLoadingLayout() && f <= -1.0f && ayQ()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.cLJ == Mode.BOTH) {
                                        this.cLK = Mode.PULL_FROM_END;
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
        if (ayP()) {
            if (this.cLM || !isRefreshing()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (ayU()) {
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
                                if (this.cLI == State.RELEASE_TO_REFRESH && (this.cLU != null || this.cLV != null)) {
                                    a(State.REFRESHING, true);
                                    return true;
                                } else if (isRefreshing()) {
                                    df(0);
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
                                ayV();
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
        this.cLM = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.cLN = z;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    public void setLoadingDrawable(Drawable drawable, Mode mode) {
        s(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public final void setMode(Mode mode) {
        if (mode != this.cLJ) {
            this.cLJ = mode;
            ayS();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.cLW = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.cLU = bVar;
        this.cLV = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.cLV = cVar;
        this.cLU = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public void setPullLabel(CharSequence charSequence, Mode mode) {
        s(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.cLO = z;
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
        s(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        setReleaseLabel(charSequence, Mode.BOTH);
    }

    public void setReleaseLabel(CharSequence charSequence, Mode mode) {
        s(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.cLQ = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.cLL = z;
    }

    final void a(State state, boolean... zArr) {
        this.cLI = state;
        switch (this.cLI) {
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
                fV(zArr[0]);
                break;
        }
        if (this.cLW != null) {
            this.cLW.a(this, this.cLI, this.cLK);
        }
    }

    protected final void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void a(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected LoadingLayout a(Context context, Mode mode, TypedArray typedArray) {
        LoadingLayout createLoadingLayout = this.cLR.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b t(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.cLJ.showHeaderLoadingLayout()) {
            bVar.a(this.cLS);
        }
        if (z2 && this.cLJ.showFooterLoadingLayout()) {
            bVar.a(this.cLT);
        }
        return bVar;
    }

    protected final LoadingLayout getFooterLayout() {
        return this.cLT;
    }

    protected final int getFooterSize() {
        return this.cLT.getContentSize();
    }

    protected final LoadingLayout getHeaderLayout() {
        return this.cLS;
    }

    protected final int getHeaderSize() {
        return this.cLS.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.aMf;
    }

    protected void a(TypedArray typedArray) {
    }

    protected void F(Bundle bundle) {
    }

    protected void G(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (this.cLK) {
            case PULL_FROM_END:
                this.cLT.pullToRefresh();
                return;
            case PULL_FROM_START:
                this.cLS.pullToRefresh();
                return;
            default:
                return;
        }
    }

    protected void fV(boolean z) {
        if (this.cLJ.showHeaderLoadingLayout()) {
            this.cLS.refreshing();
        }
        if (this.cLJ.showFooterLoadingLayout()) {
            this.cLT.refreshing();
        }
        if (z) {
            if (this.cLL) {
                d dVar = new d() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.1
                    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.d
                    public void ayW() {
                        PullToRefreshBase.this.ayT();
                    }
                };
                switch (this.cLK) {
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
            df(0);
            return;
        }
        ayT();
    }

    protected void onReleaseToRefresh() {
        switch (this.cLK) {
            case PULL_FROM_END:
                this.cLT.releaseToRefresh();
                return;
            case PULL_FROM_START:
                this.cLS.releaseToRefresh();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.cLP = true;
        this.cLS.reset();
        this.cLT.reset();
        df(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.cLK = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.cLM = bundle.getBoolean("ptr_disable_scrolling", false);
            this.cLL = bundle.getBoolean("ptr_show_refreshing_view", true);
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
        bundle.putInt("ptr_state", this.cLI.getIntValue());
        bundle.putInt("ptr_mode", this.cLJ.getIntValue());
        bundle.putInt("ptr_current_mode", this.cLK.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.cLM);
        bundle.putBoolean("ptr_show_refreshing_view", this.cLL);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Kz();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    protected final void Kz() {
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
                if (this.cLJ.showHeaderLoadingLayout()) {
                    this.cLS.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.cLJ.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.cLT.setWidth(maximumPullScroll);
                    i4 = i5;
                    i3 = -maximumPullScroll;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                }
            case VERTICAL:
                if (this.cLJ.showHeaderLoadingLayout()) {
                    this.cLS.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.cLJ.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.cLT.setHeight(maximumPullScroll);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aMf.getLayoutParams();
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.aMf.requestLayout();
                    return;
                }
                return;
            case VERTICAL:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.aMf.requestLayout();
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
        if (this.cLP) {
            if (min < 0) {
                this.cLS.setVisibility(0);
            } else if (min > 0) {
                this.cLT.setVisibility(0);
            } else {
                this.cLS.setVisibility(4);
                this.cLT.setVisibility(4);
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

    protected final void df(int i) {
        p(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void ayS() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.cLS.getParent()) {
            removeView(this.cLS);
        }
        if (this.cLJ.showHeaderLoadingLayout()) {
            a(this.cLS, 0, loadingLayoutLayoutParams);
        }
        if (this == this.cLT.getParent()) {
            removeView(this.cLT);
        }
        if (this.cLJ.showFooterLoadingLayout()) {
            a(this.cLT, loadingLayoutLayoutParams);
        }
        Kz();
        this.cLK = this.cLJ != Mode.BOTH ? this.cLJ : Mode.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.aMf = new FrameLayout(context);
        this.aMf.addView(t, -1, -1);
        a(this.aMf, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayT() {
        if (this.cLU != null) {
            this.cLU.c(this);
        } else if (this.cLV != null) {
            if (this.cLK == Mode.PULL_FROM_START) {
                this.cLV.d(this);
            } else if (this.cLK == Mode.PULL_FROM_END) {
                this.cLV.e(this);
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.PullToRefresh);
        if (obtainStyledAttributes.hasValue(12)) {
            this.cLJ = Mode.mapIntToValue(obtainStyledAttributes.getInteger(12, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.cLR = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(1, 0));
        }
        this.aMe = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.aMe);
        this.cLS = a(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.cLT = a(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(9)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(9);
            if (drawable != null) {
                this.aMe.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(3)) {
            com.baidu.tbadk.widget.pulltorefresh.library.internal.a.cj("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(3);
            if (drawable2 != null) {
                this.aMe.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.cLO = obtainStyledAttributes.getBoolean(6, true);
        }
        if (obtainStyledAttributes.hasValue(15)) {
            this.cLM = obtainStyledAttributes.getBoolean(15, false);
        }
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        ayS();
    }

    private boolean ayU() {
        switch (this.cLJ) {
            case PULL_FROM_END:
                return ayQ();
            case PULL_FROM_START:
                return ayR();
            case MANUAL_REFRESH_ONLY:
            default:
                return false;
            case BOTH:
                return ayQ() || ayR();
        }
    }

    private void ayV() {
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
        switch (this.cLK) {
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
            switch (this.cLK) {
                case PULL_FROM_END:
                    this.cLT.onPull(abs);
                    break;
                default:
                    this.cLS.onPull(abs);
                    break;
            }
            if (this.cLI != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.cLI == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
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
        if (this.cLX != null) {
            this.cLX.stop();
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
            if (this.cLQ == null) {
                this.cLQ = new DecelerateInterpolator();
            }
            this.cLX = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.cLX, j2);
            } else {
                post(this.cLX);
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
        private final int aMw;
        private final int aMx;
        private d cMd;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aMy = true;
        private long mStartTime = -1;
        private int aMz = -1;

        public e(int i, int i2, long j, d dVar) {
            this.aMx = i;
            this.aMw = i2;
            this.mInterpolator = PullToRefreshBase.this.cLQ;
            this.mDuration = j;
            this.cMd = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aMz = this.aMx - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aMx - this.aMw));
                PullToRefreshBase.this.setHeaderScroll(this.aMz);
            }
            if (this.aMy && this.aMw != this.aMz) {
                com.baidu.tbadk.widget.pulltorefresh.library.internal.b.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.cMd != null) {
                this.cMd.ayW();
            }
        }

        public void stop() {
            this.aMy = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
