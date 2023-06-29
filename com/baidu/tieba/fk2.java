package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fk2 implements nj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fk2() {
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

    @Override // com.baidu.tieba.nj2
    @SuppressLint({"BDThrowableCheck"})
    public sj2 a(rj2 rj2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rj2Var)) == null) {
            int type = rj2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!ms1.a) {
                            return new ik2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + rj2Var);
                    }
                    return new wd2();
                }
                return kv2.b();
            }
            return new ik2();
        }
        return (sj2) invokeL.objValue;
    }
}
