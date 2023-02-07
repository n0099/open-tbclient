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
/* loaded from: classes4.dex */
public final class f9a {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<f9a> d;
    public transient /* synthetic */ FieldHolder $fh;
    public g9a a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947720347, "Lcom/baidu/tieba/f9a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947720347, "Lcom/baidu/tieba/f9a;");
        }
    }

    public f9a(Context context, String str) {
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
        k9a.b();
        this.a = new g9a(context, str);
        this.b = str;
        this.c = context;
    }

    public static f9a b(Context context, String str) {
        InterceptResult invokeLL;
        f9a f9aVar;
        f9a f9aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<f9a> softReference = d;
                if (softReference == null) {
                    f9aVar = null;
                } else {
                    f9aVar = softReference.get();
                }
                if (f9aVar == null || !str.equals(f9aVar.b)) {
                    synchronized (f9a.class) {
                        f9aVar2 = new f9a(context, str);
                        d = new SoftReference<>(f9aVar2);
                    }
                    return f9aVar2;
                }
                return f9aVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (f9a) invokeLL.objValue;
    }

    public final void a(Activity activity, d9a d9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, d9aVar) == null) {
            this.a.c(activity, "123", d9aVar);
        }
    }

    public final void c(int i, int i2, Intent intent, d9a d9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, d9aVar}) == null) {
            this.a.d(i, i2, intent, d9aVar);
        }
    }
}
