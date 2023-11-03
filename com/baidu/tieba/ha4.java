package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.ea4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ha4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947816974, "Lcom/baidu/tieba/ha4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947816974, "Lcom/baidu/tieba/ha4;");
                return;
            }
        }
        a = rm1.a;
    }

    public static void a(@NonNull g63 g63Var, @NonNull ea4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, g63Var, eVar) == null) {
            long l = g63Var.X().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            id3 id3Var = new id3();
            id3Var.a = zc3.n(g63Var.X().H());
            id3Var.f = g63Var.getAppId();
            id3Var.c = g63Var.X().U();
            id3Var.b = "startup";
            id3Var.g = eVar.a;
            id3Var.e = eVar.b;
            id3Var.a("na_start", Long.valueOf(l));
            id3Var.a("h5_start", Long.valueOf(eVar.c));
            id3Var.a("h5_finish", Long.valueOf(eVar.d));
            zc3.x("1235", id3Var);
        }
    }
}
