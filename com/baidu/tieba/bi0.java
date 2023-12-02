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
public class bi0 {
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
        public static final bi0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-918153950, "Lcom/baidu/tieba/bi0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-918153950, "Lcom/baidu/tieba/bi0$b;");
                    return;
                }
            }
            a = new bi0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947645792, "Lcom/baidu/tieba/bi0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947645792, "Lcom/baidu/tieba/bi0;");
                return;
            }
        }
        a = TimeUnit.DAYS.toMillis(10L);
    }

    public bi0() {
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

    public static bi0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (bi0) invokeV.objValue;
    }

    public /* synthetic */ bi0(a aVar) {
        this();
    }

    public void a(di0 di0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, di0Var) == null) {
            wg0 wg0Var = new wg0();
            wg0Var.g = "https://cover.baidu.com/cover/deeplink_android?downloadUrl=";
            wg0Var.h(di0Var.b);
            ah0 ah0Var = wg0Var.p;
            ah0Var.a = di0Var.c;
            wg0Var.d = di0Var.a;
            ah0Var.o = di0Var.e;
            ah0Var.p = di0Var.f;
            ah0Var.n = di0Var.d;
            wg0Var.q.a = "SCHEDULEDDOWNLOAD";
            if (!TextUtils.isEmpty(di0Var.g)) {
                wg0Var.q.b = di0Var.g;
            } else {
                wg0Var.q.b = "na_ads";
            }
            if (!TextUtils.isEmpty(di0Var.h)) {
                wg0Var.q.c = di0Var.h;
            } else {
                wg0Var.q.c = "apk_yuansheng";
            }
            wg0Var.l = Long.MAX_VALUE - (a * 2);
            ng0.b().g(wg0Var);
            ng0.b().f(wg0Var);
        }
    }

    public void c(String str, boolean z) {
        wg0 wg0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) != null) || (wg0Var = (wg0) py0.b(ng0.b().a(), str)) == null) {
            return;
        }
        wg0Var.p.p = z;
        ng0.b().g(wg0Var);
        ng0.b().f(wg0Var);
    }
}
