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
public final class a2c {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<a2c> d;
    public transient /* synthetic */ FieldHolder $fh;
    public b2c a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947564727, "Lcom/baidu/tieba/a2c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947564727, "Lcom/baidu/tieba/a2c;");
        }
    }

    public a2c(Context context, String str) {
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
        f2c.b();
        this.a = new b2c(context, str);
        this.b = str;
        this.c = context;
    }

    public static a2c b(Context context, String str) {
        InterceptResult invokeLL;
        a2c a2cVar;
        a2c a2cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<a2c> softReference = d;
                if (softReference == null) {
                    a2cVar = null;
                } else {
                    a2cVar = softReference.get();
                }
                if (a2cVar == null || !str.equals(a2cVar.b)) {
                    synchronized (a2c.class) {
                        a2cVar2 = new a2c(context, str);
                        d = new SoftReference<>(a2cVar2);
                    }
                    return a2cVar2;
                }
                return a2cVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (a2c) invokeLL.objValue;
    }

    public final void a(Activity activity, y1c y1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, y1cVar) == null) {
            this.a.c(activity, "123", y1cVar);
        }
    }

    public final void c(int i, int i2, Intent intent, y1c y1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, y1cVar}) == null) {
            this.a.d(i, i2, intent, y1cVar);
        }
    }
}
