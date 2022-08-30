package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.f79;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes4.dex */
public final class g79 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static f79.a b;
    public static f79.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947746976, "Lcom/baidu/tieba/g79;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947746976, "Lcom/baidu/tieba/g79;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (g79.class) {
                if (!a) {
                    s79.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new h79();
                    c = new r79();
                    f79.a().c();
                    f79.a().d(c);
                    f79.a().d(b);
                    f79.a().e(context);
                    a = true;
                    return;
                }
                s79.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
