package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.mq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes5.dex */
public class b74 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends v13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a74 c;

        public a(a74 a74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a74Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v13, com.baidu.tieba.w13, com.baidu.tieba.u13
        public void onEvent(@NonNull s13 s13Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s13Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (s13Var.a() != null) {
                    i = s13Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (b74.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                a74 a74Var = this.c;
                a74Var.m = i;
                ic3.x("976", a74Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947597866, "Lcom/baidu/tieba/b74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947597866, "Lcom/baidu/tieba/b74;");
                return;
            }
        }
        a = am1.a;
    }

    public static void b(a74 a74Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, a74Var) != null) || a74Var == null) {
            return;
        }
        k23.Q().X(null, dx2.class, new a(a74Var));
    }

    public static void c(zi1 zi1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, zi1Var) != null) || zi1Var == null || (a2 = zi1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(z14.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= z14.a()) {
            return;
        }
        a74 a74Var = new a74();
        a74Var.b = "stuck";
        a74Var.e = "jserror";
        a74Var.f = p53.h0();
        if (p53.M() != null && p53.M().Z() != null) {
            mq2.a Z = p53.M().Z();
            a74Var.c = Z.U();
            a74Var.a = ic3.n(Z.H());
        }
        a74Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (m64.d()) {
            i = 20;
        } else {
            i = 10;
        }
        a74Var.k = i;
        a74Var.n = z14.b();
        a74Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(a74Var);
    }
}
