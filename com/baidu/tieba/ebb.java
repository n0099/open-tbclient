package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.dbb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes5.dex */
public final class ebb {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static dbb.a b;
    public static dbb.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947729988, "Lcom/baidu/tieba/ebb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947729988, "Lcom/baidu/tieba/ebb;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (ebb.class) {
                if (!a) {
                    qbb.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new fbb();
                    c = new pbb();
                    dbb.a().c();
                    dbb.a().d(c);
                    dbb.a().d(b);
                    dbb.a().e(context);
                    a = true;
                    return;
                }
                qbb.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
