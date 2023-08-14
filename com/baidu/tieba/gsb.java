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
/* loaded from: classes6.dex */
public final class gsb {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<gsb> d;
    public transient /* synthetic */ FieldHolder $fh;
    public hsb a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947805907, "Lcom/baidu/tieba/gsb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947805907, "Lcom/baidu/tieba/gsb;");
        }
    }

    public gsb(Context context, String str) {
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
        lsb.b();
        this.a = new hsb(context, str);
        this.b = str;
        this.c = context;
    }

    public static gsb b(Context context, String str) {
        InterceptResult invokeLL;
        gsb gsbVar;
        gsb gsbVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<gsb> softReference = d;
                if (softReference == null) {
                    gsbVar = null;
                } else {
                    gsbVar = softReference.get();
                }
                if (gsbVar == null || !str.equals(gsbVar.b)) {
                    synchronized (gsb.class) {
                        gsbVar2 = new gsb(context, str);
                        d = new SoftReference<>(gsbVar2);
                    }
                    return gsbVar2;
                }
                return gsbVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (gsb) invokeLL.objValue;
    }

    public final void a(Activity activity, esb esbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, esbVar) == null) {
            this.a.c(activity, "123", esbVar);
        }
    }

    public final void c(int i, int i2, Intent intent, esb esbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, esbVar}) == null) {
            this.a.d(i, i2, intent, esbVar);
        }
    }
}
