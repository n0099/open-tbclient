package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.d84;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class g84 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947747782, "Lcom/baidu/tieba/g84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947747782, "Lcom/baidu/tieba/g84;");
                return;
            }
        }
        a = pk1.a;
    }

    public static void a(@NonNull f43 f43Var, @NonNull d84.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, f43Var, eVar) == null) {
            long l = f43Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            hb3 hb3Var = new hb3();
            hb3Var.a = ya3.n(f43Var.W().G());
            hb3Var.f = f43Var.getAppId();
            hb3Var.c = f43Var.W().T();
            hb3Var.b = "startup";
            hb3Var.g = eVar.a;
            hb3Var.e = eVar.b;
            hb3Var.a("na_start", Long.valueOf(l));
            hb3Var.a("h5_start", Long.valueOf(eVar.c));
            hb3Var.a("h5_finish", Long.valueOf(eVar.d));
            ya3.x("1235", hb3Var);
        }
    }
}
