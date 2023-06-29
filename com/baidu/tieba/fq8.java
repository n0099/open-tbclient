package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static bq8<cq8> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            bq8<cq8> bq8Var = new bq8<>();
            bq8Var.e().j(1);
            cq8 cq8Var = new cq8();
            cq8Var.f(str);
            bq8Var.i(cq8Var);
            return bq8Var;
        }
        return (bq8) invokeL.objValue;
    }
}
