package com.baidu.tieba;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ag2 implements if2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ag2() {
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

    @Override // com.baidu.tieba.if2
    @SuppressLint({"BDThrowableCheck"})
    public nf2 a(mf2 mf2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mf2Var)) == null) {
            int type = mf2Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!ho1.a) {
                            return new dg2();
                        }
                        throw new IllegalArgumentException("invalid model object:" + mf2Var);
                    }
                    return new r92();
                }
                return fr2.b();
            }
            return new dg2();
        }
        return (nf2) invokeL.objValue;
    }
}
