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
public final class fkb {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<fkb> d;
    public transient /* synthetic */ FieldHolder $fh;
    public gkb a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947768428, "Lcom/baidu/tieba/fkb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947768428, "Lcom/baidu/tieba/fkb;");
        }
    }

    public fkb(Context context, String str) {
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
        kkb.b();
        this.a = new gkb(context, str);
        this.b = str;
        this.c = context;
    }

    public static fkb b(Context context, String str) {
        InterceptResult invokeLL;
        fkb fkbVar;
        fkb fkbVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<fkb> softReference = d;
                if (softReference == null) {
                    fkbVar = null;
                } else {
                    fkbVar = softReference.get();
                }
                if (fkbVar == null || !str.equals(fkbVar.b)) {
                    synchronized (fkb.class) {
                        fkbVar2 = new fkb(context, str);
                        d = new SoftReference<>(fkbVar2);
                    }
                    return fkbVar2;
                }
                return fkbVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (fkb) invokeLL.objValue;
    }

    public final void a(Activity activity, dkb dkbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, dkbVar) == null) {
            this.a.c(activity, "123", dkbVar);
        }
    }

    public final void c(int i, int i2, Intent intent, dkb dkbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, dkbVar}) == null) {
            this.a.d(i, i2, intent, dkbVar);
        }
    }
}
