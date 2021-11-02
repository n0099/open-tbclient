package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
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
/* loaded from: classes9.dex */
public abstract class SnapHelper extends RecyclerView.OnFlingListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f47097a;

    /* renamed from: b  reason: collision with root package name */
    public Scroller f47098b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView.OnScrollListener f47099c;

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f47100a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SnapHelper f47101b;

        public a(SnapHelper snapHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {snapHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47101b = snapHelper;
            this.f47100a = false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0 && this.f47100a) {
                    this.f47100a = false;
                    this.f47101b.snapToTargetExistingView();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                if (i2 == 0 && i3 == 0) {
                    return;
                }
                this.f47100a = true;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends LinearSmoothScroller {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SnapHelper f47102a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SnapHelper snapHelper, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {snapHelper, context};
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
            this.f47102a = snapHelper;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, displayMetrics)) == null) ? 100.0f / displayMetrics.densityDpi : invokeL.floatValue;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, state, action) == null) {
                SnapHelper snapHelper = this.f47102a;
                int[] calculateDistanceToFinalSnap = snapHelper.calculateDistanceToFinalSnap(snapHelper.f47097a.getLayoutManager(), view);
                int i2 = calculateDistanceToFinalSnap[0];
                int i3 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i2), Math.abs(i3)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(i2, i3, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        }
    }

    public SnapHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47099c = new a(this);
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, recyclerView) == null) || (recyclerView2 = this.f47097a) == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.f47097a = recyclerView;
        if (recyclerView != null) {
            setupCallbacks();
            this.f47098b = new Scroller(this.f47097a.getContext(), new DecelerateInterpolator());
            snapToTargetExistingView();
        }
    }

    @Nullable
    public abstract int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view);

    public int[] calculateScrollDistance(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) {
            this.f47098b.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            return new int[]{this.f47098b.getFinalX(), this.f47098b.getFinalY()};
        }
        return (int[]) invokeII.objValue;
    }

    @Nullable
    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layoutManager)) == null) {
            if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
                return new b(this, this.f47097a.getContext());
            }
            return null;
        }
        return (LinearSmoothScroller) invokeL.objValue;
    }

    public final void destroyCallbacks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f47097a.removeOnScrollListener(this.f47099c);
            this.f47097a.setOnFlingListener(null);
        }
    }

    @Nullable
    public abstract View findSnapView(RecyclerView.LayoutManager layoutManager);

    public abstract int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i2, int i3);

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean onFling(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) {
            RecyclerView.LayoutManager layoutManager = this.f47097a.getLayoutManager();
            if (layoutManager == null || this.f47097a.getAdapter() == null) {
                return false;
            }
            int minFlingVelocity = this.f47097a.getMinFlingVelocity();
            return (Math.abs(i3) > minFlingVelocity || Math.abs(i2) > minFlingVelocity) && snapFromFling(layoutManager, i2, i3);
        }
        return invokeII.booleanValue;
    }

    public final void setupCallbacks() throws IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f47097a.getOnFlingListener() == null) {
                this.f47097a.addOnScrollListener(this.f47099c);
                this.f47097a.setOnFlingListener(this);
                return;
            }
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
    }

    public final boolean snapFromFling(@NonNull RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        InterceptResult invokeLII;
        LinearSmoothScroller createSnapScroller;
        int findTargetSnapPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048585, this, layoutManager, i2, i3)) == null) {
            if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (createSnapScroller = createSnapScroller(layoutManager)) == null || (findTargetSnapPosition = findTargetSnapPosition(layoutManager, i2, i3)) == -1) {
                return false;
            }
            createSnapScroller.setTargetPosition(findTargetSnapPosition);
            layoutManager.startSmoothScroll(createSnapScroller);
            return true;
        }
        return invokeLII.booleanValue;
    }

    public void snapToTargetExistingView() {
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        View findSnapView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (recyclerView = this.f47097a) == null || (layoutManager = recyclerView.getLayoutManager()) == null || (findSnapView = findSnapView(layoutManager)) == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, findSnapView);
        if (calculateDistanceToFinalSnap[0] == 0 && calculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.f47097a.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
    }
}
