package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.ss2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes4.dex */
public class h94 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends b43 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g94 c;

        public a(g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g94Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b43, com.baidu.tieba.c43, com.baidu.tieba.a43
        public void onEvent(@NonNull y33 y33Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y33Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (y33Var.a() != null) {
                    i = y33Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (h94.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                g94 g94Var = this.c;
                g94Var.m = i;
                oe3.x("976", g94Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947778534, "Lcom/baidu/tieba/h94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947778534, "Lcom/baidu/tieba/h94;");
                return;
            }
        }
        a = fo1.a;
    }

    public static void b(g94 g94Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, g94Var) != null) || g94Var == null) {
            return;
        }
        q43.Q().X(null, jz2.class, new a(g94Var));
    }

    public static void c(jl1 jl1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, jl1Var) != null) || jl1Var == null || (a2 = jl1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(f44.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= f44.a()) {
            return;
        }
        g94 g94Var = new g94();
        g94Var.b = "stuck";
        g94Var.e = "jserror";
        g94Var.f = v73.g0();
        if (v73.M() != null && v73.M().Y() != null) {
            ss2.a Y = v73.M().Y();
            g94Var.c = Y.T();
            g94Var.a = oe3.n(Y.G());
        }
        g94Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (s84.d()) {
            i = 20;
        } else {
            i = 10;
        }
        g94Var.k = i;
        g94Var.n = f44.b();
        g94Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(g94Var);
    }
}
