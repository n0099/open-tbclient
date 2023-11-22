package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.cnb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes5.dex */
public final class dnb {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static cnb.a b;
    public static cnb.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947711729, "Lcom/baidu/tieba/dnb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947711729, "Lcom/baidu/tieba/dnb;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (dnb.class) {
                if (!a) {
                    pnb.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new enb();
                    c = new onb();
                    cnb.a().c();
                    cnb.a().d(c);
                    cnb.a().d(b);
                    cnb.a().e(context);
                    a = true;
                    return;
                }
                pnb.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
