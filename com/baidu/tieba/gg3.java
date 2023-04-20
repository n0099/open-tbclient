package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"BDThrowableCheck"})
/* loaded from: classes4.dex */
public class gg3 extends fg3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gg3() {
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
            Bundle bundle = new Bundle();
            dg3 b = jg3.b(eg3Var.a);
            if (b == null) {
                if (!fg3.a) {
                    return bundle;
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
                                bundle.putFloat("result_value", b.getFloat(eg3Var.c, Float.parseFloat(eg3Var.d)));
                            }
                        } else {
                            bundle.putString("result_value", b.getString(eg3Var.c, eg3Var.d));
                        }
                    } else {
                        bundle.putBoolean("result_value", b.getBoolean(eg3Var.c, Boolean.parseBoolean(eg3Var.d)));
                    }
                } else {
                    bundle.putLong("result_value", b.getLong(eg3Var.c, Long.parseLong(eg3Var.d)));
                }
            } else {
                bundle.putInt("result_value", b.getInt(eg3Var.c, Integer.parseInt(eg3Var.d)));
            }
            if (fg3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + eg3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
