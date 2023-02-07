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
public class ih3 extends gh3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ih3() {
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

    @Override // com.baidu.tieba.gh3
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(fh3 fh3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fh3Var)) == null) {
            eh3 b = kh3.b(fh3Var.a);
            if (b == null) {
                if (!gh3.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = fh3Var.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (gh3.a) {
                                    throw new IllegalArgumentException("wrong info params.");
                                }
                            } else {
                                b.putFloat(fh3Var.c, Float.parseFloat(fh3Var.d));
                            }
                        } else {
                            b.putString(fh3Var.c, fh3Var.d);
                        }
                    } else {
                        b.putBoolean(fh3Var.c, Boolean.parseBoolean(fh3Var.d));
                    }
                } else {
                    b.putLong(fh3Var.c, Long.parseLong(fh3Var.d));
                }
            } else {
                b.putInt(fh3Var.c, Integer.parseInt(fh3Var.d));
            }
            if (gh3.a) {
                Log.d("SwanAppSpDelegation", "Put: " + fh3Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
