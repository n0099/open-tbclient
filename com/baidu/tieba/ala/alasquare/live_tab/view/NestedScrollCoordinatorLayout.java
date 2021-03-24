package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
/* loaded from: classes4.dex */
public class NestedScrollCoordinatorLayout extends CoordinatorLayout implements NestedScrollingChild {

    /* renamed from: e  reason: collision with root package name */
    public NestedScrollingChildHelper f14803e;

    /* renamed from: f  reason: collision with root package name */
    public a f14804f;

    /* loaded from: classes4.dex */
    public static class a<DummyView extends View> extends CoordinatorLayout.Behavior<DummyView> {

        /* renamed from: a  reason: collision with root package name */
        public int f14805a = 1;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f14806b = new int[2];

        public void a(int i) {
            this.f14805a = i;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DummyView dummyview, @NonNull View view, float f2, float f3) {
            boolean dispatchNestedPreFling = ((NestedScrollCoordinatorLayout) coordinatorLayout).dispatchNestedPreFling(f2, f3);
            if (this.f14805a == 1) {
                return dispatchNestedPreFling;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DummyView dummyview, @NonNull View view, int i, int i2, @NonNull int[] iArr, int i3) {
            NestedScrollCoordinatorLayout nestedScrollCoordinatorLayout = (NestedScrollCoordinatorLayout) coordinatorLayout;
            int i4 = this.f14805a;
            if (i4 == 1) {
                nestedScrollCoordinatorLayout.dispatchNestedPreScroll(i, i2, iArr, null);
            } else if (i4 == 0) {
                int[] iArr2 = this.f14806b;
                iArr2[0] = iArr[0];
                iArr2[1] = iArr[1];
                nestedScrollCoordinatorLayout.dispatchNestedPreScroll(i, i2, iArr2, null);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DummyView dummyview, @NonNull View view, @NonNull View view2, int i, int i2) {
            return ((NestedScrollCoordinatorLayout) coordinatorLayout).startNestedScroll(i);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DummyView dummyview, @NonNull View view, int i) {
            ((NestedScrollCoordinatorLayout) coordinatorLayout).stopNestedScroll();
        }
    }

    public NestedScrollCoordinatorLayout(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f14803e = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        View view = new View(getContext());
        this.f14804f = new a();
        ViewCompat.setElevation(view, ViewCompat.getElevation(this));
        view.setFitsSystemWindows(false);
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        layoutParams.setBehavior(this.f14804f);
        addView(view, layoutParams);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.f14803e.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f14803e.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, @Nullable @Size(2) int[] iArr, @Nullable @Size(2) int[] iArr2) {
        return this.f14803e.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable @Size(2) int[] iArr) {
        return this.f14803e.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.f14803e.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f14803e.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.f14803e.setNestedScrollingEnabled(z);
    }

    public void setPassMode(int i) {
        a aVar = this.f14804f;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.f14803e.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.f14803e.stopNestedScroll();
    }

    public NestedScrollCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public NestedScrollCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
