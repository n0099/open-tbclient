package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.dqa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes5.dex */
public final class eqa {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static dqa.a b;
    public static dqa.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947744372, "Lcom/baidu/tieba/eqa;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947744372, "Lcom/baidu/tieba/eqa;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (eqa.class) {
                if (!a) {
                    qqa.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new fqa();
                    c = new pqa();
                    dqa.a().c();
                    dqa.a().d(c);
                    dqa.a().d(b);
                    dqa.a().e(context);
                    a = true;
                    return;
                }
                qqa.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
