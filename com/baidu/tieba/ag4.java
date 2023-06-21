package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.xf4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ag4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947614203, "Lcom/baidu/tieba/ag4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947614203, "Lcom/baidu/tieba/ag4;");
                return;
            }
        }
        a = js1.a;
    }

    public static void a(@NonNull zb3 zb3Var, @NonNull xf4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, zb3Var, eVar) == null) {
            long l = zb3Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            bj3 bj3Var = new bj3();
            bj3Var.a = si3.n(zb3Var.W().G());
            bj3Var.f = zb3Var.getAppId();
            bj3Var.c = zb3Var.W().T();
            bj3Var.b = "startup";
            bj3Var.g = eVar.a;
            bj3Var.e = eVar.b;
            bj3Var.a("na_start", Long.valueOf(l));
            bj3Var.a("h5_start", Long.valueOf(eVar.c));
            bj3Var.a("h5_finish", Long.valueOf(eVar.d));
            si3.x("1235", bj3Var);
        }
    }
}
