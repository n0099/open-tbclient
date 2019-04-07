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
    T aJe;
    private FrameLayout aJf;
    private State cBh;
    private Mode cBi;
    private Mode cBj;
    private boolean cBk;
    private boolean cBl;
    private boolean cBm;
    private boolean cBn;
    private boolean cBo;
    private Interpolator cBp;
    private AnimationStyle cBq;
    private LoadingLayout cBr;
    private LoadingLayout cBs;
    private b<T> cBt;
    private c<T> cBu;
    private a<T> cBv;
    private PullToRefreshBase<T>.e cBw;
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
        void asq();
    }

    protected abstract boolean ask();

    protected abstract boolean asl();

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract Orientation getPullToRefreshScrollDirection();

    public PullToRefreshBase(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.cBh = State.RESET;
        this.cBi = Mode.getDefault();
        this.cBk = true;
        this.cBl = false;
        this.cBm = true;
        this.cBn = true;
        this.cBo = true;
        this.cBq = AnimationStyle.getDefault();
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.cBh = State.RESET;
        this.cBi = Mode.getDefault();
        this.cBk = true;
        this.cBl = false;
        this.cBm = true;
        this.cBn = true;
        this.cBo = true;
        this.cBq = AnimationStyle.getDefault();
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
        return this.cBj;
    }

    public final boolean getFilterTouchEvents() {
        return this.cBm;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return p(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a p(boolean z, boolean z2) {
        return q(z, z2);
    }

    public final Mode getMode() {
        return this.cBi;
    }

    public final T getRefreshableView() {
        return this.aJe;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.cBk;
    }

    public final State getState() {
        return this.cBh;
    }

    public final boolean asj() {
        return this.cBi.permitsPullToRefresh();
    }

    public final boolean isRefreshing() {
        return this.cBh == State.REFRESHING || this.cBh == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (asj()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (aso()) {
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
                        if (!this.cBl && isRefreshing()) {
                            return true;
                        }
                        if (aso()) {
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
                            if (abs > this.mTouchSlop && (!this.cBm || abs > Math.abs(f2))) {
                                if (this.cBi.showHeaderLoadingLayout() && f >= 1.0f && asl()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.cBi == Mode.BOTH) {
                                        this.cBj = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.cBi.showFooterLoadingLayout() && f <= -1.0f && ask()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.cBi == Mode.BOTH) {
                                        this.cBj = Mode.PULL_FROM_END;
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
        if (asj()) {
            if (this.cBl || !isRefreshing()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (aso()) {
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
                                if (this.cBh == State.RELEASE_TO_REFRESH && (this.cBt != null || this.cBu != null)) {
                                    a(State.REFRESHING, true);
                                    return true;
                                } else if (isRefreshing()) {
                                    cW(0);
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
                                asp();
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
        this.cBl = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.cBm = z;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    public void setLoadingDrawable(Drawable drawable, Mode mode) {
        p(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public final void setMode(Mode mode) {
        if (mode != this.cBi) {
            this.cBi = mode;
            asm();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.cBv = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.cBt = bVar;
        this.cBu = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.cBu = cVar;
        this.cBt = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public void setPullLabel(CharSequence charSequence, Mode mode) {
        p(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.cBn = z;
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
        p(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        setReleaseLabel(charSequence, Mode.BOTH);
    }

    public void setReleaseLabel(CharSequence charSequence, Mode mode) {
        p(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.cBp = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.cBk = z;
    }

    final void a(State state, boolean... zArr) {
        this.cBh = state;
        switch (this.cBh) {
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
                fr(zArr[0]);
                break;
        }
        if (this.cBv != null) {
            this.cBv.a(this, this.cBh, this.cBj);
        }
    }

    protected final void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void a(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected LoadingLayout a(Context context, Mode mode, TypedArray typedArray) {
        LoadingLayout createLoadingLayout = this.cBq.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b q(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.cBi.showHeaderLoadingLayout()) {
            bVar.a(this.cBr);
        }
        if (z2 && this.cBi.showFooterLoadingLayout()) {
            bVar.a(this.cBs);
        }
        return bVar;
    }

    protected final LoadingLayout getFooterLayout() {
        return this.cBs;
    }

    protected final int getFooterSize() {
        return this.cBs.getContentSize();
    }

    protected final LoadingLayout getHeaderLayout() {
        return this.cBr;
    }

    protected final int getHeaderSize() {
        return this.cBr.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.aJf;
    }

    protected void a(TypedArray typedArray) {
    }

    protected void E(Bundle bundle) {
    }

    protected void F(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (this.cBj) {
            case PULL_FROM_END:
                this.cBs.pullToRefresh();
                return;
            case PULL_FROM_START:
                this.cBr.pullToRefresh();
                return;
            default:
                return;
        }
    }

    protected void fr(boolean z) {
        if (this.cBi.showHeaderLoadingLayout()) {
            this.cBr.refreshing();
        }
        if (this.cBi.showFooterLoadingLayout()) {
            this.cBs.refreshing();
        }
        if (z) {
            if (this.cBk) {
                d dVar = new d() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.1
                    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.d
                    public void asq() {
                        PullToRefreshBase.this.asn();
                    }
                };
                switch (this.cBj) {
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
            cW(0);
            return;
        }
        asn();
    }

    protected void onReleaseToRefresh() {
        switch (this.cBj) {
            case PULL_FROM_END:
                this.cBs.releaseToRefresh();
                return;
            case PULL_FROM_START:
                this.cBr.releaseToRefresh();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.cBo = true;
        this.cBr.reset();
        this.cBs.reset();
        cW(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.cBj = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.cBl = bundle.getBoolean("ptr_disable_scrolling", false);
            this.cBk = bundle.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
            State mapIntToValue = State.mapIntToValue(bundle.getInt("ptr_state", 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                a(mapIntToValue, true);
            }
            E(bundle);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        F(bundle);
        bundle.putInt("ptr_state", this.cBh.getIntValue());
        bundle.putInt("ptr_mode", this.cBi.getIntValue());
        bundle.putInt("ptr_current_mode", this.cBj.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.cBl);
        bundle.putBoolean("ptr_show_refreshing_view", this.cBk);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Hs();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    protected final void Hs() {
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
                if (this.cBi.showHeaderLoadingLayout()) {
                    this.cBr.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.cBi.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.cBs.setWidth(maximumPullScroll);
                    i4 = i5;
                    i3 = -maximumPullScroll;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                }
            case VERTICAL:
                if (this.cBi.showHeaderLoadingLayout()) {
                    this.cBr.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.cBi.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.cBs.setHeight(maximumPullScroll);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJf.getLayoutParams();
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.aJf.requestLayout();
                    return;
                }
                return;
            case VERTICAL:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.aJf.requestLayout();
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
        if (this.cBo) {
            if (min < 0) {
                this.cBr.setVisibility(0);
            } else if (min > 0) {
                this.cBs.setVisibility(0);
            } else {
                this.cBr.setVisibility(4);
                this.cBs.setVisibility(4);
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

    protected final void cW(int i) {
        i(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void asm() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.cBr.getParent()) {
            removeView(this.cBr);
        }
        if (this.cBi.showHeaderLoadingLayout()) {
            a(this.cBr, 0, loadingLayoutLayoutParams);
        }
        if (this == this.cBs.getParent()) {
            removeView(this.cBs);
        }
        if (this.cBi.showFooterLoadingLayout()) {
            a(this.cBs, loadingLayoutLayoutParams);
        }
        Hs();
        this.cBj = this.cBi != Mode.BOTH ? this.cBi : Mode.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.aJf = new FrameLayout(context);
        this.aJf.addView(t, -1, -1);
        a(this.aJf, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asn() {
        if (this.cBt != null) {
            this.cBt.c(this);
        } else if (this.cBu != null) {
            if (this.cBj == Mode.PULL_FROM_START) {
                this.cBu.d(this);
            } else if (this.cBj == Mode.PULL_FROM_END) {
                this.cBu.e(this);
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.PullToRefresh);
        if (obtainStyledAttributes.hasValue(d.l.PullToRefresh_tb_ptrMode)) {
            this.cBi = Mode.mapIntToValue(obtainStyledAttributes.getInteger(d.l.PullToRefresh_tb_ptrMode, 0));
        }
        if (obtainStyledAttributes.hasValue(d.l.PullToRefresh_tb_ptrAnimationStyle)) {
            this.cBq = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(d.l.PullToRefresh_tb_ptrAnimationStyle, 0));
        }
        this.aJe = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.aJe);
        this.cBr = a(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.cBs = a(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(d.l.PullToRefresh_tb_ptrRefreshableViewBackground)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(d.l.PullToRefresh_tb_ptrRefreshableViewBackground);
            if (drawable != null) {
                this.aJe.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(d.l.PullToRefresh_tb_ptrAdapterViewBackground)) {
            com.baidu.tbadk.widget.pulltorefresh.library.internal.a.bY("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(d.l.PullToRefresh_tb_ptrAdapterViewBackground);
            if (drawable2 != null) {
                this.aJe.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(d.l.PullToRefresh_tb_ptrOverScroll)) {
            this.cBn = obtainStyledAttributes.getBoolean(d.l.PullToRefresh_tb_ptrOverScroll, true);
        }
        if (obtainStyledAttributes.hasValue(d.l.PullToRefresh_tb_ptrScrollingWhileRefreshingEnabled)) {
            this.cBl = obtainStyledAttributes.getBoolean(d.l.PullToRefresh_tb_ptrScrollingWhileRefreshingEnabled, false);
        }
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        asm();
    }

    private boolean aso() {
        switch (this.cBi) {
            case PULL_FROM_END:
                return ask();
            case PULL_FROM_START:
                return asl();
            case MANUAL_REFRESH_ONLY:
            default:
                return false;
            case BOTH:
                return ask() || asl();
        }
    }

    private void asp() {
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
        switch (this.cBj) {
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
            switch (this.cBj) {
                case PULL_FROM_END:
                    this.cBs.onPull(abs);
                    break;
                default:
                    this.cBr.onPull(abs);
                    break;
            }
            if (this.cBh != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.cBh == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
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

    private final void i(int i, long j) {
        a(i, j, 0L, null);
    }

    private final void a(int i, long j, long j2, d dVar) {
        int scrollX;
        if (this.cBw != null) {
            this.cBw.stop();
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
            if (this.cBp == null) {
                this.cBp = new DecelerateInterpolator();
            }
            this.cBw = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.cBw, j2);
            } else {
                post(this.cBw);
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
        private final int aJw;
        private final int aJx;
        private d cBC;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aJy = true;
        private long mStartTime = -1;
        private int aJz = -1;

        public e(int i, int i2, long j, d dVar) {
            this.aJx = i;
            this.aJw = i2;
            this.mInterpolator = PullToRefreshBase.this.cBp;
            this.mDuration = j;
            this.cBC = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aJz = this.aJx - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aJx - this.aJw));
                PullToRefreshBase.this.setHeaderScroll(this.aJz);
            }
            if (this.aJy && this.aJw != this.aJz) {
                com.baidu.tbadk.widget.pulltorefresh.library.internal.b.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.cBC != null) {
                this.cBC.asq();
            }
        }

        public void stop() {
            this.aJy = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
