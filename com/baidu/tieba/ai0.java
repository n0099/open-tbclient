package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class ai0 {
    public static /* synthetic */ Interceptable $ic;
    public static final long a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ai0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-946783101, "Lcom/baidu/tieba/ai0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-946783101, "Lcom/baidu/tieba/ai0$b;");
                    return;
                }
            }
            a = new ai0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947616001, "Lcom/baidu/tieba/ai0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947616001, "Lcom/baidu/tieba/ai0;");
                return;
            }
        }
        a = TimeUnit.DAYS.toMillis(10L);
    }

    public ai0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ai0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (ai0) invokeV.objValue;
    }

    public /* synthetic */ ai0(a aVar) {
        this();
    }

    public void a(ci0 ci0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ci0Var) == null) {
            vg0 vg0Var = new vg0();
            vg0Var.g = "https://cover.baidu.com/cover/deeplink_android?downloadUrl=";
            vg0Var.h(ci0Var.b);
            zg0 zg0Var = vg0Var.p;
            zg0Var.a = ci0Var.c;
            vg0Var.d = ci0Var.a;
            zg0Var.o = ci0Var.e;
            zg0Var.p = ci0Var.f;
            zg0Var.n = ci0Var.d;
            vg0Var.q.a = "SCHEDULEDDOWNLOAD";
            if (!TextUtils.isEmpty(ci0Var.g)) {
                vg0Var.q.b = ci0Var.g;
            } else {
                vg0Var.q.b = "na_ads";
            }
            if (!TextUtils.isEmpty(ci0Var.h)) {
                vg0Var.q.c = ci0Var.h;
            } else {
                vg0Var.q.c = "apk_yuansheng";
            }
            vg0Var.l = Long.MAX_VALUE - (a * 2);
            mg0.b().g(vg0Var);
            mg0.b().f(vg0Var);
        }
    }

    public void c(String str, boolean z) {
        vg0 vg0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) != null) || (vg0Var = (vg0) my0.b(mg0.b().a(), str)) == null) {
            return;
        }
        vg0Var.p.p = z;
        mg0.b().g(vg0Var);
        mg0.b().f(vg0Var);
    }
}
