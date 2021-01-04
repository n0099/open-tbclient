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
/* loaded from: classes10.dex */
public class NestedScrollCoordinatorLayout extends CoordinatorLayout implements NestedScrollingChild {
    private static final String TAG = NestedScrollCoordinatorLayout.class.getSimpleName();
    private NestedScrollingChildHelper gFP;
    private a gFQ;

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
        this.gFP = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        View view = new View(getContext());
        this.gFQ = new a();
        ViewCompat.setElevation(view, ViewCompat.getElevation(this));
        view.setFitsSystemWindows(false);
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        layoutParams.setBehavior(this.gFQ);
        addView(view, layoutParams);
    }

    public void setPassMode(int i) {
        if (this.gFQ != null) {
            this.gFQ.setPassMode(i);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.gFP.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.gFP.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.gFP.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.gFP.stopNestedScroll();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.gFP.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable @Size(2) int[] iArr) {
        return this.gFP.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, @Nullable @Size(2) int[] iArr, @Nullable @Size(2) int[] iArr2) {
        return this.gFP.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.gFP.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.gFP.dispatchNestedPreFling(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a<DummyView extends View> extends CoordinatorLayout.Behavior<DummyView> {
        private int mode = 1;
        private final int[] gFR = new int[2];

        a() {
        }

        void setPassMode(int i) {
            this.mode = i;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DummyView dummyview, @NonNull View view, @NonNull View view2, int i, int i2) {
            return ((NestedScrollCoordinatorLayout) coordinatorLayout).startNestedScroll(i);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DummyView dummyview, @NonNull View view, int i) {
            ((NestedScrollCoordinatorLayout) coordinatorLayout).stopNestedScroll();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DummyView dummyview, @NonNull View view, int i, int i2, @NonNull int[] iArr, int i3) {
            NestedScrollCoordinatorLayout nestedScrollCoordinatorLayout = (NestedScrollCoordinatorLayout) coordinatorLayout;
            if (this.mode == 1) {
                nestedScrollCoordinatorLayout.dispatchNestedPreScroll(i, i2, iArr, null);
            } else if (this.mode == 0) {
                this.gFR[0] = iArr[0];
                this.gFR[1] = iArr[1];
                nestedScrollCoordinatorLayout.dispatchNestedPreScroll(i, i2, this.gFR, null);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DummyView dummyview, @NonNull View view, float f, float f2) {
            boolean dispatchNestedPreFling = ((NestedScrollCoordinatorLayout) coordinatorLayout).dispatchNestedPreFling(f, f2);
            if (this.mode == 1) {
                return dispatchNestedPreFling;
            }
            return false;
        }
    }
}
