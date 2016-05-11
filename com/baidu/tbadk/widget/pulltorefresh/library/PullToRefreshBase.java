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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private static /* synthetic */ int[] aCL;
    private static /* synthetic */ int[] aDe;
    private static /* synthetic */ int[] aDf;
    private State aCM;
    private Mode aCN;
    private Mode aCO;
    T aCP;
    private FrameLayout aCQ;
    private boolean aCR;
    private boolean aCS;
    private boolean aCT;
    private boolean aCU;
    private boolean aCV;
    private Interpolator aCW;
    private AnimationStyle aCX;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b aCY;
    private com.baidu.tbadk.widget.pulltorefresh.library.a.b aCZ;
    private b<T> aDa;
    private c<T> aDb;
    private a<T> aDc;
    private PullToRefreshBase<T>.e aDd;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public enum Orientation {
        VERTICAL,
        HORIZONTAL;

        /* JADX DEBUG: Replace access to removed values field (aDk) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Orientation[] valuesCustom() {
            Orientation[] valuesCustom = values();
            int length = valuesCustom.length;
            Orientation[] orientationArr = new Orientation[length];
            System.arraycopy(valuesCustom, 0, orientationArr, 0, length);
            return orientationArr;
        }
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
        void Gu();
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract Orientation getPullToRefreshScrollDirection();

    protected abstract boolean jN();

    protected abstract boolean jO();

    static /* synthetic */ int[] Gl() {
        int[] iArr = aCL;
        if (iArr == null) {
            iArr = new int[Orientation.valuesCustom().length];
            try {
                iArr[Orientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Orientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            aCL = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] Gs() {
        int[] iArr = aDe;
        if (iArr == null) {
            iArr = new int[State.valuesCustom().length];
            try {
                iArr[State.MANUAL_REFRESHING.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[State.OVERSCROLLING.ordinal()] = 6;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[State.PULL_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[State.RELEASE_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            aDe = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] Gt() {
        int[] iArr = aDf;
        if (iArr == null) {
            iArr = new int[Mode.valuesCustom().length];
            try {
                iArr[Mode.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Mode.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Mode.MANUAL_REFRESH_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Mode.PULL_FROM_END.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            aDf = iArr;
        }
        return iArr;
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.aCM = State.RESET;
        this.aCN = Mode.getDefault();
        this.aCR = true;
        this.aCS = false;
        this.aCT = true;
        this.aCU = true;
        this.aCV = true;
        this.aCX = AnimationStyle.getDefault();
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.aCM = State.RESET;
        this.aCN = Mode.getDefault();
        this.aCR = true;
        this.aCS = false;
        this.aCT = true;
        this.aCU = true;
        this.aCV = true;
        this.aCX = AnimationStyle.getDefault();
        init(context, attributeSet);
    }

    public PullToRefreshBase(Context context, Mode mode) {
        super(context);
        this.mIsBeingDragged = false;
        this.aCM = State.RESET;
        this.aCN = Mode.getDefault();
        this.aCR = true;
        this.aCS = false;
        this.aCT = true;
        this.aCU = true;
        this.aCV = true;
        this.aCX = AnimationStyle.getDefault();
        this.aCN = mode;
        init(context, null);
    }

    public PullToRefreshBase(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context);
        this.mIsBeingDragged = false;
        this.aCM = State.RESET;
        this.aCN = Mode.getDefault();
        this.aCR = true;
        this.aCS = false;
        this.aCT = true;
        this.aCU = true;
        this.aCV = true;
        this.aCX = AnimationStyle.getDefault();
        this.aCN = mode;
        this.aCX = animationStyle;
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
        return this.aCO;
    }

    public final boolean getFilterTouchEvents() {
        return this.aCT;
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a getLoadingLayoutProxy() {
        return f(true, true);
    }

    public final com.baidu.tbadk.widget.pulltorefresh.library.a f(boolean z, boolean z2) {
        return g(z, z2);
    }

    public final Mode getMode() {
        return this.aCN;
    }

    public final T getRefreshableView() {
        return this.aCP;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.aCR;
    }

    public final State getState() {
        return this.aCM;
    }

    public final boolean Gm() {
        return this.aCN.permitsPullToRefresh();
    }

    public final boolean Gn() {
        return Build.VERSION.SDK_INT >= 9 && this.aCU && com.baidu.tbadk.widget.pulltorefresh.library.c.O(this.aCP);
    }

    public final boolean Go() {
        return this.aCM == State.REFRESHING || this.aCM == State.MANUAL_REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (Gm()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mIsBeingDragged = false;
                return false;
            } else if (action == 0 || !this.mIsBeingDragged) {
                switch (action) {
                    case 0:
                        if (jM()) {
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
                        if (!this.aCS && Go()) {
                            return true;
                        }
                        if (jM()) {
                            float y2 = motionEvent.getY();
                            float x2 = motionEvent.getX();
                            switch (Gl()[getPullToRefreshScrollDirection().ordinal()]) {
                                case 2:
                                    f = x2 - this.mLastMotionX;
                                    f2 = y2 - this.mLastMotionY;
                                    break;
                                default:
                                    f = y2 - this.mLastMotionY;
                                    f2 = x2 - this.mLastMotionX;
                                    break;
                            }
                            float abs = Math.abs(f);
                            if (abs > this.mTouchSlop && (!this.aCT || abs > Math.abs(f2))) {
                                if (this.aCN.showHeaderLoadingLayout() && f >= 1.0f && jN()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.aCN == Mode.BOTH) {
                                        this.aCO = Mode.PULL_FROM_START;
                                        break;
                                    }
                                } else if (this.aCN.showFooterLoadingLayout() && f <= -1.0f && jO()) {
                                    this.mLastMotionY = y2;
                                    this.mLastMotionX = x2;
                                    this.mIsBeingDragged = true;
                                    if (this.aCN == Mode.BOTH) {
                                        this.aCO = Mode.PULL_FROM_END;
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

    public final void Gp() {
        if (Go()) {
            a(State.RESET, new boolean[0]);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (Gm()) {
            if (this.aCS || !Go()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (jM()) {
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
                                if (this.aCM == State.RELEASE_TO_REFRESH && (this.aDa != null || this.aDb != null)) {
                                    a(State.REFRESHING, true);
                                    return true;
                                } else if (Go()) {
                                    eZ(0);
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
                                Gr();
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
        this.aCS = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.aCT = z;
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
        if (mode != this.aCN) {
            this.aCN = mode;
            jK();
        }
    }

    public void setOnPullEventListener(a<T> aVar) {
        this.aDc = aVar;
    }

    public final void setOnRefreshListener(b<T> bVar) {
        this.aDa = bVar;
        this.aDb = null;
    }

    public final void setOnRefreshListener(c<T> cVar) {
        this.aDb = cVar;
        this.aDa = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.aCU = z;
    }

    public final void setRefreshing(boolean z) {
        if (!Go()) {
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
        f(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.aCW = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.aCR = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(State state, boolean... zArr) {
        this.aCM = state;
        switch (Gs()[this.aCM.ordinal()]) {
            case 1:
                onReset();
                break;
            case 2:
                onPullToRefresh();
                break;
            case 3:
                onReleaseToRefresh();
                break;
            case 4:
            case 5:
                bU(zArr[0]);
                break;
        }
        if (this.aDc != null) {
            this.aDc.a(this, this.aCM, this.aCO);
        }
    }

    protected final void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void a(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.a.b a(Context context, Mode mode, TypedArray typedArray) {
        com.baidu.tbadk.widget.pulltorefresh.library.a.b createLoadingLayout = this.aCX.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected com.baidu.tbadk.widget.pulltorefresh.library.b g(boolean z, boolean z2) {
        com.baidu.tbadk.widget.pulltorefresh.library.b bVar = new com.baidu.tbadk.widget.pulltorefresh.library.b();
        if (z && this.aCN.showHeaderLoadingLayout()) {
            bVar.a(this.aCY);
        }
        if (z2 && this.aCN.showFooterLoadingLayout()) {
            bVar.a(this.aCZ);
        }
        return bVar;
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getFooterLayout() {
        return this.aCZ;
    }

    protected final int getFooterSize() {
        return this.aCZ.getContentSize();
    }

    protected final com.baidu.tbadk.widget.pulltorefresh.library.a.b getHeaderLayout() {
        return this.aCY;
    }

    protected final int getHeaderSize() {
        return this.aCY.getContentSize();
    }

    protected int getPullToRefreshScrollDuration() {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.aCQ;
    }

    protected void a(TypedArray typedArray) {
    }

    protected void d(Bundle bundle) {
    }

    protected void e(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (Gt()[this.aCO.ordinal()]) {
            case 2:
                this.aCY.jH();
                return;
            case 3:
                this.aCZ.jH();
                return;
            default:
                return;
        }
    }

    protected void bU(boolean z) {
        if (this.aCN.showHeaderLoadingLayout()) {
            this.aCY.jp();
        }
        if (this.aCN.showFooterLoadingLayout()) {
            this.aCZ.jp();
        }
        if (z) {
            if (this.aCR) {
                com.baidu.tbadk.widget.pulltorefresh.library.d dVar = new com.baidu.tbadk.widget.pulltorefresh.library.d(this);
                switch (Gt()[this.aCO.ordinal()]) {
                    case 3:
                    case 5:
                        a(getFooterSize(), dVar);
                        return;
                    case 4:
                    default:
                        a(-getHeaderSize(), dVar);
                        return;
                }
            }
            eZ(0);
            return;
        }
        jL();
    }

    protected void onReleaseToRefresh() {
        switch (Gt()[this.aCO.ordinal()]) {
            case 2:
                this.aCY.jo();
                return;
            case 3:
                this.aCZ.jo();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.aCV = true;
        this.aCY.reset();
        this.aCZ.reset();
        eZ(0);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.aCO = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.aCS = bundle.getBoolean("ptr_disable_scrolling", false);
            this.aCR = bundle.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
            State mapIntToValue = State.mapIntToValue(bundle.getInt("ptr_state", 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                a(mapIntToValue, true);
            }
            d(bundle);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        e(bundle);
        bundle.putInt("ptr_state", this.aCM.getIntValue());
        bundle.putInt("ptr_mode", this.aCN.getIntValue());
        bundle.putInt("ptr_current_mode", this.aCO.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.aCS);
        bundle.putBoolean("ptr_show_refreshing_view", this.aCR);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Gq();
        refreshRefreshableViewSize(i, i2);
        post(new com.baidu.tbadk.widget.pulltorefresh.library.e(this));
    }

    protected final void Gq() {
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
        switch (Gl()[getPullToRefreshScrollDirection().ordinal()]) {
            case 1:
                if (this.aCN.showHeaderLoadingLayout()) {
                    this.aCY.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.aCN.showFooterLoadingLayout()) {
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                } else {
                    this.aCZ.setHeight(maximumPullScroll);
                    i6 = -maximumPullScroll;
                    i2 = i;
                    i3 = paddingRight;
                    i4 = paddingLeft;
                    break;
                }
            case 2:
                if (this.aCN.showHeaderLoadingLayout()) {
                    this.aCY.setWidth(maximumPullScroll);
                    i5 = -maximumPullScroll;
                } else {
                    i5 = 0;
                }
                if (!this.aCN.showFooterLoadingLayout()) {
                    i4 = i5;
                    i3 = 0;
                    i6 = paddingBottom;
                    i2 = paddingTop;
                    break;
                } else {
                    this.aCZ.setWidth(maximumPullScroll);
                    i4 = i5;
                    i3 = -maximumPullScroll;
                    i6 = paddingBottom;
                    i2 = paddingTop;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aCQ.getLayoutParams();
        switch (Gl()[getPullToRefreshScrollDirection().ordinal()]) {
            case 1:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.aCQ.requestLayout();
                    return;
                }
                return;
            case 2:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.aCQ.requestLayout();
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
        if (this.aCV) {
            if (min < 0) {
                this.aCY.setVisibility(0);
            } else if (min > 0) {
                this.aCZ.setVisibility(0);
            } else {
                this.aCY.setVisibility(4);
                this.aCZ.setVisibility(4);
            }
        }
        switch (Gl()[getPullToRefreshScrollDirection().ordinal()]) {
            case 1:
                scrollTo(0, min);
                return;
            case 2:
                scrollTo(min, 0);
                return;
            default:
                return;
        }
    }

    protected final void eZ(int i) {
        c(i, getPullToRefreshScrollDuration());
    }

    protected final void a(int i, d dVar) {
        a(i, getPullToRefreshScrollDuration(), 0L, dVar);
    }

    protected void jK() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.aCY.getParent()) {
            removeView(this.aCY);
        }
        if (this.aCN.showHeaderLoadingLayout()) {
            a(this.aCY, 0, loadingLayoutLayoutParams);
        }
        if (this == this.aCZ.getParent()) {
            removeView(this.aCZ);
        }
        if (this.aCN.showFooterLoadingLayout()) {
            a(this.aCZ, loadingLayoutLayoutParams);
        }
        Gq();
        this.aCO = this.aCN != Mode.BOTH ? this.aCN : Mode.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.aCQ = new FrameLayout(context);
        this.aCQ.addView(t, -1, -1);
        a(this.aCQ, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jL() {
        if (this.aDa != null) {
            this.aDa.c(this);
        } else if (this.aDb != null) {
            if (this.aCO == Mode.PULL_FROM_START) {
                this.aDb.d(this);
            } else if (this.aCO == Mode.PULL_FROM_END) {
                this.aDb.e(this);
            }
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        switch (Gl()[getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
                setOrientation(0);
                break;
            default:
                setOrientation(1);
                break;
        }
        setGravity(17);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.l.PullToRefresh);
        if (obtainStyledAttributes.hasValue(4)) {
            this.aCN = Mode.mapIntToValue(obtainStyledAttributes.getInteger(4, 0));
        }
        if (obtainStyledAttributes.hasValue(12)) {
            this.aCX = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(12, 0));
        }
        this.aCP = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.aCP);
        this.aCY = a(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.aCZ = a(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(0)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            if (drawable != null) {
                this.aCP.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(16)) {
            com.baidu.tbadk.widget.pulltorefresh.library.a.d.au("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(16);
            if (drawable2 != null) {
                this.aCP.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(9)) {
            this.aCU = obtainStyledAttributes.getBoolean(9, true);
        }
        if (obtainStyledAttributes.hasValue(13)) {
            this.aCS = obtainStyledAttributes.getBoolean(13, false);
        }
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        jK();
    }

    private boolean jM() {
        switch (Gt()[this.aCN.ordinal()]) {
            case 2:
                return jN();
            case 3:
                return jO();
            case 4:
                return jO() || jN();
            default:
                return false;
        }
    }

    private void Gr() {
        float f;
        float f2;
        int round;
        int footerSize;
        switch (Gl()[getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
                f = this.mInitialMotionX;
                f2 = this.mLastMotionX;
                break;
            default:
                f = this.mInitialMotionY;
                f2 = this.mLastMotionY;
                break;
        }
        switch (Gt()[this.aCO.ordinal()]) {
            case 3:
                round = Math.round(Math.max(f - f2, 0.0f) / 2.0f);
                footerSize = getFooterSize();
                break;
            default:
                round = Math.round(Math.min(f - f2, 0.0f) / 2.0f);
                footerSize = getHeaderSize();
                break;
        }
        setHeaderScroll(round);
        if (round != 0 && !Go()) {
            float abs = Math.abs(round) / footerSize;
            switch (Gt()[this.aCO.ordinal()]) {
                case 3:
                    this.aCZ.onPull(abs);
                    break;
                default:
                    this.aCY.onPull(abs);
                    break;
            }
            if (this.aCM != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                a(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.aCM == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
                a(State.RELEASE_TO_REFRESH, new boolean[0]);
            }
        }
    }

    private LinearLayout.LayoutParams getLoadingLayoutLayoutParams() {
        switch (Gl()[getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
                return new LinearLayout.LayoutParams(-2, -1);
            default:
                return new LinearLayout.LayoutParams(-1, -2);
        }
    }

    private int getMaximumPullScroll() {
        switch (Gl()[getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
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
        if (this.aDd != null) {
            this.aDd.stop();
        }
        switch (Gl()[getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
                scrollX = getScrollX();
                break;
            default:
                scrollX = getScrollY();
                break;
        }
        if (scrollX != i) {
            if (this.aCW == null) {
                this.aCW = new DecelerateInterpolator();
            }
            this.aDd = new e(scrollX, i, j, dVar);
            if (j2 > 0) {
                postDelayed(this.aDd, j2);
            } else {
                post(this.aDd);
            }
        }
    }

    /* loaded from: classes.dex */
    public enum AnimationStyle {
        ROTATE,
        FLIP;
        
        private static /* synthetic */ int[] aDh;

        /* JADX DEBUG: Replace access to removed values field (aDi) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static AnimationStyle[] valuesCustom() {
            AnimationStyle[] valuesCustom = values();
            int length = valuesCustom.length;
            AnimationStyle[] animationStyleArr = new AnimationStyle[length];
            System.arraycopy(valuesCustom, 0, animationStyleArr, 0, length);
            return animationStyleArr;
        }

        static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$tbadk$widget$pulltorefresh$library$PullToRefreshBase$AnimationStyle() {
            int[] iArr = aDh;
            if (iArr == null) {
                iArr = new int[valuesCustom().length];
                try {
                    iArr[FLIP.ordinal()] = 2;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[ROTATE.ordinal()] = 1;
                } catch (NoSuchFieldError e2) {
                }
                aDh = iArr;
            }
            return iArr;
        }

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
            switch ($SWITCH_TABLE$com$baidu$tbadk$widget$pulltorefresh$library$PullToRefreshBase$AnimationStyle()[ordinal()]) {
                case 2:
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

        /* JADX DEBUG: Replace access to removed values field (aDj) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Mode[] valuesCustom() {
            Mode[] valuesCustom = values();
            int length = valuesCustom.length;
            Mode[] modeArr = new Mode[length];
            System.arraycopy(valuesCustom, 0, modeArr, 0, length);
            return modeArr;
        }

        static Mode mapIntToValue(int i) {
            Mode[] valuesCustom;
            for (Mode mode : valuesCustom()) {
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

        /* JADX DEBUG: Replace access to removed values field (aDr) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] valuesCustom = values();
            int length = valuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(valuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }

        static State mapIntToValue(int i) {
            State[] valuesCustom;
            for (State state : valuesCustom()) {
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
        private final int aDl;
        private final int aDm;
        private final long aDn;
        private d aDo;
        private final Interpolator mInterpolator;
        private boolean aDp = true;
        private long mStartTime = -1;
        private int aDq = -1;

        public e(int i, int i2, long j, d dVar) {
            this.aDm = i;
            this.aDl = i2;
            this.mInterpolator = PullToRefreshBase.this.aCW;
            this.aDn = j;
            this.aDo = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aDq = this.aDm - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.aDn, 1000L), 0L)) / 1000.0f) * (this.aDm - this.aDl));
                PullToRefreshBase.this.setHeaderScroll(this.aDq);
            }
            if (this.aDp && this.aDl != this.aDq) {
                com.baidu.tbadk.widget.pulltorefresh.library.a.e.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.aDo != null) {
                this.aDo.Gu();
            }
        }

        public void stop() {
            this.aDp = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }
}
