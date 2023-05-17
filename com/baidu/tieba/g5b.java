package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
/* loaded from: classes5.dex */
public final class g5b {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<g5b> d;
    public transient /* synthetic */ FieldHolder $fh;
    public h5b a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947746325, "Lcom/baidu/tieba/g5b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947746325, "Lcom/baidu/tieba/g5b;");
        }
    }

    public g5b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        l5b.b();
        this.a = new h5b(context, str);
        this.b = str;
        this.c = context;
    }

    public static g5b b(Context context, String str) {
        InterceptResult invokeLL;
        g5b g5bVar;
        g5b g5bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<g5b> softReference = d;
                if (softReference == null) {
                    g5bVar = null;
                } else {
                    g5bVar = softReference.get();
                }
                if (g5bVar == null || !str.equals(g5bVar.b)) {
                    synchronized (g5b.class) {
                        g5bVar2 = new g5b(context, str);
                        d = new SoftReference<>(g5bVar2);
                    }
                    return g5bVar2;
                }
                return g5bVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (g5b) invokeLL.objValue;
    }

    public final void a(Activity activity, e5b e5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, e5bVar) == null) {
            this.a.c(activity, "123", e5bVar);
        }
    }

    public final void c(int i, int i2, Intent intent, e5b e5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, e5bVar}) == null) {
            this.a.d(i, i2, intent, e5bVar);
        }
    }
}
