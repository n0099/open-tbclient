package com.baidu.tbadk.widget.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class RotateLoadingLayout extends LoadingLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Animation m;
    public final Matrix n;
    public float o;
    public float p;
    public final boolean q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
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
        this.q = typedArray.getBoolean(R$styleable.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        this.n = matrix;
        this.mHeaderImage.setImageMatrix(matrix);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.m = rotateAnimation;
        rotateAnimation.setInterpolator(LoadingLayout.l);
        this.m.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.m.setRepeatCount(-1);
        this.m.setRepeatMode(1);
    }

    public final void a() {
        Matrix matrix;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (matrix = this.n) == null) {
            return;
        }
        matrix.reset();
        this.mHeaderImage.setImageMatrix(this.n);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public int getDefaultDrawableResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.drawable.default_ptr_rotate : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drawable) == null) || drawable == null) {
            return;
        }
        this.o = Math.round(drawable.getIntrinsicWidth() / 2.0f);
        this.p = Math.round(drawable.getIntrinsicHeight() / 2.0f);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void onPullImpl(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            this.n.setRotate(this.q ? f2 * 90.0f : Math.max(0.0f, Math.min(180.0f, (f2 * 360.0f) - 180.0f)), this.o, this.p);
            this.mHeaderImage.setImageMatrix(this.n);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void pullToRefreshImpl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void refreshingImpl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mHeaderImage.startAnimation(this.m);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void releaseToRefreshImpl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void resetImpl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mHeaderImage.clearAnimation();
            a();
        }
    }
}
