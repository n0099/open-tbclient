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
public final class h5b {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<h5b> d;
    public transient /* synthetic */ FieldHolder $fh;
    public i5b a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947776116, "Lcom/baidu/tieba/h5b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947776116, "Lcom/baidu/tieba/h5b;");
        }
    }

    public h5b(Context context, String str) {
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
        m5b.b();
        this.a = new i5b(context, str);
        this.b = str;
        this.c = context;
    }

    public static h5b b(Context context, String str) {
        InterceptResult invokeLL;
        h5b h5bVar;
        h5b h5bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<h5b> softReference = d;
                if (softReference == null) {
                    h5bVar = null;
                } else {
                    h5bVar = softReference.get();
                }
                if (h5bVar == null || !str.equals(h5bVar.b)) {
                    synchronized (h5b.class) {
                        h5bVar2 = new h5b(context, str);
                        d = new SoftReference<>(h5bVar2);
                    }
                    return h5bVar2;
                }
                return h5bVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (h5b) invokeLL.objValue;
    }

    public final void a(Activity activity, f5b f5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, f5bVar) == null) {
            this.a.c(activity, "123", f5bVar);
        }
    }

    public final void c(int i, int i2, Intent intent, f5b f5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, f5bVar}) == null) {
            this.a.d(i, i2, intent, f5bVar);
        }
    }
}
