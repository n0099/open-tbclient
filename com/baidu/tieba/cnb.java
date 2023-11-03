package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.bnb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes5.dex */
public final class cnb {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static bnb.a b;
    public static bnb.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947681938, "Lcom/baidu/tieba/cnb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947681938, "Lcom/baidu/tieba/cnb;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (cnb.class) {
                if (!a) {
                    onb.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new dnb();
                    c = new nnb();
                    bnb.a().c();
                    bnb.a().d(c);
                    bnb.a().d(b);
                    bnb.a().e(context);
                    a = true;
                    return;
                }
                onb.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
