package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.RequiresApi;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import com.baidu.tbadk.core.hybrid.ScrollBridgeWebview;
/* loaded from: classes3.dex */
public class NestedScrollWebView extends ScrollBridgeWebview implements NestedScrollingChild2 {

    /* renamed from: g  reason: collision with root package name */
    public final int[] f12810g;

    /* renamed from: h  reason: collision with root package name */
    public final int[] f12811h;

    /* renamed from: i  reason: collision with root package name */
    public int f12812i;
    public VelocityTracker j;
    public int k;
    public int l;
    public OverScroller m;
    public int n;
    public NestedScrollingChildHelper o;

    @RequiresApi(api = 9)
    public NestedScrollWebView(Context context) {
        super(context);
        this.f12810g = new int[2];
        this.f12811h = new int[2];
        init();
    }

    @RequiresApi(api = 9)
    public void a(int i2) {
        startNestedScroll(2, 1);
        this.m.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        this.n = getScrollY();
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public final void b() {
        if (this.j == null) {
            this.j = VelocityTracker.obtain();
        }
    }

    public final void c() {
        VelocityTracker velocityTracker = this.j;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.j = null;
        }
    }

    @Override // android.webkit.WebView, android.view.View
    @RequiresApi(api = 9)
    public void computeScroll() {
        int i2;
        int i3;
        super.computeScroll();
        if (this.m.computeScrollOffset()) {
            this.m.getCurrX();
            int currY = this.m.getCurrY();
            int i4 = currY - this.n;
            if (i4 != 0) {
                int scrollY = getScrollY();
                if (scrollY == 0) {
                    i3 = i4;
                    i2 = 0;
                } else {
                    int i5 = scrollY + i4;
                    if (i5 < 0) {
                        i2 = -scrollY;
                        i3 = i5;
                    } else {
                        i2 = i4;
                        i3 = 0;
                    }
                }
                dispatchNestedScroll(0, i2, 0, i3, null, 1);
            }
            this.n = currY;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        if (hasNestedScrollingParent(1)) {
            stopNestedScroll(1);
        }
        this.n = 0;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.o.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.o.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.o.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.o.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.o.hasNestedScrollingParent();
    }

    @RequiresApi(api = 9)
    public final void init() {
        this.o = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.m = new OverScroller(getContext());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.k = viewConfiguration.getScaledMinimumFlingVelocity();
        this.l = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.o.isNestedScrollingEnabled();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
        if (r1 != 3) goto L8;
     */
    @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview, android.webkit.WebView, android.view.View
    @RequiresApi(api = 9)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        b();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int rawY = (int) motionEvent.getRawY();
                    int i3 = this.f12812i - rawY;
                    if (dispatchNestedPreScroll(0, i3, this.f12810g, this.f12811h)) {
                        obtain.offsetLocation(0.0f, this.f12810g[1]);
                    }
                    this.f12812i = rawY;
                    int scrollY = getScrollY();
                    if (scrollY == 0) {
                        i2 = i3;
                    } else {
                        int i4 = scrollY + i3;
                        if (i4 < 0) {
                            obtain.offsetLocation(0.0f, -i4);
                            i2 = i4;
                        } else {
                            i2 = 0;
                        }
                    }
                    this.j.addMovement(obtain);
                    boolean onTouchEvent = super.onTouchEvent(obtain);
                    dispatchNestedScroll(0, i3 - i2, 0, i2, this.f12811h);
                    return onTouchEvent;
                }
            }
            VelocityTracker velocityTracker = this.j;
            velocityTracker.computeCurrentVelocity(1000, this.l);
            int yVelocity = (int) velocityTracker.getYVelocity();
            if (Math.abs(yVelocity) > this.k) {
                a(-yVelocity);
            }
            stopNestedScroll();
            c();
        } else {
            this.f12812i = (int) motionEvent.getRawY();
            startNestedScroll(2);
            this.j.addMovement(obtain);
            this.m.computeScrollOffset();
            if (!this.m.isFinished()) {
                this.m.abortAnimation();
            }
        }
        return super.onTouchEvent(obtain);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.o.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.o.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.o.stopNestedScroll();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return this.o.dispatchNestedPreScroll(i2, i3, iArr, iArr2, i4);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return this.o.dispatchNestedScroll(i2, i3, i4, i5, iArr, i6);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i2) {
        return this.o.hasNestedScrollingParent(i2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i2, int i3) {
        return this.o.startNestedScroll(i2, i3);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i2) {
        this.o.stopNestedScroll(i2);
    }

    @RequiresApi(api = 9)
    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12810g = new int[2];
        this.f12811h = new int[2];
        init();
    }
}
