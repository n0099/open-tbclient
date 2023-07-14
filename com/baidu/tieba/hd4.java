package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.sw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes6.dex */
public class hd4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends b83 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gd4 c;

        public a(gd4 gd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gd4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b83, com.baidu.tieba.c83, com.baidu.tieba.a83
        public void onEvent(@NonNull y73 y73Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y73Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (y73Var.a() != null) {
                    i = y73Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (hd4.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                gd4 gd4Var = this.c;
                gd4Var.m = i;
                oi3.x("976", gd4Var);
            }
        }
    }

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
        a = fs1.a;
    }

    public static void b(gd4 gd4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, gd4Var) != null) || gd4Var == null) {
            return;
        }
        q83.Q().X(null, j33.class, new a(gd4Var));
    }

    public static void c(ep1 ep1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, ep1Var) != null) || ep1Var == null || (a2 = ep1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(f84.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= f84.a()) {
            return;
        }
        gd4 gd4Var = new gd4();
        gd4Var.b = "stuck";
        gd4Var.e = "jserror";
        gd4Var.f = vb3.g0();
        if (vb3.M() != null && vb3.M().Y() != null) {
            sw2.a Y = vb3.M().Y();
            gd4Var.c = Y.T();
            gd4Var.a = oi3.n(Y.G());
        }
        gd4Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (sc4.d()) {
            i = 20;
        } else {
            i = 10;
        }
        gd4Var.k = i;
        gd4Var.n = f84.b();
        gd4Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(gd4Var);
    }
}
