package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz0 a;
        public final /* synthetic */ cp0 b;

        public a(jz0 jz0Var, cp0 cp0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz0Var, cp0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz0Var;
            this.b = cp0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                dz0.g(this.a, this.b);
            }
        }
    }

    public static <T> void f(@NonNull jz0 jz0Var, @Nullable cp0<T> cp0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, jz0Var, cp0Var) == null) {
            jz0Var.a();
            e01.c(new a(jz0Var, cp0Var), "als_async_executor", 2);
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return hf0.d().A() + "/clog/clog";
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return hf0.d().A() + "/elog/plog";
        }
        return (String) invokeV.objValue;
    }

    public static Boolean d() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!a11.a) {
                return Boolean.FALSE;
            }
            c11 c11Var = (c11) z01.a().a(c11.class);
            if (c11Var != null && c11Var.a()) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeV.objValue;
    }

    public static void e(@NonNull jz0 jz0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jz0Var) == null) {
            f(jz0Var, null);
        }
    }

    public static <T> void g(jz0 jz0Var, @Nullable cp0<T> cp0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, jz0Var, cp0Var) == null) && jz0Var != null && jz0Var.isValid()) {
            String jz0Var2 = jz0Var.toString();
            if (jz0Var instanceof ClogBuilder) {
                if (d().booleanValue()) {
                    str = b();
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (jz0Var instanceof kz0) {
                if (d().booleanValue()) {
                    str = c();
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (jz0Var instanceof hz0) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            jp0 jp0Var = new jp0();
            jp0Var.h(jz0Var2);
            jp0Var.k(BodyStyle.STRING);
            jp0Var.i("application/x-www-form-urlencoded");
            kp0 kp0Var = new kp0();
            kp0Var.l(str);
            kp0Var.f(jp0Var);
            ro0.b().a().a(kp0Var, cp0Var);
        }
    }
}
