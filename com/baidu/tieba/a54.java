package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.x44;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a54 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947566153, "Lcom/baidu/tieba/a54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947566153, "Lcom/baidu/tieba/a54;");
                return;
            }
        }
        a = kh1.a;
    }

    public static void a(@NonNull a13 a13Var, @NonNull x44.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, a13Var, eVar) == null) {
            long l = a13Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            c83 c83Var = new c83();
            c83Var.a = t73.n(a13Var.W().G());
            c83Var.f = a13Var.getAppId();
            c83Var.c = a13Var.W().T();
            c83Var.b = "startup";
            c83Var.g = eVar.a;
            c83Var.e = eVar.b;
            c83Var.a("na_start", Long.valueOf(l));
            c83Var.a("h5_start", Long.valueOf(eVar.c));
            c83Var.a("h5_finish", Long.valueOf(eVar.d));
            t73.x("1235", c83Var);
        }
    }
}
