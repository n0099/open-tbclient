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
import com.baidu.tieba.le6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PagerSnapHelper extends SnapHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public le6 c;
    @Nullable
    public le6 d;

    /* loaded from: classes5.dex */
    public class a extends LinearSmoothScroller {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PagerSnapHelper a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PagerSnapHelper pagerSnapHelper, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSnapHelper, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pagerSnapHelper;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, displayMetrics)) == null) {
                return 100.0f / displayMetrics.densityDpi;
            }
            return invokeL.floatValue;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return Math.min(100, super.calculateTimeForScrolling(i));
            }
            return invokeI.intValue;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(View view2, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view2, state, action) == null) {
                PagerSnapHelper pagerSnapHelper = this.a;
                int[] calculateDistanceToFinalSnap = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.a.getLayoutManager(), view2);
                int i = calculateDistanceToFinalSnap[0];
                int i2 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        }
    }

    public PagerSnapHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final int a(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view2, le6 le6Var) {
        InterceptResult invokeLLL;
        int e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutManager, view2, le6Var)) == null) {
            int d = le6Var.d(view2) + (le6Var.c(view2) / 2);
            if (layoutManager.getClipToPadding()) {
                e = le6Var.f() + (le6Var.g() / 2);
            } else {
                e = le6Var.e() / 2;
            }
            return d - e;
        }
        return invokeLLL.intValue;
    }

    @Nullable
    public final View b(RecyclerView.LayoutManager layoutManager, le6 le6Var) {
        InterceptResult invokeLL;
        int e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutManager, le6Var)) == null) {
            int childCount = layoutManager.getChildCount();
            View view2 = null;
            if (childCount == 0) {
                return null;
            }
            if (layoutManager.getClipToPadding()) {
                e = le6Var.f() + (le6Var.g() / 2);
            } else {
                e = le6Var.e() / 2;
            }
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = layoutManager.getChildAt(i2);
                int abs = Math.abs((le6Var.d(childAt) + (le6Var.c(childAt) / 2)) - e);
                if (abs < i) {
                    view2 = childAt;
                    i = abs;
                }
            }
            return view2;
        }
        return (View) invokeLL.objValue;
    }

    @Nullable
    public final View c(RecyclerView.LayoutManager layoutManager, le6 le6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, layoutManager, le6Var)) == null) {
            int childCount = layoutManager.getChildCount();
            View view2 = null;
            if (childCount == 0) {
                return null;
            }
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = layoutManager.getChildAt(i2);
                int d = le6Var.d(childAt);
                if (d < i) {
                    view2 = childAt;
                    i = d;
                }
            }
            return view2;
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.widget.banner.SnapHelper
    @Nullable
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, layoutManager, view2)) == null) {
            int[] iArr = new int[2];
            if (layoutManager.canScrollHorizontally()) {
                iArr[0] = a(layoutManager, view2, d(layoutManager));
            } else {
                iArr[0] = 0;
            }
            if (layoutManager.canScrollVertically()) {
                iArr[1] = a(layoutManager, view2, e(layoutManager));
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
            if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
                return null;
            }
            return new a(this, this.a.getContext());
        }
        return (LinearSmoothScroller) invokeL.objValue;
    }

    @NonNull
    public final le6 d(@NonNull RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, layoutManager)) == null) {
            le6 le6Var = this.d;
            if (le6Var == null || le6Var.a != layoutManager) {
                this.d = le6.a(layoutManager);
            }
            return this.d;
        }
        return (le6) invokeL.objValue;
    }

    @NonNull
    public final le6 e(@NonNull RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, layoutManager)) == null) {
            le6 le6Var = this.c;
            if (le6Var == null || le6Var.a != layoutManager) {
                this.c = le6.b(layoutManager);
            }
            return this.c;
        }
        return (le6) invokeL.objValue;
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
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        InterceptResult invokeLII;
        int position;
        boolean z;
        PointF computeScrollVectorForPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutManager, i, i2)) == null) {
            int itemCount = layoutManager.getItemCount();
            if (itemCount == 0) {
                return -1;
            }
            View view2 = null;
            if (layoutManager.canScrollVertically()) {
                view2 = c(layoutManager, e(layoutManager));
            } else if (layoutManager.canScrollHorizontally()) {
                view2 = c(layoutManager, d(layoutManager));
            }
            if (view2 == null || (position = layoutManager.getPosition(view2)) == -1) {
                return -1;
            }
            boolean z2 = false;
            if (!layoutManager.canScrollHorizontally() ? i2 > 0 : i > 0) {
                z = true;
            } else {
                z = false;
            }
            if ((layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) && (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) != null && (computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f)) {
                z2 = true;
            }
            if (z2) {
                if (z) {
                    return position - 1;
                }
                return position;
            } else if (z) {
                return position + 1;
            } else {
                return position;
            }
        }
        return invokeLII.intValue;
    }
}
