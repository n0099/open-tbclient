package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.ff4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class if4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947851570, "Lcom/baidu/tieba/if4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947851570, "Lcom/baidu/tieba/if4;");
                return;
            }
        }
        a = rr1.a;
    }

    public static void a(@NonNull hb3 hb3Var, @NonNull ff4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, hb3Var, eVar) == null) {
            long l = hb3Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            ji3 ji3Var = new ji3();
            ji3Var.a = ai3.n(hb3Var.W().G());
            ji3Var.f = hb3Var.getAppId();
            ji3Var.c = hb3Var.W().T();
            ji3Var.b = "startup";
            ji3Var.g = eVar.a;
            ji3Var.e = eVar.b;
            ji3Var.a("na_start", Long.valueOf(l));
            ji3Var.a("h5_start", Long.valueOf(eVar.c));
            ji3Var.a("h5_finish", Long.valueOf(eVar.d));
            ai3.x("1235", ji3Var);
        }
    }
}
