package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.ed4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class hd4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947819857, "Lcom/baidu/tieba/hd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947819857, "Lcom/baidu/tieba/hd4;");
                return;
            }
        }
        a = qp1.a;
    }

    public static void a(@NonNull g93 g93Var, @NonNull ed4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, g93Var, eVar) == null) {
            long l = g93Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            ig3 ig3Var = new ig3();
            ig3Var.a = zf3.n(g93Var.W().G());
            ig3Var.f = g93Var.getAppId();
            ig3Var.c = g93Var.W().T();
            ig3Var.b = "startup";
            ig3Var.g = eVar.a;
            ig3Var.e = eVar.b;
            ig3Var.a("na_start", Long.valueOf(l));
            ig3Var.a("h5_start", Long.valueOf(eVar.c));
            ig3Var.a("h5_finish", Long.valueOf(eVar.d));
            zf3.x("1235", ig3Var);
        }
    }
}
