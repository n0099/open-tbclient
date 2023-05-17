package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k21 a;
        public final /* synthetic */ bs0 b;

        public a(k21 k21Var, bs0 bs0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k21Var, bs0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k21Var;
            this.b = bs0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e21.d(this.a, this.b);
            }
        }
    }

    public static <T> void c(@NonNull k21 k21Var, @Nullable bs0<T> bs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, k21Var, bs0Var) == null) {
            k21Var.a();
            f31.c(new a(k21Var, bs0Var), "als_async_executor", 2);
        }
    }

    public static void b(@NonNull k21 k21Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, k21Var) == null) {
            c(k21Var, null);
        }
    }

    public static <T> void d(k21 k21Var, @Nullable bs0<T> bs0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, k21Var, bs0Var) == null) && k21Var != null && k21Var.isValid()) {
            String k21Var2 = k21Var.toString();
            if (k21Var instanceof ClogBuilder) {
                if (mg0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog";
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (k21Var instanceof l21) {
                if (mg0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog";
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (k21Var instanceof i21) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            is0 is0Var = new is0();
            is0Var.h(k21Var2);
            is0Var.k(BodyStyle.STRING);
            is0Var.i("application/x-www-form-urlencoded");
            js0 js0Var = new js0();
            js0Var.l(str);
            js0Var.f(is0Var);
            qr0.b().a().a(js0Var, bs0Var);
        }
    }
}
