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
/* loaded from: classes6.dex */
public class gk3 extends fk3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gk3() {
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
            Bundle bundle = new Bundle();
            dk3 b = jk3.b(ek3Var.a);
            if (b == null) {
                if (!fk3.a) {
                    return bundle;
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
                                bundle.putFloat("result_value", b.getFloat(ek3Var.c, Float.parseFloat(ek3Var.d)));
                            }
                        } else {
                            bundle.putString("result_value", b.getString(ek3Var.c, ek3Var.d));
                        }
                    } else {
                        bundle.putBoolean("result_value", b.getBoolean(ek3Var.c, Boolean.parseBoolean(ek3Var.d)));
                    }
                } else {
                    bundle.putLong("result_value", b.getLong(ek3Var.c, Long.parseLong(ek3Var.d)));
                }
            } else {
                bundle.putInt("result_value", b.getInt(ek3Var.c, Integer.parseInt(ek3Var.d)));
            }
            if (fk3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + ek3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
