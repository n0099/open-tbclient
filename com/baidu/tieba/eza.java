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
public final class eza {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<eza> d;
    public transient /* synthetic */ FieldHolder $fh;
    public fza a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947753021, "Lcom/baidu/tieba/eza;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947753021, "Lcom/baidu/tieba/eza;");
        }
    }

    public eza(Context context, String str) {
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
        jza.b();
        this.a = new fza(context, str);
        this.b = str;
        this.c = context;
    }

    public static eza b(Context context, String str) {
        InterceptResult invokeLL;
        eza ezaVar;
        eza ezaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<eza> softReference = d;
                if (softReference == null) {
                    ezaVar = null;
                } else {
                    ezaVar = softReference.get();
                }
                if (ezaVar == null || !str.equals(ezaVar.b)) {
                    synchronized (eza.class) {
                        ezaVar2 = new eza(context, str);
                        d = new SoftReference<>(ezaVar2);
                    }
                    return ezaVar2;
                }
                return ezaVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (eza) invokeLL.objValue;
    }

    public final void a(Activity activity, cza czaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, czaVar) == null) {
            this.a.c(activity, "123", czaVar);
        }
    }

    public final void c(int i, int i2, Intent intent, cza czaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, czaVar}) == null) {
            this.a.d(i, i2, intent, czaVar);
        }
    }
}
