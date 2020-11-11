package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes4.dex */
public class NestedScrollCoordinatorLayout extends CoordinatorLayout implements NestedScrollingChild {
    private static final String TAG = NestedScrollCoordinatorLayout.class.getSimpleName();
    private NestedScrollingChildHelper gmY;
    private a gmZ;

    public NestedScrollCoordinatorLayout(Context context) {
        super(context);
        i();
    }

    public NestedScrollCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i();
    }

    public NestedScrollCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        i();
    }

    private void i() {
        this.gmY = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        View view = new View(getContext());
        this.gmZ = new a();
        ViewCompat.setElevation(view, ViewCompat.getElevation(this));
        view.setFitsSystemWindows(false);
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        layoutParams.setBehavior(this.gmZ);
        addView(view, layoutParams);
    }

    public void setPassMode(int i) {
        if (this.gmZ != null) {
            this.gmZ.setPassMode(i);
        }
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.gmY.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.gmY.isNestedScrollingEnabled();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.gmY.startNestedScroll(i);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.gmY.stopNestedScroll();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.gmY.hasNestedScrollingParent();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @Size(2) @Nullable int[] iArr) {
        return this.gmY.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, @Size(2) @Nullable int[] iArr, @Size(2) @Nullable int[] iArr2) {
        return this.gmY.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.gmY.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.gmY.dispatchNestedPreFling(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a<DummyView extends View> extends CoordinatorLayout.Behavior<DummyView> {
        private int mode = 1;
        private final int[] gna = new int[2];

        a() {
        }

        void setPassMode(int i) {
            this.mode = i;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DummyView dummyview, @NonNull View view, @NonNull View view2, int i, int i2) {
            return ((NestedScrollCoordinatorLayout) coordinatorLayout).startNestedScroll(i);
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DummyView dummyview, @NonNull View view, int i) {
            ((NestedScrollCoordinatorLayout) coordinatorLayout).stopNestedScroll();
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DummyView dummyview, @NonNull View view, int i, int i2, @NonNull int[] iArr, int i3) {
            NestedScrollCoordinatorLayout nestedScrollCoordinatorLayout = (NestedScrollCoordinatorLayout) coordinatorLayout;
            if (this.mode == 1) {
                nestedScrollCoordinatorLayout.dispatchNestedPreScroll(i, i2, iArr, null);
            } else if (this.mode == 0) {
                this.gna[0] = iArr[0];
                this.gna[1] = iArr[1];
                nestedScrollCoordinatorLayout.dispatchNestedPreScroll(i, i2, this.gna, null);
            }
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DummyView dummyview, @NonNull View view, float f, float f2) {
            boolean dispatchNestedPreFling = ((NestedScrollCoordinatorLayout) coordinatorLayout).dispatchNestedPreFling(f, f2);
            if (this.mode == 1) {
                return dispatchNestedPreFling;
            }
            return false;
        }
    }
}
