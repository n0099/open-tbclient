package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.fbb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes6.dex */
public final class gbb {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static fbb.a b;
    public static fbb.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947789570, "Lcom/baidu/tieba/gbb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947789570, "Lcom/baidu/tieba/gbb;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (gbb.class) {
                if (!a) {
                    sbb.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new hbb();
                    c = new rbb();
                    fbb.a().c();
                    fbb.a().d(c);
                    fbb.a().d(b);
                    fbb.a().e(context);
                    a = true;
                    return;
                }
                sbb.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
