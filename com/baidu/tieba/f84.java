package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.c84;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class f84 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947717991, "Lcom/baidu/tieba/f84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947717991, "Lcom/baidu/tieba/f84;");
                return;
            }
        }
        a = ok1.a;
    }

    public static void a(@NonNull e43 e43Var, @NonNull c84.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, e43Var, eVar) == null) {
            long l = e43Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            gb3 gb3Var = new gb3();
            gb3Var.a = xa3.n(e43Var.W().G());
            gb3Var.f = e43Var.getAppId();
            gb3Var.c = e43Var.W().T();
            gb3Var.b = "startup";
            gb3Var.g = eVar.a;
            gb3Var.e = eVar.b;
            gb3Var.a("na_start", Long.valueOf(l));
            gb3Var.a("h5_start", Long.valueOf(eVar.c));
            gb3Var.a("h5_finish", Long.valueOf(eVar.d));
            xa3.x("1235", gb3Var);
        }
    }
}
