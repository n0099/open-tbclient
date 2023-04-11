package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.rs2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes4.dex */
public class g94 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends a43 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f94 c;

        public a(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = f94Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a43, com.baidu.tieba.b43, com.baidu.tieba.z33
        public void onEvent(@NonNull x33 x33Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x33Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (x33Var.a() != null) {
                    i = x33Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (g94.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                f94 f94Var = this.c;
                f94Var.m = i;
                ne3.x("976", f94Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947748743, "Lcom/baidu/tieba/g94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947748743, "Lcom/baidu/tieba/g94;");
                return;
            }
        }
        a = eo1.a;
    }

    public static void b(f94 f94Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, f94Var) != null) || f94Var == null) {
            return;
        }
        p43.Q().X(null, iz2.class, new a(f94Var));
    }

    public static void c(il1 il1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, il1Var) != null) || il1Var == null || (a2 = il1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(e44.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= e44.a()) {
            return;
        }
        f94 f94Var = new f94();
        f94Var.b = "stuck";
        f94Var.e = "jserror";
        f94Var.f = u73.g0();
        if (u73.M() != null && u73.M().Y() != null) {
            rs2.a Y = u73.M().Y();
            f94Var.c = Y.T();
            f94Var.a = ne3.n(Y.G());
        }
        f94Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (r84.d()) {
            i = 20;
        } else {
            i = 10;
        }
        f94Var.k = i;
        f94Var.n = e44.b();
        f94Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(f94Var);
    }
}
