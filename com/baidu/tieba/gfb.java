package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.ffb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes6.dex */
public final class gfb {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static ffb.a b;
    public static ffb.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947793414, "Lcom/baidu/tieba/gfb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947793414, "Lcom/baidu/tieba/gfb;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (gfb.class) {
                if (!a) {
                    sfb.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new hfb();
                    c = new rfb();
                    ffb.a().c();
                    ffb.a().d(c);
                    ffb.a().d(b);
                    ffb.a().e(context);
                    a = true;
                    return;
                }
                sfb.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
