package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bj2 implements ji2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bj2() {
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

    @Override // com.baidu.tieba.ji2
    @SuppressLint({"BDThrowableCheck"})
    public oi2 a(ni2 ni2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ni2Var)) == null) {
            int type = ni2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!ir1.a) {
                            return new ej2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + ni2Var);
                    }
                    return new sc2();
                }
                return gu2.b();
            }
            return new ej2();
        }
        return (oi2) invokeL.objValue;
    }
}
