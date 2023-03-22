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
public class eg3 extends dg3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public eg3() {
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

    @Override // com.baidu.tieba.dg3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(cg3 cg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cg3Var)) == null) {
            Bundle bundle = new Bundle();
            bg3 b = hg3.b(cg3Var.a);
            if (b == null) {
                if (!dg3.a) {
                    return bundle;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = cg3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (dg3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                bundle.putFloat("result_value", b.getFloat(cg3Var.c, Float.parseFloat(cg3Var.d)));
                            }
                        } else {
                            bundle.putString("result_value", b.getString(cg3Var.c, cg3Var.d));
                        }
                    } else {
                        bundle.putBoolean("result_value", b.getBoolean(cg3Var.c, Boolean.parseBoolean(cg3Var.d)));
                    }
                } else {
                    bundle.putLong("result_value", b.getLong(cg3Var.c, Long.parseLong(cg3Var.d)));
                }
            } else {
                bundle.putInt("result_value", b.getInt(cg3Var.c, Integer.parseInt(cg3Var.d)));
            }
            if (dg3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + cg3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
