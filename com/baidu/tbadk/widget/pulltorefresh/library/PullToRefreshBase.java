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
    private Interpolator ayQ;
    T bIv;
    private FrameLayout bIw;
    private State dIN;
    private Mode dIO;
    private Mode dIP;
    private boolean dIQ;
    private boolean dIR;
    private boolean dIS;
    private boolean dIT;
    private boolean dIU;
    private AnimationStyle dIV;
    private LoadingLayout dIW;
    private LoadingLayout dIX;
    private b<T> dIY;
    private c<T> dIZ;
    private a<T> dJa;
    private PullToRefreshBase<T>.e dJb;
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
        void yy();
    }

    protected abstract boolean aRr();

    protected abstract boolean aRs();

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract Orientation getPullToRefreshScrollDirection();

    public PullToRefreshBase(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.dIN = State.RESET;
        this.dIO = Mode.getDefault();
        this.dIQ = true;
        this.dIR = false;
        this.dIS = true;
        this.dIT = true;
        this.dIU = true;
        this.dIV = AnimationStyle.getDefault();
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.dIN = State.RESET;
        this.dIO = Mode.getDefault();
        this.dIQ = true;
        this.dIR = false;
        this.dIS = true;
        this.dIT = true;
        this.dIU = true;
        this.dIV = AnimationStyle.getDefault();
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
        return this.dIP;
    }

    public final boolean getFilterTouchEvents() {
        return this.dIS;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return v(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a v(boolean z, boolean z2) {
        return w(z, z2);
    }

    public final Mode getMode() {
        return this.dIO;
    }

    public final T getRefreshableView() {
        return this.bIv;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.dIQ;
    }

    public final State getState() {
        return this.dIN;
    }

    public final boolean aRq() {
        return this.dIO.permitsPullToRefresh();
    }

    public final boolean isRefreshing() {
        return this.dIN == State.REFRESHING || this.dIN == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (aRq()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (aRv()) {
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
                        if (!this.dIR && isRefreshing()) {
                            return true;
                        }
                        if (aRv()) {
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
                            if (abs > this.mTouchSlop && (!this.dIS || abs > Math.abs(f2))) {
                                if (this.dIO.showHeaderLoadingLayout() && f >= 1.0f && aRs()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.dIO == Mode.BOTH) {
                                        this.dIP = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.dIO.showFooterLoadingLayout() && f <= -1.0f && aRr()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.dIO == Mode.BOTH) {
                                        this.dIP = Mode.PULL_FROM_END;
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
        if (aRq()) {
            if (this.dIR || !isRefreshing()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (aRv()) {
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
                                if (this.dIN == State.RELEASE_TO_REFRESH && (this.dIY != null || this.dIZ != null)) {
                                    a(State.REFRESHING, true);
                                    return true;
                                } else if (isRefreshing()) {
                                    fy(0);
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
                                aRw();
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
        this.dIR = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.dIS = z;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    public void setLoadingDrawable(Drawable drawable, Mode mode) {
        v(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public final void setMode(Mode mode) {
        if (mode != this.dIO) {
            this.dIO = mode;
            aRt();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.dJa = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.dIY = bVar;
        this.dIZ = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.dIZ = cVar;
        this.dIY = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public void setPullLabel(CharSequence charSequence, Mode mode) {
        v(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.dIT = z;
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
        v(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        setReleaseLabel(charSequence, Mode.BOTH);
    }

    public void setReleaseLabel(CharSequence charSequence, Mode mode) {
        v(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.ayQ = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.dIQ = z;
    }

    final void a(State state, boolean... zArr) {
        this.dIN = state;
        switch (this.dIN) {
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
                hc(zArr[0]);
                break;
        }
        if (this.dJa != null) {
            this.dJa.a(this, this.dIN, this.dIP);
        }
    }

    protected final void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void a(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected LoadingLayout a(Context context, Mode mode, TypedArray typedArray) {
        LoadingLayout createLoadingLayout = this.dIV.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b w(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.dIO.showHeaderLoadingLayout()) {
            bVar.a(this.dIW);
        }
        if (z2 && this.dIO.showFooterLoadingLayout()) {
            bVar.a(this.dIX);
        }
        return bVar;
    }

    protected final LoadingLayout getFooterLayout() {
        return this.dIX;
    }

    protected final int getFooterSize() {
        return this.dIX.getContentSize();
    }

    protected final LoadingLayout getHeaderLayout() {
        return this.dIW;
    }

    protected final int getHeaderSize() {
        return this.dIW.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.bIw;
    }

    protected void a(TypedArray typedArray) {
    }

    protected void Z(Bundle bundle) {
    }

    protected void aa(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (this.dIP) {
            case PULL_FROM_END:
                this.dIX.pullToRefresh();
                return;
            case PULL_FROM_START:
                this.dIW.pullToRefresh();
                return;
            default:
                return;
        }
    }

    protected void hc(boolean z) {
        if (this.dIO.showHeaderLoadingLayout()) {
            this.dIW.refreshing();
        }
        if (this.dIO.showFooterLoadingLayout()) {
            this.dIX.refreshing();
        }
        if (z) {
            if (this.dIQ) {
                d dVar = new d() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.1
                    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.d
                    public void yy() {
                        PullToRefreshBase.this.aRu();
                    }
                };
                switch (this.dIP) {
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
            fy(0);
            return;
        }
        aRu();
    }

    protected void onReleaseToRefresh() {
        switch (this.dIP) {
            case PULL_FROM_END:
                this.dIX.releaseToRefresh();
                return;
            case PULL_FROM_START:
                this.dIW.releaseToRefresh();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.dIU = true;
        this.dIW.reset();
        this.dIX.reset();
        fy(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.dIP = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.dIR = bundle.getBoolean("ptr_disable_scrolling", false);
            this.dIQ = bundle.getBoolean("ptr_show_refreshing_view", true);
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
        bundle.putInt("ptr_state", this.dIN.getIntValue());
        bundle.putInt("ptr_mode", this.dIO.getIntValue());
        bundle.putInt("ptr_current_mode", this.dIP.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.dIR);
        bundle.putBoolean("ptr_show_refreshing_view", this.dIQ);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ZE();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    protected final void ZE() {
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
                if (this.dIO.showHeaderLoadingLayout()) {
                    this.dIW.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.dIO.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.dIX.setWidth(maximumPullScroll);
                    i4 = i5;
                    i3 = -maximumPullScroll;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                }
            case VERTICAL:
                if (this.dIO.showHeaderLoadingLayout()) {
                    this.dIW.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.dIO.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.dIX.setHeight(maximumPullScroll);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bIw.getLayoutParams();
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.bIw.requestLayout();
                    return;
                }
                return;
            case VERTICAL:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.bIw.requestLayout();
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
        if (this.dIU) {
            if (min < 0) {
                this.dIW.setVisibility(0);
            } else if (min > 0) {
                this.dIX.setVisibility(0);
            } else {
                this.dIW.setVisibility(4);
                this.dIX.setVisibility(4);
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

    protected final void fy(int i) {
        t(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void aRt() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.dIW.getParent()) {
            removeView(this.dIW);
        }
        if (this.dIO.showHeaderLoadingLayout()) {
            a(this.dIW, 0, loadingLayoutLayoutParams);
        }
        if (this == this.dIX.getParent()) {
            removeView(this.dIX);
        }
        if (this.dIO.showFooterLoadingLayout()) {
            a(this.dIX, loadingLayoutLayoutParams);
        }
        ZE();
        this.dIP = this.dIO != Mode.BOTH ? this.dIO : Mode.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.bIw = new FrameLayout(context);
        this.bIw.addView(t, -1, -1);
        a(this.bIw, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRu() {
        if (this.dIY != null) {
            this.dIY.c(this);
        } else if (this.dIZ != null) {
            if (this.dIP == Mode.PULL_FROM_START) {
                this.dIZ.d(this);
            } else if (this.dIP == Mode.PULL_FROM_END) {
                this.dIZ.e(this);
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
            this.dIO = Mode.mapIntToValue(obtainStyledAttributes.getInteger(12, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.dIV = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(1, 0));
        }
        this.bIv = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.bIv);
        this.dIW = a(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.dIX = a(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(9)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(9);
            if (drawable != null) {
                this.bIv.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(3)) {
            com.baidu.tbadk.widget.pulltorefresh.library.internal.a.cz("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(3);
            if (drawable2 != null) {
                this.bIv.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.dIT = obtainStyledAttributes.getBoolean(6, true);
        }
        if (obtainStyledAttributes.hasValue(15)) {
            this.dIR = obtainStyledAttributes.getBoolean(15, false);
        }
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        aRt();
    }

    private boolean aRv() {
        switch (this.dIO) {
            case PULL_FROM_END:
                return aRr();
            case PULL_FROM_START:
                return aRs();
            case MANUAL_REFRESH_ONLY:
            default:
                return false;
            case BOTH:
                return aRr() || aRs();
        }
    }

    private void aRw() {
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
        switch (this.dIP) {
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
            switch (this.dIP) {
                case PULL_FROM_END:
                    this.dIX.onPull(abs);
                    break;
                default:
                    this.dIW.onPull(abs);
                    break;
            }
            if (this.dIN != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.dIN == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
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
        if (this.dJb != null) {
            this.dJb.stop();
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
            if (this.ayQ == null) {
                this.ayQ = new DecelerateInterpolator();
            }
            this.dJb = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.dJb, j2);
            } else {
                post(this.dJb);
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
        private final int azb;
        private final int azc;
        private d dJh;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aze = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;

        public e(int i, int i2, long j, d dVar) {
            this.azc = i;
            this.azb = i2;
            this.mInterpolator = PullToRefreshBase.this.ayQ;
            this.mDuration = j;
            this.dJh = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.azc - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.azc - this.azb));
                PullToRefreshBase.this.setHeaderScroll(this.mCurrentY);
            }
            if (this.aze && this.azb != this.mCurrentY) {
                com.baidu.tbadk.widget.pulltorefresh.library.internal.b.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.dJh != null) {
                this.dJh.yy();
            }
        }

        public void stop() {
            this.aze = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
