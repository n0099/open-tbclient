package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.he9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes4.dex */
public final class ie9 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static he9.a b;
    public static he9.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947850764, "Lcom/baidu/tieba/ie9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947850764, "Lcom/baidu/tieba/ie9;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (ie9.class) {
                if (!a) {
                    ue9.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new je9();
                    c = new te9();
                    he9.a().c();
                    he9.a().d(c);
                    he9.a().d(b);
                    he9.a().e(context);
                    a = true;
                    return;
                }
                ue9.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
