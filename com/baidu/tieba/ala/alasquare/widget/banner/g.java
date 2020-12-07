package com.baidu.tieba.ala.alasquare.widget.banner;

import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
/* loaded from: classes6.dex */
public class g extends h {
    @Nullable
    private f gAN;
    @Nullable
    private f gAO;

    @Override // com.baidu.tieba.ala.alasquare.widget.banner.h
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

    @Override // com.baidu.tieba.ala.alasquare.widget.banner.h
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

    @Override // com.baidu.tieba.ala.alasquare.widget.banner.h
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

    @Override // com.baidu.tieba.ala.alasquare.widget.banner.h
    protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new LinearSmoothScroller(this.mRecyclerView.getContext()) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.g.1
                @Override // android.support.v7.widget.LinearSmoothScroller, android.support.v7.widget.RecyclerView.SmoothScroller
                protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                    int[] calculateDistanceToFinalSnap = g.this.calculateDistanceToFinalSnap(g.this.mRecyclerView.getLayoutManager(), view);
                    int i = calculateDistanceToFinalSnap[0];
                    int i2 = calculateDistanceToFinalSnap[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                    if (calculateTimeForDeceleration > 0) {
                        action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }

                @Override // android.support.v7.widget.LinearSmoothScroller
                protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.support.v7.widget.LinearSmoothScroller
                public int calculateTimeForScrolling(int i) {
                    return Math.min(100, super.calculateTimeForScrolling(i));
                }
            };
        }
        return null;
    }

    private int a(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view, f fVar) {
        int end;
        int decoratedMeasurement = (fVar.getDecoratedMeasurement(view) / 2) + fVar.getDecoratedStart(view);
        if (layoutManager.getClipToPadding()) {
            end = fVar.getStartAfterPadding() + (fVar.getTotalSpace() / 2);
        } else {
            end = fVar.getEnd() / 2;
        }
        return decoratedMeasurement - end;
    }

    @Nullable
    private View a(RecyclerView.LayoutManager layoutManager, f fVar) {
        int end;
        View view;
        View view2 = null;
        int childCount = layoutManager.getChildCount();
        if (childCount != 0) {
            if (layoutManager.getClipToPadding()) {
                end = fVar.getStartAfterPadding() + (fVar.getTotalSpace() / 2);
            } else {
                end = fVar.getEnd() / 2;
            }
            int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = layoutManager.getChildAt(i2);
                int abs = Math.abs((fVar.getDecoratedStart(childAt) + (fVar.getDecoratedMeasurement(childAt) / 2)) - end);
                if (abs < i) {
                    view = childAt;
                } else {
                    abs = i;
                    view = view2;
                }
                i2++;
                view2 = view;
                i = abs;
            }
        }
        return view2;
    }

    @Nullable
    private View b(RecyclerView.LayoutManager layoutManager, f fVar) {
        View view;
        View view2 = null;
        int childCount = layoutManager.getChildCount();
        if (childCount != 0) {
            int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = layoutManager.getChildAt(i2);
                int decoratedStart = fVar.getDecoratedStart(childAt);
                if (decoratedStart < i) {
                    view = childAt;
                } else {
                    decoratedStart = i;
                    view = view2;
                }
                i2++;
                view2 = view;
                i = decoratedStart;
            }
        }
        return view2;
    }

    @NonNull
    private f c(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (this.gAN == null || this.gAN.mLayoutManager != layoutManager) {
            this.gAN = f.b(layoutManager);
        }
        return this.gAN;
    }

    @NonNull
    private f d(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (this.gAO == null || this.gAO.mLayoutManager != layoutManager) {
            this.gAO = f.a(layoutManager);
        }
        return this.gAO;
    }
}
