package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.an9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes3.dex */
public final class bn9 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static an9.a b;
    public static an9.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947650876, "Lcom/baidu/tieba/bn9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947650876, "Lcom/baidu/tieba/bn9;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (bn9.class) {
                if (!a) {
                    nn9.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new cn9();
                    c = new mn9();
                    an9.a().c();
                    an9.a().d(c);
                    an9.a().d(b);
                    an9.a().e(context);
                    a = true;
                    return;
                }
                nn9.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
