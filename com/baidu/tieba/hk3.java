package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hk3 extends fk3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hk3() {
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

    @Override // com.baidu.tieba.fk3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(ek3 ek3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ek3Var)) == null) {
            dk3 b = jk3.b(ek3Var.a);
            if (b == null) {
                if (!fk3.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = ek3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (fk3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                b.putFloat(ek3Var.c, Float.parseFloat(ek3Var.d));
                            }
                        } else {
                            b.putString(ek3Var.c, ek3Var.d);
                        }
                    } else {
                        b.putBoolean(ek3Var.c, Boolean.parseBoolean(ek3Var.d));
                    }
                } else {
                    b.putLong(ek3Var.c, Long.parseLong(ek3Var.d));
                }
            } else {
                b.putInt(ek3Var.c, Integer.parseInt(ek3Var.d));
            }
            if (fk3.a) {
                Log.d("SwanAppSpDelegation", "Put: " + ek3Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
