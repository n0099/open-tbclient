package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d92 implements l82 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d92() {
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

    @Override // com.baidu.tieba.l82
    @SuppressLint({"BDThrowableCheck"})
    public q82 a(p82 p82Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, p82Var)) == null) {
            int type = p82Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!kh1.a) {
                            return new g92();
                        }
                        throw new IllegalArgumentException("invalid model object:" + p82Var);
                    }
                    return new u22();
                }
                return ik2.b();
            }
            return new g92();
        }
        return (q82) invokeL.objValue;
    }
}
