package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bk2 implements jj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bk2() {
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

    @Override // com.baidu.tieba.jj2
    @SuppressLint({"BDThrowableCheck"})
    public oj2 a(nj2 nj2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nj2Var)) == null) {
            int type = nj2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!is1.a) {
                            return new ek2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + nj2Var);
                    }
                    return new sd2();
                }
                return gv2.b();
            }
            return new ek2();
        }
        return (oj2) invokeL.objValue;
    }
}
