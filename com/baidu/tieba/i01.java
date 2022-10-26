package com.baidu.tieba;

import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class i01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o01 a;
        public final /* synthetic */ lq0 b;

        public a(o01 o01Var, lq0 lq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o01Var, lq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o01Var;
            this.b = lq0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i01.d(this.a, this.b);
            }
        }
    }

    public static void c(o01 o01Var, lq0 lq0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, o01Var, lq0Var) == null) {
            o01Var.a();
            j11.c(new a(o01Var, lq0Var), "als_async_executor", 2);
        }
    }

    public static void b(o01 o01Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, o01Var) == null) {
            c(o01Var, null);
        }
    }

    public static void d(o01 o01Var, lq0 lq0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, o01Var, lq0Var) == null) && o01Var != null && o01Var.isValid()) {
            String o01Var2 = o01Var.toString();
            if (o01Var instanceof ClogBuilder) {
                if (og0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog";
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (o01Var instanceof p01) {
                if (og0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog";
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (o01Var instanceof m01) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            sq0 sq0Var = new sq0();
            sq0Var.h(o01Var2);
            sq0Var.k(BodyStyle.STRING);
            sq0Var.i("application/x-www-form-urlencoded");
            tq0 tq0Var = new tq0();
            tq0Var.k(str);
            tq0Var.f(sq0Var);
            aq0.b().a().a(tq0Var, lq0Var);
        }
    }
}
