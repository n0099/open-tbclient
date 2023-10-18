package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.aab;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes5.dex */
public final class bab {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static aab.a b;
    public static aab.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947639654, "Lcom/baidu/tieba/bab;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947639654, "Lcom/baidu/tieba/bab;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (bab.class) {
                if (!a) {
                    nab.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new cab();
                    c = new mab();
                    aab.a().c();
                    aab.a().d(c);
                    aab.a().d(b);
                    aab.a().e(context);
                    a = true;
                    return;
                }
                nab.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
