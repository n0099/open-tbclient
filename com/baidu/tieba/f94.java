package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.qs2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes4.dex */
public class f94 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends z33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e94 c;

        public a(e94 e94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = e94Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z33, com.baidu.tieba.a43, com.baidu.tieba.y33
        public void onEvent(@NonNull w33 w33Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, w33Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (w33Var.a() != null) {
                    i = w33Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (f94.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                e94 e94Var = this.c;
                e94Var.m = i;
                me3.x("976", e94Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947718952, "Lcom/baidu/tieba/f94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947718952, "Lcom/baidu/tieba/f94;");
                return;
            }
        }
        a = do1.a;
    }

    public static void b(e94 e94Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, e94Var) != null) || e94Var == null) {
            return;
        }
        o43.Q().X(null, hz2.class, new a(e94Var));
    }

    public static void c(hl1 hl1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, hl1Var) != null) || hl1Var == null || (a2 = hl1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(d44.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= d44.a()) {
            return;
        }
        e94 e94Var = new e94();
        e94Var.b = "stuck";
        e94Var.e = "jserror";
        e94Var.f = t73.g0();
        if (t73.M() != null && t73.M().Y() != null) {
            qs2.a Y = t73.M().Y();
            e94Var.c = Y.T();
            e94Var.a = me3.n(Y.G());
        }
        e94Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (q84.d()) {
            i = 20;
        } else {
            i = 10;
        }
        e94Var.k = i;
        e94Var.n = d44.b();
        e94Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(e94Var);
    }
}
