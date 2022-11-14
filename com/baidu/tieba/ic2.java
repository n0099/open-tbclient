package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ic2 implements qb2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ic2() {
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

    @Override // com.baidu.tieba.qb2
    @SuppressLint({"BDThrowableCheck"})
    public vb2 a(ub2 ub2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ub2Var)) == null) {
            int type = ub2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!pk1.a) {
                            return new lc2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + ub2Var);
                    }
                    return new z52();
                }
                return nn2.b();
            }
            return new lc2();
        }
        return (vb2) invokeL.objValue;
    }
}
