package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.ef4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hf4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947821779, "Lcom/baidu/tieba/hf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947821779, "Lcom/baidu/tieba/hf4;");
                return;
            }
        }
        a = qr1.a;
    }

    public static void a(@NonNull gb3 gb3Var, @NonNull ef4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, gb3Var, eVar) == null) {
            long l = gb3Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            ii3 ii3Var = new ii3();
            ii3Var.a = zh3.n(gb3Var.W().G());
            ii3Var.f = gb3Var.getAppId();
            ii3Var.c = gb3Var.W().T();
            ii3Var.b = "startup";
            ii3Var.g = eVar.a;
            ii3Var.e = eVar.b;
            ii3Var.a("na_start", Long.valueOf(l));
            ii3Var.a("h5_start", Long.valueOf(eVar.c));
            ii3Var.a("h5_finish", Long.valueOf(eVar.d));
            zh3.x("1235", ii3Var);
        }
    }
}
