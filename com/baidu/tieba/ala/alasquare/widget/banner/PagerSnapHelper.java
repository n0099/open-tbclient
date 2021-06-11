package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import d.a.n0.v.d.h.a.d;
/* loaded from: classes4.dex */
public class PagerSnapHelper extends SnapHelper {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public d f13980c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public d f13981d;

    /* loaded from: classes4.dex */
    public class a extends LinearSmoothScroller {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int i2) {
            return Math.min(100, super.calculateTimeForScrolling(i2));
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
            int[] calculateDistanceToFinalSnap = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.f13983a.getLayoutManager(), view);
            int i2 = calculateDistanceToFinalSnap[0];
            int i3 = calculateDistanceToFinalSnap[1];
            int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i2), Math.abs(i3)));
            if (calculateTimeForDeceleration > 0) {
                action.update(i2, i3, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    public final int a(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view, d dVar) {
        int e2;
        int d2 = dVar.d(view) + (dVar.c(view) / 2);
        if (layoutManager.getClipToPadding()) {
            e2 = dVar.f() + (dVar.g() / 2);
        } else {
            e2 = dVar.e() / 2;
        }
        return d2 - e2;
    }

    @Nullable
    public final View b(RecyclerView.LayoutManager layoutManager, d dVar) {
        int e2;
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        if (layoutManager.getClipToPadding()) {
            e2 = dVar.f() + (dVar.g() / 2);
        } else {
            e2 = dVar.e() / 2;
        }
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            int abs = Math.abs((dVar.d(childAt) + (dVar.c(childAt) / 2)) - e2);
            if (abs < i2) {
                view = childAt;
                i2 = abs;
            }
        }
        return view;
    }

    @Nullable
    public final View c(RecyclerView.LayoutManager layoutManager, d dVar) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            int d2 = dVar.d(childAt);
            if (d2 < i2) {
                view = childAt;
                i2 = d2;
            }
        }
        return view;
    }

    @Override // com.baidu.tieba.ala.alasquare.widget.banner.SnapHelper
    @Nullable
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = a(layoutManager, view, d(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = a(layoutManager, view, e(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // com.baidu.tieba.ala.alasquare.widget.banner.SnapHelper
    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new a(this.f13983a.getContext());
        }
        return null;
    }

    @NonNull
    public final d d(@NonNull RecyclerView.LayoutManager layoutManager) {
        d dVar = this.f13981d;
        if (dVar == null || dVar.f65569a != layoutManager) {
            this.f13981d = d.a(layoutManager);
        }
        return this.f13981d;
    }

    @NonNull
    public final d e(@NonNull RecyclerView.LayoutManager layoutManager) {
        d dVar = this.f13980c;
        if (dVar == null || dVar.f65569a != layoutManager) {
            this.f13980c = d.b(layoutManager);
        }
        return this.f13980c;
    }

    @Override // com.baidu.tieba.ala.alasquare.widget.banner.SnapHelper
    @Nullable
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return b(layoutManager, e(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return b(layoutManager, d(layoutManager));
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.alasquare.widget.banner.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        int position;
        PointF computeScrollVectorForPosition;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View view = null;
        if (layoutManager.canScrollVertically()) {
            view = c(layoutManager, e(layoutManager));
        } else if (layoutManager.canScrollHorizontally()) {
            view = c(layoutManager, d(layoutManager));
        }
        if (view == null || (position = layoutManager.getPosition(view)) == -1) {
            return -1;
        }
        boolean z = false;
        boolean z2 = !layoutManager.canScrollHorizontally() ? i3 <= 0 : i2 <= 0;
        if ((layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) && (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) != null && (computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f)) {
            z = true;
        }
        return z ? z2 ? position - 1 : position : z2 ? position + 1 : position;
    }
}
