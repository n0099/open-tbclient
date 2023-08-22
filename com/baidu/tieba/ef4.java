package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.bf4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ef4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947732406, "Lcom/baidu/tieba/ef4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947732406, "Lcom/baidu/tieba/ef4;");
                return;
            }
        }
        a = nr1.a;
    }

    public static void a(@NonNull db3 db3Var, @NonNull bf4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, db3Var, eVar) == null) {
            long l = db3Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            fi3 fi3Var = new fi3();
            fi3Var.a = wh3.n(db3Var.W().G());
            fi3Var.f = db3Var.getAppId();
            fi3Var.c = db3Var.W().T();
            fi3Var.b = "startup";
            fi3Var.g = eVar.a;
            fi3Var.e = eVar.b;
            fi3Var.a("na_start", Long.valueOf(l));
            fi3Var.a("h5_start", Long.valueOf(eVar.c));
            fi3Var.a("h5_finish", Long.valueOf(eVar.d));
            wh3.x("1235", fi3Var);
        }
    }
}
