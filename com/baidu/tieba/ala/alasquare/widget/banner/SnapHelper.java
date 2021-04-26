package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes4.dex */
public abstract class SnapHelper extends RecyclerView.OnFlingListener {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f14708a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView.OnScrollListener f14709b = new a();

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f14710a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0 && this.f14710a) {
                this.f14710a = false;
                SnapHelper.this.snapToTargetExistingView();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            if (i2 == 0 && i3 == 0) {
                return;
            }
            this.f14710a = true;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends LinearSmoothScroller {
        public b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            SnapHelper snapHelper = SnapHelper.this;
            int[] calculateDistanceToFinalSnap = snapHelper.calculateDistanceToFinalSnap(snapHelper.f14708a.getLayoutManager(), view);
            int i2 = calculateDistanceToFinalSnap[0];
            int i3 = calculateDistanceToFinalSnap[1];
            int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i2), Math.abs(i3)));
            if (calculateTimeForDeceleration > 0) {
                action.update(i2, i3, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f14708a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.f14708a = recyclerView;
        if (recyclerView != null) {
            setupCallbacks();
            new Scroller(this.f14708a.getContext(), new DecelerateInterpolator());
            snapToTargetExistingView();
        }
    }

    @Nullable
    public abstract int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view);

    @Nullable
    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new b(this.f14708a.getContext());
        }
        return null;
    }

    public final void destroyCallbacks() {
        this.f14708a.removeOnScrollListener(this.f14709b);
        this.f14708a.setOnFlingListener(null);
    }

    @Nullable
    public abstract View findSnapView(RecyclerView.LayoutManager layoutManager);

    public abstract int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i2, int i3);

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean onFling(int i2, int i3) {
        RecyclerView.LayoutManager layoutManager = this.f14708a.getLayoutManager();
        if (layoutManager == null || this.f14708a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f14708a.getMinFlingVelocity();
        return (Math.abs(i3) > minFlingVelocity || Math.abs(i2) > minFlingVelocity) && snapFromFling(layoutManager, i2, i3);
    }

    public final void setupCallbacks() throws IllegalStateException {
        if (this.f14708a.getOnFlingListener() == null) {
            this.f14708a.addOnScrollListener(this.f14709b);
            this.f14708a.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    public final boolean snapFromFling(@NonNull RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        LinearSmoothScroller createSnapScroller;
        int findTargetSnapPosition;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (createSnapScroller = createSnapScroller(layoutManager)) == null || (findTargetSnapPosition = findTargetSnapPosition(layoutManager, i2, i3)) == -1) {
            return false;
        }
        createSnapScroller.setTargetPosition(findTargetSnapPosition);
        layoutManager.startSmoothScroll(createSnapScroller);
        return true;
    }

    public void snapToTargetExistingView() {
        RecyclerView.LayoutManager layoutManager;
        View findSnapView;
        RecyclerView recyclerView = this.f14708a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (findSnapView = findSnapView(layoutManager)) == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, findSnapView);
        if (calculateDistanceToFinalSnap[0] == 0 && calculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.f14708a.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
    }
}
