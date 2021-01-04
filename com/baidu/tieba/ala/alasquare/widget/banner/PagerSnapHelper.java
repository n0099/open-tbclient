package com.baidu.tieba.ala.alasquare.widget.banner;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes10.dex */
public class PagerSnapHelper extends SnapHelper {
    @Nullable
    private d gMA;
    @Nullable
    private d gMz;

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
            iArr[1] = a(layoutManager, view, c(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // com.baidu.tieba.ala.alasquare.widget.banner.SnapHelper
    @Nullable
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return a(layoutManager, c(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return a(layoutManager, d(layoutManager));
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.alasquare.widget.banner.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        int position;
        boolean z;
        PointF computeScrollVectorForPosition;
        boolean z2 = false;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View view = null;
        if (layoutManager.canScrollVertically()) {
            view = b(layoutManager, c(layoutManager));
        } else if (layoutManager.canScrollHorizontally()) {
            view = b(layoutManager, d(layoutManager));
        }
        if (view == null || (position = layoutManager.getPosition(view)) == -1) {
            return -1;
        }
        if (layoutManager.canScrollHorizontally()) {
            z = i > 0;
        } else {
            z = i2 > 0;
        }
        if ((layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) && (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) != null && (computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f)) {
            z2 = true;
        }
        return z2 ? z ? position - 1 : position : z ? position + 1 : position;
    }

    @Override // com.baidu.tieba.ala.alasquare.widget.banner.SnapHelper
    protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new LinearSmoothScroller(this.mRecyclerView.getContext()) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.PagerSnapHelper.1
                @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                    int[] calculateDistanceToFinalSnap = PagerSnapHelper.this.calculateDistanceToFinalSnap(PagerSnapHelper.this.mRecyclerView.getLayoutManager(), view);
                    int i = calculateDistanceToFinalSnap[0];
                    int i2 = calculateDistanceToFinalSnap[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                    if (calculateTimeForDeceleration > 0) {
                        action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                public int calculateTimeForScrolling(int i) {
                    return Math.min(100, super.calculateTimeForScrolling(i));
                }
            };
        }
        return null;
    }

    private int a(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view, d dVar) {
        int end;
        int decoratedMeasurement = (dVar.getDecoratedMeasurement(view) / 2) + dVar.getDecoratedStart(view);
        if (layoutManager.getClipToPadding()) {
            end = dVar.getStartAfterPadding() + (dVar.getTotalSpace() / 2);
        } else {
            end = dVar.getEnd() / 2;
        }
        return decoratedMeasurement - end;
    }

    @Nullable
    private View a(RecyclerView.LayoutManager layoutManager, d dVar) {
        int end;
        View view = null;
        int childCount = layoutManager.getChildCount();
        if (childCount != 0) {
            if (layoutManager.getClipToPadding()) {
                end = dVar.getStartAfterPadding() + (dVar.getTotalSpace() / 2);
            } else {
                end = dVar.getEnd() / 2;
            }
            int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = layoutManager.getChildAt(i2);
                int abs = Math.abs((dVar.getDecoratedStart(childAt) + (dVar.getDecoratedMeasurement(childAt) / 2)) - end);
                if (abs >= i) {
                    abs = i;
                    childAt = view;
                }
                i2++;
                i = abs;
                view = childAt;
            }
        }
        return view;
    }

    @Nullable
    private View b(RecyclerView.LayoutManager layoutManager, d dVar) {
        View view = null;
        int childCount = layoutManager.getChildCount();
        if (childCount != 0) {
            int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = layoutManager.getChildAt(i2);
                int decoratedStart = dVar.getDecoratedStart(childAt);
                if (decoratedStart >= i) {
                    decoratedStart = i;
                    childAt = view;
                }
                i2++;
                i = decoratedStart;
                view = childAt;
            }
        }
        return view;
    }

    @NonNull
    private d c(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (this.gMz == null || this.gMz.mLayoutManager != layoutManager) {
            this.gMz = d.b(layoutManager);
        }
        return this.gMz;
    }

    @NonNull
    private d d(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (this.gMA == null || this.gMA.mLayoutManager != layoutManager) {
            this.gMA = d.a(layoutManager);
        }
        return this.gMA;
    }
}
