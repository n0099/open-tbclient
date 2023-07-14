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
public final class ctb {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<ctb> d;
    public transient /* synthetic */ FieldHolder $fh;
    public dtb a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947687704, "Lcom/baidu/tieba/ctb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947687704, "Lcom/baidu/tieba/ctb;");
        }
    }

    public ctb(Context context, String str) {
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
        htb.b();
        this.a = new dtb(context, str);
        this.b = str;
        this.c = context;
    }

    public static ctb b(Context context, String str) {
        InterceptResult invokeLL;
        ctb ctbVar;
        ctb ctbVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<ctb> softReference = d;
                if (softReference == null) {
                    ctbVar = null;
                } else {
                    ctbVar = softReference.get();
                }
                if (ctbVar == null || !str.equals(ctbVar.b)) {
                    synchronized (ctb.class) {
                        ctbVar2 = new ctb(context, str);
                        d = new SoftReference<>(ctbVar2);
                    }
                    return ctbVar2;
                }
                return ctbVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (ctb) invokeLL.objValue;
    }

    public final void a(Activity activity, atb atbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, atbVar) == null) {
            this.a.c(activity, "123", atbVar);
        }
    }

    public final void c(int i, int i2, Intent intent, atb atbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, atbVar}) == null) {
            this.a.d(i, i2, intent, atbVar);
        }
    }
}
