package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hg3 extends fg3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hg3() {
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

    @Override // com.baidu.tieba.fg3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(eg3 eg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eg3Var)) == null) {
            dg3 b = jg3.b(eg3Var.a);
            if (b == null) {
                if (!fg3.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = eg3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (fg3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                b.putFloat(eg3Var.c, Float.parseFloat(eg3Var.d));
                            }
                        } else {
                            b.putString(eg3Var.c, eg3Var.d);
                        }
                    } else {
                        b.putBoolean(eg3Var.c, Boolean.parseBoolean(eg3Var.d));
                    }
                } else {
                    b.putLong(eg3Var.c, Long.parseLong(eg3Var.d));
                }
            } else {
                b.putInt(eg3Var.c, Integer.parseInt(eg3Var.d));
            }
            if (fg3.a) {
                Log.d("SwanAppSpDelegation", "Put: " + eg3Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
