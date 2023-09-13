package com.baidu.tieba;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.t7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class hx6 implements t7.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kv6 a;
    public gv6 b;
    public PointF c;
    public RectF d;
    public Matrix e;
    public float f;
    public boolean g;

    @Override // com.baidu.tieba.t7.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public hx6(kv6 item, gv6 drawingCache, PointF position, RectF rect, Matrix transform) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {item, drawingCache, position, rect, transform};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(drawingCache, "drawingCache");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(transform, "transform");
        this.a = item;
        this.b = drawingCache;
        this.c = position;
        this.d = rect;
        this.e = transform;
        this.f = 1.0f;
    }

    public final float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return invokeV.floatValue;
    }

    public final gv6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (gv6) invokeV.objValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public final kv6 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (kv6) invokeV.objValue;
    }

    public final PointF e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (PointF) invokeV.objValue;
    }

    public final RectF f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (RectF) invokeV.objValue;
    }

    public final Matrix g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (Matrix) invokeV.objValue;
    }

    public final void h(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            this.f = f;
        }
    }

    public final void i(gv6 gv6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gv6Var) == null) {
            Intrinsics.checkNotNullParameter(gv6Var, "<set-?>");
            this.b = gv6Var;
        }
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.g = z;
        }
    }

    public final void k(kv6 kv6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kv6Var) == null) {
            Intrinsics.checkNotNullParameter(kv6Var, "<set-?>");
            this.a = kv6Var;
        }
    }
}
