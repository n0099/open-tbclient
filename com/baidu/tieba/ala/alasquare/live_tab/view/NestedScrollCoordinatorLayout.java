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
    public NestedScrollingChildHelper f13861e;

    /* renamed from: f  reason: collision with root package name */
    public a f13862f;

    /* loaded from: classes4.dex */
    public static class a<DummyView extends View> extends CoordinatorLayout.Behavior<DummyView> {

        /* renamed from: a  reason: collision with root package name */
        public int f13863a = 1;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f13864b = new int[2];

        public void a(int i2) {
            this.f13863a = i2;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DummyView dummyview, @NonNull View view, float f2, float f3) {
            boolean dispatchNestedPreFling = ((NestedScrollCoordinatorLayout) coordinatorLayout).dispatchNestedPreFling(f2, f3);
            if (this.f13863a == 1) {
                return dispatchNestedPreFling;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DummyView dummyview, @NonNull View view, int i2, int i3, @NonNull int[] iArr, int i4) {
            NestedScrollCoordinatorLayout nestedScrollCoordinatorLayout = (NestedScrollCoordinatorLayout) coordinatorLayout;
            int i5 = this.f13863a;
            if (i5 == 1) {
                nestedScrollCoordinatorLayout.dispatchNestedPreScroll(i2, i3, iArr, null);
            } else if (i5 == 0) {
                int[] iArr2 = this.f13864b;
                iArr2[0] = iArr[0];
                iArr2[1] = iArr[1];
                nestedScrollCoordinatorLayout.dispatchNestedPreScroll(i2, i3, iArr2, null);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DummyView dummyview, @NonNull View view, @NonNull View view2, int i2, int i3) {
            return ((NestedScrollCoordinatorLayout) coordinatorLayout).startNestedScroll(i2);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DummyView dummyview, @NonNull View view, int i2) {
            ((NestedScrollCoordinatorLayout) coordinatorLayout).stopNestedScroll();
        }
    }

    public NestedScrollCoordinatorLayout(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f13861e = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        View view = new View(getContext());
        this.f13862f = new a();
        ViewCompat.setElevation(view, ViewCompat.getElevation(this));
        view.setFitsSystemWindows(false);
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        layoutParams.setBehavior(this.f13862f);
        addView(view, layoutParams);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.f13861e.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f13861e.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, @Nullable @Size(2) int[] iArr, @Nullable @Size(2) int[] iArr2) {
        return this.f13861e.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, @Nullable @Size(2) int[] iArr) {
        return this.f13861e.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.f13861e.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f13861e.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.f13861e.setNestedScrollingEnabled(z);
    }

    public void setPassMode(int i2) {
        a aVar = this.f13862f;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.f13861e.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.f13861e.stopNestedScroll();
    }

    public NestedScrollCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public NestedScrollCoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
