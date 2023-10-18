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
/* loaded from: classes5.dex */
public class ae3 extends zd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ae3() {
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

    @Override // com.baidu.tieba.zd3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(yd3 yd3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yd3Var)) == null) {
            Bundle bundle = new Bundle();
            xd3 b = de3.b(yd3Var.a);
            if (b == null) {
                if (!zd3.a) {
                    return bundle;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = yd3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (zd3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                bundle.putFloat("result_value", b.getFloat(yd3Var.c, Float.parseFloat(yd3Var.d)));
                            }
                        } else {
                            bundle.putString("result_value", b.getString(yd3Var.c, yd3Var.d));
                        }
                    } else {
                        bundle.putBoolean("result_value", b.getBoolean(yd3Var.c, Boolean.parseBoolean(yd3Var.d)));
                    }
                } else {
                    bundle.putLong("result_value", b.getLong(yd3Var.c, Long.parseLong(yd3Var.d)));
                }
            } else {
                bundle.putInt("result_value", b.getInt(yd3Var.c, Integer.parseInt(yd3Var.d)));
            }
            if (zd3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + yd3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
