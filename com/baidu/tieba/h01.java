package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n01 a;
        public final /* synthetic */ kq0 b;

        public a(n01 n01Var, kq0 kq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n01Var, kq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n01Var;
            this.b = kq0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h01.d(this.a, this.b);
            }
        }
    }

    public static void b(@NonNull n01 n01Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, n01Var) == null) {
            c(n01Var, null);
        }
    }

    public static <T> void c(@NonNull n01 n01Var, @Nullable kq0<T> kq0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, n01Var, kq0Var) == null) {
            n01Var.a();
            i11.c(new a(n01Var, kq0Var), "als_async_executor", 2);
        }
    }

    public static <T> void d(n01 n01Var, @Nullable kq0<T> kq0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, n01Var, kq0Var) == null) && n01Var != null && n01Var.isValid()) {
            String n01Var2 = n01Var.toString();
            if (n01Var instanceof ClogBuilder) {
                str = ng0.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog" : "https://als.baidu.com/clog/clog";
            } else if (n01Var instanceof o01) {
                str = ng0.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog" : "https://als.baidu.com/elog/plog";
            } else if (!(n01Var instanceof l01)) {
                return;
            } else {
                str = "https://afd.baidu.com/afd/close";
            }
            rq0 rq0Var = new rq0();
            rq0Var.h(n01Var2);
            rq0Var.k(BodyStyle.STRING);
            rq0Var.i("application/x-www-form-urlencoded");
            sq0 sq0Var = new sq0();
            sq0Var.k(str);
            sq0Var.f(rq0Var);
            zp0.b().a().a(sq0Var, kq0Var);
        }
    }
}
