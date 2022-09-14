package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bb2 implements ja2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bb2() {
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

    @Override // com.baidu.tieba.ja2
    @SuppressLint({"BDThrowableCheck"})
    public oa2 a(na2 na2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, na2Var)) == null) {
            int type = na2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!ij1.a) {
                            return new eb2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + na2Var);
                    }
                    return new s42();
                }
                return gm2.b();
            }
            return new eb2();
        }
        return (oa2) invokeL.objValue;
    }
}
