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
public final class eja {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<eja> d;
    public transient /* synthetic */ FieldHolder $fh;
    public fja a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947737645, "Lcom/baidu/tieba/eja;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947737645, "Lcom/baidu/tieba/eja;");
        }
    }

    public eja(Context context, String str) {
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
        jja.b();
        this.a = new fja(context, str);
        this.b = str;
        this.c = context;
    }

    public static eja b(Context context, String str) {
        InterceptResult invokeLL;
        eja ejaVar;
        eja ejaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<eja> softReference = d;
                if (softReference == null) {
                    ejaVar = null;
                } else {
                    ejaVar = softReference.get();
                }
                if (ejaVar == null || !str.equals(ejaVar.b)) {
                    synchronized (eja.class) {
                        ejaVar2 = new eja(context, str);
                        d = new SoftReference<>(ejaVar2);
                    }
                    return ejaVar2;
                }
                return ejaVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (eja) invokeLL.objValue;
    }

    public final void a(Activity activity, cja cjaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, cjaVar) == null) {
            this.a.c(activity, "123", cjaVar);
        }
    }

    public final void c(int i, int i2, Intent intent, cja cjaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, cjaVar}) == null) {
            this.a.d(i, i2, intent, cjaVar);
        }
    }
}
