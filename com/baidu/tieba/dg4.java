package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.ag4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dg4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947703576, "Lcom/baidu/tieba/dg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947703576, "Lcom/baidu/tieba/dg4;");
                return;
            }
        }
        a = ms1.a;
    }

    public static void a(@NonNull cc3 cc3Var, @NonNull ag4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, cc3Var, eVar) == null) {
            long l = cc3Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            ej3 ej3Var = new ej3();
            ej3Var.a = vi3.n(cc3Var.W().G());
            ej3Var.f = cc3Var.getAppId();
            ej3Var.c = cc3Var.W().T();
            ej3Var.b = "startup";
            ej3Var.g = eVar.a;
            ej3Var.e = eVar.b;
            ej3Var.a("na_start", Long.valueOf(l));
            ej3Var.a("h5_start", Long.valueOf(eVar.c));
            ej3Var.a("h5_finish", Long.valueOf(eVar.d));
            vi3.x("1235", ej3Var);
        }
    }
}
