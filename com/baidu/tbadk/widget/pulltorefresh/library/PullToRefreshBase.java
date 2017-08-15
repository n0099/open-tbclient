package com.baidu.tbadk.widget.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private State aPB;
    private Mode aPC;
    private Mode aPD;
    T aPE;
    private FrameLayout aPF;
    private boolean aPG;
    private boolean aPH;
    private boolean aPI;
    private boolean aPJ;
    private boolean aPK;
    private Interpolator aPL;
    private AnimationStyle aPM;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b aPN;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b aPO;
    private b<T> aPP;
    private c<T> aPQ;
    private a<T> aPR;
    private PullToRefreshBase<T>.e aPS;
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
        void If();
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract Orientation getPullToRefreshScrollDirection();

    protected abstract boolean isReadyForPullEnd();

    protected abstract boolean isReadyForPullStart();

    public PullToRefreshBase(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.aPB = State.RESET;
        this.aPC = Mode.getDefault();
        this.aPG = true;
        this.aPH = false;
        this.aPI = true;
        this.aPJ = true;
        this.aPK = true;
        this.aPM = AnimationStyle.getDefault();
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.aPB = State.RESET;
        this.aPC = Mode.getDefault();
        this.aPG = true;
        this.aPH = false;
        this.aPI = true;
        this.aPJ = true;
        this.aPK = true;
        this.aPM = AnimationStyle.getDefault();
        init(context, attributeSet);
    }

    public PullToRefreshBase(Context context, Mode mode) {
        super(context);
        this.mIsBeingDragged = false;
        this.aPB = State.RESET;
        this.aPC = Mode.getDefault();
        this.aPG = true;
        this.aPH = false;
        this.aPI = true;
        this.aPJ = true;
        this.aPK = true;
        this.aPM = AnimationStyle.getDefault();
        this.aPC = mode;
        init(context, null);
    }

    public PullToRefreshBase(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context);
        this.mIsBeingDragged = false;
        this.aPB = State.RESET;
        this.aPC = Mode.getDefault();
        this.aPG = true;
        this.aPH = false;
        this.aPI = true;
        this.aPJ = true;
        this.aPK = true;
        this.aPM = AnimationStyle.getDefault();
        this.aPC = mode;
        this.aPM = animationStyle;
        init(context, null);
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
        return this.aPD;
    }

    public final boolean getFilterTouchEvents() {
        return this.aPI;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return i(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a i(boolean z, boolean z2) {
        return j(z, z2);
    }

    public final Mode getMode() {
        return this.aPC;
    }

    public final T getRefreshableView() {
        return this.aPE;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.aPG;
    }

    public final State getState() {
        return this.aPB;
    }

    public final boolean isPullToRefreshEnabled() {
        return this.aPC.permitsPullToRefresh();
    }

    public final boolean isPullToRefreshOverScrollEnabled() {
        return Build.VERSION.SDK_INT >= 9 && this.aPJ && com.baidu.tbadk.widget.pulltorefresh.library.c.L(this.aPE);
    }

    public final boolean isRefreshing() {
        return this.aPB == State.REFRESHING || this.aPB == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (isPullToRefreshEnabled()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (Id()) {
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
                        if (!this.aPH && isRefreshing()) {
                            return true;
                        }
                        if (Id()) {
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
                            if (abs > this.mTouchSlop && (!this.aPI || abs > Math.abs(f2))) {
                                if (this.aPC.showHeaderLoadingLayout() && f >= 1.0f && isReadyForPullStart()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.aPC == Mode.BOTH) {
                                        this.aPD = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.aPC.showFooterLoadingLayout() && f <= -1.0f && isReadyForPullEnd()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.aPC == Mode.BOTH) {
                                        this.aPD = Mode.PULL_FROM_END;
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

    public final void onRefreshComplete() {
        if (isRefreshing()) {
            a(State.RESET, new boolean[0]);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (isPullToRefreshEnabled()) {
            if (this.aPH || !isRefreshing()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (Id()) {
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
                                if (this.aPB == State.RELEASE_TO_REFRESH && (this.aPP != null || this.aPQ != null)) {
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
                                Ie();
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
        this.aPH = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.aPI = z;
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
        if (mode != this.aPC) {
            this.aPC = mode;
            updateUIForMode();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.aPR = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.aPP = bVar;
        this.aPQ = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.aPQ = cVar;
        this.aPP = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.aPJ = z;
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
        i(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.aPL = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.aPG = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(State state, boolean... zArr) {
        this.aPB = state;
        switch (this.aPB) {
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
                onRefreshing(zArr[0]);
                break;
        }
        if (this.aPR != null) {
            this.aPR.a(this, this.aPB, this.aPD);
        }
    }

    protected final void addViewInternal(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void addViewInternal(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.a.b a(Context context, Mode mode, TypedArray typedArray) {
        com.baidu.tbadk.widget.pulltorefresh.library.a.b createLoadingLayout = this.aPM.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b j(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.aPC.showHeaderLoadingLayout()) {
            bVar.a(this.aPN);
        }
        if (z2 && this.aPC.showFooterLoadingLayout()) {
            bVar.a(this.aPO);
        }
        return bVar;
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getFooterLayout() {
        return this.aPO;
    }

    protected final int getFooterSize() {
        return this.aPO.getContentSize();
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getHeaderLayout() {
        return this.aPN;
    }

    protected final int getHeaderSize() {
        return this.aPN.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.aPF;
    }

    protected void handleStyledAttributes(TypedArray typedArray) {
    }

    protected void onPtrRestoreInstanceState(Bundle bundle) {
    }

    protected void onPtrSaveInstanceState(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (this.aPD) {
            case PULL_FROM_END:
                this.aPO.Il();
                return;
            case PULL_FROM_START:
                this.aPN.Il();
                return;
            default:
                return;
        }
    }

    protected void onRefreshing(boolean z) {
        if (this.aPC.showHeaderLoadingLayout()) {
            this.aPN.lm();
        }
        if (this.aPC.showFooterLoadingLayout()) {
            this.aPO.lm();
        }
        if (z) {
            if (this.aPG) {
                d dVar = new d() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.1
                    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.d
                    public void If() {
                        PullToRefreshBase.this.Ic();
                    }
                };
                switch (this.aPD) {
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
        Ic();
    }

    protected void onReleaseToRefresh() {
        switch (this.aPD) {
            case PULL_FROM_END:
                this.aPO.ll();
                return;
            case PULL_FROM_START:
                this.aPN.ll();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.aPK = true;
        this.aPN.reset();
        this.aPO.reset();
        smoothScrollTo(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.aPD = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.aPH = bundle.getBoolean("ptr_disable_scrolling", false);
            this.aPG = bundle.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
            State mapIntToValue = State.mapIntToValue(bundle.getInt("ptr_state", 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                a(mapIntToValue, true);
            }
            onPtrRestoreInstanceState(bundle);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        onPtrSaveInstanceState(bundle);
        bundle.putInt("ptr_state", this.aPB.getIntValue());
        bundle.putInt("ptr_mode", this.aPC.getIntValue());
        bundle.putInt("ptr_current_mode", this.aPD.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.aPH);
        bundle.putBoolean("ptr_show_refreshing_view", this.aPG);
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
                if (this.aPC.showHeaderLoadingLayout()) {
                    this.aPN.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.aPC.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.aPO.setWidth(maximumPullScroll);
                    i4 = i5;
                    i3 = -maximumPullScroll;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                }
            case VERTICAL:
                if (this.aPC.showHeaderLoadingLayout()) {
                    this.aPN.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.aPC.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.aPO.setHeight(maximumPullScroll);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aPF.getLayoutParams();
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.aPF.requestLayout();
                    return;
                }
                return;
            case VERTICAL:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.aPF.requestLayout();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setHeaderScroll(int i) {
        int maximumPullScroll = getMaximumPullScroll();
        int min = Math.min(maximumPullScroll, Math.max(-maximumPullScroll, i));
        if (this.aPK) {
            if (min < 0) {
                this.aPN.setVisibility(0);
            } else if (min > 0) {
                this.aPO.setVisibility(0);
            } else {
                this.aPN.setVisibility(4);
                this.aPO.setVisibility(4);
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
        c(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void updateUIForMode() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.aPN.getParent()) {
            removeView(this.aPN);
        }
        if (this.aPC.showHeaderLoadingLayout()) {
            addViewInternal(this.aPN, 0, loadingLayoutLayoutParams);
        }
        if (this == this.aPO.getParent()) {
            removeView(this.aPO);
        }
        if (this.aPC.showFooterLoadingLayout()) {
            addViewInternal(this.aPO, loadingLayoutLayoutParams);
        }
        refreshLoadingViewsSize();
        this.aPD = this.aPC != Mode.BOTH ? this.aPC : Mode.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.aPF = new FrameLayout(context);
        this.aPF.addView(t, -1, -1);
        addViewInternal(this.aPF, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ic() {
        if (this.aPP != null) {
            this.aPP.c(this);
        } else if (this.aPQ != null) {
            if (this.aPD == Mode.PULL_FROM_START) {
                this.aPQ.d(this);
            } else if (this.aPD == Mode.PULL_FROM_END) {
                this.aPQ.e(this);
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.PullToRefresh);
        if (obtainStyledAttributes.hasValue(d.n.PullToRefresh_tb_ptrMode)) {
            this.aPC = Mode.mapIntToValue(obtainStyledAttributes.getInteger(d.n.PullToRefresh_tb_ptrMode, 0));
        }
        if (obtainStyledAttributes.hasValue(d.n.PullToRefresh_tb_ptrAnimationStyle)) {
            this.aPM = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(d.n.PullToRefresh_tb_ptrAnimationStyle, 0));
        }
        this.aPE = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.aPE);
        this.aPN = a(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.aPO = a(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(d.n.PullToRefresh_tb_ptrRefreshableViewBackground)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(d.n.PullToRefresh_tb_ptrRefreshableViewBackground);
            if (drawable != null) {
                this.aPE.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(d.n.PullToRefresh_tb_ptrAdapterViewBackground)) {
            com.baidu.tbadk.widget.pulltorefresh.library.a.d.as("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(d.n.PullToRefresh_tb_ptrAdapterViewBackground);
            if (drawable2 != null) {
                this.aPE.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(d.n.PullToRefresh_tb_ptrOverScroll)) {
            this.aPJ = obtainStyledAttributes.getBoolean(d.n.PullToRefresh_tb_ptrOverScroll, true);
        }
        if (obtainStyledAttributes.hasValue(d.n.PullToRefresh_tb_ptrScrollingWhileRefreshingEnabled)) {
            this.aPH = obtainStyledAttributes.getBoolean(d.n.PullToRefresh_tb_ptrScrollingWhileRefreshingEnabled, false);
        }
        handleStyledAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        updateUIForMode();
    }

    private boolean Id() {
        switch (this.aPC) {
            case PULL_FROM_END:
                return isReadyForPullEnd();
            case PULL_FROM_START:
                return isReadyForPullStart();
            case MANUAL_REFRESH_ONLY:
            default:
                return false;
            case BOTH:
                return isReadyForPullEnd() || isReadyForPullStart();
        }
    }

    private void Ie() {
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
        switch (this.aPD) {
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
            switch (this.aPD) {
                case PULL_FROM_END:
                    this.aPO.onPull(abs);
                    break;
                default:
                    this.aPN.onPull(abs);
                    break;
            }
            if (this.aPB != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.aPB == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
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

    private final void c(int i, long j) {
        a(i, j, 0L, null);
    }

    private final void a(int i, long j, long j2, d dVar) {
        int scrollX;
        if (this.aPS != null) {
            this.aPS.stop();
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
            if (this.aPL == null) {
                this.aPL = new DecelerateInterpolator();
            }
            this.aPS = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.aPS, j2);
            } else {
                post(this.aPS);
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

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean permitsPullToRefresh() {
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
        private final int aQa;
        private final int aQb;
        private final long aQc;
        private d aQd;
        private final Interpolator mInterpolator;
        private boolean aQe = true;
        private long mStartTime = -1;
        private int aQf = -1;

        public e(int i, int i2, long j, d dVar) {
            this.aQb = i;
            this.aQa = i2;
            this.mInterpolator = PullToRefreshBase.this.aPL;
            this.aQc = j;
            this.aQd = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aQf = this.aQb - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.aQc, 1000L), 0L)) / 1000.0f) * (this.aQb - this.aQa));
                PullToRefreshBase.this.setHeaderScroll(this.aQf);
            }
            if (this.aQe && this.aQa != this.aQf) {
                com.baidu.tbadk.widget.pulltorefresh.library.a.e.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.aQd != null) {
                this.aQd.If();
            }
        }

        public void stop() {
            this.aQe = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
