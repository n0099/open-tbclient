package com.baidu.tbadk.widget.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes6.dex */
public class FlipLoadingLayout extends LoadingLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Animation m;
    public final Animation n;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f48686a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-514843385, "Lcom/baidu/tbadk/widget/pulltorefresh/library/internal/FlipLoadingLayout$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-514843385, "Lcom/baidu/tbadk/widget/pulltorefresh/library/internal/FlipLoadingLayout$a;");
                    return;
                }
            }
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            f48686a = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48686a[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlipLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mode, orientation, typedArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (PullToRefreshBase.Mode) objArr2[1], (PullToRefreshBase.Orientation) objArr2[2], (TypedArray) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        float f2 = mode == PullToRefreshBase.Mode.PULL_FROM_START ? -180 : 180;
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, f2, 1, 0.5f, 1, 0.5f);
        this.m = rotateAnimation;
        rotateAnimation.setInterpolator(LoadingLayout.l);
        this.m.setDuration(150L);
        this.m.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(f2, 0.0f, 1, 0.5f, 1, 0.5f);
        this.n = rotateAnimation2;
        rotateAnimation2.setInterpolator(LoadingLayout.l);
        this.n.setDuration(150L);
        this.n.setFillAfter(true);
    }

    private float getDrawableRotationAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            int i2 = a.f48686a[this.mMode.ordinal()];
            return i2 != 1 ? (i2 == 2 && this.mScrollDirection == PullToRefreshBase.Orientation.HORIZONTAL) ? 270.0f : 0.0f : this.mScrollDirection == PullToRefreshBase.Orientation.HORIZONTAL ? 90.0f : 180.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public int getDefaultDrawableResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.drawable.default_ptr_flip : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable) == null) || drawable == null) {
            return;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        ViewGroup.LayoutParams layoutParams = this.mHeaderImage.getLayoutParams();
        int max = Math.max(intrinsicHeight, intrinsicWidth);
        layoutParams.height = max;
        layoutParams.width = max;
        this.mHeaderImage.requestLayout();
        this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate((layoutParams.width - intrinsicWidth) / 2.0f, (layoutParams.height - intrinsicHeight) / 2.0f);
        matrix.postRotate(getDrawableRotationAngle(), layoutParams.width / 2.0f, layoutParams.height / 2.0f);
        this.mHeaderImage.setImageMatrix(matrix);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void onPullImpl(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void pullToRefreshImpl() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.m == this.mHeaderImage.getAnimation()) {
            this.mHeaderImage.startAnimation(this.n);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void refreshingImpl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mHeaderImage.setVisibility(0);
            this.mHeaderProgress.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void releaseToRefreshImpl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mHeaderImage.startAnimation(this.m);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void resetImpl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mHeaderImage.clearAnimation();
            this.mHeaderProgress.setVisibility(8);
            this.mHeaderImage.setVisibility(0);
        }
    }
}
