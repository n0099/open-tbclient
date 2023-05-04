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
public final class i3b {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<i3b> d;
    public transient /* synthetic */ FieldHolder $fh;
    public j3b a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947803985, "Lcom/baidu/tieba/i3b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947803985, "Lcom/baidu/tieba/i3b;");
        }
    }

    public i3b(Context context, String str) {
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
        n3b.b();
        this.a = new j3b(context, str);
        this.b = str;
        this.c = context;
    }

    public static i3b b(Context context, String str) {
        InterceptResult invokeLL;
        i3b i3bVar;
        i3b i3bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<i3b> softReference = d;
                if (softReference == null) {
                    i3bVar = null;
                } else {
                    i3bVar = softReference.get();
                }
                if (i3bVar == null || !str.equals(i3bVar.b)) {
                    synchronized (i3b.class) {
                        i3bVar2 = new i3b(context, str);
                        d = new SoftReference<>(i3bVar2);
                    }
                    return i3bVar2;
                }
                return i3bVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (i3b) invokeLL.objValue;
    }

    public final void a(Activity activity, g3b g3bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, g3bVar) == null) {
            this.a.c(activity, "123", g3bVar);
        }
    }

    public final void c(int i, int i2, Intent intent, g3b g3bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, g3bVar}) == null) {
            this.a.d(i, i2, intent, g3bVar);
        }
    }
}
