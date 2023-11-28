package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.fa4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ia4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947846765, "Lcom/baidu/tieba/ia4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947846765, "Lcom/baidu/tieba/ia4;");
                return;
            }
        }
        a = sm1.a;
    }

    public static void a(@NonNull h63 h63Var, @NonNull fa4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, h63Var, eVar) == null) {
            long k = h63Var.X().k("launch_time", 0L);
            if (k <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            jd3 jd3Var = new jd3();
            jd3Var.a = ad3.n(h63Var.X().H());
            jd3Var.f = h63Var.getAppId();
            jd3Var.c = h63Var.X().U();
            jd3Var.b = "startup";
            jd3Var.g = eVar.a;
            jd3Var.e = eVar.b;
            jd3Var.a("na_start", Long.valueOf(k));
            jd3Var.a("h5_start", Long.valueOf(eVar.c));
            jd3Var.a("h5_finish", Long.valueOf(eVar.d));
            ad3.x("1235", jd3Var);
        }
    }
}
