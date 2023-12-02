package com.baidu.tieba;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class c6a implements TypeEvaluator<PointF> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PointF a;
    public final PointF b;

    public c6a(PointF point1, PointF point2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {point1, point2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(point1, "point1");
        Intrinsics.checkNotNullParameter(point2, "point2");
        this.a = point1;
        this.b = point2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public PointF evaluate(float f, PointF startValue, PointF endValue) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), startValue, endValue})) == null) {
            Intrinsics.checkNotNullParameter(startValue, "startValue");
            Intrinsics.checkNotNullParameter(endValue, "endValue");
            double d = 1 - f;
            float f2 = 3;
            double d2 = f;
            return new PointF((int) ((startValue.x * Math.pow(d, 3.0d)) + (this.a.x * f2 * f * Math.pow(d, 2.0d)) + (this.b.x * f2 * Math.pow(d2, 2.0d) * d) + (endValue.x * Math.pow(d2, 3.0d))), (int) ((startValue.y * Math.pow(d, 3.0d)) + (this.a.y * f2 * f * Math.pow(d, 2.0d)) + (f2 * this.b.y * Math.pow(d2, 2.0d) * d) + (endValue.y * Math.pow(d2, 3.0d))));
        }
        return (PointF) invokeCommon.objValue;
    }
}
