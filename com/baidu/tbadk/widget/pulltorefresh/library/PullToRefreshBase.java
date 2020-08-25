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
/* loaded from: classes2.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private Interpolator bpN;
    T cNC;
    private FrameLayout cND;
    private boolean fdA;
    private boolean fdB;
    private AnimationStyle fdC;
    private LoadingLayout fdD;
    private LoadingLayout fdE;
    private b<T> fdF;
    private c<T> fdG;
    private a<T> fdH;
    private PullToRefreshBase<T>.e fdI;
    private State fdu;
    private Mode fdv;
    private Mode fdw;
    private boolean fdx;
    private boolean fdy;
    private boolean fdz;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mTouchSlop;

    /* loaded from: classes2.dex */
    public enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    /* loaded from: classes2.dex */
    public interface a<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase, State state, Mode mode);
    }

    /* loaded from: classes2.dex */
    public interface b<V extends View> {
        void c(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* loaded from: classes2.dex */
    public interface c<V extends View> {
        void d(PullToRefreshBase<V> pullToRefreshBase);

        void e(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface d {
        void OZ();
    }

    protected abstract boolean bxo();

    protected abstract boolean bxp();

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract Orientation getPullToRefreshScrollDirection();

    public PullToRefreshBase(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.fdu = State.RESET;
        this.fdv = Mode.getDefault();
        this.fdx = true;
        this.fdy = false;
        this.fdz = true;
        this.fdA = true;
        this.fdB = true;
        this.fdC = AnimationStyle.getDefault();
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.fdu = State.RESET;
        this.fdv = Mode.getDefault();
        this.fdx = true;
        this.fdy = false;
        this.fdz = true;
        this.fdA = true;
        this.fdB = true;
        this.fdC = AnimationStyle.getDefault();
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
        return this.fdw;
    }

    public final boolean getFilterTouchEvents() {
        return this.fdz;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return F(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a F(boolean z, boolean z2) {
        return G(z, z2);
    }

    public final Mode getMode() {
        return this.fdv;
    }

    public final T getRefreshableView() {
        return this.cNC;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.fdx;
    }

    public final State getState() {
        return this.fdu;
    }

    public final boolean bxn() {
        return this.fdv.permitsPullToRefresh();
    }

    public final boolean isRefreshing() {
        return this.fdu == State.REFRESHING || this.fdu == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (bxn()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (bxs()) {
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
                        if (!this.fdy && isRefreshing()) {
                            return true;
                        }
                        if (bxs()) {
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
                            if (abs > this.mTouchSlop && (!this.fdz || abs > Math.abs(f2))) {
                                if (this.fdv.showHeaderLoadingLayout() && f >= 1.0f && bxp()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.fdv == Mode.BOTH) {
                                        this.fdw = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.fdv.showFooterLoadingLayout() && f <= -1.0f && bxo()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.fdv == Mode.BOTH) {
                                        this.fdw = Mode.PULL_FROM_END;
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
        if (bxn()) {
            if (this.fdy || !isRefreshing()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (bxs()) {
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
                                if (this.fdu == State.RELEASE_TO_REFRESH && (this.fdF != null || this.fdG != null)) {
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
                                bxt();
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
        this.fdy = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.fdz = z;
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
        if (mode != this.fdv) {
            this.fdv = mode;
            bxq();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.fdH = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.fdF = bVar;
        this.fdG = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.fdG = cVar;
        this.fdF = null;
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
        this.fdA = z;
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
        this.bpN = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.fdx = z;
    }

    final void a(State state, boolean... zArr) {
        this.fdu = state;
        switch (this.fdu) {
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
                jU(zArr[0]);
                break;
        }
        if (this.fdH != null) {
            this.fdH.a(this, this.fdu, this.fdw);
        }
    }

    protected final void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void b(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected LoadingLayout a(Context context, Mode mode, TypedArray typedArray) {
        LoadingLayout createLoadingLayout = this.fdC.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b G(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.fdv.showHeaderLoadingLayout()) {
            bVar.a(this.fdD);
        }
        if (z2 && this.fdv.showFooterLoadingLayout()) {
            bVar.a(this.fdE);
        }
        return bVar;
    }

    protected final LoadingLayout getFooterLayout() {
        return this.fdE;
    }

    protected final int getFooterSize() {
        return this.fdE.getContentSize();
    }

    protected final LoadingLayout getHeaderLayout() {
        return this.fdD;
    }

    protected final int getHeaderSize() {
        return this.fdD.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.cND;
    }

    protected void a(TypedArray typedArray) {
    }

    protected void af(Bundle bundle) {
    }

    protected void ag(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (this.fdw) {
            case PULL_FROM_END:
                this.fdE.pullToRefresh();
                return;
            case PULL_FROM_START:
                this.fdD.pullToRefresh();
                return;
            default:
                return;
        }
    }

    protected void jU(boolean z) {
        if (this.fdv.showHeaderLoadingLayout()) {
            this.fdD.refreshing();
        }
        if (this.fdv.showFooterLoadingLayout()) {
            this.fdE.refreshing();
        }
        if (z) {
            if (this.fdx) {
                d dVar = new d() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.1
                    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.d
                    public void OZ() {
                        PullToRefreshBase.this.bxr();
                    }
                };
                switch (this.fdw) {
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
        bxr();
    }

    protected void onReleaseToRefresh() {
        switch (this.fdw) {
            case PULL_FROM_END:
                this.fdE.releaseToRefresh();
                return;
            case PULL_FROM_START:
                this.fdD.releaseToRefresh();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.fdB = true;
        this.fdD.reset();
        this.fdE.reset();
        iQ(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.fdw = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.fdy = bundle.getBoolean("ptr_disable_scrolling", false);
            this.fdx = bundle.getBoolean("ptr_show_refreshing_view", true);
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
        bundle.putInt("ptr_state", this.fdu.getIntValue());
        bundle.putInt("ptr_mode", this.fdv.getIntValue());
        bundle.putInt("ptr_current_mode", this.fdw.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.fdy);
        bundle.putBoolean("ptr_show_refreshing_view", this.fdx);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ayR();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    protected final void ayR() {
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
                if (this.fdv.showHeaderLoadingLayout()) {
                    this.fdD.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.fdv.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.fdE.setWidth(maximumPullScroll);
                    i4 = i5;
                    i3 = -maximumPullScroll;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                }
            case VERTICAL:
                if (this.fdv.showHeaderLoadingLayout()) {
                    this.fdD.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.fdv.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.fdE.setHeight(maximumPullScroll);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cND.getLayoutParams();
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.cND.requestLayout();
                    return;
                }
                return;
            case VERTICAL:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.cND.requestLayout();
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
        if (this.fdB) {
            if (min < 0) {
                this.fdD.setVisibility(0);
            } else if (min > 0) {
                this.fdE.setVisibility(0);
            } else {
                this.fdD.setVisibility(4);
                this.fdE.setVisibility(4);
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
        u(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void bxq() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.fdD.getParent()) {
            removeView(this.fdD);
        }
        if (this.fdv.showHeaderLoadingLayout()) {
            a(this.fdD, 0, loadingLayoutLayoutParams);
        }
        if (this == this.fdE.getParent()) {
            removeView(this.fdE);
        }
        if (this.fdv.showFooterLoadingLayout()) {
            b(this.fdE, loadingLayoutLayoutParams);
        }
        ayR();
        this.fdw = this.fdv != Mode.BOTH ? this.fdv : Mode.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.cND = new FrameLayout(context);
        this.cND.addView(t, -1, -1);
        b(this.cND, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxr() {
        if (this.fdF != null) {
            this.fdF.c(this);
        } else if (this.fdG != null) {
            if (this.fdw == Mode.PULL_FROM_START) {
                this.fdG.d(this);
            } else if (this.fdw == Mode.PULL_FROM_END) {
                this.fdG.e(this);
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
            this.fdv = Mode.mapIntToValue(obtainStyledAttributes.getInteger(R.styleable.PullToRefresh_tb_ptrMode, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_tb_ptrAnimationStyle)) {
            this.fdC = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(R.styleable.PullToRefresh_tb_ptrAnimationStyle, 0));
        }
        this.cNC = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.cNC);
        this.fdD = a(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.fdE = a(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_tb_ptrRefreshableViewBackground)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.PullToRefresh_tb_ptrRefreshableViewBackground);
            if (drawable != null) {
                this.cNC.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_tb_ptrAdapterViewBackground)) {
            com.baidu.tbadk.widget.pulltorefresh.library.internal.a.dL("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.PullToRefresh_tb_ptrAdapterViewBackground);
            if (drawable2 != null) {
                this.cNC.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_tb_ptrOverScroll)) {
            this.fdA = obtainStyledAttributes.getBoolean(R.styleable.PullToRefresh_tb_ptrOverScroll, true);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_tb_ptrScrollingWhileRefreshingEnabled)) {
            this.fdy = obtainStyledAttributes.getBoolean(R.styleable.PullToRefresh_tb_ptrScrollingWhileRefreshingEnabled, false);
        }
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        bxq();
    }

    private boolean bxs() {
        switch (this.fdv) {
            case PULL_FROM_END:
                return bxo();
            case PULL_FROM_START:
                return bxp();
            case MANUAL_REFRESH_ONLY:
            default:
                return false;
            case BOTH:
                return bxo() || bxp();
        }
    }

    private void bxt() {
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
        switch (this.fdw) {
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
            switch (this.fdw) {
                case PULL_FROM_END:
                    this.fdE.onPull(abs);
                    break;
                default:
                    this.fdD.onPull(abs);
                    break;
            }
            if (this.fdu != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.fdu == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
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
        if (this.fdI != null) {
            this.fdI.stop();
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
            if (this.bpN == null) {
                this.bpN = new DecelerateInterpolator();
            }
            this.fdI = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.fdI, j2);
            } else {
                post(this.fdI);
            }
        }
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
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
    /* loaded from: classes2.dex */
    public final class e implements Runnable {
        private final int bpY;
        private final int bpZ;
        private d fdO;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bqb = true;
        private long mStartTime = -1;
        private int bqc = -1;

        public e(int i, int i2, long j, d dVar) {
            this.bpZ = i;
            this.bpY = i2;
            this.mInterpolator = PullToRefreshBase.this.bpN;
            this.mDuration = j;
            this.fdO = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bqc = this.bpZ - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bpZ - this.bpY));
                PullToRefreshBase.this.setHeaderScroll(this.bqc);
            }
            if (this.bqb && this.bpY != this.bqc) {
                com.baidu.tbadk.widget.pulltorefresh.library.internal.b.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.fdO != null) {
                this.fdO.OZ();
            }
        }

        public void stop() {
            this.bqb = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
