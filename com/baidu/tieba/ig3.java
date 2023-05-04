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
public class ig3 extends hg3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ig3() {
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

    @Override // com.baidu.tieba.hg3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(gg3 gg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gg3Var)) == null) {
            Bundle bundle = new Bundle();
            fg3 b = lg3.b(gg3Var.a);
            if (b == null) {
                if (!hg3.a) {
                    return bundle;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = gg3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (hg3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                bundle.putFloat("result_value", b.getFloat(gg3Var.c, Float.parseFloat(gg3Var.d)));
                            }
                        } else {
                            bundle.putString("result_value", b.getString(gg3Var.c, gg3Var.d));
                        }
                    } else {
                        bundle.putBoolean("result_value", b.getBoolean(gg3Var.c, Boolean.parseBoolean(gg3Var.d)));
                    }
                } else {
                    bundle.putLong("result_value", b.getLong(gg3Var.c, Long.parseLong(gg3Var.d)));
                }
            } else {
                bundle.putInt("result_value", b.getInt(gg3Var.c, Integer.parseInt(gg3Var.d)));
            }
            if (hg3.a) {
                Log.d("SwanAppSpDelegation", "Get: " + gg3Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
