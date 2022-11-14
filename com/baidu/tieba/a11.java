package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g11 a;
        public final /* synthetic */ dr0 b;

        public a(g11 g11Var, dr0 dr0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g11Var, dr0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g11Var;
            this.b = dr0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a11.d(this.a, this.b);
            }
        }
    }

    public static <T> void c(@NonNull g11 g11Var, @Nullable dr0<T> dr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, g11Var, dr0Var) == null) {
            g11Var.a();
            b21.c(new a(g11Var, dr0Var), "als_async_executor", 2);
        }
    }

    public static void b(@NonNull g11 g11Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, g11Var) == null) {
            c(g11Var, null);
        }
    }

    public static <T> void d(g11 g11Var, @Nullable dr0<T> dr0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, g11Var, dr0Var) == null) && g11Var != null && g11Var.isValid()) {
            String g11Var2 = g11Var.toString();
            if (g11Var instanceof ClogBuilder) {
                if (og0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog";
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (g11Var instanceof h11) {
                if (og0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog";
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (g11Var instanceof e11) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            kr0 kr0Var = new kr0();
            kr0Var.h(g11Var2);
            kr0Var.k(BodyStyle.STRING);
            kr0Var.i("application/x-www-form-urlencoded");
            lr0 lr0Var = new lr0();
            lr0Var.l(str);
            lr0Var.f(kr0Var);
            sq0.b().a().a(lr0Var, dr0Var);
        }
    }
}
