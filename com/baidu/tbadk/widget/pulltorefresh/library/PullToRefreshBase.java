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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private State bdK;
    private Mode bdL;
    private Mode bdM;
    T bdN;
    private FrameLayout bdO;
    private boolean bdP;
    private boolean bdQ;
    private boolean bdR;
    private boolean bdS;
    private boolean bdT;
    private Interpolator bdU;
    private AnimationStyle bdV;
    private LoadingLayout bdW;
    private LoadingLayout bdX;
    private b<T> bdY;
    private c<T> bdZ;
    private a<T> bea;
    private PullToRefreshBase<T>.e beb;
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
        void Nt();
    }

    protected abstract boolean Nm();

    protected abstract boolean Nn();

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract Orientation getPullToRefreshScrollDirection();

    public PullToRefreshBase(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.bdK = State.RESET;
        this.bdL = Mode.getDefault();
        this.bdP = true;
        this.bdQ = false;
        this.bdR = true;
        this.bdS = true;
        this.bdT = true;
        this.bdV = AnimationStyle.getDefault();
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.bdK = State.RESET;
        this.bdL = Mode.getDefault();
        this.bdP = true;
        this.bdQ = false;
        this.bdR = true;
        this.bdS = true;
        this.bdT = true;
        this.bdV = AnimationStyle.getDefault();
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
        return this.bdM;
    }

    public final boolean getFilterTouchEvents() {
        return this.bdR;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return j(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a j(boolean z, boolean z2) {
        return k(z, z2);
    }

    public final Mode getMode() {
        return this.bdL;
    }

    public final T getRefreshableView() {
        return this.bdN;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.bdP;
    }

    public final State getState() {
        return this.bdK;
    }

    public final boolean Nl() {
        return this.bdL.permitsPullToRefresh();
    }

    public final boolean isRefreshing() {
        return this.bdK == State.REFRESHING || this.bdK == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (Nl()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (Nr()) {
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
                        if (!this.bdQ && isRefreshing()) {
                            return true;
                        }
                        if (Nr()) {
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
                            if (abs > this.mTouchSlop && (!this.bdR || abs > Math.abs(f2))) {
                                if (this.bdL.showHeaderLoadingLayout() && f >= 1.0f && Nn()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.bdL == Mode.BOTH) {
                                        this.bdM = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.bdL.showFooterLoadingLayout() && f <= -1.0f && Nm()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.bdL == Mode.BOTH) {
                                        this.bdM = Mode.PULL_FROM_END;
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
        if (Nl()) {
            if (this.bdQ || !isRefreshing()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (Nr()) {
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
                                if (this.bdK == State.RELEASE_TO_REFRESH && (this.bdY != null || this.bdZ != null)) {
                                    a(State.REFRESHING, true);
                                    return true;
                                } else if (isRefreshing()) {
                                    fM(0);
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
                                Ns();
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
        this.bdQ = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.bdR = z;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    public void setLoadingDrawable(Drawable drawable, Mode mode) {
        j(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public final void setMode(Mode mode) {
        if (mode != this.bdL) {
            this.bdL = mode;
            Np();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.bea = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.bdY = bVar;
        this.bdZ = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.bdZ = cVar;
        this.bdY = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public void setPullLabel(CharSequence charSequence, Mode mode) {
        j(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.bdS = z;
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
        j(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        setReleaseLabel(charSequence, Mode.BOTH);
    }

    public void setReleaseLabel(CharSequence charSequence, Mode mode) {
        j(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.bdU = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.bdP = z;
    }

    final void a(State state, boolean... zArr) {
        this.bdK = state;
        switch (this.bdK) {
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
                cl(zArr[0]);
                break;
        }
        if (this.bea != null) {
            this.bea.a(this, this.bdK, this.bdM);
        }
    }

    protected final void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void a(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected LoadingLayout a(Context context, Mode mode, TypedArray typedArray) {
        LoadingLayout createLoadingLayout = this.bdV.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b k(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.bdL.showHeaderLoadingLayout()) {
            bVar.a(this.bdW);
        }
        if (z2 && this.bdL.showFooterLoadingLayout()) {
            bVar.a(this.bdX);
        }
        return bVar;
    }

    protected final LoadingLayout getFooterLayout() {
        return this.bdX;
    }

    protected final int getFooterSize() {
        return this.bdX.getContentSize();
    }

    protected final LoadingLayout getHeaderLayout() {
        return this.bdW;
    }

    protected final int getHeaderSize() {
        return this.bdW.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.bdO;
    }

    protected void a(TypedArray typedArray) {
    }

    protected void g(Bundle bundle) {
    }

    protected void h(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (this.bdM) {
            case PULL_FROM_END:
                this.bdX.pullToRefresh();
                return;
            case PULL_FROM_START:
                this.bdW.pullToRefresh();
                return;
            default:
                return;
        }
    }

    protected void cl(boolean z) {
        if (this.bdL.showHeaderLoadingLayout()) {
            this.bdW.refreshing();
        }
        if (this.bdL.showFooterLoadingLayout()) {
            this.bdX.refreshing();
        }
        if (z) {
            if (this.bdP) {
                d dVar = new d() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.1
                    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.d
                    public void Nt() {
                        PullToRefreshBase.this.Nq();
                    }
                };
                switch (this.bdM) {
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
            fM(0);
            return;
        }
        Nq();
    }

    protected void onReleaseToRefresh() {
        switch (this.bdM) {
            case PULL_FROM_END:
                this.bdX.releaseToRefresh();
                return;
            case PULL_FROM_START:
                this.bdW.releaseToRefresh();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.bdT = true;
        this.bdW.reset();
        this.bdX.reset();
        fM(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.bdM = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.bdQ = bundle.getBoolean("ptr_disable_scrolling", false);
            this.bdP = bundle.getBoolean("ptr_show_refreshing_view", true);
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
        bundle.putInt("ptr_state", this.bdK.getIntValue());
        bundle.putInt("ptr_mode", this.bdL.getIntValue());
        bundle.putInt("ptr_current_mode", this.bdM.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.bdQ);
        bundle.putBoolean("ptr_show_refreshing_view", this.bdP);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        No();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    protected final void No() {
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
                if (this.bdL.showHeaderLoadingLayout()) {
                    this.bdW.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.bdL.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.bdX.setWidth(maximumPullScroll);
                    i4 = i5;
                    i3 = -maximumPullScroll;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                }
            case VERTICAL:
                if (this.bdL.showHeaderLoadingLayout()) {
                    this.bdW.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.bdL.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.bdX.setHeight(maximumPullScroll);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdO.getLayoutParams();
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.bdO.requestLayout();
                    return;
                }
                return;
            case VERTICAL:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.bdO.requestLayout();
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
        if (this.bdT) {
            if (min < 0) {
                this.bdW.setVisibility(0);
            } else if (min > 0) {
                this.bdX.setVisibility(0);
            } else {
                this.bdW.setVisibility(4);
                this.bdX.setVisibility(4);
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

    protected final void fM(int i) {
        f(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void Np() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.bdW.getParent()) {
            removeView(this.bdW);
        }
        if (this.bdL.showHeaderLoadingLayout()) {
            a(this.bdW, 0, loadingLayoutLayoutParams);
        }
        if (this == this.bdX.getParent()) {
            removeView(this.bdX);
        }
        if (this.bdL.showFooterLoadingLayout()) {
            a(this.bdX, loadingLayoutLayoutParams);
        }
        No();
        this.bdM = this.bdL != Mode.BOTH ? this.bdL : Mode.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.bdO = new FrameLayout(context);
        this.bdO.addView(t, -1, -1);
        a(this.bdO, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nq() {
        if (this.bdY != null) {
            this.bdY.c(this);
        } else if (this.bdZ != null) {
            if (this.bdM == Mode.PULL_FROM_START) {
                this.bdZ.d(this);
            } else if (this.bdM == Mode.PULL_FROM_END) {
                this.bdZ.e(this);
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.l.PullToRefresh);
        if (obtainStyledAttributes.hasValue(f.l.PullToRefresh_tb_ptrMode)) {
            this.bdL = Mode.mapIntToValue(obtainStyledAttributes.getInteger(f.l.PullToRefresh_tb_ptrMode, 0));
        }
        if (obtainStyledAttributes.hasValue(f.l.PullToRefresh_tb_ptrAnimationStyle)) {
            this.bdV = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(f.l.PullToRefresh_tb_ptrAnimationStyle, 0));
        }
        this.bdN = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.bdN);
        this.bdW = a(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.bdX = a(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(f.l.PullToRefresh_tb_ptrRefreshableViewBackground)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(f.l.PullToRefresh_tb_ptrRefreshableViewBackground);
            if (drawable != null) {
                this.bdN.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(f.l.PullToRefresh_tb_ptrAdapterViewBackground)) {
            com.baidu.tbadk.widget.pulltorefresh.library.internal.a.aw("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(f.l.PullToRefresh_tb_ptrAdapterViewBackground);
            if (drawable2 != null) {
                this.bdN.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(f.l.PullToRefresh_tb_ptrOverScroll)) {
            this.bdS = obtainStyledAttributes.getBoolean(f.l.PullToRefresh_tb_ptrOverScroll, true);
        }
        if (obtainStyledAttributes.hasValue(f.l.PullToRefresh_tb_ptrScrollingWhileRefreshingEnabled)) {
            this.bdQ = obtainStyledAttributes.getBoolean(f.l.PullToRefresh_tb_ptrScrollingWhileRefreshingEnabled, false);
        }
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        Np();
    }

    private boolean Nr() {
        switch (this.bdL) {
            case PULL_FROM_END:
                return Nm();
            case PULL_FROM_START:
                return Nn();
            case MANUAL_REFRESH_ONLY:
            default:
                return false;
            case BOTH:
                return Nm() || Nn();
        }
    }

    private void Ns() {
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
        switch (this.bdM) {
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
            switch (this.bdM) {
                case PULL_FROM_END:
                    this.bdX.onPull(abs);
                    break;
                default:
                    this.bdW.onPull(abs);
                    break;
            }
            if (this.bdK != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.bdK == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
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
        if (this.beb != null) {
            this.beb.stop();
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
            if (this.bdU == null) {
                this.bdU = new DecelerateInterpolator();
            }
            this.beb = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.beb, j2);
            } else {
                post(this.beb);
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
        private final int beh;
        private final int bei;
        private d bej;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bek = true;
        private long mStartTime = -1;
        private int bel = -1;

        public e(int i, int i2, long j, d dVar) {
            this.bei = i;
            this.beh = i2;
            this.mInterpolator = PullToRefreshBase.this.bdU;
            this.mDuration = j;
            this.bej = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bel = this.bei - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bei - this.beh));
                PullToRefreshBase.this.setHeaderScroll(this.bel);
            }
            if (this.bek && this.beh != this.bel) {
                com.baidu.tbadk.widget.pulltorefresh.library.internal.b.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.bej != null) {
                this.bej.Nt();
            }
        }

        public void stop() {
            this.bek = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
