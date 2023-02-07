package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.tt2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ia4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends c53 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha4 c;

        public a(ha4 ha4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ha4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c53, com.baidu.tieba.d53, com.baidu.tieba.b53
        public void onEvent(@NonNull z43 z43Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z43Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (z43Var.a() != null) {
                    i = z43Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (ia4.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                ha4 ha4Var = this.c;
                ha4Var.m = i;
                pf3.x("976", ha4Var);
            }
        }
    }

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
        a = gp1.a;
    }

    public static void b(ha4 ha4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, ha4Var) != null) || ha4Var == null) {
            return;
        }
        r53.Q().X(null, k03.class, new a(ha4Var));
    }

    public static void c(pm1 pm1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, pm1Var) != null) || pm1Var == null || (a2 = pm1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(g54.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= g54.a()) {
            return;
        }
        ha4 ha4Var = new ha4();
        ha4Var.b = "stuck";
        ha4Var.e = "jserror";
        ha4Var.f = w83.g0();
        if (w83.M() != null && w83.M().Y() != null) {
            tt2.a Y = w83.M().Y();
            ha4Var.c = Y.T();
            ha4Var.a = pf3.n(Y.G());
        }
        ha4Var.l = str + ";" + str2;
        if (t94.d()) {
            i = 20;
        } else {
            i = 10;
        }
        ha4Var.k = i;
        ha4Var.n = g54.b();
        ha4Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(ha4Var);
    }
}
