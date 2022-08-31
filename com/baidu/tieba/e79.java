package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.d79;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes3.dex */
public final class e79 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static d79.a b;
    public static d79.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947687394, "Lcom/baidu/tieba/e79;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947687394, "Lcom/baidu/tieba/e79;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (e79.class) {
                if (!a) {
                    q79.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new f79();
                    c = new p79();
                    d79.a().c();
                    d79.a().d(c);
                    d79.a().d(b);
                    d79.a().e(context);
                    a = true;
                    return;
                }
                q79.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
