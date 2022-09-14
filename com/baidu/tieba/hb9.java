package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.gb9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes4.dex */
public final class hb9 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static gb9.a b;
    public static gb9.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947818090, "Lcom/baidu/tieba/hb9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947818090, "Lcom/baidu/tieba/hb9;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (hb9.class) {
                if (!a) {
                    tb9.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new ib9();
                    c = new sb9();
                    gb9.a().c();
                    gb9.a().d(c);
                    gb9.a().d(b);
                    gb9.a().e(context);
                    a = true;
                    return;
                }
                tb9.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
