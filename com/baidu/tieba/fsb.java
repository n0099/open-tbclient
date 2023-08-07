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
public final class fsb {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<fsb> d;
    public transient /* synthetic */ FieldHolder $fh;
    public gsb a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947776116, "Lcom/baidu/tieba/fsb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947776116, "Lcom/baidu/tieba/fsb;");
        }
    }

    public fsb(Context context, String str) {
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
        ksb.b();
        this.a = new gsb(context, str);
        this.b = str;
        this.c = context;
    }

    public static fsb b(Context context, String str) {
        InterceptResult invokeLL;
        fsb fsbVar;
        fsb fsbVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<fsb> softReference = d;
                if (softReference == null) {
                    fsbVar = null;
                } else {
                    fsbVar = softReference.get();
                }
                if (fsbVar == null || !str.equals(fsbVar.b)) {
                    synchronized (fsb.class) {
                        fsbVar2 = new fsb(context, str);
                        d = new SoftReference<>(fsbVar2);
                    }
                    return fsbVar2;
                }
                return fsbVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (fsb) invokeLL.objValue;
    }

    public final void a(Activity activity, dsb dsbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, dsbVar) == null) {
            this.a.c(activity, "123", dsbVar);
        }
    }

    public final void c(int i, int i2, Intent intent, dsb dsbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, dsbVar}) == null) {
            this.a.d(i, i2, intent, dsbVar);
        }
    }
}
