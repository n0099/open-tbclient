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
    private State aPi;
    private Mode aPj;
    private Mode aPk;
    T aPl;
    private FrameLayout aPm;
    private boolean aPn;
    private boolean aPo;
    private boolean aPp;
    private boolean aPq;
    private boolean aPr;
    private Interpolator aPs;
    private AnimationStyle aPt;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b aPu;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b aPv;
    private b<T> aPw;
    private c<T> aPx;
    private a<T> aPy;
    private PullToRefreshBase<T>.e aPz;
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
        void Im();
    }

    protected abstract boolean If();

    protected abstract boolean Ig();

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract Orientation getPullToRefreshScrollDirection();

    public PullToRefreshBase(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.aPi = State.RESET;
        this.aPj = Mode.getDefault();
        this.aPn = true;
        this.aPo = false;
        this.aPp = true;
        this.aPq = true;
        this.aPr = true;
        this.aPt = AnimationStyle.getDefault();
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.aPi = State.RESET;
        this.aPj = Mode.getDefault();
        this.aPn = true;
        this.aPo = false;
        this.aPp = true;
        this.aPq = true;
        this.aPr = true;
        this.aPt = AnimationStyle.getDefault();
        init(context, attributeSet);
    }

    public PullToRefreshBase(Context context, Mode mode) {
        super(context);
        this.mIsBeingDragged = false;
        this.aPi = State.RESET;
        this.aPj = Mode.getDefault();
        this.aPn = true;
        this.aPo = false;
        this.aPp = true;
        this.aPq = true;
        this.aPr = true;
        this.aPt = AnimationStyle.getDefault();
        this.aPj = mode;
        init(context, null);
    }

    public PullToRefreshBase(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context);
        this.mIsBeingDragged = false;
        this.aPi = State.RESET;
        this.aPj = Mode.getDefault();
        this.aPn = true;
        this.aPo = false;
        this.aPp = true;
        this.aPq = true;
        this.aPr = true;
        this.aPt = AnimationStyle.getDefault();
        this.aPj = mode;
        this.aPt = animationStyle;
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
        return this.aPk;
    }

    public final boolean getFilterTouchEvents() {
        return this.aPp;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return j(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a j(boolean z, boolean z2) {
        return k(z, z2);
    }

    public final Mode getMode() {
        return this.aPj;
    }

    public final T getRefreshableView() {
        return this.aPl;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.aPn;
    }

    public final State getState() {
        return this.aPi;
    }

    public final boolean Ib() {
        return this.aPj.permitsPullToRefresh();
    }

    public final boolean Ic() {
        return Build.VERSION.SDK_INT >= 9 && this.aPq && com.baidu.tbadk.widget.pulltorefresh.library.c.Q(this.aPl);
    }

    public final boolean Id() {
        return this.aPi == State.REFRESHING || this.aPi == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (Ib()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (Ik()) {
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
                        if (!this.aPo && Id()) {
                            return true;
                        }
                        if (Ik()) {
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
                            if (abs > this.mTouchSlop && (!this.aPp || abs > Math.abs(f2))) {
                                if (this.aPj.showHeaderLoadingLayout() && f >= 1.0f && Ig()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.aPj == Mode.BOTH) {
                                        this.aPk = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.aPj.showFooterLoadingLayout() && f <= -1.0f && If()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.aPj == Mode.BOTH) {
                                        this.aPk = Mode.PULL_FROM_END;
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

    public final void Ie() {
        if (Id()) {
            a(State.RESET, new boolean[0]);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (Ib()) {
            if (this.aPo || !Id()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (Ik()) {
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
                                if (this.aPi == State.RELEASE_TO_REFRESH && (this.aPw != null || this.aPx != null)) {
                                    a(State.REFRESHING, true);
                                    return true;
                                } else if (Id()) {
                                    fx(0);
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
                                Il();
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
        this.aPo = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.aPp = z;
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
        if (mode != this.aPj) {
            this.aPj = mode;
            Ii();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.aPy = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.aPw = bVar;
        this.aPx = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.aPx = cVar;
        this.aPw = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.aPq = z;
    }

    public final void setRefreshing(boolean z) {
        if (!Id()) {
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
        j(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.aPs = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.aPn = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(State state, boolean... zArr) {
        this.aPi = state;
        switch (this.aPi) {
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
                ch(zArr[0]);
                break;
        }
        if (this.aPy != null) {
            this.aPy.a(this, this.aPi, this.aPk);
        }
    }

    protected final void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void a(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.a.b a(Context context, Mode mode, TypedArray typedArray) {
        com.baidu.tbadk.widget.pulltorefresh.library.a.b createLoadingLayout = this.aPt.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b k(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.aPj.showHeaderLoadingLayout()) {
            bVar.a(this.aPu);
        }
        if (z2 && this.aPj.showFooterLoadingLayout()) {
            bVar.a(this.aPv);
        }
        return bVar;
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getFooterLayout() {
        return this.aPv;
    }

    protected final int getFooterSize() {
        return this.aPv.getContentSize();
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getHeaderLayout() {
        return this.aPu;
    }

    protected final int getHeaderSize() {
        return this.aPu.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.aPm;
    }

    protected void a(TypedArray typedArray) {
    }

    protected void f(Bundle bundle) {
    }

    protected void g(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (this.aPk) {
            case PULL_FROM_END:
                this.aPv.Is();
                return;
            case PULL_FROM_START:
                this.aPu.Is();
                return;
            default:
                return;
        }
    }

    protected void ch(boolean z) {
        if (this.aPj.showHeaderLoadingLayout()) {
            this.aPu.ld();
        }
        if (this.aPj.showFooterLoadingLayout()) {
            this.aPv.ld();
        }
        if (z) {
            if (this.aPn) {
                d dVar = new d() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.1
                    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.d
                    public void Im() {
                        PullToRefreshBase.this.Ij();
                    }
                };
                switch (this.aPk) {
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
            fx(0);
            return;
        }
        Ij();
    }

    protected void onReleaseToRefresh() {
        switch (this.aPk) {
            case PULL_FROM_END:
                this.aPv.lc();
                return;
            case PULL_FROM_START:
                this.aPu.lc();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.aPr = true;
        this.aPu.reset();
        this.aPv.reset();
        fx(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.aPk = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.aPo = bundle.getBoolean("ptr_disable_scrolling", false);
            this.aPn = bundle.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
            State mapIntToValue = State.mapIntToValue(bundle.getInt("ptr_state", 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                a(mapIntToValue, true);
            }
            f(bundle);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        g(bundle);
        bundle.putInt("ptr_state", this.aPi.getIntValue());
        bundle.putInt("ptr_mode", this.aPj.getIntValue());
        bundle.putInt("ptr_current_mode", this.aPk.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.aPo);
        bundle.putBoolean("ptr_show_refreshing_view", this.aPn);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Ih();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    protected final void Ih() {
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
                if (this.aPj.showHeaderLoadingLayout()) {
                    this.aPu.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.aPj.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.aPv.setWidth(maximumPullScroll);
                    i4 = i5;
                    i3 = -maximumPullScroll;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                }
            case VERTICAL:
                if (this.aPj.showHeaderLoadingLayout()) {
                    this.aPu.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.aPj.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.aPv.setHeight(maximumPullScroll);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aPm.getLayoutParams();
        switch (getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.aPm.requestLayout();
                    return;
                }
                return;
            case VERTICAL:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.aPm.requestLayout();
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
        if (this.aPr) {
            if (min < 0) {
                this.aPu.setVisibility(0);
            } else if (min > 0) {
                this.aPv.setVisibility(0);
            } else {
                this.aPu.setVisibility(4);
                this.aPv.setVisibility(4);
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

    protected final void fx(int i) {
        d(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void Ii() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.aPu.getParent()) {
            removeView(this.aPu);
        }
        if (this.aPj.showHeaderLoadingLayout()) {
            a(this.aPu, 0, loadingLayoutLayoutParams);
        }
        if (this == this.aPv.getParent()) {
            removeView(this.aPv);
        }
        if (this.aPj.showFooterLoadingLayout()) {
            a(this.aPv, loadingLayoutLayoutParams);
        }
        Ih();
        this.aPk = this.aPj != Mode.BOTH ? this.aPj : Mode.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.aPm = new FrameLayout(context);
        this.aPm.addView(t, -1, -1);
        a(this.aPm, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ij() {
        if (this.aPw != null) {
            this.aPw.c(this);
        } else if (this.aPx != null) {
            if (this.aPk == Mode.PULL_FROM_START) {
                this.aPx.d(this);
            } else if (this.aPk == Mode.PULL_FROM_END) {
                this.aPx.e(this);
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
            this.aPj = Mode.mapIntToValue(obtainStyledAttributes.getInteger(d.n.PullToRefresh_tb_ptrMode, 0));
        }
        if (obtainStyledAttributes.hasValue(d.n.PullToRefresh_tb_ptrAnimationStyle)) {
            this.aPt = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(d.n.PullToRefresh_tb_ptrAnimationStyle, 0));
        }
        this.aPl = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.aPl);
        this.aPu = a(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.aPv = a(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(d.n.PullToRefresh_tb_ptrRefreshableViewBackground)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(d.n.PullToRefresh_tb_ptrRefreshableViewBackground);
            if (drawable != null) {
                this.aPl.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(d.n.PullToRefresh_tb_ptrAdapterViewBackground)) {
            com.baidu.tbadk.widget.pulltorefresh.library.a.d.av("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(d.n.PullToRefresh_tb_ptrAdapterViewBackground);
            if (drawable2 != null) {
                this.aPl.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(d.n.PullToRefresh_tb_ptrOverScroll)) {
            this.aPq = obtainStyledAttributes.getBoolean(d.n.PullToRefresh_tb_ptrOverScroll, true);
        }
        if (obtainStyledAttributes.hasValue(d.n.PullToRefresh_tb_ptrScrollingWhileRefreshingEnabled)) {
            this.aPo = obtainStyledAttributes.getBoolean(d.n.PullToRefresh_tb_ptrScrollingWhileRefreshingEnabled, false);
        }
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        Ii();
    }

    private boolean Ik() {
        switch (this.aPj) {
            case PULL_FROM_END:
                return If();
            case PULL_FROM_START:
                return Ig();
            case MANUAL_REFRESH_ONLY:
            default:
                return false;
            case BOTH:
                return If() || Ig();
        }
    }

    private void Il() {
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
        switch (this.aPk) {
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
        if (round != 0 && !Id()) {
            float abs = Math.abs(round) / footerSize;
            switch (this.aPk) {
                case PULL_FROM_END:
                    this.aPv.onPull(abs);
                    break;
                default:
                    this.aPu.onPull(abs);
                    break;
            }
            if (this.aPi != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.aPi == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
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

    private final void d(int i, long j) {
        a(i, j, 0L, null);
    }

    private final void a(int i, long j, long j2, d dVar) {
        int scrollX;
        if (this.aPz != null) {
            this.aPz.stop();
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
            if (this.aPs == null) {
                this.aPs = new DecelerateInterpolator();
            }
            this.aPz = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.aPz, j2);
            } else {
                post(this.aPz);
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
        private final int aPH;
        private final int aPI;
        private d aPJ;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aPK = true;
        private long mStartTime = -1;
        private int aPL = -1;

        public e(int i, int i2, long j, d dVar) {
            this.aPI = i;
            this.aPH = i2;
            this.mInterpolator = PullToRefreshBase.this.aPs;
            this.mDuration = j;
            this.aPJ = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aPL = this.aPI - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aPI - this.aPH));
                PullToRefreshBase.this.setHeaderScroll(this.aPL);
            }
            if (this.aPK && this.aPH != this.aPL) {
                com.baidu.tbadk.widget.pulltorefresh.library.a.e.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.aPJ != null) {
                this.aPJ.Im();
            }
        }

        public void stop() {
            this.aPK = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
