package com.baidu.tieba;

import com.baidu.tieba.ff7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class gf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final ff7.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            ff7.a aVar = new ff7.a();
            aVar.f(null);
            aVar.c(R.color.CAM_X0605);
            aVar.e(R.color.CAM_X0101);
            aVar.b(R.color.CAM_X0101);
            return aVar;
        }
        return (ff7.a) invokeV.objValue;
    }

    public static final ff7.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ff7.a aVar = new ff7.a();
            aVar.c(R.color.CAM_X0620);
            aVar.e(R.color.CAM_X0611);
            aVar.b(R.color.CAM_X0611);
            return aVar;
        }
        return (ff7.a) invokeV.objValue;
    }

    public static final ff7.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ff7.a aVar = new ff7.a();
            aVar.c(R.color.CAM_X0620);
            aVar.e(R.color.CAM_X0310);
            aVar.b(R.color.CAM_X0611);
            return aVar;
        }
        return (ff7.a) invokeV.objValue;
    }

    public static final ff7.a b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return new ff7.a();
                    }
                    return d();
                }
                return c();
            }
            return a();
        }
        return (ff7.a) invokeI.objValue;
    }
}
