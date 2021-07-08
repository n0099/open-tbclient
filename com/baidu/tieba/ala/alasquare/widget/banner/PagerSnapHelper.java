package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.v.d.h.a.d;
/* loaded from: classes4.dex */
public class PagerSnapHelper extends SnapHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public d f14188c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public d f14189d;

    /* loaded from: classes4.dex */
    public class a extends LinearSmoothScroller {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PagerSnapHelper f14190a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PagerSnapHelper pagerSnapHelper, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSnapHelper, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14190a = pagerSnapHelper;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, displayMetrics)) == null) ? 100.0f / displayMetrics.densityDpi : invokeL.floatValue;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? Math.min(100, super.calculateTimeForScrolling(i2)) : invokeI.intValue;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view, state, action) == null) {
                PagerSnapHelper pagerSnapHelper = this.f14190a;
                int[] calculateDistanceToFinalSnap = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.f14191a.getLayoutManager(), view);
                int i2 = calculateDistanceToFinalSnap[0];
                int i3 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i2), Math.abs(i3)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(i2, i3, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        }
    }

    public PagerSnapHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final int a(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view, d dVar) {
        InterceptResult invokeLLL;
        int e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutManager, view, dVar)) == null) {
            int d2 = dVar.d(view) + (dVar.c(view) / 2);
            if (layoutManager.getClipToPadding()) {
                e2 = dVar.f() + (dVar.g() / 2);
            } else {
                e2 = dVar.e() / 2;
            }
            return d2 - e2;
        }
        return invokeLLL.intValue;
    }

    @Nullable
    public final View b(RecyclerView.LayoutManager layoutManager, d dVar) {
        InterceptResult invokeLL;
        int e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutManager, dVar)) == null) {
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
        return (View) invokeLL.objValue;
    }

    @Nullable
    public final View c(RecyclerView.LayoutManager layoutManager, d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, layoutManager, dVar)) == null) {
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
        return (View) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.widget.banner.SnapHelper
    @Nullable
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, layoutManager, view)) == null) {
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
        return (int[]) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.widget.banner.SnapHelper
    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, layoutManager)) == null) {
            if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
                return new a(this, this.f14191a.getContext());
            }
            return null;
        }
        return (LinearSmoothScroller) invokeL.objValue;
    }

    @NonNull
    public final d d(@NonNull RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, layoutManager)) == null) {
            d dVar = this.f14189d;
            if (dVar == null || dVar.f64654a != layoutManager) {
                this.f14189d = d.a(layoutManager);
            }
            return this.f14189d;
        }
        return (d) invokeL.objValue;
    }

    @NonNull
    public final d e(@NonNull RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, layoutManager)) == null) {
            d dVar = this.f14188c;
            if (dVar == null || dVar.f64654a != layoutManager) {
                this.f14188c = d.b(layoutManager);
            }
            return this.f14188c;
        }
        return (d) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.widget.banner.SnapHelper
    @Nullable
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, layoutManager)) == null) {
            if (layoutManager.canScrollVertically()) {
                return b(layoutManager, e(layoutManager));
            }
            if (layoutManager.canScrollHorizontally()) {
                return b(layoutManager, d(layoutManager));
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.widget.banner.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        InterceptResult invokeLII;
        int position;
        PointF computeScrollVectorForPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutManager, i2, i3)) == null) {
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
        return invokeLII.intValue;
    }
}
