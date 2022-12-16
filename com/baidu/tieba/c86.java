package com.baidu.tieba;

import android.graphics.PointF;
import android.graphics.RectF;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class c86 extends w76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public PointF c;
    public RectF d;

    public c86() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new PointF();
        this.d = new RectF();
    }

    public final PointF c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (PointF) invokeV.objValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.w76, com.baidu.tieba.a8.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.reset();
            this.b = false;
            this.c = new PointF();
            this.d = new RectF();
        }
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.b = z;
        }
    }

    public final c86 update(boolean z, int i, PointF position, RectF rect, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), position, rect, Integer.valueOf(i2)})) == null) {
            Intrinsics.checkNotNullParameter(position, "position");
            Intrinsics.checkNotNullParameter(rect, "rect");
            this.b = z;
            if (!Intrinsics.areEqual(this.c, position)) {
                this.c.set(position);
            }
            if (!Intrinsics.areEqual(this.d, rect)) {
                this.d.set(rect);
            }
            return this;
        }
        return (c86) invokeCommon.objValue;
    }
}
