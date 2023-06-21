package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ck2 implements kj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ck2() {
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

    @Override // com.baidu.tieba.kj2
    @SuppressLint({"BDThrowableCheck"})
    public pj2 a(oj2 oj2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oj2Var)) == null) {
            int type = oj2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!js1.a) {
                            return new fk2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + oj2Var);
                    }
                    return new td2();
                }
                return hv2.b();
            }
            return new fk2();
        }
        return (pj2) invokeL.objValue;
    }
}
