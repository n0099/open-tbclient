package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gj2 implements oi2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gj2() {
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

    @Override // com.baidu.tieba.oi2
    @SuppressLint({"BDThrowableCheck"})
    public ti2 a(si2 si2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, si2Var)) == null) {
            int type = si2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!nr1.a) {
                            return new jj2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + si2Var);
                    }
                    return new xc2();
                }
                return lu2.b();
            }
            return new jj2();
        }
        return (ti2) invokeL.objValue;
    }
}
