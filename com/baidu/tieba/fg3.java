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
public class fg3 extends eg3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fg3() {
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

    @Override // com.baidu.tieba.eg3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(dg3 dg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dg3Var)) == null) {
            Bundle bundle = new Bundle();
            cg3 b = ig3.b(dg3Var.a);
            if (b == null) {
                if (!eg3.a) {
                    return bundle;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = dg3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (eg3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                bundle.putFloat("result_value", b.getFloat(dg3Var.c, Float.parseFloat(dg3Var.d)));
                            }
                        } else {
                            bundle.putString("result_value", b.getString(dg3Var.c, dg3Var.d));
                        }
                    } else {
                        bundle.putBoolean("result_value", b.getBoolean(dg3Var.c, Boolean.parseBoolean(dg3Var.d)));
                    }
                } else {
                    bundle.putLong("result_value", b.getLong(dg3Var.c, Long.parseLong(dg3Var.d)));
                }
            } else {
                bundle.putInt("result_value", b.getInt(dg3Var.c, Integer.parseInt(dg3Var.d)));
            }
            if (eg3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + dg3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
